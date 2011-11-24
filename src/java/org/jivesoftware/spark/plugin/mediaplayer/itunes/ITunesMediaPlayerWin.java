/**
 * 
 */
package org.jivesoftware.spark.plugin.mediaplayer.itunes;

import org.jivesoftware.spark.plugin.mediaplayer.MediaPlayer;
import org.jivesoftware.spark.plugin.mediaplayer.SongInfo;

import com4j.itunes.ClassFactory;
import com4j.itunes.IITTrack;
import com4j.itunes.IiTunes;


public class ITunesMediaPlayerWin implements MediaPlayer {
	@Override
	public SongInfo getCurrentPlayingSong() {
		System.out.println("Creating iTunes Wrapper for Windows");
		IiTunes itunes = ClassFactory.createiTunesApp();
		System.out.println("... it worked. Querying iTunes for current track");
		IITTrack track = itunes.currentTrack();
		if (track != null) {
			System.out.println("Got the Track. :)");
			return new SongInfo(track.artist(), track.name());
		}
		System.out.println("Current track seems to be null.");
		return null;
	}
}
