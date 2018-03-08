package tree;

public class MianTest {

	public static void main(String[] args) {
		Tree<Integer> child1 = new Tree<Integer>(8, null, null);
		Tree<Integer> child2 = new Tree<Integer>(9, null, null);
		Tree<Integer> child3 = new Tree<Integer>(4, child1, child2);
		Tree<Integer> child4 = new Tree<Integer>(5, null, null);
		Tree<Integer> child5 = new Tree<Integer>(2, child3, child4);

		Tree<Integer> child6 = new Tree<Integer>(6, null, null);
		Tree<Integer> child7 = new Tree<Integer>(7, null, null);
		Tree<Integer> child8 = new Tree<Integer>(3, child6, child7);
		// Tree<Integer> child9 = new Tree<Integer>(11, null, null);
		// child1.left=child9;

		Tree<Integer> root = new Tree<Integer>(1, child5, child8);

		beforeTraversingTree(root);
		System.out.println(".............");
		centerTraversingTree(root);
		System.out.println(".............");
		AfterTraversingTree(root);

		Object[] result = IsBalanceTree(root);
		boolean isBalance = (boolean) result[0];
		int deep = (int) result[1];
		System.out.println(isBalance + "  " + deep);

	}

	/**
	 * 前序
	 * 
	 * @param root
	 */
	public static void beforeTraversingTree(Tree<Integer> root) {
		if (root == null)
			return;
		System.out.println(root.value);
		if (root.left != null)
			beforeTraversingTree(root.left);
		if (root.right != null)
			beforeTraversingTree(root.right);
	}

	/**
	 * 中序
	 * 
	 * @param root
	 */
	public static void centerTraversingTree(Tree<Integer> root) {
		if (root == null)
			return;
		if (root.left != null)
			beforeTraversingTree(root.left);
		System.out.println(root.value);
		if (root.right != null)
			beforeTraversingTree(root.right);
	}

	/**
	 * 后序
	 * 
	 * @param root
	 */
	public static void AfterTraversingTree(Tree<Integer> root) {
		if (root == null)
			return;
		if (root.left != null)
			beforeTraversingTree(root.left);
		if (root.right != null)
			beforeTraversingTree(root.right);
		System.out.println(root.value);
	}

	/**
	 * 是否平衡树
	 * 
	 * @param root
	 * @return
	 */
	public static boolean IsBalanceBinaryTree(Tree<Integer> root) {
		Object[] result = IsBalanceTree(root);
		return (boolean) result[0];
	}

	private static Object[] IsBalanceTree(Tree<Integer> root) {
		if (root == null)
			return new Object[] { true, 0 };

		Object[] left = IsBalanceTree(root.left);
		Object[] right = IsBalanceTree(root.right);
		boolean isleftBalance = (boolean) left[0];
		int leftDeep = (int) left[1];
		boolean isRightBalance = (boolean) right[0];
		int rightDeep = (int) right[1];
		if (isleftBalance && isRightBalance && (Math.abs(leftDeep - rightDeep) <= 1)) {
			return new Object[] { true, Math.max(leftDeep, rightDeep) + 1 };
		}
		return new Object[] { false, -1 };

	}

}
