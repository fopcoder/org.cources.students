package org.students;

import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {

	@Override
	public int compare( Student h1, Student h2 ) {
		return h1.getGrade() > h2.getGrade() ? 1 : h1.getGrade() < h2
				.getGrade() ? -1 : 0;
	}

}
