
public class Mergesort {
	
    private int a[], b[] ;
    private int aSize ;
    
    public Mergesort(int arr[], int n){  //생성자 함수, 정렬할 데이터를 배열 a 에 받음
    	a = arr;                              //임시 배열 b 를 동적으로 생성
    	aSize = n;
    	b = new int[aSize+1];
    }
    
    public int[] MergeSortCall() {  // MergeSort가 재귀함수 이므로, 처음 호출함
    	MergeSort(1, aSize);
    	return a ;
    }
    
    public void MergeSort(int low, int high)
    // a[low : high] is a global array to be sorted.
    // Small(P) is true if there is only one element to
    // sort. In this case the list is already sorted.
    {
        if (low < high) { // If there are more than one element
           // Divide P into subproblems.
             // Find where to split the set.
               int mid = (low + high)/2;
           // Solve the subproblems.
             MergeSort(low, mid);
             MergeSort(mid + 1, high);
           // Combine the solutions.
             Merge(low, mid, high);
        }
    }
    public void Merge(int low, int mid, int high)
    // a[low:high] is a global array containing two sorted
    // subsets in a[low:mid] and in a[mid+1:high]. The goal
    // is to merge these two sets into a single set residing
    // in a[low:high]. b[] is an auxiliary global array.
    {
        int h = low, i = low, j = mid+1, k;
        while ((h <= mid) && (j <= high)) {
           if (a[h] <= a[j]) { b[i] = a[h]; h++; }
           else { b[i] = a[j]; j++; } i++;
        }
        if (h > mid) for (k=j; k<=high; k++) {
                        b[i] = a[k]; i++;
                     }
        else for (k=h; k<=mid; k++) {
                b[i] = a[k]; i++;
             }
        for (k=low; k<=high; k++) a[k] = b[k];
    }


}
