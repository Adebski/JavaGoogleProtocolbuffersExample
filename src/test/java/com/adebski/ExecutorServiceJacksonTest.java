package com.adebski;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExecutorServiceJacksonTest {
    @Test
    public void createsExecutorServicesJackson() throws IOException {
        String exampleConfiguration =
            Files.readString(Paths.get("./example-executor-service-configuration.json"));
        ObjectMapper objectMapper =
            new ObjectMapper().registerModule(new ParameterNamesModule());

        ExecutorServiceJackson.ExecutorServices parsedExecutorServices =
            objectMapper.readValue(exampleConfiguration, ExecutorServiceJackson.ExecutorServices.class);

        System.out.println(parsedExecutorServices);
    }
}
