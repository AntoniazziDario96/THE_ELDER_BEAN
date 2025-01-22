package com.generation.the_elder_bean.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Random;

public class Turno
{
	@JsonIgnore
	private Personaggio personaggio1, personaggio2;
	private String primoAdAttaccare, secondoAdAttaccare;
	private long vitaPersonaggio1, vitaPersonaggio2, dannoPersonaggio1, dannoPersonaggio2;
	private boolean evasoPersonaggio1, evasoPersonaggio2, crittatoPersonaggio1, crittatoPersonaggio2;

	public String getPrimoAdAttaccare()
	{
		return primoAdAttaccare;
	}

	public String getSecondoAdAttaccare()
	{
		return secondoAdAttaccare;
	}

	public long getVitaPersonaggio1()
	{
		return vitaPersonaggio1;
	}

	public long getVitaPersonaggio2()
	{
		return vitaPersonaggio2;
	}

	public long getDannoPersonaggio1()
	{
		return dannoPersonaggio1;
	}

	public long getDannoPersonaggio2()
	{
		return dannoPersonaggio2;
	}

	public boolean isEvasoPersonaggio1()
	{
		return evasoPersonaggio1;
	}

	public boolean isEvasoPersonaggio2()
	{
		return evasoPersonaggio2;
	}

	public boolean isCrittatoPersonaggio1()
	{
		return crittatoPersonaggio1;
	}

	public boolean isCrittatoPersonaggio2()
	{
		return crittatoPersonaggio2;
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



		int a =0;
		eseguiAttacco(p1,p2,a);
		a=1;
		Personaggio c = null;
		if (p2.getVita() > 0)//gruppo R6 mi ha aiuto
			c = p2;
		p1 = p2;
		p2 = c;
		eseguiAttacco(p1,p2,a);



	}

	//calcola chi inizia il turno
	public Personaggio[] velocità(Personaggio personaggio1, Personaggio personaggio2)
	{
		Random random = new Random();
		long velocitap1 = 0;
		long velocitap2 = 0;
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

	public void attaccoPesante(Personaggio personaggio1, Personaggio personaggio2)
	{



	}
	private void eseguiAttacco(Personaggio p1, Personaggio p2,  int a) {
		Random random = new Random();
		long danno = 0;
		boolean evaso = false;
		boolean crittato = false;


		// Determina se il difensore evade
		if (random.nextInt(1, 11) >= p2.getEvasione()) {
			evaso = false;

			// Calcolo del danno critico
			long dannoCritico = 0;
			if (random.nextInt(1, 11) <= p1.getCritico()) {
				dannoCritico = (p1.getAttacco() - p2.getDifesa()) + p1.getAttacco();
				crittato = true;
			}

			// Calcolo del danno base
			danno = Math.max(
					(p1.getAttacco() - p2.getDifesa()),
					p1.getAttacco() * 40 / 100
			);
			danno += dannoCritico;

			// Aggiornamento della vita del difensore
			p2.setVita(p2.getVita() - danno);
		} else {
			evaso = true;
		}

		// Aggiorna le variabili di stato per il turno
		if (a==0) {
			dannoPersonaggio1 = danno;
			evasoPersonaggio1 = evaso;
			crittatoPersonaggio1 = crittato;
			vitaPersonaggio2 = p2.getVita();

		} else {
			dannoPersonaggio2 = danno;
			evasoPersonaggio2 = evaso;
			crittatoPersonaggio2 = crittato;
			vitaPersonaggio1 = p2.getVita();
		}



		// Stampa del risultato
		if (evaso) {
			System.out.println(p2.getNome() + " ha schivato l'attacco di " + p1.getNome());
		} else {
			System.out.println(
					"Il colpo di " + p1.getNome() +
							" ha colpito " + p2.getNome() +
							(crittato ? " e ha crittato" : "") +
							" infliggendogli " + danno + " danni, ora la vita di " + p2.getNome() + " è " + p2.getVita()
			);
		}
	}

}

