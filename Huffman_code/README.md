# 허프만 코드, 최적합병트리

최적합병트리를 이용해 텍스트파일내의 문자열을 읽어 각 알파벳에 해당하는 허프만코드를 출력한다.

### Program Code

* Main - 파일입력 및 결과출력

```
importjava.io.File;
importjava.io.FileNotFoundException;
importjava.io.FileReader;
importjava.io.IOException;
publicclasshuffman_opt_merg {
publicstaticvoidmain(String[] args) {
Huffman huff =newHuffman();//허프만 객체 생성
try{
File test =newFile("C:\\Users\\admin\\Desktop\\4-1\\알고리즘\\과제3\\3.txt");
//파일객체 생성
FileReader file_reader =newFileReader(test);//파일 읽어들이기
intcur=0;//각 문자 저장변수
System.out.print("파일내용 : ");
while((cur =file_reader.read()) !=-1) {//문서의 끝까지 문자 읽기
System.out.print((char)cur);
huff.count(cur);//문자 빈도수 체크
}
file_reader.close();
}
catch(FileNotFoundException e) {
e.getStackTrace();
}
catch(IOException e) {
e.getStackTrace();
}//파일 입력 끝
System.out.println("\n"+"파일의 문자와 빈도수와 지정된 호프만 코드 : ");
huff.HuffmanTree();//최소히프에 문자와 빈도수를 저장 후 트리생성
int[]arr =newint[huff.num.size()-1];//트리 추적을 위한 배열
huff.showWord(huff.huffman, arr, 0);//허프만 코드 출력
}
}
```

* 허프만 클래스 - 문자 빈도수 저장 및 트리생성 및 허프만 코드 결정 클래스

```
importjava.util.HashMap;
publicclassHuffman {
publicHashMap<Character, Integer>num =newHashMap<Character, Integer>();
//문자와 빈도수를 저장하는 해시맵 생성
publicTreeNode huffman =null; // 허프만 트리 객체생성
publicvoidcount(ints) {
charc=(char)s;//캐릭터형변환
if(num.containsKey(c)) {//문자가 존재하면 값 카운트
num.put(c, num.get(c)+1);
}
else{//첫문자라면 key값을 생성하고 카운트
num.put(c, 1);
}
}
publicvoidHuffmanTree() {
Minheap h =newMinheap();
if(num.isEmpty())
return; // 없는 문자 null
for(chark : num.keySet())
h.put(newTreeNode(num.get(k), k));
// 최소 히프에 문자와 빈도수 저장
//빈도수에 따라 각 히프는 트리를 정렬 생성하게 됨
while(true) {
TreeNode leftchild =h.removeMin();
TreeNode rightchild =h.removeMin();
// 최소노드 2개를 삭제
huffman =newTreeNode(leftchild.num+rightchild.num,'.');
// 삭제한 최소노드 2개로 부모노드 생성 두번째 인자 '.'은 해당노드는 단말노드가 아닌
// 내부노드 이므로 count하지 않는 값인 '.'로 전달
huffman.leftNode =leftchild;
huffman.rightNode =rightchild;
// 부모노드의 왼쪽 오른쪽 자식에 최소노드 2개를 저장
if(h.isEmpty())
return; // 히프가 비어있으면 허프만트리 완성
h.put(huffman); // 최소 히프에 최소노드로 만든 부모노드를 다시 삽입
}// 해당작업 반복
}
publicvoidshowWord(TreeNode rt, int[] trace, intlastObj) {
// 허프만의 root를 받으면 각각 문자의 코드를 출력
// trace배열은 트리에서 단말노드를 추적하기 위한 배열. 원소는 단말노드의 코드집합이다.
if(rt.leftNode !=null) {// 왼쪽 자식을 탐색할 경우
trace[lastObj] =0; // 0을 저장
showWord(rt.leftNode, trace, lastObj +1);
// 해당 왼쪽자식에서부터 탐색 시작
}
if(rt.rightNode !=null) { // 오른쪽 자식을 탐색할 경우
trace[lastObj] =1; // 1을 저장
showWord(rt.rightNode, trace, lastObj +1);
// 해당 오른쪽자식에서부터 탐색 시작
}
if(rt.leftNode ==null&&rt.rightNode ==null) {
// 단말노드일 경우 해당 문자와 빈도수를 출력
System.out.print(rt.word +"의 빈도 수: "+rt.num +", 코드 : ");
printArr(trace, lastObj); // 해당 문자의 코드 출력
}
}
publicvoidprintArr(int[] arr, intlastObj) {
// 단말노드를 추적한 trace배열을 출력
for(inti=0; i<lastObj; i++)
System.out.print(arr[i]);
System.out.println("");
}
}
```

* 최소 히프클래스 - 트리노드생성 및 히프삭제 및 합병정렬 클래스

```
importjava.util.ArrayList;
importjava.util.Collections;
publicclassMinheap {
ArrayList<TreeNode>heap =newArrayList<TreeNode>();
//arraylist 자료구조를 이용해 heap
publicMinheap() {
heap.add(null); // 첫 번째 공간을 비운다
}
publicvoidput(TreeNode n) { // 삽입 함수
heap.add(n); // heap에 n 삽입
intchild =heap.size()-1;
// heap의 마지막 원소 위치
intcurrentNode =child/2;
// child의 부모 위치
while(currentNode >=1&&heap.get(child).num <heap.get(currentNode).num) {
Collections.swap(heap, child, currentNode);
// 빈도수를 기준으로 자식원소의 빈도수가 부모보다 작다면 swap
child =currentNode;
currentNode =child/2;
// 마지막 원소에서부터 루트까지
}
}
publicbooleanisEmpty() { // heap이 비어있다면 true
return(heap.size() <=1);
}
publicTreeNode removeMin() { // 히프의 삭제
if(isEmpty())
returnnull;
TreeNode minObj =heap.get(1); // 가장 작은 원소
intlastObj =heap.size()-1; // 히프의 마지막 원소의 위치
heap.set(1, heap.get(lastObj)); // 히프의 루트를 마지막원소로 대체
heap.remove(lastObj);
intcurrentNode =1;
intleftNode =currentNode*2;
intrightNode =currentNode*2+1;
// 루트부터 시작
while(leftNode <=heap.size()-1) {
// 왼쪽 자식이 존재하는 경우에만 실행한다.
inttmp;
if(rightNode >heap.size()-1) {
// 오른쪽 자식이 없는 경우
if(heap.get(leftNode).num >=heap.get(currentNode).num)
// 왼쪽 자식(빈도수)이 더 크거나 같다면 종료
break;
tmp =leftNode;
}
else{ // 왼쪽 자식 오른쪽 자식이 모두 있는 경우
if(heap.get(leftNode).num >=heap.get(currentNode).num &&heap.get(rightNode).num >=heap.get(currentNode).num)
// 두 자식 노드가 부모 노드보다 더 크거나 같다면 종료
break;
tmp =(heap.get(leftNode).num <heap.get(rightNode).num)
? leftNode : rightNode;
// 더 작은 노드로 변경한다.
}
Collections.swap(heap, tmp, currentNode);
// tmp와 currentNode의 위치에 있는 값을 swap
currentNode =tmp;
leftNode =currentNode*2;
rightNode =currentNode*2+1;
// tmp의 위치부터 다시 시작
}
returnminObj;
}
}
```

* 트리노드 클래스 - 트리노드의 구조체형식의 클래스

```
publicclassTreeNode { // 트리노드 객체
publicintnum; // 빈도 수 
publiccharword; // 문자
publicTreeNode leftNode;
publicTreeNode rightNode;
publicTreeNode(intnum, charword) {
this.num =num;
this.word =word;
leftNode =rightNode =null;
}
}
```

### Result
Alphabet frequency & Huffman code

* 첫 번째 문서

![image](https://user-images.githubusercontent.com/26988563/163967794-379088be-6f70-4f6e-9f82-4a3731f30ebe.png)

* 두 번째 문서

![image](https://user-images.githubusercontent.com/26988563/163967944-9ab425f7-c747-42ca-8998-a4a4f13557de.png)

* 세 번째 문서

![image](https://user-images.githubusercontent.com/26988563/163968078-aeb2b282-9755-4811-add1-851717bca73f.png)


