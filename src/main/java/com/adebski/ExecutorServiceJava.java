package com.adebski;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ExecutorServiceJava {
    public static final class FixedExecutorServiceConfiguration {
        private final String namePattern;
        private final int numberOfThreads;
        private final boolean daemon;

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
            ExecutorServiceJava.FixedExecutorServiceConfiguration that = (ExecutorServiceJava.FixedExecutorServiceConfiguration) o;
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
        private final List<ExecutorServiceJava.FixedExecutorServiceConfiguration> executorServiceConfigurations;

        public ExecutorServices(List<ExecutorServiceJava.FixedExecutorServiceConfiguration> executorServiceConfigurations) {
            this.executorServiceConfigurations = executorServiceConfigurations;
        }

        public List<ExecutorServiceJava.FixedExecutorServiceConfiguration> getExecutorServiceConfigurations() {
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
            ExecutorServiceJava.ExecutorServices that = (ExecutorServiceJava.ExecutorServices) o;
            return Objects.equals(executorServiceConfigurations, that.executorServiceConfigurations);
        }

        @Override
        public int hashCode() {
            return Objects.hash(executorServiceConfigurations);
        }
    }

    public static final ExecutorServices EXAMPLE_CONFIGURATION =
        new ExecutorServices(
            Arrays.asList(
                new FixedExecutorServiceConfiguration(
                    "first-test-pool-%d",
                    6,
                    true),
                new FixedExecutorServiceConfiguration(
                    "second-test-pool-%d",
                    3,
                    true
                )
            )
        );
}
