import java.util.*;
public class Main{
	public static void main(String args[]){
		int[] a=new int[]{3,5,4,8,2,0,9,0,-12,1,-6,-5,6,-4};
		sort(a,0,a.length-1);
		int result=search(a,1,a.length-1,0);
		System.out.println(result);
	}
	//快速排序算法
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
	//二分查找算法
	static int search(int[] a,int start,int end,int key){
		int mid=(start+end+1)/2;
		if(start>end){
			return -1;
		}
		if(a[mid]==key){
			return mid;
		}
		if(a[mid]>key){
			return search(a,start,mid-1,key);
		}
		if(a[mid]<key){
			return search(a,mid+1,end,key);
		}
		return mid;
	}
}