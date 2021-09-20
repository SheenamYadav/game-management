package com.interview.project.gamemanagement.service;

import com.interview.project.gamemanagement.model.Game;

public interface IGameService {

	Game saveGame(Game game);

	Game getGameWithId(Long id);

	Long updateGame(Game game);

	Long deleteGameWithId(Long id);

}
