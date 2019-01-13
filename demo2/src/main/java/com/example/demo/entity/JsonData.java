package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class JsonData implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String filePath;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    public JsonData(String name, String filePath, String status) {
        this.name = name;
        this.filePath = filePath;
        this.status = status;
    }

    public JsonData(String status, String error) {
        this.status = status;
        this.error = error;
    }

    public JsonData() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
