package com.generation.the_elder_bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.generation.the_elder_bean.controllers.helper.ControllerHelper;
import com.generation.the_elder_bean.models.entities.Combattimento;
import com.generation.the_elder_bean.models.entities.Personaggio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TheElderBeanApplicationTests
{
	@Autowired
	ControllerHelper controllerHelper;

	@Test
	void contextLoads() throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		Personaggio p = controllerHelper.combattenteByid(1);

		System.out.println(mapper.writeValueAsString(p));


	}
}


