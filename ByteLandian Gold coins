//This problem uses a combination of 
//topdown and bottom up approach in Dynamic programming
import java.util.Scanner;
class ByteLandian
{
	static long[] arr;
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		arr=new long[100000+1];
		//calculates the value of maximum dollar  for coin upto 100000 
		// for coin greater than 100000 it uses recursion
		for(int i=1;i<=100000;i++)
		{
			arr[i]=Math.max((arr[i/2]+arr[i/3]+arr[i/4]),i);
		}
		while(sc.hasNext())
		{
			int n=sc.nextInt();
			System.out.println(max_dollar(n));
		}
		
    }
		static long max_dollar(int n)
	{
		if(n<=100000)
			return arr[n];
		else
		return(max_dollar(n/2)+max_dollar(n/3)+max_dollar(n/4));
	}    
}
