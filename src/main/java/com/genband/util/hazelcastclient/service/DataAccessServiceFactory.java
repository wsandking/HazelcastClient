package com.genband.util.hazelcastclient.service;

/**
 * 
 * 
 * 
 * @author sewang
 *
 */
public class DataAccessServiceFactory {

    public static ReplicateDataService getService(String das) {

        DataAccessService svc = DataAccessService.valueOf(das);
        ReplicateDataService service = null;

        switch (svc) {
        case HAZELCAST_DATA_CLUSTER:

            service = HazelcastReplicatDataService.getInstance();
            break;

        default:
            /**
             * 
             * Unrecognized client
             * 
             */
            break;

        }

        return service;

    }

}
