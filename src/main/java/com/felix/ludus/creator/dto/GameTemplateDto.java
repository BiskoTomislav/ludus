package com.felix.ludus.creator.dto;

import com.felix.ludus.creator.repository.model.GameTemplateTypeEnum;

import java.util.Map;
import java.util.Objects;

public class GameTemplateDto {

    private String name;

    private GameTemplateTypeEnum type;

    private Map<String, String> properties;

    public GameTemplateDto(String name, GameTemplateTypeEnum type, Map<String, String> properties) {
        this.name = name;
        this.type = type;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameTemplateTypeEnum getType() {
        return type;
    }

    public void setType(GameTemplateTypeEnum type) {
        this.type = type;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "GameTemplateDto{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", properties=" + properties +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameTemplateDto that = (GameTemplateDto) o;
        return Objects.equals(name, that.name) && type == that.type && Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, properties);
    }
}
