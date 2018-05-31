/**
 * 
 */
package com.learn.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MembersInLargeGroup {

	// Complete the membersInTheLargestGroups function below.
	static void membersInTheLargestGroups(int numberOfStudent, int numberOfRequests, int minGroupSize, int maxGroupSize,
			int minGradeOneSize, int minGradeTwoSize, int minGradeThreeSize) {
		Map<String, String> groupMap = new HashMap<>();
		for (int i = 0; i < numberOfStudent; i++) {
			String[] studentProfile = scanner.nextLine().split(" ");
			groupMap.put(studentProfile[0], studentProfile[1]);
		}

		List<RequestPair> requestPair = new ArrayList<>();
		for (int j = 0; j < numberOfRequests; j++) {
			String[] pairString = scanner.nextLine().split(" ");
			RequestPair req = new RequestPair(pairString[0], pairString[1]);
			requestPair.add(req);
		}

		TreeSet<String> resultMap = findMaxLengthSet(numberOfStudent, numberOfRequests, minGroupSize, maxGroupSize,
				minGradeOneSize, minGradeTwoSize, minGradeThreeSize, groupMap, requestPair);

	}

	private static TreeSet<String> findMaxLengthSet(int numberOfStudent, int numberOfRequests, int minGroupSize,
			int maxGroupSize, int minGradeOneSize, int minGradeTwoSize, int minGradeThreeSize,
			Map<String, String> groupMap, List<RequestPair> requestPairList) {
		
    	Map<String,StudentGroup> groupStudentMap = new HashMap<>();
		for(Entry<String, String> iteratorEntrySet:groupMap.entrySet()){
			String keyName= iteratorEntrySet.getKey();
			StudentGroup group = new StudentGroup(keyName, iteratorEntrySet.getValue());
			groupStudentMap.put(keyName, group);
		}
		for (RequestPair reqpair : requestPairList) {
			StudentGroup studentGroupNameOne = groupStudentMap.get(reqpair.studentOne);
			StudentGroup studentGroupNameTwo = groupStudentMap.get(reqpair.studentTwo);
			
			if(studentGroupNameOne.contains(studentGroupNameTwo)){
				continue;
			}
			else{
				StudentGroup groupThree =  new StudentGroup(studentGroupNameOne, studentGroupNameTwo);
				for(String student:groupThree.getStudents()){
					groupStudentMap.put(student, groupThree);
				}
			}
		
		}
    	
    	
    	
    	return null;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] nmabfst = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nmabfst[0]);

		int m = Integer.parseInt(nmabfst[1]);

		int a = Integer.parseInt(nmabfst[2]);

		int b = Integer.parseInt(nmabfst[3]);

		int f = Integer.parseInt(nmabfst[4]);

		int s = Integer.parseInt(nmabfst[5]);

		int t = Integer.parseInt(nmabfst[6]);

		membersInTheLargestGroups(n, m, a, b, f, s, t);

		scanner.close();
	}

}

class RequestPair {

	String studentOne;

	/**
	 * @return the studentOne
	 */
	public String getStudentOne() {
		return studentOne;
	}

	/**
	 * @param studentOne
	 *            the studentOne to set
	 */
	public void setStudentOne(String studentOne) {
		this.studentOne = studentOne;
	}

	/**
	 * @return the studentTwo
	 */
	public String getStudentTwo() {
		return studentTwo;
	}

	/**
	 * @param studentTwo
	 *            the studentTwo to set
	 */
	public void setStudentTwo(String studentTwo) {
		this.studentTwo = studentTwo;
	}

	String studentTwo;

	RequestPair(String studentOne, String studentTwo) {
		this.studentOne = studentOne;
		this.studentTwo = studentTwo;
	}

}

class StudentGroup {

	boolean contains(StudentGroup group){
		return this.contains(group);
	}
	/**
	 * @return the students
	 */
	public Set<String> getStudents() {
		return students;
	}

	/**
	 * @param students
	 *            the students to set
	 */
	public void setStudents(Set<String> students) {
		this.students = students;
	}

	/**
	 * @return the firstGrade
	 */
	public int getFirstGrade() {
		return firstGrade;
	}

	/**
	 * @param firstGrade
	 *            the firstGrade to set
	 */
	public void setFirstGrade(int firstGrade) {
		this.firstGrade = firstGrade;
	}

	/**
	 * @return the secondGrade
	 */
	public int getSecondGrade() {
		return secondGrade;
	}

	/**
	 * @param secondGrade
	 *            the secondGrade to set
	 */
	public void setSecondGrade(int secondGrade) {
		this.secondGrade = secondGrade;
	}

	/**
	 * @return the thirdGrade
	 */
	public int getThirdGrade() {
		return thirdGrade;
	}

	/**
	 * @param thirdGrade
	 *            the thirdGrade to set
	 */
	public void setThirdGrade(int thirdGrade) {
		this.thirdGrade = thirdGrade;
	}

	Set<String> students = new HashSet<>();
	int firstGrade = 0;
	int secondGrade = 0;
	int thirdGrade = 0;

	StudentGroup(String students, String grade) {
		this.students.add(students);
		switch (grade) {
		case "1":
			this.firstGrade++;
			break;
		case "2":
			this.secondGrade++;
			break;

		case "3":
			this.firstGrade++;
			break;
		}
	}

	StudentGroup(StudentGroup group1, StudentGroup group2) {
		this.students.addAll(group1.getStudents());
		this.students.addAll(group2.getStudents());
		this.firstGrade = group1.firstGrade + group2.firstGrade;
		this.secondGrade = group1.secondGrade + group2.secondGrade;
		this.thirdGrade = group1.thirdGrade + group2.thirdGrade;
	}

}
