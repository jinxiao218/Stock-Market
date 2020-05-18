package com.ibm.service.impl;

import java.io.IOException;
import java.sql.Blob;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.model.FileRecord;
import com.ibm.repository.FileRecordRepository;
import com.ibm.service.StockDataService;

@Service
public class StockDataServiceImpl implements StockDataService {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	FileRecordRepository repository;
	
	@Transactional
	public FileRecord saveFile(MultipartFile file) throws IOException {
		FileRecord record = new FileRecord();
		String fileName = file.getOriginalFilename();
		Session session = entityManager.unwrap(Session.class);
		Blob blob = Hibernate.getLobCreator(session).createBlob(file.getBytes());
		
		record.setFileData(blob);
		record.setFileName(fileName==null ? Calendar.getInstance().toString() : fileName );
		record.setState(0);
		record.setMessage("Processing");
		
		return repository.save(record);
	}
}