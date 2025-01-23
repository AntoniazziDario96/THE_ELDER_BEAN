package com.generation.the_elder_bean.models.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.generation.the_elder_bean.controllers.helper.ControllerHelper;
import com.generation.the_elder_bean.models.repositories.PersonaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class prova

{
	public static void main(String[] args) throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();


		Personaggio p1 = new Personaggio();
		Personaggio p2 = new Personaggio();
		p1.setNome("Guerriero");
		p1.setAttacco(10);
		p1.setDifesa(6);
		p1.setEvasione(2);
		p1.setVelocita(4);
		p1.setCritico(2);
		p1.setVita(200);


		// Impostazione attributi per p2
		p2.setNome("Assassino");
		p2.setAttacco(10);
		p2.setDifesa(2);
		p2.setEvasione(6);
		p2.setVelocita(6);
		p2.setCritico(3);
		p2.setVita(200);

		Combattimento c = new Combattimento(p1, p2);
		c.combatti();
		String json = mapper.writeValueAsString(c);
		System.out.println(json);
	}
}

