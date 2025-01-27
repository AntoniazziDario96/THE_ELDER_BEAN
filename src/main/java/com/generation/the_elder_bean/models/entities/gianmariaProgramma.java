package com.generation.the_elder_bean.models.entities;

import java.util.ArrayList;
import java.util.List;

public class gianmariaProgramma
{
	public static void main(String[] args)
	{

		for (int i = 1; i <= 50; i++)
		{

			if (((i) % 3 == 0 && (i) % 5 == 0))
			{
				System.out.println("FizzBuzz");
				;
			}
			if ((i ) % 3 == 0)
			{

				System.out.println("Fizz");
			}
			if ((i) % 5 == 0)
				System.out.println("Buzz");
			else
			{
				System.out.println(i);
			}
		}
	}
}

