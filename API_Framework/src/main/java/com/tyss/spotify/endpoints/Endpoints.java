package com.tyss.spotify.endpoints;

public class Endpoints {

	public static String AUTHORIZE="/authorize";
	public static String TOKEN="/api/token";
	
	
	public static String SINGLEALBUM="/albums/{id}";
	public static String ALBUMS="/albums";
	public static String ALBUMTRACKS="/albums/{id}/tracks";
	public static String USERSAVEDALBUMS="/me/albums";
	public static String CHECKUSERSAVEDALBUMS="/me/albums/contains";
	public static String GETNEWRELEASES="/browse/new-releases";
	
	
	public static String GETARTIST="/artists/{id}";
	public static String GETSEVERALARTISTS="/artists";
	public static String GETARTISTSALBUMS="/artists/{id}/albums";
	public static String GETARTISTSTOPTRACKS="/artists/{id}/top-tracks";
	public static String GETARTISTSRELATEDARTISTS="/artists/{id}/related-artists";
	
	
	public static String GETSHOWS="/shows/{id}";
	public static String GETSEVERALSHOWS="/shows";
	public static String GETSHOWSEPISODES="/shows/{id}/episodes";
	public static String GETUSERSAVEDSHOWS="/me/shows";
	public static String SAVESHOWSFORUSER="/me/shows";
	public static String CHECKUSERSAVEDSHOWS="/me/shows/contains";
	
	
	public static String GETEPISODE="/episodes/{id}";
	public static String GETSEVERALEPISODES="/episodes";
	public static String USERSAVEDEPISODES="/me/episodes";
	public static String CHECKUSERSAVEDEPISODES="/me/episodes/contains";
	
	public static String GETTRACK="/tracks/{id}"; 
	public static String GETSEVERALTRACKS="/tracks";
	public static String GETUSERSAVEDTRACKS="/me/tracks";
	public static String CHECKUSERSAVEDTRACKS="/me/tracks/contains";
	public static String GETSINGLETRACKAUDIOFEATURE="/audio-features/{id}";
	public static String GETMULTIPLETRACKAUDIOFEATURE="/audio-features";
	public static String GETTRACKSAUDIOANALYSIS="/audio-analysis/{id}";
	public static String GETRECOMMENDATIONS="/recommendations";	
	
	public static String GETPLAYLIST="/playlists/{playlist_id}";	
	public static String GETPLAYLISTITEM="/playlists/{playlist_id}/tracks";
	public static String CURRENTUSERPLAYLIST="/me/playlists";
	public static String USERPLAYLIST="/users/{user_id}/playlists";
	
	public static String USER="/me";
	public static String USERTOPITEMS="/me/top/{type}";
	public static String USERPROFILE="/users/{user_id}"; 
	public static String FOLLOWPLAYLIST="/playlists/{playlist_id}/followers";
	public static String UNFOLLOWFOLLOWPLAYLIST="/playlists/{playlist_id}/followers";
	
	public static String GETPLAYBACKSTATUS="/me/player";
	public static String GETCURRENTLYPLAYINGTRACKA="/me/player/currently-playing";
	
	public static String SEARCHFORITEM="/search";
	
	public static String BROWSEMULTIPLECATEGORIES="/browse/categories";
	public static String BROWSESINGLECATEGORY="/browse/categories/{category_id}";
	
	public static String AVAILABLEGENRE="/recommendations/available-genre-seeds";
	
	public static String AVAILABLEMARKETS="/markets";
	
	
}
