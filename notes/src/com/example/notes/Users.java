package com.example.notes;

public class Users {

	// private variables
	String name, college, city, branch, email, password;
	int semester, year;

	// Empty constructor
	public Users() {

	}

	// constructor
	public Users(String name, String branch, int year, int semester,
			String college, String city, String email, String password) {
		this.name = name;
		this.college = college;
		this.city = city;
		this.branch = branch;
		this.email = email;
		this.semester = semester;
		this.year = year;
		this.password = password;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}