package com.example.notes;

public class NotesData {

	// private variables
	String name, college, city, branch, professor, notes;
	int semester, year;

	// Empty constructor
	public NotesData() {

	}

	// constructor
	public NotesData(String name, String branch, int year, int semester,
			String college, String city, String professor, String notes) {
		this.name = name;
		this.college = college;
		this.city = city;
		this.branch = branch;
		this.professor = professor;
		this.semester = semester;
		this.year = year;
		this.notes = notes;

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

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}