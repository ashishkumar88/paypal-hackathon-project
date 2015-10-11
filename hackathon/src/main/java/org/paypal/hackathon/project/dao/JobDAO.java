package org.paypal.hackathon.project.dao;

import java.util.List;

import org.paypal.hackathon.project.persistence.bean.JobSettings;

public interface JobDAO {

	public void update(JobSettings jobSettings);
	public void save(JobSettings jobSettings);
	public List<JobSettings> getAllJobs();
	public JobSettings getJobById(Long id);
	public void deleteJob(JobSettings job);
}
