
public class Str_edit_cost {
	private int cost[][]; // 비용 2차원 배열
	private String edit[][]; // 편집 2차원 배열
	
	public Str_edit_cost(int x_len, int y_len) {
		cost = new int[x_len][y_len];
		edit = new String[x_len][y_len];
		
		for(int i = 0; i < x_len; i++)
			for(int j = 0; j < y_len; j++) {
				cost[i][j]=0;
				edit[i][j]=""; // 배열 초기화
			}
	}
	
	public void putCost(int i, int j, int cost) {
		this.cost[i][j] = cost;
	} // cost 값 삽입 함수
	
	public void putEdit(int i, int j, String edit) {
		this.edit[i][j] = edit;
	} // 편집 문자 삽입 함수
	
	public int getCost(int i, int j) {
		return cost[i][j];
	} // 해당 위치 cost 값 출력 함수
	
	public String getEdit(int i, int j) {
		return edit[i][j];
	} // 해당 위치 edit 값 출력 함수
	
	public void showCost() {
		System.out.println("c(i,j)표");
		for(int i=0; i<cost.length; i++) {
			for(int j=0; j<cost[i].length; j++)
				System.out.print(cost[i][j] + "    ");
			System.out.println();
		}
	} // cost 표 출력 함수
	public String backTrackCost(String a) { 
		// edit 배열을 역추적해서 최적 편집 순서열을 찾는 함수
		int i = cost.length-1;
		int j = cost[0].length-1;
		// cost 배열의 마지막 인덱스 i, j
		while(true) {
			if(i==0 && j==0) // 역추적을 끝내면 종료
				break;
			else {
				a += edit[i][j]; // 최적의 편집에 해당하는 문자열 추가
				if(edit[i][j]=="I")
					j--;
				else if(edit[i][j]=="D")
					i--;
				else {
					i--;
					j--;
				} // 편집 테이블을 이용해 최적 편집 순서열을 역추적
			}
		}
		return a;
	}
}
