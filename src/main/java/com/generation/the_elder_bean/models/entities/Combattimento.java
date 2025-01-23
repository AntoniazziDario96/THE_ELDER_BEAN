package com.generation.the_elder_bean.models.entities;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;


public class Combattimento
{

	private Personaggio personaggioVincente;
	private List<Turno> turni;
	private Personaggio personaggio1, personaggio2;

	public Combattimento(Personaggio personaggio1, Personaggio personaggio2)
	{
		this.personaggio1 = personaggio1;
		this.personaggio2 = personaggio2;
	}

	public Personaggio getPersonaggio2()
	{
		return personaggio2;
	}

	public void setPersonaggio2(Personaggio personaggio2)
	{
		this.personaggio2 = personaggio2;
	}

	public Personaggio getPersonaggio1()
	{
		return personaggio1;
	}

	public void setPersonaggio1(Personaggio personaggio1)
	{
		this.personaggio1 = personaggio1;
	}

	public Personaggio getPersonaggioVincente()
	{
		return personaggioVincente;
	}


	public List<Turno> getTurni()
	{
		return turni;
	}

	public void setTurni(List<Turno> turni)
	{
		this.turni = turni;
	}

	public void combatti()
	{
		turni = new ArrayList<>();

		while (personaggio1.getVita() > 0 && personaggio2.getVita() > 0)
		{
			Turno turno = new Turno(personaggio1, personaggio2);
			turni.add(turno);

		}
		if (personaggio1.getVita() > 0)
		{

			System.out.println(personaggio1.getNome() + " ha obliterato l'esistenza di " + personaggio2.getNome()+" dalla faccia della terra");
			personaggioVincente = personaggio1;
		}

		else
		{
			System.out.println(personaggio2.getNome() + " ha obliterato l'esistenza di " + personaggio1.getNome());
			personaggioVincente = personaggio2;

		}

	}


}
