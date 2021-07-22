package com.aem.myaem.core.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.aem.myaem.core.customosgiconfig.COsgiC;
import com.aem.myaem.core.service.COCI;
@Component(service = COCI.class,immediate = true)
@Designate(ocd=COsgiC.class)
public class COCImpl implements COCI{
	private COsgiC osgiconfiguration;

	@Activate
	protected void activate(COsgiC osgiconfiguration) {
		this.osgiconfiguration=osgiconfiguration;
		
	}
	@Override
	public String osgiConfigaration() {
		// TODO Auto-generated method stub
		int StudentId=osgiconfiguration.getstudentId();
		String studentname=osgiconfiguration.getstudentName();
		String studentCollegeName=osgiconfiguration.getstudentcollagename();
		
		return StudentId+studentname+studentCollegeName;
	}

}
