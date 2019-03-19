import java.util.*;
public class Main{
	static String s;
	static int ans=0;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		s=sc.next();
		System.out.println(f(s));
	}
	public static int f(String s){
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<=s.length();j++){
				if(check(i,j)){
					ans=Math.max(ans,j-i);//比较各个子串取最大的子串长度
				}
			}
		}
		return ans;
	}
	public static boolean check(int i,int j){
		Set<Character> set=new HashSet<>();
		for(int k=i;k<j;k++){
			if(set.contains(s.charAt(k))){
				return false;
			}
			set.add(s.charAt(k));
		}
		return true;
	}
}