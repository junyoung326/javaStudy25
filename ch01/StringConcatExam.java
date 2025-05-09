package ch01;

public class StringConcatExam {

	public static void main(String[] args) {
		String str1 = "JDK" + 6.0 ;
		String str2 = str1 + " Ư¡" ;
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("--------------------------");
		String str3 = "JDK" + 3 + 3.0 ;
		String str4 = 3 + 3.0 + "JDk";
		System.out.println(str3);
		System.out.println(str4);
		String str5 = 3 + 3.0 + "JDk" + 2 + 2.0;
		System.out.println(str5);


	}

}
