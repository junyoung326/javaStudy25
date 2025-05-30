package ch05.extended.school;

public class StudentExam {

	public static void main(String[] args) {
		Student stu1 = new Student("김기원", 180, 80, 50, "12345", 3, 4);
		Student stu2 = new Student("엠아이티", 210, 90, 45, "12346", 2, 5);
		
		stu1.show();
		stu2.show();

	}

}
