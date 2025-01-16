package com.generation.the_elder_bean.models.entities;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Personaggio extends BaseEntity
{
	private String nome;
	private long attacco, difesa, evasione, velocita, critico, esperienza, livello, vita, stamina,gold;

	public long getAttacco()
	{
		return attacco;
	}

	public void setAttacco(long attacco)
	{
		this.attacco = attacco;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null) {
			throw new IllegalArgumentException("Ti sei dimenticato di mettere il nome");
		}

		this.nome = nome;
	}

	public long getDifesa()
	{
		return difesa;
	}

	public void setDifesa(long difesa)
	{
		this.difesa = difesa;
	}

	public long getEvasione()
	{
		return evasione;
	}

	public void setEvasione(long evasione)
	{
		this.evasione = evasione;
	}

	public long getVelocita()
	{
		return velocita;
	}

	public void setVelocita(long velocita)
	{
		this.velocita = velocita;
	}

	public long getCritico()
	{
		return critico;
	}

	public void setCritico(long critico)
	{
		this.critico = critico;
	}

	public long getEsperienza()
	{
		return esperienza;
	}

	public void setEsperienza(long esperienza)
	{
		this.esperienza = esperienza;
	}

	public long getLivello()
	{
		return livello;
	}

	public void setLivello(long livello)
	{
		this.livello = livello;
	}

	public long getVita()
	{
		return vita;
	}

	public void setVita(long vita)
	{
		this.vita = vita;
	}

	public long getStamina()
	{
		return stamina;
	}

	public void setStamina(long stamina)
	{
		this.stamina = stamina;
	}

	public long getGold()
	{
		return gold;
	}

	public void setGold(long gold)
	{
		this.gold = gold;
	}
}
