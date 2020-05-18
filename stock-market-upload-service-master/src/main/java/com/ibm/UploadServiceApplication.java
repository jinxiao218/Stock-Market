package com.ibm;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ibm.model.FileRecord;
import com.ibm.model.UploadStatus;
import com.ibm.repository.FileRecordRepository;
import com.ibm.service.StockDataService;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class UploadServiceApplication {

	@Autowired
	StockDataService service;
	
	@Autowired
	FileRecordRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(UploadServiceApplication.class, args);
	}

	@PostMapping("/")
    public UploadStatus handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {

		FileRecord record = null;
		UploadStatus status = new UploadStatus(true, "File uploaded successfully");
		try {
			record = service.saveFile(file);
			status.setRecordId(record.getId());
		} catch (IOException e) {
			status.setSuccess(false);
			status.setMessage("Failed to upload file, please check if the file is valid");
		}

        return status;
    }
}
