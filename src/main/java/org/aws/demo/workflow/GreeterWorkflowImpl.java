package org.aws.demo.workflow;
import com.amazonaws.services.simpleworkflow.flow.annotations.Asynchronous;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;

import org.aws.demo.activities.GreeterActivitiesClient;
import org.aws.demo.activities.GreeterActivitiesClientImpl;

public class GreeterWorkflowImpl implements GreeterWorkflow{
   private GreeterActivitiesClient operations = new GreeterActivitiesClientImpl();

    @Override
    public void greet(int count) {
        Promise<String> name = operations.getName();
        Promise<String> greeting = getGreeting(count, name);
        operations.say(greeting);
    }

    @Asynchronous
    private Promise<String> getGreeting(int count, Promise<String> name) {
        String returnString = "Activity N°:" +count + " - Hello " + name.get() + "!";
        return Promise.asPromise(returnString);
    }
}