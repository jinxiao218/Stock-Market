package com.ibm.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

	@Autowired
	private MailService MailService;

	@Test
	public void testSimpleMail() throws Exception {
		MailService.sendHtmlMail("15114037969@163.com", "test simple mail", " hello this is simple mail");
	}

}
