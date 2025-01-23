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
@RequestMapping("/api/combattimento")
public class CombattimentoController
{


	@Autowired
	ControllerHelper combatHelper;

	@PostMapping("/esegui")
	public ResponseEntity<Combattimento> eseguiCombattimento(@RequestBody CombatRequest combatRequest)
	{
		long id1 = combatRequest.getId1();
		long id2 = combatRequest.getId2();

		Combattimento risultato = combatHelper.combattiamoooo(id1, id2);


		return ResponseEntity.ok(risultato);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Personaggio> getcombattente(@PathVariable long id)

	{
		Personaggio a = combatHelper.combattenteByid(id);
		return ResponseEntity.ok(a);
	}

}
