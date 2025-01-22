package br.com.yourhome.register.configuracao.exception;

import br.com.yourhome.register.configuracao.exception.model.MessageType;
import org.springframework.http.HttpStatus;

import java.util.List;

import static java.util.Collections.singletonList;

public class ConflictException extends AppRuntimeException {

	public ConflictException(String notification) {
		super(MessageType.Conflict_Error, singletonList(notification), HttpStatus.CONFLICT.value());
	}

	public ConflictException(List<String> notifications) {
		super(MessageType.Conflict_Error, notifications, HttpStatus.CONFLICT.value());
	}

	public ConflictException(List<String> notifications, Throwable cause) {
		super(MessageType.Conflict_Error, notifications, cause, HttpStatus.CONFLICT.value());
	}

}
