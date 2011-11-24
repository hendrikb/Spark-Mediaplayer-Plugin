/**
 * 
 */
package org.jivesoftware.spark.plugin.mediaplayer.itunes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.jivesoftware.spark.plugin.mediaplayer.MediaPlayer;
import org.jivesoftware.spark.plugin.mediaplayer.SongInfo;


/**
 * @author Steven Mohr
 */
public class ITunesMediaPlayerMac implements MediaPlayer {

	@Override
	public SongInfo getCurrentPlayingSong() {
		Runtime rt = Runtime.getRuntime();
		SongInfo songInfo = new SongInfo();
		try {
			String[] args = { "osascript", "-e", "tell app \"iTunes\" to artist of current track as string" };
			Process proc = rt.exec(args);
			InputStream in = proc.getInputStream();

			BufferedReader buf = new BufferedReader(new InputStreamReader(in));
			String artist = buf.readLine();
			buf.close();

			String[] args2 = { "osascript", "-e", "tell app \"iTunes\" to name of current track as string" };
			proc = rt.exec(args2);
			in = proc.getInputStream();
			buf = new BufferedReader(new InputStreamReader(in));
			String title = buf.readLine();
			buf.close();

			songInfo.setArtist(artist);
			songInfo.setTitle(title);
		}
		catch (IOException e) {
			return null;
		}
		return songInfo;
	}
}
