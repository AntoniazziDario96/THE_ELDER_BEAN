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

		vitaPersonaggio1 = p1.getVita();
		vitaPersonaggio2 = p2.getVita();
		if (random.nextInt(1, 11) >= p2.getEvasione())


		{
			evasoPersonaggio1 = false;
			crittatoPersonaggio1 = false;
			long dannoCritico = 0;
			if (random.nextInt(1, 11) <= p1.getCritico())
			{

				dannoCritico = (p1.getAttacco() - p2.getDifesa()) + p1.getAttacco();
				crittatoPersonaggio1 = true;
			}

			long danno = ((p1.getAttacco() - p2.getDifesa()));

			if ((danno) < (p2.getDifesa() * 40 / 100))

				danno = (p1.getAttacco() * 40 / 100);
			danno = dannoCritico + danno;
			dannoPersonaggio1 = danno;
			vitaPersonaggio2 = vitaPersonaggio2 - danno;
			p2.setVita(vitaPersonaggio2);

			System.out.println(
					"Il colpo di " + p1.getNome() +
							" ha colpito " + p2.getNome() +
							(crittatoPersonaggio1 ? " e ha crittato" : "") +
							" infliggendogli " + danno + " danni,ora la vita di " + p2.getNome() + " è " + p2.getVita()
			);

		}
		else
		{
			System.out.println(p2.getNome() + " ha schivato l' attacco di " + p1.getNome());
			evasoPersonaggio1 = true;
		}

		if (p2.getVita() > 0)//gruppo R6 mi ha aiuto
		{

			if (random.nextInt(1, 11) >= p1.getEvasione())

			{
				evasoPersonaggio2 = false;
				crittatoPersonaggio2 = false;
				long dannoCritico1 = 0;
				if (random.nextInt(1, 11) <= p2.getCritico())
				{
					dannoCritico1 = (p2.getAttacco() - p1.getDifesa()) + p2.getAttacco();
					crittatoPersonaggio2 = true;
				}

				long danno1 = ((p2.getAttacco() - p1.getDifesa()));

				if ((danno1) < (p1.getDifesa() * 40 / 100))

					danno1 = (p2.getAttacco() * 40 / 100);
				danno1 = dannoCritico1 + danno1;
				dannoPersonaggio2 = danno1;
				vitaPersonaggio1 = vitaPersonaggio1 - danno1;
				p1.setVita(vitaPersonaggio1);

				System.out.println(
						"Il colpo di " + p2.getNome() +
								" ha colpito " + p1.getNome() +
								(crittatoPersonaggio2 ? " e ha crittato" : "") +
								" infliggendogli " + danno1 + " danni, ora la vita di " + p1.getNome() + " è " + p1.getVita()
				);

			}
			else
			{
				System.out.println(p1.getNome() + " ha schivato l'attacco di " + p2.getNome());
				evasoPersonaggio2 = true;
			}

		}


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

}

