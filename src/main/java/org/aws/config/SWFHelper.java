package org.aws.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;

public enum SWFHelper {
    INSTANCE;


    public static String DOMAIN() {
       String domain = System.getProperty("SWF_DOMAIN");
       if (domain == null) {
           throw new RuntimeException("Missing SWF_DOMAIN property");
       }
       return domain;
    }

    public static AmazonSimpleWorkflow CLIENT(){
       ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70*1000);

       return AmazonSimpleWorkflowClient.builder().withRegion("us-east-1").withClientConfiguration(config).build();
    }

    public static int getIterations() {
        String iterations = System.getProperty("iterations");
        if (iterations == null || "".equals(iterations)) {
            return 10;
        }
        return Integer.parseInt(iterations);
    }
}
