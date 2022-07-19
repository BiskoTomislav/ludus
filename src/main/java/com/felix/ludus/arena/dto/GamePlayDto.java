package com.felix.ludus.arena.dto;

public class GamePlayDto {
    String name;

    public GamePlayDto() {
    }

    public GamePlayDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGameName(String name) {
        this.name = name;
    }
}
