/**
 * 
 */
package com.ibm.users;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserControllerTest {

	@Autowired
    private WebApplicationContext webApplicationContext;
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getUsers() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}
	
	@Test
	public void createAdmin() throws Exception{
		String content ="{\"username\":\"admin3\",\"password\":\"123456\",\"email\":\"admin3@cn.ibm.com\"}";
		mvc.perform(MockMvcRequestBuilders.post("/createAdmin")
		.contentType("application/json").content(content))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());

	}
	@Test
	public void signup() throws Exception{
		String content ="{\"username\":\"user3\",\"password\":\"123456\",\"email\":\"user3@cn.ibm.com\"}";
		mvc.perform(MockMvcRequestBuilders.post("/signup")
		.contentType("application/json").content(content))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	@Test
	public void updatePassword() throws Exception{
		String content ="{\"username\":\"user3\",\"password\":\"6666\",\"email\":\"user3@cn.ibm.com\"}";
		mvc.perform(MockMvcRequestBuilders.post("/updatePassword")
		.contentType("application/json").content(content))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}

}
