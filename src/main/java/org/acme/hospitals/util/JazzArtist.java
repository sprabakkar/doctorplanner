package org.acme.hospitals.util;

import java.util.ArrayList;
import java.util.List;

public class JazzArtist {
	public String name;
    public boolean isAlive;
    public String url;
    public List<Album> albums = new ArrayList<Album>();
 
    public JazzArtist(String name, boolean isAlive, String url) {
        this.name = name;
        this.isAlive = isAlive;
        this.url = url;
    }
 
    public void addAlbum(Album album) {
        albums.add(album);
    }
}
