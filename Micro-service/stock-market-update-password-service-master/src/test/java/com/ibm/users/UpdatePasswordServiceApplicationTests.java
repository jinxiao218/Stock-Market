package com.ibm.users;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ibm.UpdatePasswordServiceApplication;

@SpringBootTest
class UpdatePasswordServiceApplicationTests {
	@Autowired
    private WebApplicationContext webApplicationContext;
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
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
