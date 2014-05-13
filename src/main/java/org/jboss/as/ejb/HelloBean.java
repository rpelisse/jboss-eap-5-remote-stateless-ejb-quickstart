package org.jboss.as.ejb;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name="Hello")
@Remote(Hello.class)
public class HelloBean implements Hello {

   private static final boolean DEBUG = true;

   @Resource
   private SessionContext context;

   private void printDebugInfo() {
       if ( DEBUG ) {
         System.out.println("Hello World!");
       }
   }

   private static void printDebugResult(String result) {
       if ( DEBUG )
         System.out.println(result);
   }

   public String sayHello() {
       printDebugInfo();
       String result = "Hello " + getName();
       printDebugResult(result);
       return result;
    }

   private String getName() {
     return "Mike";
   }
}
