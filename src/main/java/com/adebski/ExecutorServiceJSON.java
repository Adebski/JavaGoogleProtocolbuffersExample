package com.adebski;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ExecutorServiceJSON {

    public static final class ExecutorServiceConfiguration {
        private final JsonNode jsonNode;

        public ExecutorServiceConfiguration(JsonNode jsonNode) {
            this.jsonNode = jsonNode;
        }

        public String getNamePattern() {
            return jsonNode.get("namePattern").asText();
        }

        public int getNumberOfThreads() {
            return jsonNode.get("numberOfThreads").asInt();
        }

        public boolean isDaemon() {
            return jsonNode.get("daemon").asBoolean();
        }
    }

    public static final class ExecutorServiceConfigurations {
        private final JsonNode jsonNode;

        public ExecutorServiceConfigurations(JsonNode jsonNode) {
            this.jsonNode = jsonNode;
        }

        public List<ExecutorServiceConfiguration> getConfigurations() {
            JsonNode executorServiceConfigurations =
                jsonNode.get("executorServiceConfigurations");

            ArrayNode arrayNode = (ArrayNode) executorServiceConfigurations;

            return StreamSupport.stream(arrayNode.spliterator(), false)
                .map(ExecutorServiceConfiguration::new)
                .collect(Collectors.toList());
        }
    }
}
