package com.cdac.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cdac.dao.AlbumSongDao;
import com.cdac.dao.GenericDao;
import com.cdac.entity.Album;
import com.cdac.entity.Song;

public class AlbumSongTest {

	public static void main(String[] args) {
		/* -------- scenario 1  ------------ */
		// -------- adding album ----------- */
		//GenericDao dao = new GenericDao();
		AlbumSongDao dao = new AlbumSongDao();
		
		/*Album album = new Album();
		album.setName("Hits of 2021");
		album.setReleaseDate(LocalDate.of(2021, 12, 25));
		album.setCopyright("Amazon Music");
		dao.save(album);*/
		
		// ------ adding song to an album ------- */
		/*Album album = (Album) dao.findByPK(Album.class, 2);
		Song song = new Song();
		song.setTitle("Lut Gaye");
		song.setArtist("Jubin Nautiyal");
		song.setGenre("Romantic");
		song.setAlbum(album);
		dao.save(song);*/
		
		
		/* -------- scenario 2  ------------ */
		// -------- adding album and songs together -------- */
		/*Album album = new Album();
		album.setName("Hits of 2020");
		album.setReleaseDate(LocalDate.of(2020, 12, 25));
		album.setCopyright("T-Series Music");
		
		Song song1 = new Song();
		song1.setTitle("Chal Ghar Chale");
		song1.setArtist("Arijit Singh");
		song1.setGenre("Romantic");
		song1.setAlbum(album);
		
		Song song2 = new Song();
		song2.setTitle("Bheegi Bheegi");
		song2.setArtist("Neha Kakkar");
		song2.setGenre("Romantic");
		song2.setAlbum(album);
		
		List<Song> songs = new ArrayList<>();
		songs.add(song1);
		songs.add(song2);
		album.setSongs(songs);
		
		dao.save(album);*/
		
		//List<Album> list = dao.findAlbumsByCopyright("Sony Music");
		/*List<Album> list = dao.findAlbumsByArtist("Jubin Nautiyal");
		for(Album album : list) {
			System.out.println(album.getId());
			System.out.println(album.getName());
			System.out.println(album.getReleaseDate());
			System.out.println("--------------");
		}*/
		
		//List<Song> list = dao.findSongsByArtist("Neha Kakkar");
		List<Song> list = dao.findSongsByArtistAndYear("Neha Kakkar", 2020);
		for(Song song : list) {
			System.out.println(song.getTitle());
			System.out.println(song.getGenre());
			System.out.println("--------------");
		}
	}
}
