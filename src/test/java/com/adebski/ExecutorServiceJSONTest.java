package com.adebski;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExecutorServiceJSONTest {

    @Test
    public void parseConfigurationJsonNode() throws IOException {
        String exampleConfiguration =
            Files.readString(Paths.get("./example-executor-service-configuration.json"));
        ObjectMapper objectMapper =
            new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(exampleConfiguration);

        String firstNamePattern =
            jsonNode
                .get("executorServiceConfigurations")
                .get(0)
                .get("namePattern")
                .asText();

        System.out.println("firstNamePattern: " + firstNamePattern);
    }

    @Test
    public void parseConfigurationExecutorServiceJSON() throws IOException {
        String exampleConfiguration =
            Files.readString(Paths.get("./example-executor-service-configuration.json"));
        ObjectMapper objectMapper =
            new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(exampleConfiguration);
        ExecutorServiceJSON.ExecutorServiceConfigurations executorServiceConfigurations =
            new ExecutorServiceJSON.ExecutorServiceConfigurations(jsonNode);

        String firstNamePattern =
            executorServiceConfigurations.getConfigurations().get(0).getNamePattern();

        System.out.println("firstNamePattern: " + firstNamePattern);
    }
}
