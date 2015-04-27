package org.cources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;

public class Human implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	private String name, surname;
	private int age = 0;

	public Human( String name, String surname ) {
		this.name = name;
		this.surname = surname;
	}

	public Human( String name, String surname, int age ) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname( String surname ) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge( int age ) {
		this.age = age;
	}

	public void saveToFile( File path ) {
		File f = new File( path, this.getName() + ".dump.txt" );

		try( PrintWriter pw = new PrintWriter( f ) ) {
			pw.println( this );
			pw.close();
		}
		catch( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "name=" + name + ", surname=" + surname + ", age=" + age;
	}

	@Override
	public boolean equals( Object obj ) {
		if( this == obj ) return true;
		else if( obj == null ) return false;
		else if( this.getClass() != obj.getClass() ) return false;

		Human h = (Human)obj;
		return ( this.age == h.age && this.name == h.name && this.surname == h.surname );
	}
}
