package org.jivesoftware.spark.plugin.mediaplayer.pref;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
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

	private JCheckBox cbDisplayButton;
	private JComboBox comboPlayers;
	private JTextField tfFormat;
	private final MPProperties pref = MPProperties.getInstance();

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

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Media player plugins"));

		JLabel lDisplayButton = new JLabel("Add Button to the ChatBox Window");
		cbDisplayButton = new JCheckBox();

		panel.add(lDisplayButton, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.NORTHWEST, 
		    GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		panel.add(cbDisplayButton, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.NORTHEAST, 
            GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

		JLabel lPlayers = new JLabel("Select Media Player");
		comboPlayers = new JComboBox();
		comboPlayers.addItem("iTunes");

		panel.add(lPlayers, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.NORTHWEST, 
            GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		
		panel.add(comboPlayers, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.NORTHEAST, 
            GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

		JLabel lFormat = new JLabel("Select Output Format");
		tfFormat = new JTextField();
		tfFormat.setToolTipText("Available: $artist, $title");

		panel.add(lFormat, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.NORTHWEST, 
            GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		panel.add(tfFormat, new GridBagConstraints(1, 2, 4, 4, 1.0, 0.0, GridBagConstraints.NORTHEAST, 
            GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

		return panel;
	}

	@Override
	public void load() {
		comboPlayers.setSelectedIndex(0);
		cbDisplayButton.setSelected(pref.getMpcpDisplayNpButton());
		tfFormat.setText(pref.getMpcpFormat());
	}

	@Override
	public void commit() {
		pref.setMpcpDisplayNpButton(cbDisplayButton.isSelected());
		pref.setMpcpFormat(tfFormat.getText());
		pref.save();
	}

	@Override
	public boolean isDataValid() {
		return true;
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
