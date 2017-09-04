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
public class GreetingWorkflowWorker {

	public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
		SpringApplication.run(GreetingWorkflowWorker.class, args);
        AmazonSimpleWorkflow service = SWFHelper.INSTANCE.CLIENT();

        String domain = SWFHelper.INSTANCE.DOMAIN();

        String taskListToPoll = "HelloWorldAsyncList";

        WorkflowWorker wfw = new WorkflowWorker(service, domain, taskListToPoll);
        wfw.addWorkflowImplementationType(GreeterWorkflowImpl.class);
        wfw.start();
        System.out.println("Worker Started!!!");
	}
}
