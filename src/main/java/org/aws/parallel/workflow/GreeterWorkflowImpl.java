package org.aws.parallel.workflow;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;

import org.aws.parallel.activities.GreeterActivitiesClient;
import org.aws.parallel.activities.GreeterActivitiesClientImpl;

public class GreeterWorkflowImpl implements GreeterWorkflow {
   private GreeterActivitiesClient operations = new GreeterActivitiesClientImpl();

    @Override
    public void greet(int count) {
        Promise<String> name = operations.getName();
        Promise<String> greeting = operations.getGreeting(count);
        operations.say(greeting, name);
    }
}