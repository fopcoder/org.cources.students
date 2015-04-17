package org.cources;

public class Instructor extends Human {
	private static final long serialVersionUID = 1L;
	private String degree;
	private String profession;

	public Instructor( String name, String surname, String degree, String profession ) {
		super( name, surname );
		this.degree = degree;
		this.profession = profession;
	}

	public Instructor( String name, String surname, int age, String degree, String profession ) {
		super( name, surname, age );
		this.degree = degree;
		this.profession = profession;
	}

	public Instructor( String name, String surname ) {
		super( name, surname );
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree( String degree ) {
		this.degree = degree;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession( String profession ) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Instructor [degree = " + degree + ", profession = " + profession + ", " + super.toString() + "]";
	}

	@Override
	public boolean equals( Object obj ) {
		return ( super.equals( obj ) && this.degree == ( (Instructor)obj ).degree && this.profession == ( (Instructor)obj ).profession );
	}

	@Override
	protected Instructor clone() {
		return new Instructor( this.getName(), this.getSurname(), this.getAge(), this.degree, this.profession );
	}

}
