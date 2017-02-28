package com.genband.util.hazelcastclient.service;

import java.util.Map;

import com.genband.util.hazelcastclient.config.HazelcastClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.transaction.TransactionContext;
import com.hazelcast.transaction.TransactionOptions;
import com.hazelcast.transaction.TransactionOptions.TransactionType;

/**
 * Need to handle synchronzied issues
 * 
 * @author sewang
 *
 */
public class HazelcastReplicatDataService implements ReplicatDataService {

	private static HazelcastReplicatDataService instance;
	private HazelcastInstance hInstance;
	private TransactionOptions options;
	private Map<String, String> eventMap;

	protected static HazelcastReplicatDataService getInstance() {

		if (null == instance)
			instance = new HazelcastReplicatDataService();
		return instance;

	}

	private HazelcastReplicatDataService() {

		hInstance = HazelcastClient.newHazelcastClient(HazelcastClientConfig.composeConfiguration());
		options = new TransactionOptions().setTransactionType(TransactionType.TWO_PHASE);
		eventMap = hInstance.getReplicatedMap("MobilePushEventMap");

	}

	@Override
	public String getValue(String key) {

		TransactionContext context = hInstance.newTransactionContext(options);
		context.beginTransaction();

		System.out.println(String.format("Get value for key - %s ", key));
		String value = eventMap.get(key);

		context.commitTransaction();

		return value;

	}

	@Override
	public String retrieveValue(String key) {

		TransactionContext context = hInstance.newTransactionContext(options);
		context.beginTransaction();

		String value = eventMap.get(key);
		eventMap.remove(key);

		context.commitTransaction();

		return value;

	}

	@Override
	public String storeValue(String key, String value) {

		/**
		 * Maybe some validation need to be done here
		 */

		TransactionContext context = hInstance.newTransactionContext(options);
		context.beginTransaction();

		System.out.println(String.format("Storing key %s : value %s", key, value));
		eventMap.put(key, value);

		context.commitTransaction();

		return null;
	}

}
