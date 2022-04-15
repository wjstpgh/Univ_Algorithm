import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class huffman_opt_merg {
	public static void main(String[] args) {
		Huffman huff = new Huffman();//허프만 객체 생성
		
		try {
			File test = new File("C:\\Users\\admin\\Desktop\\4-1\\알고리즘\\과제3\\3.txt");
			//파일객체 생성
			FileReader file_reader = new FileReader(test);//파일 읽어들이기
			
			int cur=0;//각 문자 저장변수
			System.out.print("파일내용 : ");
			while((cur = file_reader.read()) != -1) {//문서의 끝까지 문자 읽기
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
		int []arr = new int[huff.num.size()-1];//트리 추적을 위한 배열
		huff.showWord(huff.huffman, arr, 0);//허프만 코드 출력
		
	}

}
