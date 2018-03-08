package array;

public class RectangleArray {

	public static void main(String[] args) {
		int[][]arr=new int[][]{{1,2,3,4,5},{6,7,8,9,10},{3,5,6,6,7},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
		circlePrintRectangle(arr);
	}
	public static void circlePrintRectangle(int[][] arr){
		if(arr==null)return;
		int xLength=arr[0].length;
		int yLength=arr.length;
		int maxIndex=Math.min(xLength, yLength)/2;
		int x,y;
		for(int index=0;index<maxIndex;index++){
			for(x=index;x<xLength-index;x++)
				System.out.println(arr[index][x]);
			x--;
			for(y=index+1;y<yLength-index;y++)
				System.out.println(arr[y][x]);
			y--;
			for(--x;x>=index;x--)
				System.out.println(arr[y][x]);
			x++;
			for(--y;y>index;y--)
				System.out.println(arr[y][index]);
		}
		int xGap=xLength-maxIndex*2;
		int yGap=yLength-maxIndex*2;
		if(xGap==1)for(y=maxIndex;y<maxIndex+yGap;y++)System.out.println(arr[y][maxIndex]);
		if(yGap==1)for(x=maxIndex;x<maxIndex+xGap;x++)System.out.println(arr[maxIndex][x]);	
		
	}
}
