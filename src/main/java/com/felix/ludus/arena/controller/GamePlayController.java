package com.felix.ludus.arena.controller;

import com.felix.ludus.arena.dto.GamePlayDto;
import com.felix.ludus.arena.service.GamePlayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GamePlayController {

    private final GamePlayService gamePlayService;

    public GamePlayController(GamePlayService gamePlayService) {
        this.gamePlayService = gamePlayService;
    }

    @PostMapping("/gameplay")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity store(@RequestBody GamePlayDto gamePlayDto) {
        Map<String, String> results = gamePlayService.playGame(gamePlayDto);

        return ResponseEntity.ok(results);
    }

}
