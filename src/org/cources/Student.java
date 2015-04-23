package org.cources;

public class Student extends Human {
	private static final long serialVersionUID = 1L;
	private double grade = 0;

	public Student( String name, String surname ) {
		super( name, surname );
	}

	public Student( String name, String surname, int age, double grade ) {
		super( name, surname, age );
		this.grade = grade;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade( double g ) {
		this.grade = g;
	}

	@Override
	public String toString() {
		return "Student [grade = " + grade + ", " + super.toString() + "]";
	}

	@Override
	public boolean equals( Object obj ) {
		return ( super.equals( obj ) && this.grade == ( (Student)obj ).grade );
	}

	@Override
	protected Student clone() {
		return new Student( this.getName(), this.getSurname(), this.getAge(), this.grade );
	}

}
