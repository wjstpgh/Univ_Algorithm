import java.util.Scanner;
import java.util.Arrays;
public class sort {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("n=");
		int n=sc.nextInt();//�Է¹��� �迭 ���� �Է�
		int list[]=new int[n];//�迭 ����
		
		System.out.println(n+"���� ���ڸ� �Է��ϼ���.");
		for(int i=0;i<list.length;i++) {//������ ���� �Է�
			list[i]=sc.nextInt();
		}
		
		for(int i=0;i<list.length;i++) {//���� �ݺ���
			for(int j=i+1;j<list.length;j++) {
				if(list[i]>list[j]) {
					int temp=list[i];
					list[i]=list[j];
					list[j]=temp;
				}
			}
		}
		System.out.print("�������� ���İ�� :"+Arrays.toString(list));//���ĵ� ��� ���
		 
	}
}