package com.felix.ludus.creator.repository.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "GAME_TEMPLATE", uniqueConstraints = @UniqueConstraint(columnNames={"NAME"}))
@TypeDef(name = "json", typeClass = JsonType.class)
public class GameTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private GameTemplateTypeEnum type;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String, String> properties = new HashMap<>();

    public GameTemplate() {
    }

    public GameTemplate(Long id, String name, GameTemplateTypeEnum type, Map<String, String> properties) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.properties = properties;
    }

    public GameTemplate(String name, GameTemplateTypeEnum type, Map<String, String> properties) {
        this.name = name;
        this.type = type;
        this.properties = properties;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "GameTemplate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", properties=" + properties +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameTemplate that = (GameTemplate) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && type == that.type && Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, properties);
    }
}
