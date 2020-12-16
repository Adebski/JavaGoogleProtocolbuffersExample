package com.adebski;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * JSON schema that describes Java ExecutorService configuration.
 *
 * Generated using http://www.jsonschema2pojo.org/.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "executorServiceConfigurations"
})
public class ExecutorServiceJSONSchema {

    @JsonProperty("executorServiceConfigurations")
    private List<ExecutorServiceConfiguration> executorServiceConfigurations = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ExecutorServiceJSONSchema() {
    }

    /**
     *
     * @param executorServiceConfigurations
     */
    public ExecutorServiceJSONSchema(List<ExecutorServiceConfiguration> executorServiceConfigurations) {
        super();
        this.executorServiceConfigurations = executorServiceConfigurations;
    }

    @JsonProperty("executorServiceConfigurations")
    public List<ExecutorServiceConfiguration> getExecutorServiceConfigurations() {
        return executorServiceConfigurations;
    }

    @JsonProperty("executorServiceConfigurations")
    public void setExecutorServiceConfigurations(List<ExecutorServiceConfiguration> executorServiceConfigurations) {
        this.executorServiceConfigurations = executorServiceConfigurations;
    }

    public ExecutorServiceJSONSchema withExecutorServiceConfigurations(List<ExecutorServiceConfiguration> executorServiceConfigurations) {
        this.executorServiceConfigurations = executorServiceConfigurations;
        return this;
    }

}