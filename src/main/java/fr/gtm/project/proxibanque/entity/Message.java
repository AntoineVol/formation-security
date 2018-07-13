package fr.gtm.project.proxibanque.entity;

public class Message {

	private String content;
	private boolean error;

	public Message(String content, boolean error) {
		this.content = content;
		this.error = error;
	}

	public Message(String message) {
		this(message, false);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}
