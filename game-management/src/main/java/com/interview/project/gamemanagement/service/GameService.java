package com.interview.project.gamemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.project.gamemanagement.model.Game;
import com.interview.project.gamemanagement.repository.GameRepository;

@Service
public class GameService implements IGameService{

	@Autowired
	GameRepository gameRepository;
	
	@Override
	public Game saveGame(Game game) {
		return gameRepository.save(game);
	}

	@Override
	public Game getGameWithId(Long id) {
		return gameRepository.getById(id);
	}

	@Override
	public Long updateGame(Game game) {
		Game gameFromDb = gameRepository.getById(game.getGameId());
		if(gameFromDb!=null) {
			Game result = gameRepository.save(game);
			return result.getGameId();
		}
		return null;
	}

	@Override
	public Long deleteGameWithId(Long id) {
		Game game = gameRepository.getById(id);
		if(game!=null) {
			gameRepository.delete(game);
			return game.getGameId();
		}
		return null;
	}

}
