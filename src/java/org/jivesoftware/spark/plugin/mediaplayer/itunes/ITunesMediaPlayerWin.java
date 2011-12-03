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
		final IiTunes itunes = ClassFactory.createiTunesApp();
		IITTrack track = itunes.currentTrack();
		if (track != null) {
			return new SongInfo(track.artist(), track.name());
		}
		return null;
	}
}
