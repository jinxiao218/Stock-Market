package com.ibm;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ibm.model.FileRecord;
import com.ibm.repository.CompanyRepository;
import com.ibm.repository.ExchangeToCompanyRepository;
import com.ibm.repository.FileRecordRepository;
import com.ibm.repository.SectorRepository;
import com.ibm.repository.StockExchangeRepository;
import com.ibm.service.FileProcessingService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class FileProcessingServiceApplicationTests {
	@Autowired
	private WebApplicationContext context;
	@Autowired
	private FileProcessingService fileProcessingService;
	@Autowired
	private CompanyRepository companyRepository;	
	@Autowired
	private ExchangeToCompanyRepository  exchangeToCompanyRepository;
	@Autowired
	private FileRecordRepository fileRecordRepository;
	@Autowired
	private SectorRepository sectorRepository;
	@Autowired
	private StockExchangeRepository stockExchangeRepository;

	@Value("${local.server.port}")
	private int port;

	@Autowired
    private WebApplicationContext webApplicationContext;
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	@Test
	void contextLoads() {
		assertEquals(1, companyRepository.count());
		assertEquals(1, exchangeToCompanyRepository.count());
		assertEquals(1, fileRecordRepository.count());
		assertEquals(1, sectorRepository.count());
		assertEquals(1, stockExchangeRepository.count());
	}
	
	@Test
	void processFileTest() {
		 fileProcessingService.processFile(null);
	}
}
