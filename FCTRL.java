import java.util.*;
class Spoj_Fact
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		for(int i=0;i<testcase;i++)
		{
			long num=sc.nextLong();
			trailing_zeroes(num);
		}
		
	}
	static void trailing_zeroes(long num)
	{
		long ans=0;
		int b=5;
		long x=10;
		while(x>=5)
		{
			long temp=num;
			x=temp/b;
			ans+=x;
			b*=5;
			
		}
		System.out.println(ans);
		
	}
}
