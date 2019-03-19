import java.math.*;
public class Main{
	//问题描述：
	//在上面的数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。
	//路径上的每一步都只能往左下或右下走。
	public static void main(String[] args){
		int[][] sw=new  int[][]{{5},{1,6},{9,4,0},{3,7,0,5},{2,5,3,8,5}};
		System.out.println(f(sw,0,0));

	}
	//将数字三角形用二维数组进行保存
	public static int f(int[][] a,int i,int j){
		int r=a.length;
		int c=a[0].length;
		int target=a[i][j];
		if(a.length==0)return 0;
		if(i==r-1)return target;
		return target+Math.max(f(a,i+1,j),f(a,i+1,j+1));
	}
}