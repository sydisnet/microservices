package org.javaee7.wildfly.samples.everest.order;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.javaee7.wildfly.samples.services.registration.ServiceRegistry;
import org.javaee7.wildfly.samples.services.ZooKeeperServices;

/**
 * @author arungupta
 */
@Startup
@Singleton
public class OrderService {
    @Inject @ZooKeeperServices ServiceRegistry services;
//    @Inject @SnoopRegistry ServiceRegistry services;
//    @Inject @FixedRegistry ServiceRegistry services;
    
    private static final String endpointURI = "http://localhost:8080/order/resources/order";
    private static final String serviceName = "order";
    
    @PostConstruct
    public void registerService() {
        services.registerService(serviceName, endpointURI);
    }
    
    @PreDestroy
    public void unregisterService() {
        services.unregisterService(serviceName, endpointURI);
    }
}
