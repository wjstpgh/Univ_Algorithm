import java.util.Scanner;

public class Str_edit_main {
	public static void main(String[] args) {
		
		System.out.print("문자열 길이 입력: ");//문자열 길이 입력
		Scanner sc = new Scanner(System.in);
		int x_len = sc.nextInt();
		int y_len = sc.nextInt();
		sc.nextLine();
		System.out.print("X 문자열 입력: ");//각 문자열 입력
		String x = sc.nextLine();

		System.out.print("Y 문자열 입력: ");
		String y = sc.nextLine();
		
		sc.close();
		System.out.print("각 연산의 비용은 삽입(I)=1, 삭제(D)=1, 교체(C)=2 입니다.\r");
		
		
		Str_edit e = new Str_edit(x, y, x_len, y_len); // 문자열 편집 객체 생성
		e.str_editing(x_len+1, y_len+1); // 문자열 편집 시작
	}
}