//Author Harsh Gupta
import java.util.*;
import java.lang.*;
import java.io.*;
 
class GORELIAN
{

     int V;
     GORELIAN(int a)
     {
         V=a;
     }
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 

    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+dist[i]);
    }
 
  
    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V]; 
        Boolean sptSet[] = new Boolean[V];
 

        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        
        dist[src] = 0;
 
        for (int count = 0; count < V-1; count++)
        {
   
            int u = minDistance(dist, sptSet);
 
         
            sptSet[u] = true;
 
            for (int v = 0; v < V; v++)
 
               
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
 
 
        int ans=dist[dist.length-1];
        if(ans!=Integer.MAX_VALUE)
        System.out.println(ans+" blips");
       else
        System.out.println("Holiday");
    }
 


    public static void main (String[] args)
    {

   
        Scanner sc=new Scanner(System.in);
        while(true)
        {

        int row=sc.nextInt();
       
        int col=sc.nextInt();
        if(row==0)
            break;
        int xx=(row+1)*(col+1);
        int[][] g=new int[xx][xx];

        for(int i=0;i<col;i++)
        {
            int wt=sc.nextInt();
         
            String c=sc.next();
           
            if(c.equals("*"))
            {
                if(wt!=0)
                {
                       g[i][i+1]=2520/wt;
                g[i+1][i]=2520/wt;
                }
             
            }
            else if(c.equals(">"))
                g[i][i+1]=2520/wt;
            else if(c.equals("<"))
                g[i+1][i]=2520/wt;
         

        }
        int i=0;
        int j=col+1;
        for(int count=0;count<row;count++)
        {
            int temp=i;
            for(;i<(temp+col+1);i++)
            {
                int wt=sc.nextInt();
            String c=sc.next();
            if(c.equals("*"))
            {
                if(wt!=0)
                {
                    g[i][col+1+i]=2520/wt;
                    g[col+1+i][i]=2520/wt;
                }
                
            }
            else if(c.equals("v"))
                g[i][i+col+1]=2520/wt;
            else if(c.equals("^"))
                g[col+i+1][i]=2520/wt;
            }
              temp=j;


            for(;j<(temp+col);j++)
        {
             int wt=sc.nextInt();
             String c=sc.next();
            if(c.equals("*"))
            {
                if(wt!=0)
                {
                    g[j][j+1]=2520/wt;
                    g[j+1][j]=2520/wt;
                }
                
            }
            else if(c.equals(">"))
                g[j][j+1]=2520/wt;
            else if(c.equals("<"))
                g[j+1][j]=2520/wt;

        }
        j++;
       
       
        

        }

        

      
        GORELIAN t = new GORELIAN(xx);
       

        t.dijkstra(g, 0);
    }
    }
}
