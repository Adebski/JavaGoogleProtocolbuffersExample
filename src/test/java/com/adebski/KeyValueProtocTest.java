package com.adebski;

import com.google.protobuf.TextFormat;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class KeyValueProtocTest {

    @Test
    public void parsesConfiguration() throws IOException {
        String exampleConfiguration =
            Files.readString(Paths.get("./key-value.proto"));

        KeyValueProtoc.GenericConfiguration parsedConfiguration =
            TextFormat.parse(
                exampleConfiguration,
                KeyValueProtoc.GenericConfiguration.class);

        String firstNamePattern =
            parsedConfiguration
                .getConfigurationOrThrow("executorServiceConfigurations")
                .getValueWrapperList()
                .get(0)
                .getNestedConfiguration()
                .getConfigurationOrThrow("namePattern")
                .getValueWrapperList()
                .get(0)
                .getStringValue();
        System.out.println("firstNamePattern: " + firstNamePattern);
    }
}
