Remote Stateless EJB Invocation
===============================
Author: Romain Pelisse
Level: Beginner
Technologies: EJB
Summary: Demonstrates how to remotely invoked a Stateless EJB
Target Product: EAP
Product Versions: EAP 5.2.0
Source: <https://github.com/rpelisse/jboss-eap-5-remote-stateless-ejb-quickstart>

What is it?
-----------

This quickstart demonstre how to package and deploy a stateless EJB, and then invoke it remotely,
from a simple Java application.

System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.

The application this project produces is designed to be run on JBoss EAP 5.2.0.

Install EAP
-----------

1. Obtain JBoss EAP on Red Hat's Customer Portal at https://access.redhat.com/jbossnetwork/restricted/listSoftware.html

Note: the will provided you both a Maven repository, from which Maven will be able to retrieve *compile* needed jars, but also some runtime dependencies (in the lib/ folder) required to run the quickstart.

Run the quickstart
------------------

1. Open a command line and navigate to the root directory of this quickstart. Set the JBOSS\_HOME
   environment variable:

       $ export JBOSS\_HOME=${USER}/path/to/jboss/eap/jboss-as

2. Type this command to build and deploy the archive:

       $ mvn clean package

3. This will create a jar file at `target/`, deploy the archive into JBoss:

       $ cp target/*.jar ${JBOSS_HOME}/server/default/deploy/

4. If not already started, start JBoss (in a separate interpreter):

       $ cd ${JBOSS_HOME}
       $ ./bin/run.sh

5 . Run the example application in its directory:

       $ mvn exec:java

6. Run the example using JNDI over HTTP features:

       $ mvn -DuseJndiOverHttp=true exec:java

Note: all other configuration changes for the client (server host, port, ...) requires to edit the Java client file and modify the code.

Debug the Application
---------------------

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following commands to pull them into your local repository. The IDE should then detect them.

    mvn dependency:sources
    mvn dependency:resolve -Dclassifier=javadoc
