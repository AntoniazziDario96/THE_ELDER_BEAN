package com.generation.the_elder_bean.models.entities;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Personaggio extends BaseEntity
{
	private String nome;
	private int attacco, difesa, evasione, velocita, critico, vita;
	private int durataBuffAttacco, durataBuffDifesa, durataBuffEvasione, durataBuffVelocita, durataBuffCritico;
	private int attaccoBuffato, difesaBuffata, evasioneBuffata, velocitaBuffato, criticoBuffato;
	private String immagine;

	public String getImmagine()
	{
		return immagine;
	}

	public void setImmagine(String immagine)
	{
		this.immagine = immagine;
	}

	public void setDurataBuffAttacco(int durataBuffAttacco)
	{
		this.durataBuffAttacco = durataBuffAttacco;
	}

	public void setDurataBuffDifesa(int durataBuffDifesa)
	{
		this.durataBuffDifesa = durataBuffDifesa;
	}

	public void setDurataBuffEvasione(int durataBuffEvasione)
	{
		this.durataBuffEvasione = durataBuffEvasione;
	}

	public void setDurataBuffVelocita(int durataBuffVelocita)
	{
		this.durataBuffVelocita = durataBuffVelocita;
	}

	public void setDurataBuffCritico(int durataBuffCritico)
	{
		this.durataBuffCritico = durataBuffCritico;
	}

	public void setAttaccoBuffato(int attaccoBuffato)
	{
		this.attaccoBuffato = attaccoBuffato;
	}

	public void setDifesaBuffata(int difesaBuffata)
	{
		this.difesaBuffata = difesaBuffata;
	}

	public void setEvasioneBuffata(int evasioneBuffata)
	{
		this.evasioneBuffata = evasioneBuffata;
	}

	public void setVelocitaBuffato(int velocitaBuffato)
	{
		this.velocitaBuffato = velocitaBuffato;
	}

	public void setCriticoBuffato(int criticoBuffato)
	{
		this.criticoBuffato = criticoBuffato;
	}

	public int getAttacco()
	{
		if (durataBuffAttacco == 0)
		{
			return attacco;

		}
		else
			return attaccoBuffato + attacco;
	}


	public void setAttacco(int attacco)
	{
		this.attacco = attacco;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome) throws IllegalArgumentException
	{
		if (nome == null)
		{
			throw new IllegalArgumentException("Ti sei dimenticato di mettere il nome");
		}

		this.nome = nome;
	}

	public int getDifesa()
	{
		if (durataBuffDifesa == 0)
		{
			return difesa;
		}
		return difesa + difesaBuffata;
	}


	public void setDifesa(int difesa)
	{
		this.difesa = difesa;
	}

	public int getEvasione()
	{
		if (durataBuffEvasione == 0)
		{
			return evasione;
		}
		return evasione + evasioneBuffata;
	}

	public void setEvasione(int evasione)
	{
		this.evasione = evasione;
	}

	public int getVelocita()
	{
		if (durataBuffVelocita == 0)
		{
			return velocita + velocitaBuffato;
		}
		return velocita;
	}

	public void setVelocita(int velocita)
	{
		this.velocita = velocita;
	}

	public int getCritico()
	{
		if (durataBuffCritico == 0)
		{
			return critico + criticoBuffato;
		}
		return critico;
	}

	public void setCritico(int critico)
	{
		this.critico = critico;
	}


	public int getVita()
	{
		return vita;
	}

	public void setVita(int vita)
	{
		this.vita = vita;
	}


}
