public class Main{
	//题目要求：
	//给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
	public static void main(String[] args){
		int[][] sum=new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		System.out.println(search(100,sum));
	}
	static boolean search(int target,int[][] a){
		if(a==null||a.length==0||a[0].length==0){
			return false;
		}
		int r=0;
		int c=a[0].length-1;
		while(r<=a.length-1&&c>=0){
			if(target==a[r][c]){
				return true;
			}else if(target>a[r][c]){
				r++;
			}else{
				c--;
			}
		}
		return false;
	}
}