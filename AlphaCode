import java.util.*;
import java.lang.*;

class AlphaCode_Spoj
{
	public static void main(String args[])
	{
			Scanner sc=new Scanner(System.in);
		String s=sc.next();
		
	
		while(!s.equals("0"))
		{
			
				int a=1;
		int b=1;
		int ans=1;
		for(int i=0;i<s.length();i++)
		{
			int x=Character.getNumericValue(s.charAt(i));
			if(i>0)
			{
				int c=Character.getNumericValue(s.charAt(i-1));
				int n=c*10+x;
				if(n>=10 && n<=26)
				{
					if(n==10 || n==20)
					{
						ans=b;
						b=a;
					a=ans;
						
					}
					else
					{
						ans=a+b;
					b=a;
					a=ans;
						
					}
					
					  
				}
				else
				{
					a=b=ans;
				}
			}
			
		}
		System.out.println(ans);
		s=sc.next();
		}
	}
}
