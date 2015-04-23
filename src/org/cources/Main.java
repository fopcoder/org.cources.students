package org.cources;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main( String[] args ) {
		Student s1 = new Student( "vasya", "pupkin", 28, 11.5 );
		Student s2 = new Student( "петя", "порох", 30, 10.5 );
		Student s3 = new Student( "манька", "облигация", 18, 5.6 );
		Student s4 = new Student( "jonh", "doe", 70, 2.0 );
		Student s5 = s4.clone();

		Instructor l1 = new Instructor( "doctor", "lektor", 40, "PhD", "cannibal" );
		Instructor l2 = new Instructor( "ff", "preobrazhenski", 50, "PhD", "sharikov maker" );

		try {
			Group g1 = new Group( "KK01", 4, 4 );

			g1.addInstructor( l1 );
			g1.addInstructor( l2 );

			g1.addStudent( s1 );
			g1.addStudent( s1 );
			g1.addStudent( s3 );
			g1.addStudent( s4 );

			g1.delStudent( 2 );
			g1.addStudent( s2 );
			g1.addStudent( s5 );
			// g1.delInstructor(0);

			// System.out.println( "found: " + g1.findStudent( "vasya", "pupkin"
			// ) );
			// System.out.println( "found: " + g1.findStudent( "doe" ) );

			Group g2 = g1.clone();
			Group g3 = g1.clone();
			g2.setName( "RT94" );
			g3.setName( "FM52" );

			ArrayList<Student> s = g1.getStudents();

			Collections.sort( s, new AgeComparator() );
			// Collections.sort( s, new GradeComparator() );

			s.forEach( System.out::println );
			System.out.println();
			g1.getStudents().forEach( System.out::println );

			// System.out.println( s4.equals( s5 ) );

			String path = "c:\\temp";

			g1.serialize( path );
			g2.serialize( path );
			g3.serialize( path );

			File dir = new File( path );
			FilenameFilter textFilter = new FilenameFilter() {
				@Override
				public boolean accept( File dir, String name ) {
					String lowercaseName = name.toLowerCase();
					if( lowercaseName.endsWith( ".grp" ) ) {
						return true;
					}
					else {
						return false;
					}
				}
			};

			File[] files = dir.listFiles( textFilter );
			ArrayList<Group> aGroups = new ArrayList<Group>();
			for( File ff : files ) {
				System.out.println( ff.getAbsolutePath() );
				Group gg = Group.deserialize( ff.getAbsolutePath() );
				if( gg != null ) {
					aGroups.add( gg );
					System.out.println( gg );
				}
			}

		}
		catch( ArrayIndexOutOfBoundsException | NegativeArraySizeException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println( "end finish" );

	}
}
