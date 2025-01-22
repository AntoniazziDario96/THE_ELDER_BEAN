package com.generation.the_elder_bean.controllers.helper;

import com.generation.the_elder_bean.models.entities.Combattimento;
import com.generation.the_elder_bean.models.entities.Personaggio;
import com.generation.the_elder_bean.models.repositories.PersonaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface ControllerHelper
{


	Personaggio combattenteByid(long id);

	Combattimento combattiamoooo(long id1, long id2);
}
