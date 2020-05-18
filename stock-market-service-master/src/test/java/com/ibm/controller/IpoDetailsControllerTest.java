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

public class IpoDetailsControllerTest {

	@Autowired
    private WebApplicationContext webApplicationContext;
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	@Test
	public void testGetIpoLong() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/ipo/20").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

	@Test
	public void testGetIpo() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/ipo/").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

	@Test
	public void testCreateIpo() throws Exception {
		String content ="{\"company\":\"id:18\",\"stockExchange\":\"id:14\",\"price\":\"150\",\"totalShares\":\"125000\",\"openDate\":\"1331163474\"}";
	    mvc.perform(MockMvcRequestBuilders.post("/exchange-company-map/").accept(MediaType.APPLICATION_JSON).content(content))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

	@Test
	public void testUpdateIpo() throws Exception {
		String content ="{\"company\":\"id:18\",\"stockExchange\":\"id:14\",\"price\":\"180\",\"totalShares\":\"250000\",\"openDate\":\"1331163474\"}";
	    mvc.perform(MockMvcRequestBuilders.post("/exchange-company-map/").accept(MediaType.APPLICATION_JSON).content(content))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

}
