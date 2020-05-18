package com.ibm.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class ExchangeToCompanyControllerTest {

	@Autowired
    private WebApplicationContext webApplicationContext;
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testCreateMap() throws Exception{
		String content ="{\"companyId\":\"20\",\"exchangeId\":\"14\",\"stockCode\":\"532648\"}";
	    mvc.perform(MockMvcRequestBuilders.post("/exchange-company-map/").accept(MediaType.APPLICATION_JSON).content(content))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
}
	

	@Test
	public void testUpdateMap() throws Exception {
		String content ="{\"companyId\":\"20\",\"exchangeId\":\"16\",\"stockCode\":\"533333\"}";
	    mvc.perform(MockMvcRequestBuilders.post("/exchange-company-map/").accept(MediaType.APPLICATION_JSON).content(content))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
}
	}


