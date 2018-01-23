package org.aws.parallel.activities;

public class GreeterActivitiesImpl implements GreeterActivities {
   @Override
   public String getName() {
      return "World";
   }

   @Override
   public String getGreeting(int iteration) {
      return  "Iteration N°: " + iteration + " - Parallel - Hello";
   }

   @Override
   public void say(String greeting, String name) {
       System.out.println(greeting + name);
   }
}