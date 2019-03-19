public class Main{
	static int[][] array=new int[8][8];
	static int num=0;
	public static void main(String[] args){
		f(0);
	}
	public static boolean check(int k,int j){
			for(int i=0;i<8;i++){
				if(array[i][j]==1){
					return false;
				}
			}
			for(int i=k-1,m=j-1;i>=0&&m>=0;i--,m--){
				if(array[i][m]==1){
					return false;
				}
			}
			for(int i=k-1,m=j+1;i>=0&&m<=7;i--,m++){
				if(array[i][m]==1){
					return false;
				}
			}
			return true;
	}
	public static void f(int i){
		if(i>7){
			num++;
			print();
			return;
		}
		for(int j=0;j<8;j++){
			if(check(i,j)){
				array[i][j]=1;
				f(i+1);
				array[i][j]=0;
			}
		}
	}
	public static void print(){
		System.out.println(num);
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(array[i][j]==1){
					System.out.print("o"+" ");
				}else{
					System.out.print("+"+" ");
				}
			}
			System.out.println();
		}
	}
}