package com.interview.project.gamemanagement.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.project.gamemanagement.model.Game;
import com.interview.project.gamemanagement.model.GameImage;
import com.interview.project.gamemanagement.service.GameImageService;
import com.interview.project.gamemanagement.service.GameService;

@RestController
@RequestMapping("/game/")
public class GameController {

	@Autowired
	GameService gameService;
	
	@Autowired
	GameImageService gameImageService;
	
	
	@GetMapping("getGameImage")
	public GameImage getGameImage(@RequestHeader Long gameId) throws InterruptedException, ExecutionException {
		return gameImageService.getGameImage(gameId);
	}
	
	@PostMapping("createGameImage")
	public String createGameImage(@RequestBody GameImage gameImage) throws InterruptedException, ExecutionException {
		return gameImageService.saveGameImage(gameImage);
	}
	
	@GetMapping("getGame")
	public Game getGame(@RequestHeader Long gameId) {
		return gameService.getGameWithId(gameId);
	}
	
	@PostMapping("createGame")
	public Game createGame(@RequestBody Game game) {
		return gameService.saveGame(game);
	}
	
	@PutMapping("updateGame")
	public Long updateGame(@RequestBody Game game) {
		return gameService.updateGame(game);
	}
	
	@DeleteMapping("deleteGame")
	public Long deleteGame(@RequestHeader Long gameId) {
		return gameService.deleteGameWithId(gameId);
	}
	
	@GetMapping("start")
	public Game startGame(@PathVariable("gameId") Long gameId, @PathVariable("userId") Long userId) {
		return new Game();
	}
}
