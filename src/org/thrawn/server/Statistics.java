package org.thrawn.server;

public class Statistics {

	private int level;
	private int score;
	private int kills;
	private int deaths;
	private int assists;
	
	public Statistics(int level, int score, int kills, int deaths, int assists) {
		this.level = level;
		this.score = score;
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
	}
	
	public final void setLevel(int level) {
		this.level = level;
	}
	
	public final void setScore(int score) {
		this.score = score;
	}
	
	public final void setKills(int kills) {
		this.kills = kills;
	}
	
	public final void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	
	public final void setAssists(int assists) {
		this.assists = assists;
	}
	
	public final int getLevel() {
		return level;
	}
	
	public final int getScore() {
		return score;
	}
	
	public final int getKills() {
		return kills;
	}
	
	public final int getDeaths() {
		return deaths;
	}
	
	public final int getAssists() {
		return assists;
	}
	
	
}
