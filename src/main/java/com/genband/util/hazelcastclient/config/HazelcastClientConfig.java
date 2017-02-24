package com.genband.util.hazelcastclient.config;

import com.hazelcast.client.config.ClientConfig;

public class HazelcastClientConfig {

	/**
	 * Load it from environment variable
	 * 
	 * @param cfg
	 */
	private static void loadProperties(ClientConfig cfg) {
		
		/**
		 * 
		 * Maybe do the smart Join, read environment var and find services based
		 * on that
		 * 
		 */
		cfg.getNetworkConfig().addAddress("172.28.250.4:32002");
		
	}

	public static ClientConfig composeConfiguration() {

		ClientConfig cfg = new ClientConfig();
		loadProperties(cfg);

		return cfg;

	}
}
