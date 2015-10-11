package org.paypal.hackathon.project.persistence.bean;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_settings", catalog = "paypalhackathon")
public class JobSettings {

	public static final String FIND_JOB_BY_ID = "findJobById";

	private Long jobSettingsId;
	private String jobTitle;
	private String jobType;
	private String description;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "job_settings_id", unique = true, nullable = false)
	public Long getJobSettingsId() {
		return this.jobSettingsId;
	}

	public void setJobSettingsId(Long jobSettingsId) {
		this.jobSettingsId = jobSettingsId;
	}

	@Column(name = "job_title")
	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name = "job_type")
	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	@Column(name = "job_description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
