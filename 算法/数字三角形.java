import java.math.*;
public class Main{
	//����������
	//�������������������Ѱ��һ���Ӷ������ױߵ�·����ʹ��·����������������֮�����
	//·���ϵ�ÿһ����ֻ�������»������ߡ�
	public static void main(String[] args){
		int[][] sw=new  int[][]{{5},{1,6},{9,4,0},{3,7,0,5},{2,5,3,8,5}};
		System.out.println(f(sw,0,0));

	}
	//�������������ö�ά������б���
	public static int f(int[][] a,int i,int j){
		int r=a.length;
		int c=a[0].length;
		int target=a[i][j];
		if(a.length==0)return 0;
		if(i==r-1)return target;
		return target+Math.max(f(a,i+1,j),f(a,i+1,j+1));
	}
}