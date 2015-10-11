package org.paypal.hackathon.project.dao;

import java.util.List;

import org.paypal.hackathon.project.persistence.bean.JobSettings;

public interface JobDAO {

	public boolean update(JobSettings jobSettings);
	public boolean save(JobSettings jobSettings);
	public List<JobSettings> getAllJobs();
	public JobSettings getJobById(Long id);
	public boolean deleteJob(JobSettings job);
}
