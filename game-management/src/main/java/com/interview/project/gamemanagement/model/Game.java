package com.interview.project.gamemanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "game")
@Data
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long gameId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "image_url")
	private String imageUrl; //TODO : imageUrl as url from firebase.
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	/*no of levels in the game.*/
	@Column(name="levels")
	private int levels;
	
	/*game has a game category*/
	@ManyToOne
	@JoinColumn(name="game_category_id", nullable=false)
	private GameCategory gameCategory;
	
	/*game has multiple transactions*/
	@OneToMany(mappedBy="game")
	private List<GameTransaction> gameTransactions;	
}