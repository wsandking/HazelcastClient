package com.genband.util.hazelcastclient.service;

public enum DataAccessService {
	HAZELCAST_DATA_CLUSTER("Hazelcast replicat data service ");

	private String value;

	DataAccessService(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}

}
