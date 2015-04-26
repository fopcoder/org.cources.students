package org.cources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Student> student = new ArrayList<>();
	private ArrayList<Instructor> instructor = new ArrayList<>();
	private String name;
	private int year, num;

	public Group( String name, int year, int num ) {
		this.name = name;
		this.year = year;
		this.num = num;
	}

	public ArrayList<Student> getStudents() {
		ArrayList<Student> s = new ArrayList<>();
		this.student.forEach( i -> s.add( i.clone() ) );
		return s;
	}

	public void addStudent( Student s ) {
		if( this.num == this.student.size() ) {
			System.out.println( "student place is over" );
			return;
		}
		this.student.add( s );
	}

	public void delStudent( int idx ) {
		try {
			this.student.remove( idx );
		}
		catch( IndexOutOfBoundsException e ) {
			System.out.println( "idx not found" );
		}
	}

	public ArrayList<Student> findStudent( String surname ) {
		ArrayList<Student> s = new ArrayList<>();

		this.student.forEach( i -> {
			if( i.getSurname() == surname ) s.add( i.clone() );
		} );

		return s;
	}

	public ArrayList<Student> findStudent( String name, String surname ) {
		ArrayList<Student> s = new ArrayList<>();

		this.student.forEach( i -> {
			if( i.getName() == name && i.getSurname() == surname ) {
				s.add( i.clone() );
			}
		} );

		return s;//
	}

	public ArrayList<Instructor> getInstructors() {
		ArrayList<Instructor> s = new ArrayList<Instructor>();
		this.instructor.forEach( i -> s.add( i.clone() ) );
		return s;
	}

	public void addInstructor( Instructor s ) {
		this.instructor.add( s );
	}

	public void delInstructor( int idx ) {
		try {
			this.instructor.remove( idx );
		}
		catch( IndexOutOfBoundsException e ) {
			System.out.println( "idx not found" );
		}
	}

	public void serialize( String path ) {
		String fn = path + "/" + this.name + ".grp";
		try( ObjectOutputStream OOS = new ObjectOutputStream( new FileOutputStream( fn ) ) ) {
			OOS.writeObject( this );
		}
		catch( IOException e ) {
			System.out.println( "ERROR save group !!!" );
		}
	}

	public static Group deserialize( String fileName ) {
		Group g = null;

		try( ObjectInputStream OIS = new ObjectInputStream( new FileInputStream( fileName ) ) ) {
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

	public int getNum() {
		return num;
	}

	public void saveToFile( File path ) {
		File f = new File( path, this.getName() + ".dump.txt" );

		try( PrintWriter pw = new PrintWriter( f ) ) {
			pw.println( "------- GROUP --------" );
			pw.println( this );

			pw.println( "------- INSTRUCTORS --------" );
			this.instructor.forEach( i -> pw.println( i ) );

			pw.println( "------- STUDENTS --------" );
			this.student.forEach( i -> pw.println( i ) );
		}
		catch( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String s = "Group [name=" + name + ", year=" + year + "]\n";

		for( Student i : this.student )
			s += i + "\n";

		for( Instructor i : this.instructor )
			s += i + "\n";

		return s;
	}

	@Override
	protected Group clone() {
		Group g = new Group( this.name, this.year, this.num );

		this.student.forEach( i -> g.student.add( i.clone() ) );
		this.instructor.forEach( i -> g.instructor.add( i.clone() ) );

		return g;
	}
}
