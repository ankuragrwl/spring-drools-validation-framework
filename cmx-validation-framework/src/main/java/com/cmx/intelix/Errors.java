/**
 * Project : cmx-validation-framework
 * Type : Errors
 * Created By : shekharp
 * Date : Aug 21, 2016
 */
package com.cmx.intelix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author shekharp
 *
 */
public class Errors {

	private final List<Error> errors = Collections.synchronizedList(new ArrayList<Error>());

	public Collection<Error> getErrors() {
		return Collections.unmodifiableCollection(errors);
	}

	public void addError(Object target, String field, String message) {
		this.errors.add(new Error(target, field, message));
	}

	public boolean hasErrors() {
		if (this.errors.size() > 0) {
			return true;
		}
		return false;
	}
}
