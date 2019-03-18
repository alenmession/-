import java.util.*;
public class Main{
	public static void main(String args[]){
		int[] a=new int[]{3,5,4,8,2,0,9,12,-12,-5,6,-4};
		sort(a,0,a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	static void sort(int[] a,int low,int hight){
		int start=low;
		int end=hight;
		int key=a[low];
		while(start<end){
			while(start<end&&a[end]>=key){
				end--;
			}
			if(a[end]<=key){
				int temp=a[start];
				a[start]=a[end];
				a[end]=temp;
			}
			while(start<end&&a[start]<=key){
				start++;
			}
			if(a[start]>=key){
				int temp=a[end];
				a[end]=a[start];
				a[start]=temp;
			}
		}
		if(low<start){
			sort(a,low,start-1);
		}
		if(end<hight){
			sort(a,end+1,hight);
		}
	}
}