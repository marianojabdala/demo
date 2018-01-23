package org.aws.parallel;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import org.aws.config.SWFHelper;
import org.aws.parallel.activities.GreeterActivitiesImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingActivitiesWorkerParallel {

	public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
		SpringApplication.run(GreetingActivitiesWorkerParallel.class, args);
        AmazonSimpleWorkflow service = SWFHelper.INSTANCE.CLIENT();

        String domain = SWFHelper.INSTANCE.DOMAIN();

        String taskListToPoll = "HelloWorldParallelList";

        ActivityWorker aw = new ActivityWorker(service, domain, taskListToPoll);
        aw.addActivitiesImplementation(new GreeterActivitiesImpl());
        aw.setTaskExecutorThreadPoolSize(10);
        aw.start();

        System.out.println("Activities Worker Parallel Started!!!");
	}
}
