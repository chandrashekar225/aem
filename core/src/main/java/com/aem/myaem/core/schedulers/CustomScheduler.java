package com.aem.myaem.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.myaem.core.customosgiconfig.SlingSchedulerConfiguration;
@Component(immediate = true, service = CustomScheduler.class)
@Designate(ocd = SlingSchedulerConfiguration.class)
public class CustomScheduler implements Runnable  {
	private static final Logger log = LoggerFactory.getLogger(CustomScheduler.class);
	private String customParameter;
	private int schedulerId;
	@Reference
	private Scheduler scheduler;
	
	
	@Activate
	protected void activate(SlingSchedulerConfiguration config) {
		schedulerId=config.schedulername().hashCode();
		customParameter=config.customParameter();
		
	}
	@Modified
	protected void modified(SlingSchedulerConfiguration config) {
		removeScheduler();
		schedulerId=config.schedulername().hashCode();
		addScheduler(config);
		
		
	}
	
	@Deactivate
	protected void deactive() {
		
		removeScheduler();
	}
	
	private void addScheduler(SlingSchedulerConfiguration config) {
		// TODO Auto-generated method stub
		
		if (config.enabled()) {
			
			ScheduleOptions scheduleOptions = scheduler.EXPR(config.cronExpression());
			scheduleOptions.name(config.schedulername());
			scheduleOptions.canRunConcurrently(false);
			scheduler.schedule(this, scheduleOptions);
			log.info("scheduler added");
			 
		} else {
log.info("schedular disabled");
		}
		
	}
	private void removeScheduler() {
		// TODO Auto-generated method stub
		log.info("Removing scheduler: {}", schedulerId);
		scheduler.unschedule(String.valueOf(schedulerId));
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		log.info("Custom Scheduler is now running using the passed custom paratmeter, customParameter {}", customParameter);
	}

}
