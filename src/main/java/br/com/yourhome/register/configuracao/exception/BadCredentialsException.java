package br.com.yourhome.register.configuracao.exception;

import br.com.yourhome.register.configuracao.exception.model.MessageType;
import org.springframework.http.HttpStatus;

import static java.util.Collections.singletonList;

public class BadCredentialsException extends AppRuntimeException {

	public BadCredentialsException(String message) {
		super(MessageType.Invalid_Token, singletonList(message), HttpStatus.UNAUTHORIZED.value());
	}

}
