package com.genband.util.hazelcastclient;

import com.genband.util.hazelcastclient.service.DataAccessServiceFactory;
import com.genband.util.hazelcastclient.service.ReplicatDataService;

/**
 * 
 * Dummy hazelcast client for testing purpose
 * 
 * @author sewang
 *
 */
public class HazelcastClientSample {

	public static void main(String args[]) {

		try {

			System.out.println("Starting sys deployment.");
			ReplicatDataService service = DataAccessServiceFactory.getService("HAZELCAST_DATA_CLUSTER");

			service.storeValue("Maps", "Queens");
			System.out.println("Get value: " + service.getValue("Maps"));
			Thread.sleep(18000);

			System.out.println("Get value: " + service.getValue("Maps"));

			Thread.sleep(18000);
			System.out.println("Get value: " + service.getValue("Maps"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
