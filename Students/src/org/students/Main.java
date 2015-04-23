package org.students;

import java.util.Arrays;

public class Main {

	public static void main( String[] args ) {

		Student s1 = new Student( "vasya", "pupkin", 28, 11.5 );
		Student s2 = new Student( "петя", "порох", 30, 10.5 );
		Student s3 = new Student( "манька", "облигация", 18, 5.6 );
		Student s4 = new Student( "jonh", "doe", 70, 2.0 );

		Student s5 = s4.clone(); // 8800

		Instructor l1 = new Instructor( "doctor", "lektor", 40, "PhD",
				"cannibal" );
		Instructor l2 = new Instructor( "ff", "preobrazhenski", 50, "PhD",
				"sharikov maker" );

		try {
			Group g1 = new Group( "KK01", 4, 4 );

			g1.addInstructor( l1 );
			g1.addInstructor( l2 );

			g1.addStudent( s1 );
			g1.addStudent( s2 );
			g1.addStudent( s3 );
			g1.addStudent( s4 );

			// g1.delStudent(1);
			// g1.addStudent(s4);

			// g1.delInstructor(0);

			// System.out.println("found: " + g1.findStudent("vasya",
			// "pupkin"));
			// System.out.println("found: " + g1.findStudent("doe"));

			Student[] s = g1.getStudents();
			Arrays.stream( s ).forEach( System.out::println );
			System.out.println();
			// for( Student st : s )
			// System.out.println( st );
			Arrays.sort( s, new AgeComparator() );
			// for( Student st : s )
			// System.out.println( st );

			System.out.println( s4.equals( s5 ) );

			String path = "c:\\temp\\g1.txt";

			g1.serialize( path );

			Group g7 = Group.deserialize( path );

			// System.out.println( "==>\n" + g7 );

			Student[] ss = g7.getStudents();
			Arrays.sort( ss, new GradeComparator() );
			for( Student st : ss )
				System.out.println( st );

		}
		catch( ArrayIndexOutOfBoundsException | NegativeArraySizeException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println( "end" );

	}
}
