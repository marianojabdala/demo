package org.aws.parallel;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;
import org.aws.config.SWFHelper;
import org.aws.parallel.workflow.GreeterWorkflowImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingWorkflowWorkerParallel {

	public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
		SpringApplication.run(GreetingWorkflowWorkerParallel.class, args);

		AmazonSimpleWorkflow service = SWFHelper.INSTANCE.CLIENT();

        String domain = SWFHelper.INSTANCE.DOMAIN();

        String taskListToPoll = "HelloWorldParallelList";

        WorkflowWorker wfw = new WorkflowWorker(service, domain, taskListToPoll);
        wfw.addWorkflowImplementationType(GreeterWorkflowImpl.class);
        wfw.start();
        System.out.println("Worker Parallel Started!!!");
	}
}
