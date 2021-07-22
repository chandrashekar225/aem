package com.aem.myaem.core.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.aem.myaem.core.customosgiconfig.HttpConfiguration;
import com.aem.myaem.core.network.Network;
import com.aem.myaem.core.service.HttpConfigI;


@Component(service=HttpConfigI.class,immediate = true)
@Designate(ocd=HttpConfiguration.class)
public class HttpConfigImpl implements HttpConfigI{
	private HttpConfiguration obj;
	@Activate
	protected void activate(HttpConfiguration obj) {
		this.obj=obj;
		
	}
	
	@Override
	public String makeHttpCall() {
		// TODO Auto-generated method stub
		try {
			boolean enable=obj.enableConfig();
			String protocol=obj.getProtocol();
			String server=obj.getserver();
			String endpoint=obj.getEndpoint();
			String url = protocol + "://" + server + "/" + endpoint;
			if (enable) {
				String response = Network.readJson(url);
				return response;
			} else {
				return "Configuration not enabled";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "Error occurred" + e.getMessage();
		}
	}

}
