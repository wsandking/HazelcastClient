package com.genband.util.hazelcastclient.service;

public enum DataAccessService {
    HAZELCAST_DATA_CLUSTER("Hazelcast", "Hazelcast replicat data service.");

    private String key;
    private String description;

    DataAccessService(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String toString() {
        return this.key + " : " + this.description;
    }

}
