import java.util.Scanner;
import java.math.BigInteger;
class Main
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
        int testcase=sc.nextInt();
		while(testcase>0)
		{
			int n=sc.nextInt();
			BigInteger b=new BigInteger("1");
			for(int i=1;i<=n;i++)
			{
				b=b.multiply(new BigInteger(Integer.toString(i)));
			}
			System.out.println(b.toString());
			testcase--;
		}
		
	}
}
