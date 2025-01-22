package com.generation.the_elder_bean.controllers.helper;

import com.generation.the_elder_bean.models.entities.Combattimento;
import com.generation.the_elder_bean.models.entities.Personaggio;
import com.generation.the_elder_bean.models.repositories.PersonaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControllerHelperImpl implements ControllerHelper
{

	@Autowired
	PersonaggioRepository pgRep;




	@Override
	public Personaggio combattenteByid(long id)
	{

		Personaggio pg1 = pgRep.findById(id).get();

		return pg1;
	}

	@Override
	public Combattimento combattiamoooo(long id1, long id2)
	{
		Personaggio pg1 = combattenteByid(id1);
		Personaggio pg2 = combattenteByid(id2);
		Combattimento combat = new Combattimento(pg1, pg2);
		combat.combatti();
		return combat;
	}
}
