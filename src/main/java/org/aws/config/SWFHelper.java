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
       return System.getProperty("SWF_DOMAIN");
   }

   public static AmazonSimpleWorkflow CLIENT(){
       ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70*1000);

       return AmazonSimpleWorkflowClient.builder().withClientConfiguration(config).build();
   }
}
