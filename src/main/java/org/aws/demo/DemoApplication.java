package org.aws.demo;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.*;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;
import org.aws.config.SWFHelper;
import org.aws.demo.activities.GreeterActivitiesImpl;
import org.aws.demo.workflow.GreeterWorkflow;
import org.aws.demo.workflow.GreeterWorkflowImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
		SpringApplication.run(DemoApplication.class, args);
        AmazonSimpleWorkflow service = SWFHelper.INSTANCE.CLIENT();

        String domain = SWFHelper.INSTANCE.DOMAIN();
        String taskListToPoll = "HelloWorldAsyncList";

        ActivityWorker aw = new ActivityWorker(service, domain, taskListToPoll);
        aw.addActivitiesImplementation(new GreeterActivitiesImpl());
        aw.start();

        WorkflowWorker wfw = new WorkflowWorker(service, domain, taskListToPoll);
        wfw.addWorkflowImplementationType(GreeterWorkflowImpl.class);
        wfw.start();
        System.out.println("Worker Started!!!");
	}
}
