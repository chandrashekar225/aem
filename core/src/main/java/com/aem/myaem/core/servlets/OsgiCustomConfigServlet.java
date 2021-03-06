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

import com.aem.myaem.core.service.CustomOsgiI;
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=OsgiCustomConfigServlet Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "Sling.servlet.paths="+"/bin/OsgiCustomConfigServlet"
})
public class OsgiCustomConfigServlet extends SlingAllMethodsServlet{
	@Reference
	private CustomOsgiI obj;
@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(request, response);
	
	try {
		String scr=obj.readOsgiConfiguration();
		response.getWriter().write(scr);
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
