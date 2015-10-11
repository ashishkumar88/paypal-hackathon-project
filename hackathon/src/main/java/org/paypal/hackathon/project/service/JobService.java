package org.paypal.hackathon.project.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.paypal.hackathon.project.dao.JobDAO;
import org.paypal.hackathon.project.persistence.bean.JobSettings;
import org.paypal.hackathon.project.web.view.JobRequestView;
import org.paypal.hackathon.project.web.view.ResponseStatusView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

	@Autowired
	JobDAO jobDAO;

	public ResponseStatusView createJob(JobRequestView jobRequestView) {
		try{
			JobSettings jobSettings = this.mapModelToBean(jobRequestView);
			this.jobDAO.save(jobSettings);
			ResponseStatusView responseStatusView = ResponseStatusView.createSuccessResponse("Job has been successfully created.");
			return responseStatusView;
		} catch(Exception e) {
			ResponseStatusView responseStatusView = ResponseStatusView.createErrorResponse("Error while creating job.");
			return responseStatusView;
		}
	}

	private JobSettings mapModelToBean(JobRequestView jobRequestView) {
		JobSettings jobSettings = new JobSettings();
		jobSettings.setJobType(jobRequestView.getType());
		jobSettings.setJobTitle(jobRequestView.getTitle());
		jobSettings.setDescription(jobRequestView.getDescription());
		if(StringUtils.isNotEmpty(jobRequestView.getJobId())) {
			jobSettings.setJobSettingsId(Long.parseLong(jobRequestView.getJobId()));
		}
		return jobSettings;
	}

	public List<JobSettings> getAllJobs(JobRequestView jobRequestView) {
		return this.jobDAO.getAllJobs();
	}

	public JobSettings getJobById(JobRequestView jobRequestView) {
		return this.jobDAO.getJobById(Long.parseLong(jobRequestView.getJobId()));
	}

	public ResponseStatusView updateJob(JobRequestView jobRequestView) {
		JobSettings jobSettings = this.mapModelToBean(jobRequestView);
		try{
			this.jobDAO.update(jobSettings);
			ResponseStatusView responseStatusView = ResponseStatusView.createSuccessResponse("Job has been successfully updated.");
			return responseStatusView;
		} catch(Exception e) {
			ResponseStatusView responseStatusView = ResponseStatusView.createErrorResponse("Error while updating job.");
			return responseStatusView;
		}
	}

	public ResponseStatusView deleteJob(JobRequestView jobRequestView) {
		JobSettings jobSettings = this.mapModelToBean(jobRequestView);
		try{
			this.jobDAO.deleteJob(jobSettings);
			ResponseStatusView responseStatusView = ResponseStatusView.createSuccessResponse("Job has been successfully updated.");
			return responseStatusView;
		} catch(Exception e) {
			ResponseStatusView responseStatusView = ResponseStatusView.createErrorResponse("Error while updating job.");
			return responseStatusView;
		}
	}

}
