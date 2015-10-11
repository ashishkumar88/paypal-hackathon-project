package org.paypal.hackathon.project.persistence.bean;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "content_settings", catalog = "paypalhackathon")
public class ContentSettings implements java.io.Serializable {

	/**
	 *
	 */
	public static final String FIND_CONTENT_BY_ID = "findContentById";
	public static final String FIND_CONTENT_BY_STRING_ID = "findContentByStringId";

	private static final long serialVersionUID = -2378531157732598340L;
	private Long contentSettingsId;
	private String contentTypeName;
	private String content;
	private String contentId;
	private String fieldType;

	public ContentSettings() {

	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	@Column(name = "content_id")
	public String getContentId() {
		return this.contentId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "content_settings_id", unique = true, nullable = false)
	public Long getContentSettingsId() {
		return this.contentSettingsId;
	}

	@Column(name = "content_type_name")
	public String getContentTypeName() {
		return this.contentTypeName;
	}

	@Column(name = "field_type")
	public String getFieldType() {
		return this.fieldType;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public void setContentSettingsId(Long contentSettingsId) {
		this.contentSettingsId = contentSettingsId;
	}

	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
}
