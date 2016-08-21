/**
 * Project : cmx-validation-framework
 * Type : Person
 * Created By : shekharp
 * Date : Aug 21, 2016
 */
package com.cmx.intelix;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shekharp
 *
 */
@Entity
@Table(name = "person")
@BusinessRulesConstraint
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer personId;

	private String fname;

	private String lname;

	private Integer age;

	/**
	 *
	 */
	public Person() {
		super();
	}

	/**
	 * @param personId
	 * @param fname
	 * @param lname
	 * @param age
	 */
	public Person(Integer personId, String fname, String lname, Integer age) {
		super();
		this.personId = personId;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}

	/**
	 * @return the personId
	 */
	public Integer getPersonId() {
		return personId;
	}

	/**
	 * @param personId
	 *            the personId to set
	 */
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname
	 *            the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname
	 *            the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

}
