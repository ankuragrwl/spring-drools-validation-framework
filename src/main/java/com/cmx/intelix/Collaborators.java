/**
 * Project : cmx-validation-framework
 * Type : Collaborators
 * Created By : shekharp
 * Date : Aug 21, 2016
 */
package com.cmx.intelix;

import java.util.Collections;
import java.util.Map;

/**
 * @author shekharp
 *
 */
// @Component
public class Collaborators {

	private final Map<String, Object> collaborators;

	public Collaborators(Map<String, Object> collaborators) {
		super();
		this.collaborators = collaborators;
	}

	public Map<String, Object> getCollaborators() {
		return Collections.unmodifiableMap(collaborators);
	}
}
