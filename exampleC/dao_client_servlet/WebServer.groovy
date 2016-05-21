
// thanks to Renato Athaydes - http://bit.ly/1U6aEAA

@Grab(group='org.eclipse.jetty.aggregate', module='jetty-all', version='7.6.15.v20140411')

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.*
import groovy.servlet.*
 
println "Starting Jetty, press Ctrl+C to stop."

def server = new Server(5150)
 
def handler = new ServletContextHandler(ServletContextHandler.SESSIONS)
handler.contextPath = '/'
handler.resourceBase = '.'
handler.addServlet(GroovyServlet, '*.groovy')
def filesHolder = handler.addServlet(DefaultServlet, '/')
filesHolder.setInitParameter('resourceBase', './public')
 
server.handler = handler
server.start()
