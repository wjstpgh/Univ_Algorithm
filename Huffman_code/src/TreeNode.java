public class TreeNode { // 트리노드 객체
	
	public int num; // 빈도 수 
	public char word; // 문자
	public TreeNode leftNode;
	public TreeNode rightNode;
	
	public TreeNode(int num, char word) {
		this.num = num;
		this.word = word;
		leftNode = rightNode = null;
	}

}
