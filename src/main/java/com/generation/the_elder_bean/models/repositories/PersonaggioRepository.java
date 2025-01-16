package com.generation.the_elder_bean.models.repositories;

import com.generation.the_elder_bean.models.entities.Personaggio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaggioRepository extends JpaRepository<Personaggio, Long>
{
}
