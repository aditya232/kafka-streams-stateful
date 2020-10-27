# kafka-streams-stateful example
This example demonstrates aggregation in Kafka Streams with two different approaches, one based on DSL operators like `groupByKey` and `reduce`,
and another using Kafka Streams Processor API and state stores.


## Dependencies
> - **JAVA 8**,**Maven** and **Kafka** should be installed for running this project.

## To Run:
> - Create input Kafka topic `user-activity` from Kafka root directory:\
    ``` 
    bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4 --topic user-activity 
    ```
> - Run `mvn clean compile assembly:single`. A jar named `kafka-streams-stateful-1.0-SNAPSHOT-jar-with-dependencies.jar` will be created in `target` directory.
> - A data generation script is present in the `TestDataGenerator` class with which you can push Kafka messages to the input Kafka topic:\
    ```
    java -cp target/kafka-streams-stateful-1.0-SNAPSHOT-jar-with-dependencies.jar org.streams.demo.TestDataGenerator {{number_of_messages}}
    ```
> - To Run the Kafka Streams Application:\
    ```
    java -cp target/kafka-streams-stateful-1.0-SNAPSHOT-jar-with-dependencies.jar org.streams.demo.Main
    ```
