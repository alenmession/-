public class Main{
	public static void main(String[] args){
		for(int d=2;d<9;d++){
			for(int b=2;b<9;b++){
				if(d==b)continue;
				for(int g=2;g<9;g++){
					if(b==g||d==g)continue;
					int c=b+1;
					if(c==9||c==b||c==d||c==g)continue;
					if(c+g<=10)continue;
					int sum=9000+b*100+c*10+d+1000+g*10+b;
					for(int i=2;i<9;i++){
						if(i==b||i==d||i==c||i==g)continue;
						if(sum==10000+c*100+b*10+i){
							System.out.println(" "+1+""+0+""+g+""+b);
						}
					}
				}
			}
		}
	}
}