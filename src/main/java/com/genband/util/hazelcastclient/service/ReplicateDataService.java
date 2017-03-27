package com.genband.util.hazelcastclient.service;

/**
 * 
 * Cannot specifiy which hashmap to store yet, may implement this function later
 * 
 * @author sewang
 *
 */
public interface ReplicateDataService {

    /**
     * Retrive the value and delete the entry from default map
     * 
     * @param key
     * @return
     */
    public String retrieveValue(String key);

    /**
     * Retrive the value and delete the entry from map
     * 
     * @param key
     * @return
     */
    public String retrieveValue(String key, String mapName);

    /**
     *  Read the value for MapName
     *  
     * @param key 
     * @param mapName
     * @return
     */
    public String getValueFromMap(String key, String mapName);

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
    public void storeValue(String key, String value);

    /**
     * Store <key,value> in a specific data structure
     * 
     * @param key
     * @param value
     * @return
     */
    public void storeValue(String map, String key, String value);

}
