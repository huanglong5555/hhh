package sort;
/**
 * 归并排序
 * @author huanglong
 *
 */
public class MergerSort {
	private static void  merger(int[]arr,int start,int middle,int end){
		int index1=start,index2=middle+1,index=0;
		int[] temp=new int[end-start+1];
		while(index1<=middle&&index2<=end)temp[index++]=arr[index1]>arr[index2]?arr[index1++]:arr[index2++];//此处是给temp赋值而不是arr
		while(index1<=middle)temp[index++]=arr[index1++];
		while(index2<=end)temp[index++]=arr[index2++];
		System.arraycopy(temp, 0, arr, start, temp.length);
	}
	public static void mergerSort(int [] arr,int start ,int end){
		if(start>=end)return;
		int middle=(start+end)/2;
		mergerSort(arr, start, middle);
		mergerSort(arr, middle+1, end);
		merger(arr,start,middle,end);
	}
}
