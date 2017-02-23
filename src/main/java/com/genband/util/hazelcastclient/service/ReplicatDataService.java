package com.genband.util.hazelcastclient.service;

/**
 * 
 * Cannot specifiy which hashmap to store yet, may implement this function later
 * 
 * @author sewang
 *
 */
public interface ReplicatDataService {

	/**
	 * Retrive the value and delete the entry
	 * 
	 * @param key
	 * @return
	 */
	public String retrieveValue(String key);

	/**
	 * Read the value from a key
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key);

	/**
	 * Store <key,value> inside a Replicat Data
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String storeValue(String key, String value);

}
