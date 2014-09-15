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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class H2Database implements H2DatabaseMBean {

    private final Logger log = LoggerFactory.getLogger(H2Database.class);

    private String args = "";

    private Server h2Server;

    @Override
    public String getArgs() {
        return args;
    }

    @Override
    public void setArgs(final String args) {
        this.args = args;
    }

    protected void start() throws Exception {
        log.info("Start H2 server");
        log.info("Create H2 server with the following arguments " + args);
        h2Server = Server.createTcpServer(args.split(" "));

        h2Server.setOut(System.err);
        h2Server.start();
    }

    protected void stop() throws Exception {
        log.info("Stopping H2 server");
        h2Server.shutdown();
        h2Server = null;
    }

}
