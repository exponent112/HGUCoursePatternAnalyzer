package edu.handong.analysis;

import java.util.ArrayList;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Course> courses = new ArrayList<Course>();
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Student> initiateStudentArrayFromLines(String[] lines) {
		String[] temp;
		int j=0;
		ArrayList<Student> Sname = new ArrayList<Student>();
		 for(int i=0;i<lines.length;i++){
			temp = lines[i].split(", ");
			Student exit = new Student(temp[1]);
			if(j==0) {
				Sname.add(j,new Student(temp[1].trim()));
				j++;}
			while(studentExist(Sname,exit)){
				if(j>=numOfStudents) break;
				Sname.add(j,new Student(temp[1].trim()));
				j++;}
		 	}
		 return Sname;
		// TODO: implement this method	
		 }

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> students, Student student) {
		// TODO: implement this method
		for(int i=0;i<students.size();i++) {
			if(students.get(i)==null) break;
			else if(((students.get(i)).getName()).equals(student.getName())) return false;
		}
		return true;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines) {
		String[] temp;
		int j=0;
		ArrayList<Course> Sname = new ArrayList<Course>();
		 for(int i=0;i<lines.length;i++){
			temp = lines[i].split(", ");
			Course exit = new Course(temp[2]);
			if(j==0) {
				Sname.add(j,new Course(temp[2].trim()));
				j++;}
			while(courseExist(Sname,exit)){
				if(j>=numOfCourses) break;
				Sname.add(j,new Course(temp[2].trim()));
				j++;}
		 	}
		 return Sname;
		// TODO: implement this method	
		 }

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> courses, Course course) {
		for(int i=0;i<courses.size();i++) {
			if(courses.get(i)==null) break;
			else if(((courses.get(i)).getCourseName()).equals(course.getCourseName())) return false;
		}
		return true;
		// TODO: implement this method
	}

}
