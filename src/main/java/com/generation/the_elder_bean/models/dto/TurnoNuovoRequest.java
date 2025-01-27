package com.generation.the_elder_bean.models.dto;

import com.generation.the_elder_bean.models.entities.Turno;

public class TurnoNuovoRequest
{
	Turno turnoP;
	String mossap1;
	String mossap2;


	public Turno getTurnoP()
	{
		return turnoP;
	}

	public void setTurnoP(Turno turnoP)
	{
		this.turnoP = turnoP;
	}

	public String getMossap1()
	{
		return mossap1;
	}

	public void setMossap1(String mossap1)
	{
		this.mossap1 = mossap1;
	}

	public String getMossap2()
	{
		return mossap2;
	}

	public void setMossap2(String mossap2)
	{
		this.mossap2 = mossap2;
	}
}
