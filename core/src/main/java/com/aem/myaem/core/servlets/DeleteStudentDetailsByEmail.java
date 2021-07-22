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

import com.aem.myaem.core.service.StudentI;
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=DeleteStudentDetailsByEmail Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
		/*
		 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
		 * "sling.servlet.extensions=" + "txt"
		 */
        "Sling.servlet.paths="+"/bin/deleteStudentDetailsByEmail"
})
public class DeleteStudentDetailsByEmail extends SlingAllMethodsServlet{
	
	@Reference
	StudentI StdDeleteDetails;
@Override
protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doPost(request, response);
	String firstName=request.getParameter("fname");
	String lastName=request.getParameter("lname");
	String email=request.getParameter("email");
	try {
		boolean b=StdDeleteDetails.deleteStudentDetailsByEmail(firstName, lastName, email);
		if (b) {
			response.getWriter().write("firstName"+firstName+"lastName"+lastName+"email"+email+b);

		} else {
			response.getWriter().write("Somthing went Wrong**********");

		}
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
