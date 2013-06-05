/**                                                                                                                   
 * Copyright (C) 2013 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation
 * version 2.1 of the License.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth
 * Floor, Boston, MA 02110-1301, USA.
 **/
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
