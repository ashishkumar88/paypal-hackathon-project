package org.paypal.hackathon.project.utils;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class TaskScheduling {

	static final Logger logger = Logger.getLogger(TaskScheduling.class);

	public void doWork() {
		logger.info("Initiating task scheduling");
	}

	@Scheduled(cron = "0 0 0 16 * ?")
	public void endOfFortnightTask() {
	}

	@Scheduled(cron = "0 0 0 1 * ?")
	public void endOfMonthTask() {
	}

	@Scheduled(cron = "0 0 0 * * MON")
	public void endOfWeekTask() {
	}

	public void initiateInvoiceBatch() {
	}

	@PostConstruct
	public void onStartup() {
		this.doWork();
	}
}