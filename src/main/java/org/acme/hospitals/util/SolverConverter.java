package org.acme.hospitals.util;

import com.thoughtworks.xstream.XStream;

public class SolverConverter {
	public static void main(String[] args) {
		//createXMlFromObject();
		//createXMLFromObjectUsingAliasAndImplicitCollection();
		createXMLFromObjectUsingAlias();
	}

	public static void createXMlFromObject() {
		JazzArtist artist = new JazzArtist("Bix Beiderbecke", false, null);
		Album album1 = new Album("Bix Beiderbecke with the Paul Whiteman Orchestra", 5, 1928);
		Album album2 = new Album("Bix Beiderbecke and His Gang", 6, 1927);
		artist.addAlbum(album1);
		artist.addAlbum(album2);
		XStream xStream = new XStream();
		System.out.println(xStream.toXML(artist));
	}

	public static void createXMLFromObjectUsingAliasAndImplicitCollection() {
		JazzArtist artist1 = new JazzArtist("Benny Goodman", false, null);
		Album album3 = new Album("In Stockholm", 5, 1959);
		Album album4 = new Album("A Jazz Holiday", 3, 1928);
		artist1.addAlbum(album3);
		artist1.addAlbum(album4);
		XStream xStream2 = new XStream();
		xStream2.alias("artist", JazzArtist.class);
		xStream2.alias("album", Album.class);
		xStream2.addImplicitCollection(JazzArtist.class, "albums");
		System.out.println(xStream2.toXML(artist1));
	}

	public static void createXMLFromObjectUsingAlias() {
		JazzArtist artist2 = new JazzArtist("Benny Goodman", false, null);
		Album album3 = new Album("In Stockholm", 5, 1959);
		Album album4 = new Album("A Jazz Holiday", 3, 1928);
		artist2.addAlbum(album3);
		artist2.addAlbum(album4);
		XStream xStream2 = new XStream();
		xStream2.alias("artist", JazzArtist.class);
		xStream2.alias("album", Album.class);
		System.out.println(xStream2.toXML(artist2));
	}
}
