package br.com.yourhome.register.configuracao.exception;

import br.com.yourhome.register.configuracao.exception.model.MessageType;
import org.springframework.http.HttpStatus;

import static java.util.Collections.emptyList;

public class NoContentException extends AppRuntimeException {

	public NoContentException() {
		super(MessageType.No_Content_Error, emptyList(), HttpStatus.NO_CONTENT.value());
	}

}
