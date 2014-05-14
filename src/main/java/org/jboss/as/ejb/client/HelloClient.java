package org.jboss.as.ejb.client;

import java.util.Hashtable;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

import org.jboss.as.ejb.Hello;

public class HelloClient {

    public static void main(String[] args) throws Exception {
        System.out.println(SEPARATOR);
        InitialContext ctx = getInitialContext();

        Object obj = ctx.lookup("/Hello/http");

        Hello ejbObject = (Hello) obj;

        System.out.println(ejbObject.sayHello());
        System.out.println(SEPARATOR);

    }

    protected static InitialContext getInitialContext() throws NamingException {
        Hashtable<String, String> env = new Hashtable<String, String>();
        if ( ! useJndiOverHttp() ) {
            env.put(Context.PROVIDER_URL, "localhost:1099");
            env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");            
        } else {
        	System.out.println("Using JNDI over HTTP to communicate with remote server");
            env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.HttpNamingContextFactory");
            env.put(Context.PROVIDER_URL, "http://localhost:8080/unified-invoker/JNDIFactory/?return-exception=true");
            env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        }
        return new InitialContext(env);
    }

    private static boolean useJndiOverHttp() {
        return stringToBoolean(retrieveParameterFromSystemProperties("useJndiOverHttp"));
    }
    
    public static String retrieveParameterFromSystemProperties(String parameterName) {
        return  System.getProperty(parameterName);
    }

    public static boolean stringToBoolean(String booleanValue) {
        if ( ! "".equals(booleanValue) )
        	return Boolean.valueOf(booleanValue);
        return false;
    }
    
    private static final String SEPARATOR = "===============================================";
}
