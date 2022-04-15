
public class Quicksort {

	private	int a[];
    private int aSize ;
    
    public Quicksort(int arr[], int n){  //생성자 함수, 정렬할 데이터를 배열 a 에 받음
    	a = arr;                              //임시 배열 b 를 동적으로 생성
    	aSize = n;
		a[n+1] = Integer.MAX_VALUE ;          // a[n+1] is set to infinity.

     }
    
    public int[] QuickSortCall() {  // MergeSort가 재귀함수 이므로, 처음 호출함
    	QuickSort(1, aSize);
    	return a ;
    }
    	
	 void QuickSort(int p, int q)
	   // Sorts the elements a[p],..., a[q] which reside in
	   // the global array a[1:n] into ascending order; a[n+1]
	   // is considered to be defined and must be >= all the
	   // elements in a[1:n].
	   {
	       if (p < q) { // If there are more than one element
	          // divide P into two subproblems.
	            int j = Partition(a, p, q+1);
	              // j is the position of the
	              // partitioning element.
	          // Solve the subproblems.
	            QuickSort(p, j-1);
	            QuickSort(j+1,q);
	          // There is no need for combining solutions.
	       }
	   }
	 int Partition(int a[], int m, int p)
	   // Within a[m], a[m+1],..., a[p-1] the elements
	   // are rearranged in such a manner that if
	   // initially t==a[m], then after completion
	   // a[q]==t for some q between m and p-1, a[k]<=t
	   // for m<=k<q, and a[k]>=t for q<k<p. q is returned.
	   {
	       int mid = m+(p-m)/2;
	       if(a[m]>a[mid]) Interchange(a,m,mid);
	       if(a[mid]>a[p]) Interchange(a,mid,p);
	       if(a[m]>a[mid]) Interchange(a,m,mid);
	       int v=a[mid]; int i=m, j=p;
	       
	       do {
	              do i++;
	              while (a[i] < v);
	              do j--;
	              while (a[j] > v);
	              if (i < j) Interchange(a, i, j);
	          } while (i < j);
	          a[m] = a[j]; a[j] = v; return(j);
	   }
	 
	 void Interchange(int a[], int i, int j){
		 int temp = a[i];
		 a[i] = a[j];
		 a[j] = temp;
	 }


}
