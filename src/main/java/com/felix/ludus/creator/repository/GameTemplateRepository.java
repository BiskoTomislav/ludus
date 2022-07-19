package com.felix.ludus.creator.repository;

import com.felix.ludus.creator.repository.model.GameTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameTemplateRepository  extends JpaRepository<GameTemplate, Long> {
    GameTemplate findByName(String name);
}
