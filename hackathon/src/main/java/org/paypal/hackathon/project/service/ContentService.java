package org.paypal.hackathon.project.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.paypal.hackathon.project.dao.ContentDAO;
import org.paypal.hackathon.project.persistence.bean.ContentSettings;
import org.paypal.hackathon.project.web.view.ContentRequestView;
import org.paypal.hackathon.project.web.view.ResponseStatusView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

	@Autowired
	ContentDAO contentDAO;

	public List<ContentSettings> getAllContents() {
		return this.contentDAO.getAllContents();
	}

	public ContentSettings getContentById(Long Id) {
		return this.contentDAO.getContentById(Id);
	}

	public ContentSettings getContentById(String Id) {
		return this.contentDAO.getContentById(Id);
	}

	public ResponseStatusView createContent(ContentRequestView contentRequestView) {
		try{
			ContentSettings contentSettings = this.mapModelToBean(contentRequestView);
			this.contentDAO.save(contentSettings);
			ResponseStatusView responseStatusView = ResponseStatusView.createSuccessResponse("Content has been successfully created.");
			return responseStatusView;
		} catch(Exception e) {
			e.printStackTrace();
			ResponseStatusView responseStatusView = ResponseStatusView.createErrorResponse("Error while creating content.");
			return responseStatusView;
		}
	}

	private ContentSettings mapModelToBean(ContentRequestView contentRequestView) {
		ContentSettings contentSettings = new ContentSettings();
		contentSettings.setContentTypeName(contentRequestView.getContentTypeName());
		contentSettings.setFieldType(contentRequestView.getFieldType());
		contentSettings.setContent(contentRequestView.getContent());
		contentSettings.setContentId(contentRequestView.getContentId());
		if(StringUtils.isNotEmpty(contentRequestView.getContentSettingsId())) {
			contentSettings.setContentSettingsId(Long.parseLong(contentRequestView.getContentSettingsId()));
		}
		return contentSettings;
	}

	public ResponseStatusView updateContent(ContentRequestView contentRequestView) {
		try{
			ContentSettings contentSettings = this.mapModelToBean(contentRequestView);
			this.contentDAO.update(contentSettings);
			ResponseStatusView responseStatusView = ResponseStatusView.createSuccessResponse("Content has been successfully updated.");
			return responseStatusView;
		} catch(Exception e) {
			ResponseStatusView responseStatusView = ResponseStatusView.createErrorResponse("Error while updating content.");
			return responseStatusView;
		}
	}

	public ResponseStatusView deleteContent(ContentRequestView contentRequestView) {
		try{
			ContentSettings contentSettings = this.mapModelToBean(contentRequestView);
			this.contentDAO.deleteContent(contentSettings);
			ResponseStatusView responseStatusView = ResponseStatusView.createSuccessResponse("Content has been successfully deleted.");
			return responseStatusView;
		} catch(Exception e) {
			ResponseStatusView responseStatusView = ResponseStatusView.createErrorResponse("Error while deleting content.");
			return responseStatusView;
		}
	}
}
