/**
 * 
 */
package org.jivesoftware.spark.plugin.mediaplayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jivesoftware.spark.ChatManager;
import org.jivesoftware.spark.SparkManager;
import org.jivesoftware.spark.plugin.Plugin;
import org.jivesoftware.spark.plugin.mediaplayer.itunes.ITunesMediaPlayerFactory;
import org.jivesoftware.spark.ui.ChatInputEditor;
import org.jivesoftware.spark.ui.ChatRoom;
import org.jivesoftware.spark.ui.ChatRoomButton;
import org.jivesoftware.spark.ui.ChatRoomListenerAdapter;


/**
 * @author Hendrik Bergunde <hbergunde@gmx.de>
 */
public class MediaPlayerPlugin implements Plugin {

	/**
	 * Initializes the Mediaplayer Plugin
	 * 
	 * @see org.jivesoftware.spark.plugin.Plugin#initialize()
	 */
	@Override
	public void initialize() {

		// TODO provide basic Preferences Page

		ChatManager cm = SparkManager.getChatManager();
		cm.addChatRoomListener(new ChatRoomListenerAdapter() {
			@Override
			public void chatRoomOpened(ChatRoom room) {

				//TODO: Use Button here, not "np: "
				ChatRoomButton cb = new ChatRoomButton("np: ");
				final ChatInputEditor cie = room.getChatInputEditor();
				cb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						MediaPlayer mp = ITunesMediaPlayerFactory.getITunesMediaPlayer();
						if (mp != null) {
							SongInfo si = mp.getCurrentPlayingSong();
							if (si != null) {

								//TODO: Support Placeholder Usage, not just "np: $artist - $song"
								cie.setText("np: " + si.getArtist() + " - " + si.getTitle());
							}
						}
					}
				});

				room.getEditorBar().add(cb);

			}
		});
	}

	/**
	 * @see org.jivesoftware.spark.plugin.Plugin#shutdown()
	 */
	@Override
	public void shutdown() {

	}

	/**
	 * @see org.jivesoftware.spark.plugin.Plugin#canShutDown()
	 */
	@Override
	public boolean canShutDown() {
		return false;
	}

	/**
	 * @see org.jivesoftware.spark.plugin.Plugin#uninstall()
	 */
	@Override
	public void uninstall() {}

}
