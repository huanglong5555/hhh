package binary;

public class BinaryOperator {

	public static void main(String[] args) {
		System.out.println(add(1, 44));
		
		System.out.println(fbljArr(3));
		System.out.println(fbljArr(4));
		System.out.println(fbljArr(5));
	}

	public static int add(int a, int b) {
		int val1 = a ^ b;
		int val2 = a & b;
		val2 = val2 << 1;
		if (val2 == 0)
			return val1;
		return add(val1, val2);
	}

	public static int fbljArr(int n){
		int f1=1,f2=2;
		if(n==1)return f1;
		if(n==2)return f2;
		
		for(int i=3;i<=n;i++){
			f2=f1+f2;
			f1=f2-f1;
		}
		return f2;
	}
}
