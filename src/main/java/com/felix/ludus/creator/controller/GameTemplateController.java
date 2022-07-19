package com.felix.ludus.creator.controller;

import com.felix.ludus.creator.dto.GameTemplateDto;
import com.felix.ludus.creator.mapper.GameTemplateMapper;
import com.felix.ludus.creator.repository.model.GameTemplate;
import com.felix.ludus.creator.repository.model.GameTemplateTypeEnum;
import com.felix.ludus.creator.service.GameTemplateService;
import com.felix.ludus.creator.validator.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class GameTemplateController {

    private final GameTemplateService gameTemplateService;
    private final GameTemplateMapper gameTemplateMapper;

    public GameTemplateController(GameTemplateService gameTemplateService, GameTemplateMapper gameTemplateMapper) {
        this.gameTemplateService = gameTemplateService;
        this.gameTemplateMapper = gameTemplateMapper;
    }

    @GetMapping("/gametemplate/{id}")
    public GameTemplateDto get(@PathVariable("id") Long id) {
        return gameTemplateMapper.map(gameTemplateService.findGameTemplate(id).orElse(new GameTemplate()));
    }

    @GetMapping("/gametemplate")
    public List<GameTemplateDto> list() {
        return gameTemplateService.findAll().stream().map(gameTemplate -> gameTemplateMapper.map(gameTemplate)).toList();
    }

    @PostMapping("/gametemplate")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity store(@RequestBody GameTemplateDto gameTemplateDto) {
        Validator validator = getValidatorForGameType(gameTemplateDto.getType());

        List<String> errorMessages = validator.validate(gameTemplateDto.getProperties());

        if(errorMessages.isEmpty()) {
            gameTemplateService.store(gameTemplateMapper.map(gameTemplateDto));
            return ResponseEntity.status(HttpStatus.CREATED).body(gameTemplateDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }
    }

    @DeleteMapping("/gametemplate/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Long id) {
        gameTemplateService.delete(id);
    }

    private Validator getValidatorForGameType(GameTemplateTypeEnum type) {
        Object validator = null;
        try {
            String className = "com.felix.ludus.creator.validator." + type.name + "Validator";
            Class c = Class.forName(className);

            Constructor constructor = c.getConstructor();

            validator = constructor.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException nsme){
            nsme.printStackTrace();
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        } catch (InstantiationException ie) {
            ie.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return (Validator) validator;
    }
}
