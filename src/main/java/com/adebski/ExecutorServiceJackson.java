package com.adebski;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;
import java.util.Objects;

public class ExecutorServiceJackson {
    public static final class FixedExecutorServiceConfiguration {
        private final String namePattern;
        private final int numberOfThreads;
        private final boolean daemon;

        @JsonCreator
        public FixedExecutorServiceConfiguration(String namePattern,
                                                 int numberOfThreads,
                                                 boolean daemon) {
            this.namePattern = namePattern;
            this.numberOfThreads = numberOfThreads;
            this.daemon = daemon;
        }

        public String getNamePattern() {
            return namePattern;
        }

        public int getNumberOfThreads() {
            return numberOfThreads;
        }

        public boolean getDaemon() {
            return daemon;
        }

        @Override
        public String toString() {
            return "FixedExecutorServiceConfiguration{" +
                    "namePattern='" + namePattern + '\'' +
                    ", numberOfThreads=" + numberOfThreads +
                    ", daemon=" + daemon +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FixedExecutorServiceConfiguration that = (FixedExecutorServiceConfiguration) o;
            return numberOfThreads == that.numberOfThreads &&
                    daemon == that.daemon &&
                    Objects.equals(namePattern, that.namePattern);
        }

        @Override
        public int hashCode() {
            return Objects.hash(namePattern, numberOfThreads, daemon);
        }
    }

    public static final class ExecutorServices {
        private final List<FixedExecutorServiceConfiguration> executorServiceConfigurations;

        @JsonCreator
        public ExecutorServices(List<FixedExecutorServiceConfiguration> executorServiceConfigurations) {
            this.executorServiceConfigurations = executorServiceConfigurations;
        }

        public List<FixedExecutorServiceConfiguration> getExecutorServiceConfigurations() {
            return executorServiceConfigurations;
        }

        @Override
        public String toString() {
            return "ExecutorServices{" +
                    "executorServiceConfigurations=" + executorServiceConfigurations +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ExecutorServices that = (ExecutorServices) o;
            return Objects.equals(executorServiceConfigurations, that.executorServiceConfigurations);
        }

        @Override
        public int hashCode() {
            return Objects.hash(executorServiceConfigurations);
        }
    }
}
