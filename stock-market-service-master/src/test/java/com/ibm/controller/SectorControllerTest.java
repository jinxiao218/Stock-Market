package com.ibm.controller;

import static org.junit.Assert.fail;

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

public class SectorControllerTest {

	@Autowired
    private WebApplicationContext webApplicationContext;
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetSectorLong() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sector/9").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

	@Test
	public void testGetSector() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sector/").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

	@Test
	public void testCreateSector() throws Exception {
		String content ="{\"name\":\"Banks Pvt\"}";
	    mvc.perform(MockMvcRequestBuilders.post("/sector/").accept(MediaType.APPLICATION_JSON).content(content))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

	@Test
	public void testUpdateSector() throws Exception {
		String content ="{\"name\":\"Banks ccc\"}";
	    mvc.perform(MockMvcRequestBuilders.post("/sector/9").accept(MediaType.APPLICATION_JSON).content(content))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

}
