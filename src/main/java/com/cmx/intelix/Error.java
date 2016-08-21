/**
 * Project : cmx-validation-framework
 * Type : Error
 * Created By : shekharp
 * Date : Aug 21, 2016
 */
package com.cmx.intelix;

/**
 * @author shekharp
 *
 */
public class Error {

	private final Object target;
	private final String field;
	private final String message;

	public Error(Object target, String field, String message) {
		super();
		this.target = target;
		this.field = field;
		this.message = message;
	}

	public Object getTarget() {
		return target;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}

}
