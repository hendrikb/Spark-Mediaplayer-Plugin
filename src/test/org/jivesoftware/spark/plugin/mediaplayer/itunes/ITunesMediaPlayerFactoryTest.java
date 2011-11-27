/**
 * 
 */
package org.jivesoftware.spark.plugin.mediaplayer.itunes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jivesoftware.spark.plugin.mediaplayer.MediaPlayer;
import org.junit.Test;


/**
 * @author steven
 */
public class ITunesMediaPlayerFactoryTest {

	@Test
	public void testGetMediaPlayer() {
		MediaPlayer mp = ITunesMediaPlayerFactory.getITunesMediaPlayer();
		assertNotNull(mp);
		if (System.getProperty("os.name").toLowerCase().equals("windows")) {
			assertTrue(mp instanceof ITunesMediaPlayerWin);
		}
		else if (System.getProperty("os.name").toLowerCase().equals("mac os x")) {
			assertTrue(mp instanceof ITunesMediaPlayerMac);
		}
		else {
			fail();
		}

	}

}
