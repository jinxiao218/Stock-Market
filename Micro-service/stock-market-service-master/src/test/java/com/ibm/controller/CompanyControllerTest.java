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

public class CompanyControllerTest {
	@Autowired
    private WebApplicationContext webApplicationContext;
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetCompanyIntInt() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/company/1/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}

	@Test
	public void testGetCompanyLong() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/company/18").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}

	@Test
	public void testGetCompanyByName() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/company/ibm").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}

	@Test
	public void testGetCompanyString() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/company/search/txt").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}

	@Test
	public void testCreateCompany() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/").param("huwei","renzhengfei","zhang zhe,ren zhengfei","id:14","1500","id:8","huawei is a company for phones...").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}

	@Test
	public void testUpdateCompany() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/18").param("huwei","renzhengfei","zhang zhe,ren zhengfei","id:14","1500","id:8","hphones...").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}

}
