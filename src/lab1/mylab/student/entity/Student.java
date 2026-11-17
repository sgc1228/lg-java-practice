package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	private String studentId; // 학번
	private String name;      // 이름
	private String major;     // 전공
	private int grade;        // 학년 (1~4)

	public Student(String studentId, String name, String major, int grade) throws InvalidGradeException {
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		// 학년은 검사 규칙이 있는 setter를 통해 넣는다.
		setGrade(grade);
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) throws InvalidGradeException {
		// 학년은 1~4 까지만 허용
		if (grade < 1 || grade > 4) {
			throw new InvalidGradeException("학년은 1~4 사이의 값이어야 합니다.");
		}
		this.grade = grade;
	}

	@Override
	public String toString() {
		return name + " / " + major + " / " + grade + "학년";
	}
}
