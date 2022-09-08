package com.server_programming.handling_list.domain;

public class Student {
	private String firstName;
	private String lastName;

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}

}
