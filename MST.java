import java.util.*;

class MST
{
	int nodes,edges;
	int[] parent;
	Edge e[];
	MST(int n,int ed)
	{
		nodes=n;
		edges=ed;
		e=new Edge[ed];
		for(int i=0;i<edges;i++)
			e[i]=new Edge();
		
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ed=sc.nextInt();
		Main m=new Main(n,ed);
		for(int i=0;i<ed;i++)
		{
			m.e[i].src=sc.nextInt()-1;
			m.e[i].dest=sc.nextInt()-1;
			m.e[i].weight=sc.nextInt();
		}
		Arrays.sort(m.e);
		/*for(int i=0;i<ed;i++)
		{
			System.out.println(m.e[i].weight);
		}
		*/
		
		m.kruskalMain(m);

	}
	class Edge implements Comparable<Edge>
	{
		int src,dest,weight;
		
		public int compareTo(Edge e)
		{
			return this.weight - e.weight;
			
		}
	}
	
	public void kruskalMain(Main m)
	{
		long cost=0;
		parent=new int[nodes];
		for(int i=0;i<nodes;i++)
			parent[i]=i;
		int i=0;
		int t=0;
		while(i<nodes-1)
		{
			int x=find(m.e[t].src);
			int y=find(m.e[t].dest);
			
			if(x!=y)
			{
				union(x,y);
				
				cost+=m.e[t].weight;
				
				i++;
			}
			t++;
		}
		System.out.println(cost);
	}
	
	int find(int i)
	{
		while(parent[i]!=i)
			i=parent[i];
		return i;
	}
		void union(int x,int y)
	{
		int xroot=find(x);
		int yroot=find(y);
		
		parent[xroot]=yroot;

	}
	

}

