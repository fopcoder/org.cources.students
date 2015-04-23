package org.students;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	private Student[] student;
	private Instructor[] instructor;
	private String name;
	private int year;

	public Group( String name, int year, int num )
			throws ArrayIndexOutOfBoundsException, NegativeArraySizeException {
		this.name = name;
		this.year = year;
		this.student = new Student[num];
		this.instructor = new Instructor[2];
	}

	public Student[] getStudents() {
		Student[] s = new Student[this.student.length];

		try {
			System.arraycopy( this.student, 0, s, 0, this.student.length );
		}
		catch( Exception e ) {
			s = null;
			e.printStackTrace();
		}

		return s;
	}

	public boolean addStudent( Student s ) {
		boolean t = false;

		for( int i = 0; i < this.student.length; i++ ) {
			if( this.student[i] != null ) continue;

			this.student[i] = s;
			t = true;
			break;
		}

		return t;
	}

	public boolean delStudent( int idx ) {
		boolean t = false;

		try {
			this.student[idx] = null;
			t = true;
		}
		catch( Exception e ) {
			e.printStackTrace();
		}

		return t;
	}

	public Student findStudent( String surname ) {
		Student s = null;

		for( int i = 0; i < this.student.length; i++ ) {
			if( this.student[i] == null ) continue;

			if( this.student[i].getSurname() == surname ) {
				s = this.student[i];
				break;
			}
		}

		return s;
	}

	public Student findStudent( String name, String surname ) {
		Student s = null;

		for( int i = 0; i < this.student.length; i++ ) {
			if( this.student[i] == null ) continue;

			if( this.student[i].getName() == name
					&& this.student[i].getSurname() == surname ) {
				s = this.student[i];
				break;
			}
		}

		return s;
	}

	public Instructor[] getInstructors() {
		Instructor[] s = new Instructor[this.instructor.length];

		try {
			System.arraycopy( this.instructor, 0, s, 0, this.instructor.length );
		}
		catch( Exception e ) {
			s = null;
			e.printStackTrace();
		}

		return s;
	}

	public boolean addInstructor( Instructor s ) {
		boolean t = false;

		for( int i = 0; i < this.instructor.length; i++ ) {
			if( this.instructor[i] != null ) continue;

			this.instructor[i] = s;
			t = true;
			break;
		}

		return t;
	}

	public boolean delInstructor( int idx ) {
		boolean t = false;

		try {
			this.instructor[idx] = null;
			t = true;
		}
		catch( Exception e ) {
			e.printStackTrace();
		}

		return t;
	}

	public void serialize( String path ) {
		try( ObjectOutputStream OOS = new ObjectOutputStream(
				new FileOutputStream( path ) ) ) {
			OOS.writeObject( this );
		}
		catch( IOException e ) {
			System.out.println( "ERROR save group !!!" );
		}
	}

	public static Group deserialize( String path ) {
		Group g = null;

		try( ObjectInputStream OIS = new ObjectInputStream(
				new FileInputStream( path ) ) ) {
			g = (Group)OIS.readObject();
		}
		catch( IOException | ClassNotFoundException e ) {
			System.out.println( "ERROR load group !!!" );
		}

		return g;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear( int year ) {
		this.year = year;
	}

	@Override
	public String toString() {
		String s = "Group [name=" + name + ", year=" + year + "]\n";

		for( int i = 0; i < this.student.length; i++ ) {
			if( this.student[i] == null ) continue;
			s += this.student[i] + "\n";
		}

		for( int i = 0; i < this.instructor.length; i++ ) {
			if( this.instructor[i] == null ) continue;
			s += this.instructor[i] + "\n";
		}

		return s;
	}
}
