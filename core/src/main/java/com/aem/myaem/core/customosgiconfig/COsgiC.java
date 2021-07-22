package com.aem.myaem.core.customosgiconfig;



import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="Student details",description="this givs Student details")
public @interface COsgiC {
	@AttributeDefinition(name="StudentId",description="enter StudentID",type=AttributeType.INTEGER)
	public int getstudentId();
	@AttributeDefinition(name="StudentName",description="enter StudentName",type=AttributeType.STRING)
	public String getstudentName();
	@AttributeDefinition(name="StudentCollage",description="enter Studen college Name",type=AttributeType.STRING)
	public String getstudentcollagename();
	
}
