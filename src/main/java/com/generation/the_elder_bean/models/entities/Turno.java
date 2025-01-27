package com.generation.the_elder_bean.models.entities;

import java.util.Random;

public class Turno
{

	private Personaggio personaggio1, personaggio2;
	private String primoAdAttaccare, secondoAdAttaccare;
	private int vitaPrimoAdAttaccare, vitaSecondoAdAttaccare, dannoPrimoAdAttaccare, dannoSecondoAdAttaccare;
	private boolean evasoPrimoAdAttacare, evasoSecondoAdAttaccare, crittatoPrimoAdAttaccare, crittatoSecondoAdAttaccare;
	private String log;

	public Turno()
	{

	}

	public Turno(Personaggio personaggio1, Personaggio personaggio2)
	{
		this.personaggio1 = personaggio1;
		this.personaggio2 = personaggio2;
	}

	public String getLog()
	{
		return log;
	}

	public void setLog(String log)
	{
		this.log = log;
	}

	private String mossaPrimoAdAttaccare, mossaSecondoAdAttaccare;

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

	public Turno(Turno t, String mossePuno, String mossePdue)
	{
		this(t.personaggio1, t.personaggio2, mossePuno, mossePdue);
	}

	public Turno(Personaggio personaggio1, Personaggio personaggio2, String mossePuno, String mossePdue)
	{
		log = "";
		Random random = new Random();
		setPersonaggio1(personaggio1);
		setPersonaggio2(personaggio2);

		Personaggio[] ordine = velocità(this.personaggio1, this.personaggio2);
		Personaggio p1 = ordine[0];
		primoAdAttaccare = p1.getNome();
		Personaggio p2 = ordine[1];
		secondoAdAttaccare = p2.getNome();

		if (p1 == personaggio1)
		{
			mossaPrimoAdAttaccare = mossePuno;
			mossaSecondoAdAttaccare = mossePdue;


		}
		else
		{
			mossaPrimoAdAttaccare = mossePdue;

			mossaSecondoAdAttaccare = mossePuno;

		}

		int a = 0;
		boolean attaccoParte = true;
		String mossa = mossaPrimoAdAttaccare;
		eseguiMosse(mossa, p1, p2);

		if (mossaPrimoAdAttaccare.equals("attacco normale") || mossaPrimoAdAttaccare.equals("attacco pesante") || mossaPrimoAdAttaccare.equals("attacco perforante"))

		{
			attaccoParte = true;
		}
		else

		{
			attaccoParte = false;
		}

		log = log + p1.getNome() + " usa " + mossa + " ";
		if (attaccoParte == true)

		{
			log = eseguiAttacco(p1, p2, a, log);

		}

		a = 1;

		if (p2.getVita() > 0)

		{
			Personaggio temp = p1; // Salva il valore corrente di p1
			p1 = p2; // Assegna p2 a p1
			p2 = temp; // Ripristina il valore originale di p1 in p2
			mossa = mossaSecondoAdAttaccare;
			attaccoParte = true;
			log = log + p1.getNome() + " usa " + mossa + " ";
			eseguiMosse(mossa, p1, p2);

			if (mossaSecondoAdAttaccare.equals("attacco normale") || mossaSecondoAdAttaccare.equals("attacco pesante") || mossaSecondoAdAttaccare.equals("attacco perforante"))
			{
				attaccoParte = true;
			}
			else
			{
				attaccoParte = false;
			}
			if (attaccoParte == true)


			{
				log = eseguiAttacco(p1, p2, a, log);
			}

		}
		else
		{
			vitaPrimoAdAttaccare = p1.getVita();
		}



		p1.decrementDurations();
		p2.decrementDurations();


		System.out.println("----------------------------------------------------------------------------------");

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


	private String eseguiAttacco(Personaggio p1, Personaggio p2, int a, String log)
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
				dannoCritico = (p1.attacco);
				crittato = true;
			}

			// Calcolo del danno base
			danno = Math.max((p1.getAttacco() - p2.getDifesa()), p1.getAttacco() * 30 / 100);
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
			return log = log + " " + (p2.getNome() + " ha schivato l'attacco di " + p1.getNome() + " ");
		}
		else
		{
			return log = log + " Il colpo di " + p1.getNome() +
					" ha colpito " + p2.getNome() +
					(crittato ? " e ha crittato" : "") +
					" infliggendogli " + danno + " danni, ora la vita di " + p2.getNome() + " è " + p2.getVita() + " ";

		}
	}

	public void attaccoNormale()
	{

	}

	public void attaccoPesante(Personaggio p1)
	{
		p1.setAttaccoBuffato((int) (p1.attacco * 1.3));
		p1.setDifesaNerfata((int) (p1.difesa * 0.5));
		p1.setEvasioneNerfato((int) (p1.evasione * 0.5));
		p1.setDurataNerfDifesa(2);
		p1.setDurataNerfEvasione(2);
		p1.setDurataBuffAttacco(1);
	}

	public void difesaPotenziata(Personaggio p1)
	{


		int buff = (int) (p1.difesa*0.2);
		if (buff < 0)
			buff = 1;
		p1.setDifesaBuffata(buff);


		p1.setDurataBuffDifesa(3);

	}

	public void evasionePotenziata(Personaggio p1)
	{

		int buff = (int) (p1.evasione*0.2);
		if (buff < 0)
			buff = 1;
		p1.setEvasioneBuffata(buff);


		p1.setDurataBuffEvasione(3);

	}


	public void attaccoPerforante(Personaggio p2,Personaggio p1)
	{
		p2.setDifesaNerfata((int) (p2.difesa*0.5));
		p2.setDurataNerfDifesa(3);
		p1.setAttaccoNerfato(p2.getAttacco());
		p1.setDurataNerfAttacco(1);



	}

	public void retePesante(Personaggio p2 ,Personaggio p1)
	{

		p2.setEvasioneNerfato((int) (p2.evasione * 0.5));
		p2.setDurataNerfEvasione(3);
		p1.setAttaccoNerfato(p2.getAttacco());
		p1.setDurataNerfAttacco(1);



	}

	public void cura(Personaggio p1)
	{
		if (p1.curaUsata()==false)
		{
			int vitaPreCura = p1.getVita();
			p1.setVita((int) ((vitaPreCura+(((200)-vitaPreCura) * 0.3))));

			p1.setVelocitaNerfata(100);
			p1.setDurataNerfVelocita(2);
			p1.setCuraUsata(true);
			System.out.println(p1.getNome() + "si è curato del 30% della vita mancante e la sua vita è passata da " + vitaPreCura + " a " + p1.getVita());
		}
		else
		{
			System.out.println("pezzo di merda coglione bastardo di un " + p1.getNome() + " ti sei già curato mo non fai nulla tutto il turno ahahahahah AHAHAHAHHA ");


		}


	}

	public void eseguiMosse(String mossa, Personaggio p1, Personaggio p2)
	{
		String mossaEseguita = null;
		boolean corretto = false;

		switch (mossa)
		{
			case "attacco normale":
			{
				attaccoNormale();
				break;

			}
			case "attacco pesante":
			{
				attaccoPesante(p1);
				break;

			}

			case "attacco perforante":
			{
				attaccoPerforante(p2,p1);
				break;

			}
			case "difesa potenziata":
			{
				difesaPotenziata(p1);
				break;

			}
			case "evasione potenziata":
			{
				evasionePotenziata(p1);
				break;

			}
			case "cura":
			{
				cura(p1);
				break;

			}


		}


	}


}




