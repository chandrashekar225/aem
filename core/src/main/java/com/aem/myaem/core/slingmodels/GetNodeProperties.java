package com.aem.myaem.core.slingmodels;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.Node;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.aem.myaem.core.bean.NodeOprations;
import com.aem.myaem.core.service.NodeOprationsI;


@Model(adaptables=Resource.class)

public class GetNodeProperties {
	
	

	@OSGiService
	NodeOprationsI obj;
	
	private String firstName;
	private String lastName;
	private String pwd;
	private String username;
	
	@PostConstruct
	protected void init() {
		try {
			NodeOprations bean=obj.getNodeProperties();
			 firstName=bean.getFirstName();
			 lastName=bean.getLastName();
			 pwd=bean.getPassword();
			 username=bean.getUserName();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPwd() {
		return pwd;
	}
	public String getUsername() {
		return username;
	}
	
	
	
	
	

}
