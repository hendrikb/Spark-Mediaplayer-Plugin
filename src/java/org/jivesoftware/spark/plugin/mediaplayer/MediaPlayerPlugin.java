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
	 * @see org.jivesoftware.spark.plugin.Plugin#initialize()
	 */
	@Override
	public void initialize() {
		System.out.println("Initializing Now Playing plugin");
		ChatManager cm = SparkManager.getChatManager();
		cm.addChatRoomListener(new ChatRoomListenerAdapter() {
			@Override
			public void chatRoomOpened(ChatRoom room) {

				ChatRoomButton cb = new ChatRoomButton("np: ");
				final ChatInputEditor cie = room.getChatInputEditor();
				cb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						MediaPlayer mp = ITunesMediaPlayerFactory.getITunesMediaPlayer();
						System.out.println("Querying iTunes");
						if (mp != null) {
							SongInfo si = mp.getCurrentPlayingSong();
							if (si != null) {
								cie.setText("np: " + si.getArtist() + " - " + si.getTitle());
							}
							else System.out.println("Couldn't get any iTunes data");
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

		// TODO Method shutdown was added 22.11.2011 needs implementing 
	}

	/**
	 * @see org.jivesoftware.spark.plugin.Plugin#canShutDown()
	 */
	@Override
	public boolean canShutDown() {
		return false;

		// TODO Method canShutDown was added 22.11.2011 needs implementing 
	}

	/**
	 * @see org.jivesoftware.spark.plugin.Plugin#uninstall()
	 */
	@Override
	public void uninstall() {

		// TODO Method uninstall was added 22.11.2011 needs implementing 
	}

}
