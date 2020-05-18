package com.ibm.service.impl;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.model.FileRecord;
import com.ibm.repository.FileRecordRepository;
import com.ibm.service.FileProcessingService;

@Service
public class FileProcessingServiceImpl implements FileProcessingService {
	
	@Autowired
	FileRecordRepository repository;
	
	public void processFile(FileRecord record) {
		
		/*
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(record.getFileData().getBinaryStream());
			XSSFSheet worksheet = workbook.getSheetAt(0);

			if(isValidWorksheet(worksheet, record)) {			
				Iterator<Row> rows = worksheet.iterator();
				while(rows.hasNext()) {
			        processRow(rows.next(), record);
				}
			}
		} catch (IOException | SQLException e) {
			record.setErrorMessage(e.getMessage());
		}
		repository.save(record);
		*/
		System.out.println("Processing");
	}


	
	/**
	 * @param worksheet
	 * @param record
	 * @return checks if the worksheet is valid 
	 * * validation rule - sheet should contain only one company
	 */
	private boolean isValidWorksheet(XSSFSheet worksheet, FileRecord record) {
		boolean isValid = true;
		Iterator<Row> rows = worksheet.iterator();
		while(rows.hasNext() && isValid) {
	        
		}
		return isValid;
	}


	private void processRow(Row row, FileRecord record) {
		// TODO Auto-generated method stub
		
	}

}