package com.felix.ludus.creator.service;

import com.felix.ludus.creator.repository.model.GameTemplate;
import com.felix.ludus.creator.repository.GameTemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameTemplateService {

    private final GameTemplateRepository gameTemplateRepository;

    public GameTemplateService(GameTemplateRepository gameTemplateRepository) {
        this.gameTemplateRepository = gameTemplateRepository;
    }

    public Optional<GameTemplate> findGameTemplate(Long id) {
        return gameTemplateRepository.findById(id);
    }

    public List<GameTemplate> findAll() {
        return gameTemplateRepository.findAll();
    }

    public void store(GameTemplate gameTemplate) {
        gameTemplateRepository.save(gameTemplate);
    }

    public void delete(Long id) {
        gameTemplateRepository.deleteById(id);
    }
}
