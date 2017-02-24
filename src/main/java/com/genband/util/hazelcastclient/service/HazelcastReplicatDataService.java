package com.genband.util.hazelcastclient.service;

import java.util.Map;

import com.genband.util.hazelcastclient.config.HazelcastClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;

/**
 * Need to handle synchronzied issues
 * 
 * @author sewang
 *
 */
public class HazelcastReplicatDataService implements ReplicatDataService {

	private static HazelcastReplicatDataService instance;
	private HazelcastInstance hInstance;
	private Map<String, String> eventMap;

	protected static HazelcastReplicatDataService getInstance() {

		if (null == instance)
			instance = new HazelcastReplicatDataService();
		return instance;

	}

	private HazelcastReplicatDataService() {

		hInstance = HazelcastClient.newHazelcastClient(HazelcastClientConfig.composeConfiguration());
		eventMap = hInstance.getMap("MobilePushEventMap");

	}

	@Override
	public String getValue(String key) {

		System.out.println(String.format("Retriving value for key %s ", key));
		return eventMap.get(key);

	}

	@Override
	public String retrieveValue(String key) {

		String value = eventMap.get(key);
		eventMap.remove(key);

		return value;

	}

	@Override
	public String storeValue(String key, String value) {

		/**
		 * Maybe some validation need to be done here
		 */
		System.out.println(String.format("Storing key %s : value %s", key, value));
		eventMap.put(key, value);

		return null;
	}

}
