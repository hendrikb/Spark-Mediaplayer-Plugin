package org.jivesoftware.spark.plugin.mediaplayer.itunes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.jivesoftware.spark.plugin.mediaplayer.SongInfo;
import org.junit.Before;
import org.junit.Test;


public class ITunesMediaPlayerWinTest {

	private ITunesMediaPlayerWin itunes;

	@Before
	public void init() {
		itunes = new ITunesMediaPlayerWin();
	}

	@Test
	public final void testGetCurrentPlayingSong() {

		try {
			SongInfo si = itunes.getCurrentPlayingSong();

			assertNotNull(si);
			si.setArtist("Hendrik");
			assertEquals("Hendrik", si.getArtist());
			si.setTitle("Test");
			assertEquals("Test", si.getTitle());
		}
		catch (Exception e) {
			fail("This basic testGetCurrentPlayingSong-handling should not fail in this test case. Error: " + e.getMessage());
		}

	}
}
