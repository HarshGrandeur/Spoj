import java.util.Scanner;
import java.lang.Math.*;

class EDIST_Spoj
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		while(testcase>0)
		{
			String s1=sc.next();
			String s2=sc.next();
			int m=s1.length();
			int n=s2.length();
			
			int[][] arr=new int[m+1][n+1];
			
			for(int i=0;i<m;i++)
				arr[i][0]=i;
			
			for(int j=0;j<n;j++)
				arr[0][j]=j;
			
			for(int i=1;i<=m;i++)
			{
				for(int j=1;j<=n;j++)
				{
					if(s1.charAt(i-1)==s2.charAt(j-1))
						arr[i][j]=arr[i-1][j-1];
					
					else
					{
						arr[i][j]=1+Math.min(arr[i][j-1],Math.min(arr[i-1][j],arr[i-1][j-1]));
					}
				}
			}
			
			System.out.println(arr[m][n]);
			testcase--;

			
		}
		
		
		
	}
	
}
