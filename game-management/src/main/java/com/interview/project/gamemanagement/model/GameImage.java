package com.interview.project.gamemanagement.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class GameImage {
	private Long gameId;
	private String gameImageUrl;
}
