package com.tyss.spotify.pojo;

public class PojoLibrary {
	
	public String seed_genres;
	public String seed_tracks;
	public int limit;
	public int offset;
	public String market;
	public String seed_artists;
	
	
	public String getSeed_artists() {
		return seed_artists;
	}
	public void setSeed_artists(String seed_artists) {
		this.seed_artists = seed_artists;
	}
	public String getSeed_genres() {
		return seed_genres;
	}
	public void setSeed_genres(String seed_genres) {
		this.seed_genres = seed_genres;
	}
	public String getSeed_tracks() {
		return seed_tracks;
	}
	public void setSeed_tracks(String seed_tracks) {
		this.seed_tracks = seed_tracks;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	

}
