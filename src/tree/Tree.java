package tree;

public class Tree<T> {
	T value;
	Tree<T> left,right;
	public Tree(T value,Tree<T> left,Tree<T> right){
		this.value=value;
		this.left=left;
		this.right=right;
	}
}
