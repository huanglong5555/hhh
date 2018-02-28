package sort;

public class QuickSort {
	public static void sort(int[]arr,int begin,int end){
		
		if(begin>=end)return;
		int index1=begin,index2=end;
		while(index1<index2){
			while(index1<index2&&arr[index2]>=arr[index1]){
				index2--;
			}
			if(index1<index2){
			int temp=arr[index2];
			arr[index2]=arr[index1];
			arr[index1++]=temp;
			}
			while(index1<index2&&arr[index1]<=arr[index2]){
				index1++;
			}
			if(index1<index2){
			int temp=arr[index1];
			arr[index1]=arr[index2];
			arr[index2--]=temp;}
		}
		if(index1>begin)sort(arr,begin,index1-1);
		if(index2<end)sort(arr,index2+1,end);
		
	}
	public static void quickSort(int[]arr,int start,int end){
		if(start>=end)return;
		int low=start,high=end;
		while(low<high){
			while(low<high&&arr[low]<=arr[high])high--;
			if(low<high){
			int temp=arr[high];
			arr[high]=arr[low];
			arr[low]=temp;
			low++;}
			while(low<high&&arr[high]>=arr[low])low++;
			if(low<high){
				int temp=arr[high];
				arr[high]=arr[low];
				arr[low]=temp;
				high--;
			}
			
		}
		if(low>start)quickSort(arr,start,low-1);
		if(high<end)quickSort(arr,high+1,end);
	}
}
