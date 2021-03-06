package com.swesource.sample.jee;

import org.jboss.ejb3.annotation.Clustered;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 */
@Stateful
@Local(ServerSfsbLocal.class)
@Remote(ServerSfsbRemote.class)
@Clustered
public class ServerSfsbBean implements ServerSfsbLocal, ServerSfsbRemote {

    @PersistenceContext(unitName = "samplePU")
    EntityManager em;

    @Override
    public String sayHello() {
        System.out.println("In ServerSfsbBean.sayHello()");
        return "Hello!";
    }
}
