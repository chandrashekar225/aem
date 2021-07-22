package com.aem.myaem.core.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.myaem.core.service.SampleInterface;


public class SampleImpl implements SampleInterface{
	//private static final long serialVersionUid=1L;

	protected static final Logger log=LoggerFactory.getLogger(SampleImpl.class);
	@Override
	public boolean addEmp(String firstName, String lastName, String EmployeeId) {
		// TODO Auto-generated method stub
		log.info("firstName=================================="+firstName);
		log.info("lastName=================================="+lastName);
		log.info("EmpId=================================="+EmployeeId);

		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
