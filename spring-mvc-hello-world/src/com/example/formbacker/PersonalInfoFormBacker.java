package com.example.formbacker;

//a form backing bean
public class PersonalInfoFormBacker {
	private Name name;
	private int age;
	private String interest;
	
	
	public PersonalInfoFormBacker() {
		super();
		name = new Name();
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
}
