package com.interview.project.gamemanagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "game_category")
@Data
public class GameCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long gameCategoryId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "category")
	private String category;
	
	/*each game category has multiple games*/
	@OneToMany(mappedBy="gameCategory")
	private List<Game> games;
}