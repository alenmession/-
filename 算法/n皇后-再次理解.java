import java.math.*;
import java.util.*;
public class Main{
	static int[] x=new int[1000];//x[i]��ʾ�ʺ�����ڵ�i�е���x[i]��
	static int count=0;
	static int n=4;
	public static void main(String[] args){
		f(1);
		System.out.println(count);
	}
	public static boolean check(int t){//�жϻʺ��ܷ����ĳһλ��
		boolean flag=true;
		for(int i=1;i<t;i++){//�ж����ڷŵĻʺ����ѷ��õĻʺ��λ���Ƿ��ͻ
			if(x[t]==x[i]||t-i==Math.abs(x[t]-x[i])){//�ж��У��Խ��Ƿ��ͻ
				flag=false;
				break;
			}
		}
		return flag;
	}
	public static void f(int t){
		if(t>n){
			count++;
			System.out.print("�ʺ�λ�ã�");
			for(int k=1;k<=n;k++){
				System.out.print(x[k]+" ");
			}
			System.out.println();
		}else{
			for(int i=1;i<=n;i++){
				x[t]=i;//���ʺ���ڵ�i��
				if(check(t)){//���ʺ��λ���Ƿ�Ϸ�
					f(t+1);
				}
			}
		}
	}
}