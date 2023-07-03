package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cdac.entity.Album;
import com.cdac.entity.Song;
import com.cdac.util.JPAUtil;

public class AlbumSongDao extends GenericDao {

	//SQL -> select * from tbl_album where copyright = 'Sony Music'
	//HQL -> select a from Album a where a.copyright = 'Sony Music'
	public List<Album> findAlbumsByCopyright(String copyright) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query q = em.createQuery("select a from Album a where a.copyright = :cp");
			q.setParameter("cp", copyright); 
			List<Album> list = q.getResultList();
			return list;
		}
		finally {
			em.close();
		}
	}
	
	//SQL -> select * from tbl_album a join tbl_song s on a.album_id =s.album_id where s.artist="Neha Kakkar"
	//HQL -> select a from Album a join a.songs s where s.artist = 'Neha Kakkar'
	public List<Album> findAlbumsByArtist(String artist) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query q = em.createQuery("select a from Album a join a.songs s where s.artist = :art");
			q.setParameter("art", artist); 
			List<Album> list = q.getResultList();
			return list;
		}
		finally {
			em.close();
		}
	}

	//SQL -> select * from tbl_song where artist = 'Neha Kakkar'
	//HQL -> select s from Song s where s.artist = 'Neha Kakkar'
	public List<Song> findSongsByArtist(String artist) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query q = em.createQuery("select s from Song s where s.artist = :art");
			//TypedQuery<Song> q = em.createQuery("select s from Song s where s.artist = :art", Song.class);
			q.setParameter("art", artist); 
			List<Song> list = q.getResultList();
			return list;
		}
		finally {
			em.close();
		}
	}

	//SQL -> 
	//		select * from tbl_song s
	//		join tbl_album a on s.album_id = a.album_id
	//		where s.artist = 'Neha Kakkar' and year(a.release_date) = 2021
	//HQL -> 
	//		select s from Song s join s.album a 
	//		where s.artist = 'Neha Kakkar' and year(a.releaseDate) = 2021
	public List<Song> findSongsByArtistAndYear(String artist, int year) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query q = em.createQuery("select s from Song s join s.album a where s.artist = :abc and year(a.releaseDate) = :xyz");
			q.setParameter("abc", artist); 
			q.setParameter("xyz", year);
			List<Song> list = q.getResultList();
			return list;
		}
		finally {
			em.close();
		}
	}

	
	
}
