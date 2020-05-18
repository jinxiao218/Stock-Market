package com.ibm.service;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;

public class StockDataServiceTest {
	@Autowired
	StockDataService stockDataService;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSaveFile() {
		try {
			stockDataService.saveFile(new MockMultipartFile("test","this is a test file".getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
