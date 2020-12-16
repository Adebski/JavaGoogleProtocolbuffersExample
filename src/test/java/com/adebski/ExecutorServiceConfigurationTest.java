package com.adebski;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.google.protobuf.TextFormat;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExecutorServiceConfigurationTest {

    @Test
    public void createsExecutorServices() throws IOException {
        ExecutorServiceProtoc.ExecutorServices executorServices = ExecutorServiceProtoc.ExecutorServices.newBuilder()
                .addExecutorServiceConfigurations(
                        ExecutorServiceProtoc.FixedExecutorServiceConfiguration.newBuilder()
                                .setDaemon(true)
                                .setNamePattern("first-test-pool-%d")
                                .setNumberOfThreads(6)
                                .build())
                .addExecutorServiceConfigurations(ExecutorServiceProtoc.FixedExecutorServiceConfiguration.newBuilder()
                        .setDaemon(true)
                        .setNamePattern("second-test-pool-%d")
                        .setNumberOfThreads(3)
                        .build())
                .build();

        String exampleExecutorServiceConfiguration =
                Files.readString(Paths.get("./example-executor-service-configuration.proto"));
        ExecutorServiceProtoc.ExecutorServices parsedExecutorServices =
                TextFormat.parse(exampleExecutorServiceConfiguration, ExecutorServiceProtoc.ExecutorServices.class);

        System.out.println("executorServices.equals(parsedExecutorServices): " + executorServices.equals(parsedExecutorServices));
    }
}
