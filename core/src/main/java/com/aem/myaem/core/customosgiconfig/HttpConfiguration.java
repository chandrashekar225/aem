package com.aem.myaem.core.customosgiconfig;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name="Http Configuration",description = "This configuration reads the values to make an HTTP call to a JSON webservice")
public @interface HttpConfiguration {
@AttributeDefinition(name="Enable config",description ="This property indicates whether the configuration values will taken into account or not",type=AttributeType.BOOLEAN)
public boolean enableConfig();

@AttributeDefinition(name="Protocal",description = "Choose Protocol",options = {@Option(label="HTTP",value="HTTP"),@Option(label="HTTPS",value="HTTPS")})
public String getProtocol();

@AttributeDefinition(name="Server",description = "Enter the server name")
public String getserver();

@AttributeDefinition(name="Endpoint",description = "Enter the endpoint")
public String getEndpoint();

}
