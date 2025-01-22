package br.com.yourhome.register.configuracao.exception.model;

import java.util.Arrays;

public enum MessageType {

	Invalid_Token("Invalid Token"),

	Mult_Status_Error("The request is finished with errors."),

	No_Content_Error("The identifier that already exists."),

	Conflict_Error("The identifier that already exists."),

	Parameter_Error("A require param was missing, or malformed."),

	Bad_Request_Error("Request invalid or malformed."),

	Business_Logic_Error("Business logic error."),

	Resource_Not_Found("Resource not found."),

	Internal_Architecture_Error("Ooops! some big problem found."),

	List_Not_Found("List not found."),

	Method_Not_Allowed("Method Not Allowed"),

	Unsupported_Media_Type("The request entity is in a format not supported."),

	Access_Denied("Access denied."),

	Integration_Error("Error on services contract."),

	ERROR("error"),

	DESCRIPTION("error_description"),

	URI("error_uri"),

	INVALID_REQUEST("invalid_request"),

	INVALID_CLIENT("invalid_client"),

	INVALID_GRANT("invalid_grant"),

	UNAUTHORIZED_CLIENT("unauthorized_client"),

	UNSUPPORTED_GRANT_TYPE("unsupported_grant_type"),

	INVALID_SCOPE("invalid_scope"),

	INSUFFICIENT_SCOPE("insufficient_scope"),

	INVALID_TOKEN("invalid_token"),

	REDIRECT_URI_MISMATCH("redirect_uri_mismatch"),

	UNSUPPORTED_RESPONSE_TYPE("unsupported_response_type"),

	ACCESS_DENIED("access_denied");

	private final String description;

	MessageType(final String des) {
		description = des;
	}

	public static MessageType getByType(String type) {
		return Arrays.stream(MessageType.values()).filter(messageType -> messageType.name().equalsIgnoreCase(type))
				.findFirst().orElse(MessageType.ERROR);
	}

	public String getDescription() {
		return description;
	}

}
