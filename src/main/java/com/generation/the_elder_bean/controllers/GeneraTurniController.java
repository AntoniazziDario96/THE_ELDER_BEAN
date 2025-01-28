package com.generation.the_elder_bean.controllers;

import com.generation.the_elder_bean.controllers.helper.ControllerHelper;
import com.generation.the_elder_bean.models.dto.TurnoNuovoRequest;
import com.generation.the_elder_bean.models.entities.CombatRequest;
import com.generation.the_elder_bean.models.entities.Combattimento;
import com.generation.the_elder_bean.models.entities.Personaggio;
import com.generation.the_elder_bean.models.entities.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/turni")
public class GeneraTurniController
{


	@Autowired
	ControllerHelper combatHelper;


	@GetMapping("/{id1}/{id2}")
	public Turno getTurno(@PathVariable int id1, @PathVariable int id2)
	{
		Personaggio personaggio1 = combatHelper.combattenteByid(id1);
		Personaggio personaggio2 = combatHelper.combattenteByid(id2);
		Turno primoTurno = new Turno(personaggio1, personaggio2);
		return primoTurno;
	}


	@PostMapping("/prossimo/{mossap1}/{mossap2}")
	public ResponseEntity<Turno> prossimoTurno(@RequestBody Turno turno, @PathVariable String mossap1, @PathVariable String mossap2)
	{


		Turno risultato = combatHelper.turnoGenerator(turno, mossap1.toLowerCase(), mossap2.toLowerCase());


		return ResponseEntity.ok(risultato);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Personaggio> getcombattente(@PathVariable long id)

	{
		Personaggio a = combatHelper.combattenteByid(id);
		return ResponseEntity.ok(a);
	}

}