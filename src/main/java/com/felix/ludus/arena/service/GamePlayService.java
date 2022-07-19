package com.felix.ludus.arena.service;

import com.felix.ludus.arena.dto.GamePlayDto;
import com.felix.ludus.arena.gameplayer.GamePlayer;
import com.felix.ludus.creator.repository.GameTemplateRepository;
import com.felix.ludus.creator.repository.model.GameTemplate;
import com.felix.ludus.creator.repository.model.GameTemplateTypeEnum;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Service
public class GamePlayService {

    private final GameTemplateRepository gameTemplateRepository;

    public GamePlayService(GameTemplateRepository gameTemplateRepository) {
        this.gameTemplateRepository = gameTemplateRepository;
    }

    public Map<String, String> playGame(GamePlayDto gamePlayDto) {
        GameTemplate gameTemplate = gameTemplateRepository.findByName(gamePlayDto.getName());

        GamePlayer gamePlayer = getGamePlayerForGameType(gameTemplate.getType());

        return gamePlayer.play(gameTemplate.getProperties());
    }

    private GamePlayer getGamePlayerForGameType(GameTemplateTypeEnum type) {
        Object gamePlayer = null;
        try {
            String className = "com.felix.ludus.arena.gameplayer." + type.name + "GamePlayer";
            Class c = Class.forName(className);

            Constructor constructor = c.getConstructor();

            gamePlayer = constructor.newInstance();

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

        return (GamePlayer) gamePlayer;
    }
}
