/**
 * Project : cmx-validation-framework
 * Type : BusinessRulesConstraint
 * Created By : shekharp
 * Date : Aug 21, 2016
 */
package com.cmx.intelix;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author shekharp
 *
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = BusinessRulesConstraintValidator.class)
public @interface BusinessRulesConstraint {
	String message() default "Business rules validation failed.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}