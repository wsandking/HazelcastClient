package com.genband.util.hazelcastclient.config;

import java.io.InputStream;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;

public class HazelcastServerConfig {

	/**
	 * Load it from environment variable
	 * 
	 * @param cfg
	 */
	private void loadProperties(Config cfg) {
		/**
		 * 
		 * Maybe do the smart Join, read environment var and find services based
		 * on that
		 * 
		 */

	}

	public Config composeConfiguration() {

		Config cfg = null;
		cfg = new Config();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("hazelcast.xml");
		cfg = new XmlConfigBuilder(in).build();
		loadProperties(cfg);
		System.out.println(cfg.toString());

		return cfg;

	}
}
