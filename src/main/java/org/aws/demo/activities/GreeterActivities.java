package org.aws.demo.activities;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 300,
        defaultTaskStartToCloseTimeoutSeconds = 10)

@Activities(version="2.0")
public interface GreeterActivities {
   String getName();
   String getGreeting(String name);
   void say(String what);
}