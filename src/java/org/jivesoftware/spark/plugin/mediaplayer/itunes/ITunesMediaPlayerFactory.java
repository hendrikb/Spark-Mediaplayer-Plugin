/**
 * 
 */
package org.jivesoftware.spark.plugin.mediaplayer.itunes;

import org.jivesoftware.spark.plugin.mediaplayer.MediaPlayer;


/**
 * Encapsulates the decision which concrete iTunesMediaPlayer implementation is
 * used.
 * 
 * @author steven
 */
public class ITunesMediaPlayerFactory {

	/**
	 * Returns a {@link MediaPlayer} implementation based on the Operating
	 * System it's running on.
	 * 
	 * @return MediaPlayer implementation.
	 */
	public static MediaPlayer getITunesMediaPlayer() {
		final String osName = System.getProperty("os.name");
		System.out.println("Querying OS for iTunes determination: " + osName);
		if (osName.contains("Windows")) {
			System.out.println("Got Windows");
			return new ITunesMediaPlayerWin();
		}
		else if (osName.toLowerCase().equals("mac os x")) {
			System.out.println("Got Mac: " + osName);
			return new ITunesMediaPlayerMac();
		}
		System.out.println("Got Nothing.");
		return null;
	}

}
