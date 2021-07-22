package com.aem.myaem.core.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.myaem.core.bean.NodeOprations;
import com.aem.myaem.core.service.NodeOprationsI;

public class NodeSlingModelImpl implements NodeOprationsI{
	protected static final Logger log=LoggerFactory.getLogger(NodeOparationsImpl.class);

	@Reference
	private ResourceResolverFactory resolverFactory;
	ResourceResolver resourceResolver = null;
	private Session session;
	Resource resource;
	String resourcePath = "/content/ayansh/en/jcr:content/employ";

	@Override
	public boolean registerEmployDetails(String firstName, String lastName, String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean employLogin(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NodeOprations getNodeProperties() {
		// TODO Auto-generated method stub
		NodeOprations bean=null;
		try {
			resourceResolver = resolverFactory.getServiceResourceResolver(getSubServiceMap());
			session = resourceResolver.adaptTo(Session.class);
			log.info("Session*****"+session);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return null;
	}

	private Map<String, Object> getSubServiceMap(){
		log.info("****Inside getSubServiceMenu*****");
		Map<String, Object> serviceMap = null;
		
		try {
			serviceMap = new HashMap<String, Object>();
			serviceMap.put(ResourceResolverFactory.SUBSERVICE, "shiva");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			log.info("error*****"+ errors.toString());
		}
		
			log.info("****getSubServiceMenu method end****");
		return serviceMap;
		
	}

	@Override
	public boolean getChildNodeProperties() {
		// TODO Auto-generated method stub
		return false;
	}

}
