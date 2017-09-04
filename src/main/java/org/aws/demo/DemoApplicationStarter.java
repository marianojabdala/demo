package org.aws.demo;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;

import com.amazonaws.util.StringUtils;
import org.aws.config.SWFHelper;
import org.aws.demo.workflow.GreeterWorkflowClientExternal;
import org.aws.demo.workflow.GreeterWorkflowClientExternalFactory;
import org.aws.demo.workflow.GreeterWorkflowClientExternalFactoryImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplicationStarter {

	public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
	    SpringApplication.run(DemoApplicationStarter.class, args);
        AmazonSimpleWorkflow service = SWFHelper.INSTANCE.CLIENT();

        String domain = SWFHelper.INSTANCE.DOMAIN();

        for( int i=10 ; i< 20; i++){
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
