import java.util.Scanner;
import java.math.*;
public class Main{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		int c=s.nextInt();
		int n=s.nextInt();
		int[] wi=new int[n];
		int sum=0;
		int num=0;
		for(int i=0;i<n;i++){
			wi[i]=s.nextInt();
		}
		qs(wi,0,wi.length-1);
		for(int i=0;i<wi.length;i++){
			sum+=wi[i];
			if(sum>=c){
				if(sum==c){
					num=n;
				}else{
					num=i;
				}
				break;
			}
		}
		System.out.println(num);
	}
	public static void qs(int[] a,int low,int hight){
		int start=low;
		int end=hight;
		int key=a[low];
		while(start<end){
			while(start<end&&a[end]>=key){
				end--;
			}
			if(a[end]<key){
				int temp=a[end];
				a[end]=a[start];
				a[start]=temp;
			}
			while(a[start]<=key&&start<end){
				start++;
			}
			if(a[start]>key){
				int temp=a[start];
				a[start]=a[end];
				a[end]=temp;
			}
		}
		if(start>low){
			qs(a,low,start-1);
		}
		if(end<hight){
			qs(a,end+1,hight);
		}
	}
}