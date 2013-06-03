package org.bonitasoft.jboss.jdbc;

import org.jboss.system.ServiceMBean;


public interface H2DatabaseMBean extends ServiceMBean {

    String getArgs();
    void setArgs(String args);

}
