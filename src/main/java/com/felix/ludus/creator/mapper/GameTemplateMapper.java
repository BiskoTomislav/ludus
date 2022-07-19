package com.felix.ludus.creator.mapper;

import com.felix.ludus.creator.dto.GameTemplateDto;
import com.felix.ludus.creator.repository.model.GameTemplate;
import org.springframework.stereotype.Component;

@Component
public class GameTemplateMapper {

    public GameTemplateDto map(GameTemplate gameTemplate) {
        return new GameTemplateDto(gameTemplate.getName(), gameTemplate.getType(), gameTemplate.getProperties());
    }

    public GameTemplate map(GameTemplateDto gameTemplateDto) {
        return new GameTemplate(gameTemplateDto.getName(), gameTemplateDto.getType(), gameTemplateDto.getProperties());
    }
}
