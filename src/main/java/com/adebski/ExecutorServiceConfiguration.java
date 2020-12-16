package com.adebski;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Generated using http://www.jsonschema2pojo.org/.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "namePattern",
    "numberOfThreads",
    "daemon"
})
public class ExecutorServiceConfiguration {

    /**
     * The name pattern used to create threads managed by this ExecutorService.
     * (Required)
     *
     */
    @JsonProperty("namePattern")
    @JsonPropertyDescription("The name pattern used to create threads managed by this ExecutorService.")
    private String namePattern;
    /**
     * The number of threads managed by this ExecutorService.
     * (Required)
     *
     */
    @JsonProperty("numberOfThreads")
    @JsonPropertyDescription("The number of threads managed by this ExecutorService.")
    private int numberOfThreads;
    /**
     * If threads managed by this ExecutorService should be daemon threads or not
     * (Required)
     *
     */
    @JsonProperty("daemon")
    @JsonPropertyDescription("If threads managed by this ExecutorService should be daemon threads or not")
    private boolean daemon;

    /**
     * No args constructor for use in serialization
     *
     */
    public ExecutorServiceConfiguration() {
    }

    /**
     *
     * @param namePattern
     * @param numberOfThreads
     * @param daemon
     */
    public ExecutorServiceConfiguration(String namePattern, int numberOfThreads, boolean daemon) {
        super();
        this.namePattern = namePattern;
        this.numberOfThreads = numberOfThreads;
        this.daemon = daemon;
    }

    /**
     * The name pattern used to create threads managed by this ExecutorService.
     * (Required)
     *
     */
    @JsonProperty("namePattern")
    public String getNamePattern() {
        return namePattern;
    }

    /**
     * The name pattern used to create threads managed by this ExecutorService.
     * (Required)
     *
     */
    @JsonProperty("namePattern")
    public void setNamePattern(String namePattern) {
        this.namePattern = namePattern;
    }

    public ExecutorServiceConfiguration withNamePattern(String namePattern) {
        this.namePattern = namePattern;
        return this;
    }

    /**
     * The number of threads managed by this ExecutorService.
     * (Required)
     *
     */
    @JsonProperty("numberOfThreads")
    public int getNumberOfThreads() {
        return numberOfThreads;
    }

    /**
     * The number of threads managed by this ExecutorService.
     * (Required)
     *
     */
    @JsonProperty("numberOfThreads")
    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public ExecutorServiceConfiguration withNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        return this;
    }

    /**
     * If threads managed by this ExecutorService should be daemon threads or not
     * (Required)
     *
     */
    @JsonProperty("daemon")
    public boolean isDaemon() {
        return daemon;
    }

    /**
     * If threads managed by this ExecutorService should be daemon threads or not
     * (Required)
     *
     */
    @JsonProperty("daemon")
    public void setDaemon(boolean daemon) {
        this.daemon = daemon;
    }

    public ExecutorServiceConfiguration withDaemon(boolean daemon) {
        this.daemon = daemon;
        return this;
    }

}