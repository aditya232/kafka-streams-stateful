package org.streams.demo.serdes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonSerializer<T> implements Serializer<T> {

    private static final Logger log = LoggerFactory.getLogger(JsonSerializer.class);
    private final ObjectMapper mapper = new ObjectMapper();
    private Class<T> deserializedClass;

    public JsonSerializer(Class<T> deserializedClass) {
        this.deserializedClass = deserializedClass;
    }

    @Override
    public byte[] serialize(String topic, T t) {
        try {
            return mapper.writeValueAsBytes(t);
        } catch (JsonProcessingException e) {
            log.error("Failed to Serialize : {}", t, e);
        }
        return null;
    }
}
