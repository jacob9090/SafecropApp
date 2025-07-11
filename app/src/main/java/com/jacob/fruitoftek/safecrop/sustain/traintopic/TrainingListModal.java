package com.jacob.fruitoftek.safecrop.sustain.traintopic;

import java.io.Serializable;

public class TrainingListModal implements Serializable {

    private String topic;
    private String description;

    public TrainingListModal(String topic, String description) {
        this.topic = topic;
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}