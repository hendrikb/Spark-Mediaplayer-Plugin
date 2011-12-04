package org.jivesoftware.spark.plugin.mediaplayer.pref;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.jivesoftware.spark.SparkManager;


/**
 * OTRProperties file stuff
 * 
 * @author Bergunde Holger
 */
public class MPProperties {
	private final Properties props;
	private File configFile;

	private static final Object LOCK = new Object();
	private static MPProperties instance = null;

	/**
	 * returns the Instance of this Properties file
	 * 
	 * @return
	 */
	public static MPProperties getInstance() {
		synchronized (LOCK) {
			if (instance == null) {
				instance = new MPProperties();
			}
			return instance;
		}
	}

	private MPProperties() {
		this.props = new Properties();

		try {
			props.load(new FileInputStream(getConfigFile()));
		}
		catch (IOException e) {
			// Can't load ConfigFile
		}

	}

	private File getConfigFile() {
		if (configFile == null)
		    configFile = new File(SparkManager.getUserDirectory(), "mpp.properties");

		return configFile;
	}

	public void save() {
		try {
			props.store(new FileOutputStream(getConfigFile()), "Storing Media Player Control Plugin properties");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ===============================================================================
	// ===============================================================================
	// ===============================================================================
	private boolean getBoolean(String property, boolean defaultValue) {
		return Boolean.parseBoolean(props.getProperty(property, Boolean.toString(defaultValue)));
	}

	private void setBoolean(String property, boolean value) {
		props.setProperty(property, Boolean.toString(value));
	}

	private void setString(String string, String text) {
		props.setProperty(string, text);
	}

	private int getInt(String property) {
		return Integer.parseInt(props.getProperty(property, "0"));
	}

	private void setInt(String property, int integer) {
		props.setProperty(property, "" + integer);
	}

	public String getProperty(String property) {
		return props.getProperty(property);
	}

	public void setMpcpDisplayNpButton(boolean b) {
		setBoolean("MPCPdisplayNpButton", b);
	}

	public boolean getMpcpDisplayNpButton() {
		return getBoolean("MPCPdisplayNpButton", true);
	}

	public void setMpcpFormat(String text) {
		setString("MPCPformat", text);
	}

	public String getMpcpFormat() {
		return getString("MPCPformat", "np: $artist - $title");
	}

	private String getString(String key, String defaultvalue) {
		return props.getProperty(key);
	}
}
