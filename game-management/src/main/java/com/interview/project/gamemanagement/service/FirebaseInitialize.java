package com.interview.project.gamemanagement.service;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FirebaseInitialize {

	@PostConstruct
	public void initialize() {
		try {
		FileInputStream serviceAccount = new FileInputStream("./game-management-8f764.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://game-management-8f764.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);
		} catch(Exception e) {
			log.info("Error occured while  Firebase app initialize : ", e);
		}
	}
}
