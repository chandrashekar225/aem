package com.aem.myaem.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.myaem.core.bean.NodeOprations;
import com.aem.myaem.core.service.NodeOprationsI;
import com.google.gson.Gson;
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=JsonConversionSer Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "Sling.servlet.paths="+"/bin/JsonConversionSer"
})

public class JsonConversionSer extends SlingAllMethodsServlet{
	
	protected static final Logger log=LoggerFactory.getLogger(JsonConversionSer.class);
	@Reference
	NodeOprationsI obj;
@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(request, response);
	try {
		log.info("entered into servlet try***********");
		
		NodeOprations bean =obj.getNodeProperties();
		log.info("bean*******************"+bean);
		String json = new Gson().toJson(bean);
		log.info("json conversion************"+json);
		response.getWriter().write(json);

	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
