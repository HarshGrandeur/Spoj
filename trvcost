import java.util.Scanner;

class TRVCOST_Spoj
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int roads=sc.nextInt();
		int[][] cost=new int[501][501];
		for(int i=0;i<501;i++)
		{
			for(int j=0;j<501;j++)
				cost[i][j]=500000;
		}
		for(int i=0;i<501;i++)
			cost[i][i]=0;
		
		for(int i=0;i<roads;i++)
		{
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			if(c<cost[a][b])
			{
					cost[a][b]=c;
					cost[b][a]=c;
			}
			
		}
		int source=sc.nextInt();
		for(int k=0;k<501;k++)
		{
			for(int i=0;i<501;i++)
			{
				for(int j=0;j<501;j++)
				{
					if(cost[i][k]+cost[k][j]<cost[i][j])
						cost[i][j]=cost[i][k]+cost[k][j];
				}
			}
		}
		int Q=sc.nextInt();
		for(int i=0;i<Q;i++)
		{
			int test=sc.nextInt();
			int ans=cost[source][test];
			if(ans==500000)
				System.out.println("NO PATH");
			else if(source==test)
				System.out.println("0");
			else
			System.out.println(cost[source][test]);
		}
	}

}
