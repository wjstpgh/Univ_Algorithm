# 합병정렬과 퀵정렬 성능측정

합병정렬과 퀵정렬을 코드를 짜고 데이터셋의 크기에 따라 런타임을 측정하여 성능을 비교한다.

* Code - Main

```
publicclassPerfComp {
publicstaticvoidmain(String[] args) {
intarrSize =100000; // 배열의 크기
intarr[] =newint[arrSize+1];//합병정렬배열
intarr1[] =newint[arrSize+2];//퀵정렬배열
longstart, end;
floatsum_result_m=0, sum_result_q=0;
for(inti=1; i<=arrSize; i++) {
arr[i] =(int)(java.lang.Math.random()*99999); //테스트 데이터 생성
arr1[i] =arr[i];
}
System.out.println("데이터셋의 크기가"+arrSize+"일때:");
for(inti=1;i<=10;i++) {
System.out.println(i+"번째 데이터셋 결과:");
Mergesort m =newMergesort(arr, arrSize) ;
start =System.currentTimeMillis();
arr =m.MergeSortCall();
end =System.currentTimeMillis();
System.out.println("합병정렬 걸린시간:"+(float)(end-start)/1000+"초");
sum_result_m =sum_result_m +(float)(end-start)/1000;
Quicksort q =newQuicksort(arr1, arrSize) ;
start =System.currentTimeMillis();
arr1 =q.QuickSortCall();
end =System.currentTimeMillis();
System.out.println("퀵정렬 걸린시간:"+(float)(end-start)/1000+"초");
sum_result_q =sum_result_q +(float)(end-start)/1000;
}
System.out.println("합병정렬 걸린시간 평균:"+sum_result_m/10);
System.out.println("퀵정렬 걸린시간 평균:"+sum_result_q/10);
}
}
```

* Code - Median Rule 

```
intmid =m+(p-m)/2;
if(a[m]>a[mid]) Interchange(a,m,mid);
if(a[mid]>a[p]) Interchange(a,mid,p);
if(a[m]>a[mid]) Interchange(a,m,mid);
intv=a[mid]; inti=m, j=p;
```

* Result

<html xmlns="http://www.w3.org/TR/REC-html40" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word"><head><!--[if !mso]>
<style>
v\:* {behavior:url(#default#vml);}
o\:* {behavior:url(#default#vml);}
w\:* {behavior:url(#default#vml);}
.shape {behavior:url(#default#vml);}
</style>
<![endif]
--><!--p.0
{mso-style-name:"바탕글";line-height:160%;margin-left:0pt;margin-right:0pt;text-indent:0pt;margin-top:0pt;margin-bottom:0pt;text-align:justify;word-break:break-hangul;layout-grid-mode:both;background:#ffffff;vertical-align:baseline;mso-pagination:none;text-autospace:none;mso-padding-alt:0pt 0pt 0pt 0pt;mso-ascii-font-family:맑은 고딕;mso-ascii-font-family:맑은 고딕;mso-font-width:100%;letter-spacing:0pt;mso-text-raise:0pt;font-size:10.0pt;color:#000000;mso-font-kerning:0pt;background:#ffffff;}
--></head><body><!--StartFragment-->

데이터 셋 | 1000 | 5000 | 10000 | 20000 | 50000 | 100000
-- | -- | -- | -- | -- | -- | --
합병정렬 | 0.002 | 0.009 | 0.0011 | 0.0015 | 0.0037 | 0.0048
퀵정렬 | 0.001 | 0.0011 | 0.0035 | 0.008 | 0.0114 | 0.012

<!--EndFragment--></body></html>

> 편의상 소수점 다섯 번째 자리수에서 버림하였습니다.

> 합병정렬 시간복잡도 : O(nlogn) + 보조기억장소

> 퀵정렬 시간복잡도 : (평균의 경우) O(nlogn) (최악의 경우) O(n2) + 중간값

데이터셋 1만개 전까지는 퀵정렬이 빠른 것을 확인 가능하고 1만개 이후부터는 합병정렬이 빠른 것을 확인 가능하다. 퀵정렬은 데이터셋이 늘어날수록 증가치가 큰 반면에 합병정렬은 데이터셋이 늘어나도 증가치가 작은 것으로 통해 

데이터셋이 클수록 합병정렬이 유리하고, 

데이터셋이 작다면 퀵정렬이 유리한 것을 유추가능하다.

* Capture

N=1000

![image](https://user-images.githubusercontent.com/26988563/163716779-bef4ff23-d3a7-42a7-8001-c8af30f26c19.png)

N=5000

![image](https://user-images.githubusercontent.com/26988563/163716788-39656e21-7a76-48c5-864f-9b14fe9b7851.png)

N=10000

![image](https://user-images.githubusercontent.com/26988563/163716800-ce654c77-f3a4-4a34-9164-0e064b90c107.png)

N=20000

![image](https://user-images.githubusercontent.com/26988563/163716812-9603924f-4408-4f2a-8862-3b35e4efb50e.png)

N=50000

![image](https://user-images.githubusercontent.com/26988563/163716820-7c69919e-79f1-40b1-9313-69897ab86d49.png)

N=100000

![image](https://user-images.githubusercontent.com/26988563/163716826-f2ed0f82-be73-439b-bc1c-bff51d6d4694.png)

