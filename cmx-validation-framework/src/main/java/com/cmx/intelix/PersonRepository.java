/**
 * Project : cmx-validation-framework
 * Type : PersonRepository
 * Created By : shekharp
 * Date : Aug 21, 2016
 */
package com.cmx.intelix;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shekharp
 *
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
