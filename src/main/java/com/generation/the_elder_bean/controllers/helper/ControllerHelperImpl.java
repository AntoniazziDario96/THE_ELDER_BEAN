package com.generation.the_elder_bean.controllers.helper;

import com.generation.the_elder_bean.models.entities.Personaggio;

import java.util.Random;

public class ControllerHelperImpl implements ControllerHelper
{
	public void Combattimento(Personaggio personaggio1, Personaggio personaggio2)
	{
		while (personaggio1.getVita() < 0 || personaggio2.getVita() < 0 || round == 10) ;
		{

			Random random = new Random();


			Personaggio personaggioInizio = null;
			Personaggio personaggioFinali = null;

			long velocitap1, velocitap2;

			// Ciclo che ripete il calcolo delle velocità finché non sono diverse
			do
			{
				velocitap1 = personaggio1.getVelocita() + random.nextInt(6) + 1;
				velocitap2 = personaggio2.getVelocita() + random.nextInt(6) + 1;

				// Debug per vedere le velocità generate
				System.out.println("Velocità P1: " + velocitap1 + " - Velocità P2: " + velocitap2);
			} while (velocitap1 == velocitap2);  // Continua finché le velocità sono uguali

			// Ora che le velocità sono diverse, assegna i personaggi
			if (velocitap1 > velocitap2)
			{
				personaggioInizio = personaggio1;
				personaggioFinali = personaggio2;
			}
			else
			{
				personaggioInizio = personaggio2;
				personaggioFinali = personaggio1;
			}


		}


	}
}
