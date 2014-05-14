package org.jboss.as.ejb.client;

import java.util.Hashtable;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.as.ejb.Hello;

public class HelloClient {
    public static void main(String[] args) throws Exception {
        InitialContext ctx = getInitialContext();

        Object obj = ctx.lookup("/Hello/remote");

        Hello ejbObject = (Hello) obj;
        System.out.println(SEPARATOR);
        System.out.println(ejbObject.sayHello());
        System.out.println(SEPARATOR);

    }

    protected static InitialContext getInitialContext() throws NamingException {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put("java.naming.provider.url", "localhost:1199");
        env.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        return new InitialContext(env);
    }

    private static final String SEPARATOR = "===============================================";
}
