package ch01;

public class CharExam {

	public static void main(String[] args) {
		char c1 = 'A' + 1 ; // 65+1 -> charŸ������ �Ѿ�� ->B
		char c2 = 'A' ; // 65 -> charŸ������ c2�� ����
		//char c3 = c2 + 1 ; c2�� charŸ������ 1�� ���Ϸ��� �ߴµ� int�� ���
		char c3 = (char)(c2+1); 
		// char c4 = c2 + 1
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		
		System.out.println("-----------------------");
		int x = 1000000 ;
		int y = 1000000 ;
		int z = x * y ;
		System.out.println(z);
		
		long x1 = 1000000 ;
		long y1 = 1000000 ;
		long z1 = x1 * y1 ;
		System.out.println(z1);
		

	

	}

}
