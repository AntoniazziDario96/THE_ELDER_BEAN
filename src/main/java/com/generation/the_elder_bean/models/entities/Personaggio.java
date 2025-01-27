package com.generation.the_elder_bean.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.util.List;

@Entity
public class Personaggio extends BaseEntity
{
	private String nome;
	public int attacco, difesa, evasione, velocita, critico, vita;
	@Transient
	private int durataBuffAttacco, durataBuffDifesa, durataBuffEvasione, durataBuffVelocita, durataBuffCritico, durataNerfAttacco, durataNerfDifesa, durataNerfEvasione, durataNerfVelocita, durataNerfCritico;
	@Transient
	private int attaccoBuffato, difesaBuffata, evasioneBuffata, velocitaBuffato, criticoBuffato, attaccoNerfato, difesaNerfata, evasioneNerfato, velocitaNerfata, criticoNerfato;
	private String immagine;
	@Transient
	private boolean curaUsata;

	public int getDurataBuffAttacco()
	{
		return durataBuffAttacco;
	}

	public int getDurataBuffDifesa()
	{
		return durataBuffDifesa;
	}

	public int getDurataBuffEvasione()
	{
		return durataBuffEvasione;
	}

	public int getDurataBuffVelocita()
	{
		return durataBuffVelocita;
	}

	public int getDurataBuffCritico()
	{
		return durataBuffCritico;
	}

	public int getDurataNerfAttacco()
	{
		return durataNerfAttacco;
	}

	public int getDurataNerfDifesa()
	{
		return durataNerfDifesa;
	}

	public int getDurataNerfEvasione()
	{
		return durataNerfEvasione;
	}

	public int getDurataNerfVelocita()
	{
		return durataNerfVelocita;
	}

	public int getDurataNerfCritico()
	{
		return durataNerfCritico;
	}

	public int getAttaccoBuffato()
	{
		return attaccoBuffato;
	}

	public int getDifesaBuffata()
	{
		return difesaBuffata;
	}

	public int getEvasioneBuffata()
	{
		return evasioneBuffata;
	}

	public int getVelocitaBuffato()
	{
		return velocitaBuffato;
	}

	public int getCriticoBuffato()
	{
		return criticoBuffato;
	}

	public int getAttaccoNerfato()
	{
		return attaccoNerfato;
	}

	public int getDifesaNerfata()
	{
		return difesaNerfata;
	}

	public int getEvasioneNerfato()
	{
		return evasioneNerfato;
	}

	public int getVelocitaNerfata()
	{
		return velocitaNerfata;
	}

	public int getCriticoNerfato()
	{
		return criticoNerfato;
	}

	public boolean isCuraUsata()
	{
		return curaUsata;
	}

	public boolean curaUsata()
	{
		return curaUsata;
	}

	public void setCuraUsata(boolean curaUsata)
	{
		this.curaUsata = curaUsata;
	}

	public void setDurataNerfAttacco(int durataNerfAttacco)
	{
		this.durataNerfAttacco = durataNerfAttacco;
	}

	public void setDurataNerfDifesa(int durataNerfDifesa)
	{
		this.durataNerfDifesa = durataNerfDifesa;
	}

	public void setDurataNerfEvasione(int durataNerfEvasione)
	{
		this.durataNerfEvasione = durataNerfEvasione;
	}

	public void setDurataNerfVelocita(int durataNerfVelocita)
	{
		this.durataNerfVelocita = durataNerfVelocita;
	}

	public void setDurataNerfCritico(int durataNerfCritico)
	{
		this.durataNerfCritico = durataNerfCritico;
	}

	public void setAttaccoNerfato(int attaccoNerfato)
	{
		this.attaccoNerfato = attaccoNerfato;
	}

	public void setDifesaNerfata(int difesaNerfata)
	{
		this.difesaNerfata = difesaNerfata;
	}

	public void setEvasioneNerfato(int evasioneNerfato)
	{
		this.evasioneNerfato = evasioneNerfato;
	}

	public void setVelocitaNerfata(int velocitaNerfata)
	{
		this.velocitaNerfata = velocitaNerfata;
	}

	public void setCriticoNerfato(int criticoNerfato)
	{
		this.criticoNerfato = criticoNerfato;
	}

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
		if (durataBuffAttacco == 0 && durataNerfAttacco == 0)
		{
			return attacco;

		}
		if (!(durataBuffAttacco == 0) && durataNerfAttacco == 0)
		{

			return attaccoBuffato + attacco;
		}
		if ((durataBuffAttacco == 0 && !(durataNerfAttacco == 0)))
		{

			return attacco - attaccoNerfato;
		}
		else
		{

			return attacco + attaccoBuffato - attaccoNerfato;
		}
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
		if (durataBuffDifesa == 0 && durataNerfDifesa == 0)
		{
			return difesa;
		}
		else if (durataBuffDifesa != 0 && durataNerfDifesa == 0)
		{

			return difesa + difesaBuffata;
		}
		else if (durataBuffDifesa == 0 && durataNerfDifesa!=0)
		{

			return difesa - difesaNerfata;
		}
		else
		{

			return difesa + difesaBuffata - difesaNerfata;
		}
	}


	public void setDifesa(int difesa)
	{
		this.difesa = difesa;
	}

	public int getEvasione()
	{
		if (durataBuffEvasione == 0 && durataNerfEvasione == 0)
		{
			return evasione;
		}
		if ((durataBuffEvasione != 0) && durataNerfEvasione == 0)
		{

			return evasione + evasioneBuffata;
		}
		if ((durataBuffEvasione == 0) && (durataNerfEvasione != 0))
		{

			return evasione - evasioneNerfato;
		}
		else
		{

			return evasione + evasioneBuffata - evasioneNerfato;
		}
	}

	public void setEvasione(int evasione)
	{
		this.evasione = evasione;
	}

	public int getVelocita()
	{
		if (durataBuffVelocita == 0 && durataNerfVelocita == 0)
		{
			return velocita;
		}
		if ((durataBuffVelocita == 0) && (durataNerfVelocita != 0))
		{

			return velocita -velocitaNerfata;
		}
		if ((durataNerfVelocita == 0) && (durataBuffVelocita != 0))
		{

			return velocita + velocitaBuffato;
		}

		return velocita + velocitaBuffato - velocitaNerfata;
	}

	public void setVelocita(int velocita)
	{
		this.velocita = velocita;
	}

	public int getCritico()
	{
		if (durataBuffCritico == 0 && durataNerfCritico == 0)
		{
			return critico;
		}
		if ((durataNerfCritico == 0) && (durataBuffCritico != 0))
		{

			return critico + criticoBuffato;
		}
		if (durataNerfCritico != 0 && (durataBuffCritico == 0))
		{


			return critico - criticoNerfato;
		}
		return critico + criticoBuffato - criticoNerfato;
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



	public void decrementDurations() {
		// Decrementa ciascuna durata se maggiore di 0
		if (durataBuffAttacco > 0) durataBuffAttacco--;
		if (durataBuffDifesa > 0) durataBuffDifesa--;
		if (durataBuffEvasione > 0) durataBuffEvasione--;
		if (durataBuffVelocita > 0) durataBuffVelocita--;
		if (durataBuffCritico > 0) durataBuffCritico--;
		if (durataNerfAttacco > 0) durataNerfAttacco--;
		if (durataNerfDifesa > 0) durataNerfDifesa--;
		if (durataNerfEvasione > 0) durataNerfEvasione--;
		if (durataNerfVelocita > 0) durataNerfVelocita--;
		if (durataNerfCritico > 0) durataNerfCritico--;
	}


}
