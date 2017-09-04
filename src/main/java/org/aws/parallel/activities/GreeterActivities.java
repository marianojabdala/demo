package org.aws.parallel.activities;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 300,
        defaultTaskStartToCloseTimeoutSeconds = 10)
@Activities(version="3.0")
public interface GreeterActivities {
   String getName();
   String getGreeting();
   void say(String greeting, String name);
}