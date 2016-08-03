import java.util.*;

class PCPC12E
{
	private static class Node
	{
		int v;
		int dist;
	}
    public static void main(String[] args)
    {

    	Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int m=sc.nextInt();
            int n=sc.nextInt();
            int S=sc.nextInt();
            int L=sc.nextInt();
            int N=m*n;
            int[] board=new int[N];
            // set all the board cells to -1
            for(int i=0;i<N;i++)
                    board[i]=-1;
            // Input snakes
            for(int i=0;i<S;i++)
            {
                board[sc.nextInt()-1]=sc.nextInt()-1;
            }
            // Input ladders
            for(int i=0;i<L;i++)
            {
                board[sc.nextInt()-1]=sc.nextInt()-1;
            }
            // total numeber of cells
            
           int ans=getMin_moves(board,N);
           System.out.println(ans);
        }
    	

	}

    static int getMin_moves(int[] board,int N)
    {
    	boolean[] visited=new boolean[N];
    	for(int i=0;i<N;i++)
    	{
    		visited[i]=false;
    	}
    	Queue<Node> q=new LinkedList<Node>();
    	//visited[0]=true;
    	Node s=new Node();
    	s.v=-1;
    	s.dist=0;
    	q.add(s);
    	Iterator itr=q.iterator();  
    	Node qe=new Node();
    	qe.v=-1;
    	qe.dist=-1;
    	if(N==1)
    		return 1;
		while(itr.hasNext())
		{  
			qe = q.peek(); 
			int v = qe.v;
			if(v==N-1)
			{
				return qe.dist;			
			}
			q.poll();
			for(int j=v+1; j<=(v+6) && j<N; ++j)
        	{
            // If this cell is already visited, then ignore
            	if (!visited[j])
            	{
                // Otherwise calculate its distance and mark it
                // as visited
                	Node a=new Node();
                	a.dist = (qe.dist + 1);
                	visited[j] = true;
 
                // Check if there a snake or ladder at 'j'
                // then tail of snake or top of ladder
                // become the adjacent of 'i'
                	if (board[j] != -1)
                	{
                            /*
                		if(board[board[j]]!=-1)
                		{
                			int temp=board[board[j]];
                			while(temp!=-1)
                			{
                				temp=board[temp];

                			}
                			a.v=board[]
                		}
                		else
                    		a.v = board[j];
                    		*/
                    		int temp=board[j];
                    		while(board[temp]!=-1)
                    		{
                    			temp=board[temp];

                    		}
                    		a.v=temp;

                	}
               		else
                    	a.v = j;
                	q.add(a);
                	//System.out.println("v "+a.v);
            	}
        	}
			
		}  

    	return -1;
    }


}
