package br.com.yourhome.register.configuracao.exception;

import br.com.yourhome.register.configuracao.exception.model.MessageType;

import java.util.List;

public class AppRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private List<String> notifications;

	private MessageType messageType;

	private Integer errorCode;

	public AppRuntimeException() {
	}

	public AppRuntimeException(MessageType messageType, List<String> notifications, Integer errorCode) {
		super(new Throwable(notifications.toString()));
		this.messageType = messageType;
		this.notifications = notifications;
		this.errorCode = errorCode;
	}

	public AppRuntimeException(MessageType messageType, List<String> notifications, Throwable cause,
			Integer errorCode) {
		super(cause);
		this.messageType = messageType;
		this.notifications = notifications;
		this.errorCode = errorCode;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public List<String> getNotifications() {
		return notifications;
	}

	public int getHttpErrorCode() {
		return errorCode;
	}

}
