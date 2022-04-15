
public class PerfComp {
	public static void main(String[] args) {
		int arrSize = 100000 ;    // 배열의 크기
		int arr[] = new int[arrSize+1];//합병정렬배열
		int arr1[] = new int[arrSize+2];//퀵정렬배열
		long start, end;
		float sum_result_m=0, sum_result_q=0;
		
		for(int i=1; i<= arrSize; i++) {
			arr[i] = (int)(java.lang.Math.random()*99999);  //테스트 데이터 생성
			arr1[i] = arr[i];
		}
		System.out.println("데이터셋의 크기가"+arrSize+"일때:");
		
		for(int i=1;i<=10;i++) {
			System.out.println(i+"번째 데이터셋 결과:");
			

			Mergesort m = new Mergesort(arr, arrSize) ;
			
			start = System.currentTimeMillis();
			arr = m.MergeSortCall();
			end = System.currentTimeMillis();
			System.out.println("합병정렬 걸린시간:" + (float)(end-start)/1000 +"초");
			sum_result_m = sum_result_m + (float)(end-start)/1000;
					
			Quicksort q = new Quicksort(arr1, arrSize) ;
			
			start = System.currentTimeMillis();
			arr1 = q.QuickSortCall();
			end = System.currentTimeMillis();
			System.out.println("퀵정렬 걸린시간:" + (float)(end-start)/1000 +"초");
			sum_result_q = sum_result_q + (float)(end-start)/1000;

		}
		System.out.println("합병정렬 걸린시간 평균:" + sum_result_m/10);
		System.out.println("퀵정렬 걸린시간 평균:" + sum_result_q/10);
	}

}
