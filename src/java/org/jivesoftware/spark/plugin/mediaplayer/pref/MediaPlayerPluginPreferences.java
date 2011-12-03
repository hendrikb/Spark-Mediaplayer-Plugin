package org.jivesoftware.spark.plugin.mediaplayer.pref;

import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jivesoftware.spark.plugin.mediaplayer.MediaPlayerPlugin;
import org.jivesoftware.spark.plugin.mediaplayer.util.MPResources;
import org.jivesoftware.spark.preference.Preference;


public class MediaPlayerPluginPreferences implements Preference {

	@Override
	public String getTitle() {
		return MediaPlayerPlugin.PLUGIN_NAME;
	}

	@Override
	public Icon getIcon() {
		return MPResources.getIcon(MediaPlayerPlugin.PLUGIN_ICON_24);
	}

	@Override
	public String getTooltip() {
		return MediaPlayerPlugin.PLUGIN_NAME;
	}

	@Override
	public String getListName() {
		return MediaPlayerPlugin.PLUGIN_NAME.replaceAll("[Pp]lugin", "");
	}

	@Override
	public String getNamespace() {
		return "org.jivesoftware.spark.plugin.mediaplayer.pref";
	}

	@Override
	public JComponent getGUI() {

		JPanel panel = new JPanel(new GridLayout(3, 2));

		JLabel lDisplayButton = new JLabel("Add Button to the ChatBox Window");
		JCheckBox cbDisplayButton = new JCheckBox();

		panel.add(lDisplayButton);
		panel.add(cbDisplayButton);

		JLabel lPlayers = new JLabel("Select Media Player");
		JComboBox comboPlayers = new JComboBox();
		comboPlayers.addItem("iTunes");

		panel.add(lPlayers);
		panel.add(comboPlayers);

		JLabel lFormat = new JLabel("Select Output Format");
		JTextField tfFormat = new JTextField();
		tfFormat.setToolTipText("Available: $artist, $title");

		panel.add(lFormat);
		panel.add(tfFormat);

		return panel;
	}

	@Override
	public void load() {}

	@Override
	public void commit() {}

	@Override
	public boolean isDataValid() {
		return false;
	}

	@Override
	public String getErrorMessage() {
		return "Something went wrong with: " + MediaPlayerPlugin.PLUGIN_NAME;
	}

	@Override
	public Object getData() {
		return null;
	}

	@Override
	public void shutdown() {}

}
