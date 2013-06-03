package org.bonitasoft.jboss.jdbc;

import org.h2.tools.Server;
import org.jboss.system.ServiceMBeanSupport;


public class H2Database extends ServiceMBeanSupport implements H2DatabaseMBean {

    private String args = "";
    
    private Server h2Server;
    
    public String getArgs() {
        return args;
    }
    
    public void setArgs(String args) {
        this.args = args;
    }
    
    // ServiceMBeanSupport methods
    
    protected void createService() throws Exception {
        log.info("Create H2 server with the following arguments " + args);
        h2Server = Server.createTcpServer(args.split(" "));
        
        h2Server.setOut(System.err);
    }

    protected void startService() throws Exception {
        log.info("Start H2 server");
        h2Server.start();
    }

    protected void stopService() throws Exception {
        log.info("Stopping H2 server");
        h2Server.shutdown();
    }

    protected void destroyService() throws Exception {
        h2Server = null;
    }


}
