/**
 * Project : cmx-validation-framework
 * Type : BusinessRulesConstraintValidator
 * Created By : shekharp
 * Date : Aug 21, 2016
 */
package com.cmx.intelix;

import java.util.Arrays;
import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kie.internal.runtime.StatelessKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author shekharp
 *
 */

/**
 * Custom JSR303 {@link ConstraintValidator} that uses a Drools
 * {@link StatelessKnowledgeSession} to implement rules-based validation of
 * objects decorated with a @BusinessRulesConstraint annotation
 */
public class BusinessRulesConstraintValidator implements ConstraintValidator<BusinessRulesConstraint, Object> {

	private final Log logger = LogFactory.getLog(BusinessRulesConstraintValidator.class);

	private final StatelessKnowledgeSession session;

	@Autowired
	public BusinessRulesConstraintValidator(StatelessKnowledgeSession session, Collaborators collaborators) {
		this.session = session;
		if (collaborators != null) {
			final Map<String, Object> map = collaborators.getCollaborators();
			for (final String key : map.keySet()) {
				session.setGlobal(key, map.get(key));
			}
		}
	}

	@Override
	public void initialize(BusinessRulesConstraint constraint) {
	}

	@Override
	public boolean isValid(Object target, ConstraintValidatorContext context) {

		// Create Errors
		final Errors errors = new Errors();

		try {

			// Fire rules
			session.execute(Arrays.asList(new Object[] { errors, target }));

			// Check for errors
			if (errors.hasErrors()) {
				// Build constraint violations
				context.disableDefaultConstraintViolation();
				for (final Error error : errors.getErrors()) {
					context.buildConstraintViolationWithTemplate(error.getMessage()).addNode(error.getField())
							.addConstraintViolation();
				}
				return false;
			}
		} catch (final Exception e) {
			logger.error(e);
			return false;
		}

		return true;
	}

}
