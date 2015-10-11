package org.paypal.hackathon.project.web.view;

public class ResponseStatusView {
	@Override
	public String toString() {
		return "ResponseStatusView [severity=" + this.severity + ", message="
				+ this.message + "]";
	}
	public enum Severity {ERROR, VALID}

	private Severity severity = Severity.VALID;
	private String message;

	public Severity getSeverity() {
		return this.severity;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	public static ResponseStatusView createSuccessResponse(String message) {
		ResponseStatusView responseStatusView = new ResponseStatusView();
		responseStatusView.setMessage(message);
		return responseStatusView;
	}
	public static ResponseStatusView createErrorResponse(String message) {
		ResponseStatusView responseStatusView = new ResponseStatusView();
		responseStatusView.setSeverity(Severity.ERROR);
		responseStatusView.setMessage(message);
		return responseStatusView;
	}
}