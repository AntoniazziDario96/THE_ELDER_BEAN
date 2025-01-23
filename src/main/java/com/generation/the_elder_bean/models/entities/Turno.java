package com.generation.the_elder_bean.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Random;

public class Turno
{
	@JsonIgnore
	private Personaggio personaggio1, personaggio2;
	private String primoAdAttaccare, secondoAdAttaccare;
	private int vitaPrimoAdAttaccare, vitaSecondoAdAttaccare, dannoPrimoAdAttaccare, dannoSecondoAdAttaccare;
	private boolean evasoPrimoAdAttacare, evasoSecondoAdAttaccare, crittatoPrimoAdAttaccare, crittatoSecondoAdAttaccare;

	public String getPrimoAdAttaccare()
	{
		return primoAdAttaccare;
	}

	public String getSecondoAdAttaccare()
	{
		return secondoAdAttaccare;
	}

	public int getVitaPrimoAdAttaccare()
	{
		return vitaPrimoAdAttaccare;
	}

	public int getVitaSecondoAdAttaccare()
	{
		return vitaSecondoAdAttaccare;
	}

	public int getDannoPrimoAdAttaccare()
	{
		return dannoPrimoAdAttaccare;
	}

	public int getDannoSecondoAdAttaccare()
	{
		return dannoSecondoAdAttaccare;
	}

	public boolean isEvasoPrimoAdAttacare()
	{
		return evasoPrimoAdAttacare;
	}

	public boolean isEvasoSecondoAdAttaccare()
	{
		return evasoSecondoAdAttaccare;
	}

	public boolean isCrittatoPrimoAdAttaccare()
	{
		return crittatoPrimoAdAttaccare;
	}

	public boolean isCrittatoSecondoAdAttaccare()
	{
		return crittatoSecondoAdAttaccare;
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


	public Turno(Personaggio personaggio1, Personaggio personaggio2)
	{
		Random random = new Random();

		Personaggio[] ordine = velocità(personaggio1, personaggio2);
		Personaggio p1 = ordine[0];
		primoAdAttaccare = p1.getNome();
		Personaggio p2 = ordine[1];
		secondoAdAttaccare = p2.getNome();


		int a = 0;
		int b = 0;
		if (b == 0)
		{
			eseguiAttacco(p1, p2, a);
		}

		a = 1;

		if (p2.getVita() > 0)
		{
			Personaggio temp = p1; // Salva il valore corrente di p1
			p1 = p2; // Assegna p2 a p1
			p2 = temp; // Ripristina il valore originale di p1 in p2

			b = 0;
			if (b == 0)
			{
				eseguiAttacco(p1, p2, a);
			}
		}
		else vitaPrimoAdAttaccare = p1.getVita();

		System.out.println("---------------------------------------------------------------------");
	}

	//calcola chi inizia il turno
	public Personaggio[] velocità(Personaggio personaggio1, Personaggio personaggio2)
	{
		Random random = new Random();
		int velocitap1 = 0;
		int velocitap2 = 0;
		Personaggio p1 = null;
		Personaggio p2 = null;
		do

		{

			velocitap1 = personaggio1.getVelocita() + random.nextInt(6) + 1;
			velocitap2 = personaggio2.getVelocita() + random.nextInt(6) + 1;


		}
		while (velocitap1 == velocitap2);
		if (velocitap1 > velocitap2)

		{
			primoAdAttaccare = personaggio1.getNome();
			p1 = personaggio1;
			p2 = personaggio2;
			secondoAdAttaccare = personaggio2.getNome();
		}
		else

		{
			primoAdAttaccare = personaggio2.getNome();
			p1 = personaggio2;
			p2 = personaggio1;
			secondoAdAttaccare = personaggio1.getNome();
		}
		return new Personaggio[]{p1, p2};

	}

	public void attaccoNormale()
	{

	}

	public void attaccoPesante(Personaggio p1)
	{
		p1.setAttacco(p1.getAttacco() * 2);
		p1.setDifesa(p1.getDifesa() - 4);
	}

	public void difesaPotenziata(Personaggio p1, int b)
	{
		p1.setDifesa(p1.getDifesa() + 3);
		b = 1;
	}

	public void attaccoPerforante(Personaggio p1, Personaggio p2)
	{
		p2.setDifesa((Math.round(p2.getDifesa() * 3) / 10) + p2.getDifesa());
		;
	}

	private void eseguiAttacco(Personaggio p1, Personaggio p2, int a)
	{
		Random random = new Random();
		int danno = 0;
		boolean evaso = false;
		boolean crittato = false;

		// Determina se il difensore evade
		if (random.nextInt(1, 11) >= p2.getEvasione())
		{
			evaso = false;

			// Calcolo del danno critico
			int dannoCritico = 0;
			if (random.nextInt(1, 11) <= p1.getCritico())
			{
				dannoCritico = (p1.getAttacco() - p2.getDifesa()) + p1.getAttacco();
				crittato = true;
			}

			// Calcolo del danno base
			danno = Math.max(
					(p1.getAttacco() - p2.getDifesa()),
					p1.getAttacco() * 40 / 100
			);
			danno += dannoCritico;
		}
		else
		{
			evaso = true;
		}

		// Aggiorna la vita del difensore

		p2.setVita(p2.getVita() - danno);

		// Aggiorna le variabili di stato per il turno

		if (a == 0)
		{
			dannoPrimoAdAttaccare = danno;
			evasoSecondoAdAttaccare = evaso;
			crittatoPrimoAdAttaccare = crittato;
			vitaSecondoAdAttaccare = p2.getVita();

		}
		else
		{
			dannoSecondoAdAttaccare = danno;
			evasoPrimoAdAttacare = evaso;
			crittatoSecondoAdAttaccare = crittato;
			vitaPrimoAdAttaccare = p2.getVita();

		}

		// Stampa del risultato
		if (evaso)
		{
			System.out.println(p2.getNome() + " ha schivato l'attacco di " + p1.getNome());
		}
		else
		{
			System.out.println(
					"Il colpo di " + p1.getNome() +
							" ha colpito " + p2.getNome() +
							(crittato ? " e ha crittato" : "") +
							" infliggendogli " + danno + " danni, ora la vita di " + p2.getNome() + " è " + p2.getVita()
			);
		}
	}


}

