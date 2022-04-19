# 최적문자열 편집

각 연산의 비용에 따라 X문자열을 Y문자열로 편집할 시에 최적의 편집 순서열과 편집비용표를 출력하고 문자열이 적용되는 순서또한 출력한다.

### Program Code

* Main

```
importjava.util.Scanner;
publicclassStr_edit_main {
publicstaticvoidmain(String[] args) {
System.out.print("문자열 길이 입력: ");//문자열 길이 입력
Scannersc =newScanner(System.in);
intx_len =sc.nextInt();
inty_len =sc.nextInt();
sc.nextLine();
System.out.print("X 문자열 입력: ");//각 문자열 입력
Stringx =sc.nextLine();
System.out.print("Y 문자열 입력: ");
Stringy =sc.nextLine();
sc.close();
System.out.print("각 연산의 비용은 삽입(I)=1, 삭제(D)=1, 교체(C)=2 입니다.\r");
Str_edit e =newStr_edit(x, y, x_len, y_len); // 문자열 편집 객체 생성
e.str_editing(x_len+1, y_len+1); // 문자열 편집 시작
}
}
```

* 편집함수

```
importjava.util.ArrayList;
publicclassStr_edit {
ArrayList<Character>X =newArrayList<>(); 
ArrayList<Character>Y =newArrayList<>();
Stringgood_edit_result; // 최적의 편집 순서열
intID_cost=1; // 삽입,삭제 비용
intC_cost=2; // 교체 비용
publicStr_edit(Stringx, Stringy, intx_l, inty_l) {
X.add(null);
Y.add(null);
// 인덱스 0에 null 삽입
for(inti=0; i<x_l; i++)
X.add(x.charAt(i));
for(inti=0; i<y_l; i++)
Y.add(y.charAt(i));
//string to arraylist
good_edit_result ="";
// 편집 순서열을 빈 상태로 초기화
}
publicvoidstr_editing(intx_l, inty_l) {
// 삽입, 삭제, 교체 함수
Str_edit_cost c =newStr_edit_cost(x_l,y_l);
// cost 객체 생성
for(inti=0; i<x_l; i++) { // cost, edit 배열에 각각 값을 삽입
for(intj=0; j<y_l; j++) {
if(i==0&&j>0) { // 삽입 
c.putCost(i, j, c.getCost(i,j-1)+ID_cost); 
// cost 배열에 삽입 비용 삽입
c.putEdit(i, j, "I"); 
// edit 배열에 삽입 문자열 삽입
}
elseif(i>0&&j==0) { // 삭제
c.putCost(i, j, c.getCost(i-1, j)+ID_cost); 
// cost 배열에 삭제 비용 삽입
c.putEdit(i, j, "D"); 
// edit 배열에 삭제 문자열 삽입
}
elseif(i>0&&j>0) { 
// 삽입, 삭제, 교체 중 가장 작은 값
intic =c.getCost(i, j-1)+ID_cost;
intdc =c.getCost(i-1, j)+ID_cost;
intcc; 
// 삽입, 삭제, 교체 비용을 비교하기위해 3개의 변수 선언
if(X.get(i)==Y.get(j))
cc=c.getCost(i-1, j-1); 
// 교체할 문자가 서로 같다면 교체 비용이 0이다.
else
cc=c.getCost(i-1, j-1)+C_cost;
intmin =(ic >dc) ? dc : ic;
min =(min >cc) ? cc : min; 
// 3개의 비용 중 최소값
if(min ==ic) { // 최소값이 삽입 비용
c.putCost(i, j, ic);
c.putEdit(i, j, "I");
}
elseif(min ==dc) { // 최소값이 삭제 비용
c.putCost(i, j, dc);
c.putEdit(i, j, "D");
}
elseif(min ==cc) { // 최소값이 교체 비용
c.putCost(i, j, cc);
c.putEdit(i, j, "C");
}
}
}
}
c.showCost(); // c(i.j) 출력
good_edit_result =c.backTrackCost(good_edit_result); // 최적 편집 순서열 s_edit 초기화
ApplyString(); 
// 최적 편집 순서열과 입력문자열에 차례로 적용한 문자열 출력
}
publicvoidApplyString() {
// 최적 편집 순서열 출력, 입력문자열에 차례로 적용한 문자열 출력
char[] e =newchar[good_edit_result.length()]; 
// 역순으로 출력하기 위해 char 배열 e를 선언
for(inti =0; i<e.length; i++)
e[i] =good_edit_result.charAt(i);
// 배열 초기화
System.out.print("최적의 편집 순서열: ");
for(inti =e.length-1; i>=0; i--)
System.out.print(e[i]+" ");
System.out.println();
// 역순으로 출력
System.out.print("입력문자열에 차례로 적용하기: ");
inty=0; // X문자열에 추가된 Y문자열의 마지막 문자 인덱스
for(inti =e.length-1; i>=0; i--) {
if(e[i] =='I') { // 삽입일 경우
y++;
X.add(y,Y.get(y)); // X문자열에 Y[y]문자 추가
for(intt=1; t<X.size(); t++)
System.out.print(X.get(t));
System.out.print(" ");
// 출력
}
elseif(e[i] =='D') { // 삭제일 경우
X.remove(y+1); 
// Y[y]문자 다음에 있는 첫 번째 X문자 삭제
for(intt=1; t<X.size(); t++)
System.out.print(X.get(t));
System.out.print(" ");
} // 출력
elseif(e[i] =='C') { // 교체일 경우
y++;
if(X.get(y) ==Y.get(y)) { 
// 교체할 X, Y문자가 서로 같으면 변경 없이 출력
for(intt=1; t<X.size(); t++)
System.out.print(X.get(t));
System.out.print(" ");
}
else{ // 문자가 다르면 교체 후 출력
X.set(y, Y.get(y));
for(intt=1; t<X.size(); t++)
System.out.print(X.get(t));
System.out.print(" ");
}
}
}
System.out.println();
}
}
```

* 표 생성 함수

```
publicclassStr_edit_cost {
privateintcost[][]; // 비용 2차원 배열
privateStringedit[][]; // 편집 2차원 배열
publicStr_edit_cost(intx_len, inty_len) {
cost =newint[x_len][y_len];
edit =newString[x_len][y_len];
for(inti =0; i <x_len; i++)
for(intj =0; j <y_len; j++) {
cost[i][j]=0;
edit[i][j]=""; // 배열 초기화
}
}
publicvoidputCost(inti, intj, intcost) {
this.cost[i][j] =cost;
} // cost 값 삽입 함수
publicvoidputEdit(inti, intj, Stringedit) {
this.edit[i][j] =edit;
} // 편집 문자 삽입 함수
publicintgetCost(inti, intj) {
returncost[i][j];
} // 해당 위치 cost 값 출력 함수
publicStringgetEdit(inti, intj) {
returnedit[i][j];
} // 해당 위치 edit 값 출력 함수
publicvoidshowCost() {
System.out.println("c(i,j)표");
for(inti=0; i<cost.length; i++) {
for(intj=0; j<cost[i].length; j++)
System.out.print(cost[i][j] +" ");
System.out.println();
}
} // cost 표 출력 함수
publicStringbackTrackCost(Stringa) { 
// edit 배열을 역추적해서 최적 편집 순서열을 찾는 함수
inti =cost.length-1;
intj =cost[0].length-1;
// cost 배열의 마지막 인덱스 i, j
while(true) {
if(i==0&&j==0) // 역추적을 끝내면 종료
break;
else{
a +=edit[i][j]; // 최적의 편집에 해당하는 문자열 추가
if(edit[i][j]=="I")
j--;
elseif(edit[i][j]=="D")
i--;
else{
i--;
j--;
} // 편집 테이블을 이용해 최적 편집 순서열을 역추적
}
}
returna;
}
}
```

### Result

* Case 1

![image](https://user-images.githubusercontent.com/26988563/163969242-5486c470-95ce-4c76-82b8-672a8aa835c2.png)

* Case 2

![image](https://user-images.githubusercontent.com/26988563/163969288-16e82e5b-7957-4658-8bc1-793917ee6209.png)

* Case 3

![image](https://user-images.githubusercontent.com/26988563/163969337-348c3947-607b-4b79-ad57-350970d338f7.png)

* Case 4

![image](https://user-images.githubusercontent.com/26988563/163969376-5bc30102-e951-4c0b-9a7c-2117e36c99b3.png)

* Case 5

![image](https://user-images.githubusercontent.com/26988563/163969407-cec7361a-bfbf-4080-ad7e-97ffdf25cd70.png)

