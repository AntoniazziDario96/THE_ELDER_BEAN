package com.generation.the_elder_bean.controllers.helper;

import com.generation.the_elder_bean.models.entities.Combattimento;
import com.generation.the_elder_bean.models.entities.Personaggio;
import com.generation.the_elder_bean.models.entities.Turno;
import com.generation.the_elder_bean.models.repositories.PersonaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControllerHelperImpl implements ControllerHelper
{

	@Autowired
	PersonaggioRepository pgRep;


	@Override
	public Personaggio combattenteByid(long id)
	{

		Personaggio pg1 = pgRep.findById(id).get();

		return pg1;
	}

	@Override
	public Combattimento combattiamoooo(long id1, long id2)
	{
		Personaggio pg1 = combattenteByid(id1);
		Personaggio pg2 = combattenteByid(id2);
		Combattimento combat = new Combattimento(pg1, pg2);
		combat.combatti();
		return combat;
	}

	@Override
	public List<Personaggio> getAllCombattenti()
	{
		return pgRep.findAll();
	}

	@Override
	public Turno turnoGenerator(Turno turno1, String mossap1, String mossap2)
	{

		turno1.setPersonaggio1(resetBaseStat(turno1.getPersonaggio1()));
		turno1.setPersonaggio2(resetBaseStat(turno1.getPersonaggio2()));
		Turno t = new Turno(turno1, mossap1, mossap2);
		return t;

	}

	private Personaggio resetBaseStat(Personaggio pg1)
	{
		Personaggio r = pgRep.findById(pg1.getId()).get();
		r.setAttaccoNerfato(pg1.getAttaccoNerfato());
		r.setDurataNerfAttacco(pg1.getDurataNerfAttacco());
		r.setAttaccoBuffato(pg1.getAttaccoBuffato());
		r.setDurataBuffAttacco(pg1.getDurataBuffAttacco());
		r.setEvasioneNerfato(pg1.getEvasioneNerfato());
		r.setDurataNerfEvasione(pg1.getDurataNerfEvasione());
		r.setEvasioneBuffata(pg1.getEvasioneBuffata());
		r.setDurataBuffEvasione(pg1.getDurataBuffEvasione());
		r.setVita(pg1.getVita());
		r.setVelocitaNerfata(pg1.getVelocitaNerfata());
		r.setDurataNerfVelocita(pg1.getDurataNerfVelocita());
		r.setVelocitaBuffato(pg1.getVelocitaBuffato());
		r.setDurataBuffVelocita(pg1.getDurataBuffVelocita());

		r.setDifesaNerfata(pg1.getDifesaNerfata());
		r.setDurataNerfDifesa(pg1.getDurataNerfDifesa());
		r.setDifesaBuffata(pg1.getDifesaBuffata());
		r.setDurataBuffDifesa(pg1.getDurataBuffDifesa());
		r.setCuraUsata(pg1.isCuraUsata());
		r.setCriticoNerfato(pg1.getCriticoNerfato());
		r.setDurataNerfCritico(pg1.getDurataNerfCritico());
		r.setCriticoBuffato(pg1.getCriticoBuffato());
		r.setDurataBuffCritico(pg1.getDurataBuffCritico());

		return r;
	}
}
