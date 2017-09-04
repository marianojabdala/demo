package org.aws.parallel;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;

import org.aws.config.SWFHelper;
import org.aws.parallel.workflow.GreeterWorkflowClientExternal;
import org.aws.parallel.workflow.GreeterWorkflowClientExternalFactory;
import org.aws.parallel.workflow.GreeterWorkflowClientExternalFactoryImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplicationStarterParallel {

	public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
	    SpringApplication.run(DemoApplicationStarterParallel.class, args);

        AmazonSimpleWorkflow service = SWFHelper.INSTANCE.CLIENT();

        String domain = SWFHelper.INSTANCE.DOMAIN();

        for( int i=1 ; i < 5; i++){
            GreeterWorkflowClientExternalFactory factory = new GreeterWorkflowClientExternalFactoryImpl(service, domain);
            GreeterWorkflowClientExternal greeter = factory.getClient();
            System.out.println("RunID: " + greeter.getWorkflowExecution().getRunId());
            System.out.println("Workflow Id:" + greeter.getWorkflowExecution().getWorkflowId());
            greeter.greet(i);
            System.out.println("Message sent");
            System.out.println
                    ("######################################################################################");
        }


	}
}
