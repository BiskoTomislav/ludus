package com.felix.ludus.creator.dto;

import java.util.List;

public class GameTemplateResponseDto {

    String status;
    List<String> errorMessages;

    public GameTemplateResponseDto(String status, List<String> errorMessages) {
        this.status = status;
        this.errorMessages = errorMessages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
