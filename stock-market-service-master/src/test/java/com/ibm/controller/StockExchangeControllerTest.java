package com.ibm.controller;

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

public class StockExchangeControllerTest {

	@Autowired
    private WebApplicationContext webApplicationContext;
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetExchangeLong() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/stock-exchange/14").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

	@Test
	public void testGetExchange() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/stock-exchange/").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

	@Test
	public void testCreateExchange() throws Exception {
		String content ="{\"code\":\"NES\",\"brief\":\"National Stock Exchange\",\"address\":\"China shen zhen\",\"remarks\":\"first IPO\"}";
	    mvc.perform(MockMvcRequestBuilders.post("/stock-exchange/").accept(MediaType.APPLICATION_JSON).content(content))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

	@Test
	public void testUpdateExchange() throws Exception{
		String content ="{\"code\":\"BSE\",\"brief\":\"Bombay Stock Exchange\",\"address\":\"China shanghai\",\"remarks\":\"first IPO\"}";
	    mvc.perform(MockMvcRequestBuilders.post("/stock-exchange/14").accept(MediaType.APPLICATION_JSON).content(content))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

}
