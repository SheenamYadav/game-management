package com.interview.project.gamemanagement.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.interview.project.gamemanagement.model.GameImage;

@Service
public class GameImageService {
	
	public GameImage getGameImage(Long gameId) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentRefrence = dbFirestore.collection("gameimage").document(gameId.toString());
		ApiFuture<DocumentSnapshot> future = documentRefrence.get();
		
		DocumentSnapshot document = future.get();
		
		GameImage gameImage = new GameImage();
		if(document.exists())
			gameImage = document.toObject(GameImage.class);
		return gameImage;
	}
	
	public String saveGameImage(GameImage gameImage) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("gameimage").document(gameImage.getGameId().toString()).set(gameImage);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
}
