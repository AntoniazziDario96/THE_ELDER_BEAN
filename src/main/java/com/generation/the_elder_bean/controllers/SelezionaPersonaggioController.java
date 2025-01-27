package com.generation.the_elder_bean.controllers;

import com.generation.the_elder_bean.controllers.helper.ControllerHelper;
import com.generation.the_elder_bean.models.entities.CombatRequest;
import com.generation.the_elder_bean.models.entities.Combattimento;
import com.generation.the_elder_bean.models.entities.Personaggio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/selezione")
public class SelezionaPersonaggioController
{

	@Autowired
	ControllerHelper combatHelper;


	@GetMapping("/listaPersonaggi")
	public List<Personaggio> getAllCombattenti()

	{
		return combatHelper.getAllCombattenti();
	}

}
