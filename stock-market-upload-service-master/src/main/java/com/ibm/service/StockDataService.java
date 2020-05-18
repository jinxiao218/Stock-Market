package com.ibm.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.ibm.model.FileRecord;

public interface StockDataService {
	
	public FileRecord saveFile(MultipartFile file) throws IOException;
	
}
