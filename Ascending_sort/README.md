# 오름차순 정렬, 입출력

입력받은 배열을 오름차순으로 정렬해 출력하는 코드

* Code

```
import java.util.Scanner;
import java.util.Arrays;

public class sort {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("n=");
		int n=sc.nextInt();//입력받을 배열 갯수 입력
		int list[]=new int[n];//배열 선언
		
		System.out.println(n+"개의 숫자를 입력하세요.");
		for(int i=0;i<list.length;i++) {//정렬할 정수 입력
			list[i]=sc.nextInt();
		}
		
		for(int i=0;i<list.length;i++) {//정렬 반복문
			for(int j=i+1;j<list.length;j++) {
				if(list[i]>list[j]) {
					int temp=list[i];
					list[i]=list[j];
					list[j]=temp;
				}
			}
		}
		System.out.print("오름차순 정렬결과 :"+Arrays.toString(list));//정렬된 결과 출력
	}
}
```

* Result

![image](https://user-images.githubusercontent.com/26988563/163663503-b006ef0c-6f17-4878-80b1-80b6f7a3d68c.png)

![image](https://user-images.githubusercontent.com/26988563/163663505-ee64ae2b-d981-4208-b342-2bec209e0eeb.png)
