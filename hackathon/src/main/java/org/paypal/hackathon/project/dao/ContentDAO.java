package org.paypal.hackathon.project.dao;

import java.util.List;

import org.paypal.hackathon.project.persistence.bean.ContentSettings;

public interface ContentDAO {

	public List<ContentSettings> getAllContents();
	public ContentSettings getContentById(Long Id);
	public ContentSettings getContentById(String Id);
	public boolean save(ContentSettings contentSettings);
	public boolean update(ContentSettings contentSettings);
	public boolean deleteContent(ContentSettings contentSettings);
}
