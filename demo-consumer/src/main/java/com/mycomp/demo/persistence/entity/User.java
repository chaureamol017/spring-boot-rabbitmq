/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.demo.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author Amol
 */

//@Setter
//@Getter
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
	private String registrationFor;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String mobile;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRegistrationFor() {
		return registrationFor;
	}

	public void setRegistrationFor(String registrationFor) {
		this.registrationFor = registrationFor;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
