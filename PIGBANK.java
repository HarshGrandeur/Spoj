import java.util.*;

class PiggyBank_Spoj
{
	public static void main(String[] args)
	{
		//System.out.println(Integer.MAX_VALUE);
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		while(testcase>0)
		{
			int E=sc.nextInt();
			int F=sc.nextInt();
			int coins=sc.nextInt();
			int coin[][]=new int[coins][2];
			for(int i=0;i<coins;i++)
			{
				coin[i][0]=sc.nextInt();
				coin[i][1]=sc.nextInt();
			}
			int t=F-E+1;
			/*
			int table[][]=new int[coins+1][F-E+1];
			int x=0,y=0;
			for (int i =0;i< coins+1; i++)
			{
				for (int j = 0; j <F-E+1; j++)
				{
					if(i==0 || j==0)
						table[i][j]=0;
					else if(coin[i-1][1]<=j && coin[i-1][0]+table[i][j-coin[i-1][1]]<F-E+1)
						table[i][j]=coin[i-1][0]+table[i][j-coin[i-1][1]];
					else
						table[i][j]=table[i-1][j];
						
		
				}
			}
			/*
			for(int i=0;i<coins+1;i++)
			{
				System.out.println();
				for(int j=0;j<F-E+1;j++)
					System.out.print(table[i][j]);
			}
			*/
			
			
			int[] table=new int[F-E+1];
			table[0]=0;
			for(int i=1;i<F-E+1;i++)
			table[i]=Integer.MAX_VALUE;
			
			for(int i=1;i<F-E+1;i++)
			{
				for(int j=0;j<coins;j++)
				{
					if(coin[j][1]<=i)
					{
						int sub_res=table[i-coin[j][1]];
						if(sub_res!=Integer.MAX_VALUE && sub_res+coin[j][0]<table[i])
							table[i]=sub_res+coin[j][0];
					}
				}
			}
			
			
			
			
			if(table[F-E]==Integer.MAX_VALUE)
				System.out.println("This is impossible.");
			else
			System.out.println("The minimum amount of money in the piggy-bank is "+table[F-E]+".");
			testcase--;
			
		}
		
	}
}
