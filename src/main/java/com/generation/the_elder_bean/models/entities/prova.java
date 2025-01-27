package com.generation.the_elder_bean.models.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.generation.the_elder_bean.controllers.helper.ControllerHelper;
import com.generation.the_elder_bean.models.repositories.PersonaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RestController;


public class prova

{
	public static void main(String[] args) throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();


		Personaggio p1 = new Personaggio();
		Personaggio p2 = new Personaggio();
		p1.setNome("Guerriero");
		p1.setAttacco(10);
		p1.setDifesa(5);
		p1.setEvasione(5);
		p1.setVelocita(7);
		p1.setCritico(3);
		p1.setVita(200);


		// Impostazione attributi per p2
		p2.setNome("Assassino");
		p2.setAttacco(10);
		p2.setDifesa(5);
		p2.setEvasione(5);
		p2.setVelocita(6);
		p2.setCritico(1);
		p2.setVita(200);
		Turno t0 = new Turno(p1, p2);
		String json0 = mapper.writeValueAsString(t0);
		System.out.println(json0);
		Turno t1 = new Turno(t0, "attacco pesante", "attacco pesante");

		String json = mapper.writeValueAsString(t1);
		System.out.println(json);
		Turno t2 = new Turno(t1, "attacco normale", "attacco normale");
		String json2 = mapper.writeValueAsString(t2);
		System.out.println(json2);

		Turno t3 = new Turno(t2, "attacco pesante", "attacco pesante");
		String json3 = mapper.writeValueAsString(t3);
		System.out.println(json3);
		Turno t4 = new Turno(t3, "attacco normale", "attacco normale");
		String json4 = mapper.writeValueAsString(t4);
		System.out.println(json4);
		Turno t5 = new Turno(t4, "attacco normale", "attacco pesante");

	}
}

