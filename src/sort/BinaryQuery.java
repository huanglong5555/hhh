package sort;

public class BinaryQuery {
	/**
	 * 递归方式
	 * @param arr
	 * @param start
	 * @param end
	 * @param value
	 * @return
	 */
	public static int query(int[] arr,int start,int end,int value) {
		int middle=(start+end)/2;
		if(arr[middle]==value)return middle;
		if(start==end)return -1;
		if(arr[middle]>value){
			return query(arr, start, middle-1, value);
		}else{
			return query(arr, middle+1, end, value);
		}
	}
	/**
	 * 循环方式
	 * @param arr
	 * @param des
	 * @return 
	 */
	public static int binaryQuery(int[]arr,int des){
		int low=0,high=arr.length-1;
		while(low<=high){
			int middle=(low+high)/2;
			if(arr[middle]==des)return middle;
			if(arr[middle]>des)high=middle-1;
			else low=middle+1;
		}
		return -1;
	}
}
