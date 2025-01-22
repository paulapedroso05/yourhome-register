package br.com.yourhome.register.configuracao.exception;

import br.com.yourhome.register.configuracao.exception.model.MessageType;
import org.springframework.http.HttpStatus;

import java.util.List;

import static java.util.Collections.singletonList;

public class ResourceNotFoundException extends AppRuntimeException {

	public ResourceNotFoundException(String notification) {
		super(MessageType.Resource_Not_Found, singletonList(notification), HttpStatus.NOT_FOUND.value());
	}

	public ResourceNotFoundException(List<String> notifications) {
		super(MessageType.Resource_Not_Found, notifications, HttpStatus.NOT_FOUND.value());
	}

	public ResourceNotFoundException(List<String> notifications, Throwable cause) {
		super(MessageType.Resource_Not_Found, notifications, cause, HttpStatus.NOT_FOUND.value());
	}

}
