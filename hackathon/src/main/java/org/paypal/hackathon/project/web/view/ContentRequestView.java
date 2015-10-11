package org.paypal.hackathon.project.web.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ContentRequestView {

	private String contentId;
	private String contentSettingsId;
	private String searchString;
	private String contentTypeName;
	private String fieldType;
	private String content;

	public String getContentId() {
		return this.contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getSearchString() {
		return this.searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	public String getContentSettingsId() {
		return this.contentSettingsId;
	}
	public void setContentSettingsId(String contentSettingsId) {
		this.contentSettingsId = contentSettingsId;
	}
	public String getContentTypeName() {
		return this.contentTypeName;
	}
	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}
	public String getFieldType() {
		return this.fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
