package org.aws.demo;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;
import org.aws.config.SWFHelper;
import org.aws.demo.activities.GreeterActivitiesImpl;
import org.aws.demo.workflow.GreeterWorkflowImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingActivitiesWorker {

	public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
		SpringApplication.run(GreetingActivitiesWorker.class, args);
        AmazonSimpleWorkflow service = SWFHelper.INSTANCE.CLIENT();

        String domain = SWFHelper.INSTANCE.DOMAIN();

        String taskListToPoll = "HelloWorldAsyncList";

        ActivityWorker aw = new ActivityWorker(service, domain, taskListToPoll);
        aw.addActivitiesImplementation(new GreeterActivitiesImpl());
        aw.start();

        System.out.println("Activities Worker Started!!!");
	}
}
