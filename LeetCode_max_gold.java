import java.util.*;
import java.lang.*;
import java.io.*;

class LeetCode_max_gold
{
    private static Reader sc;
    private static PrintWriter out;
    static int arr[][];


    static int n;
    static int m;

    



    public static void main (String[] args) throws IOException
    {


        sc = new Reader ();
        out = new PrintWriter (System.out, true);

        n = sc.nextInt();
        m = sc.nextInt();
        arr= new int[n][m];
        int[][] visited;
        for(int i =0;i < n; i++){
          for(int j=0; j<m; j++){
            arr[i][j]= sc.nextInt();
          }
        }

        int ans = 0;

        for(int i =0;i < n; i++){
          for(int j=0; j<m; j++){
            visited = new int[n][m];
              // System.out.println("node"+i+"---"+j+"---");
            ans = Math.max(ans, find_max_gold(0, i, j, visited));
          }
        }

        System.out.println(ans);

    }

    static int find_max_gold(int value, int i, int j, int visited[][]){


      if(!check_index(i , j, visited)){
        return value;
      }

      if(arr[i][j] == 0){
        return value;
      }


      value = value + arr[i][j];
      visited[i][j] = 1;

      

      int[][] visited1 = copy_arr(visited);
      int[][] visited2 = copy_arr(visited);
      int[][] visited3 = copy_arr(visited);
      int[][] visited4 = copy_arr(visited);
     


      int val1 = find_max_gold(value, i, j+1,visited1);


      int val2 = find_max_gold(value, i, j-1,visited2);


      int val3 = find_max_gold(value, i + 1, j,visited3);

      
      int val4 = find_max_gold(value, i - 1, j,visited4);



      return Math.max(Math.max(val1, val2), Math.max(val3, val4));


      // return Math.max(Math.max(find_max_gold(value, i, j+1,visited),
      // find_max_gold(value, i, j-1,visited)),
      // Math.max(find_max_gold(value, i + 1, j,visited),
      // find_max_gold(value, i-1, j,visited)));

    }

    static boolean check_index(int i, int j, int[][] visited){
      boolean check = (i < n && i>=0) && (j<m && j>=0) && (visited[i][j] == 0);

      return check;

    }

    static int[][] copy_arr(int[][] src){

    	int[][] arr = new int[n][m];

    	 for(int c =0;c < n; c++){
        for(int d=0; d<m; d++){
        	arr[c][d] = src[c][d];
          
        }
        
      }
      return arr;

    }

}





class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;
    public Reader(){
        din=new DataInputStream(System.in);
        buffer=new byte[BUFFER_SIZE];
        bufferPointer=bytesRead=0;
    }

    public Reader(String file_name) throws IOException{
        din=new DataInputStream(new FileInputStream(file_name));
        buffer=new byte[BUFFER_SIZE];
        bufferPointer=bytesRead=0;
    }

    public String readLine() throws IOException{
        byte[] buf=new byte[64]; // line length
        int cnt=0,c;
        while((c=read())!=-1){
            if(c=='\n')break;
            buf[cnt++]=(byte)c;
        }
        return new String(buf,0,cnt);
    }

    public int nextInt() throws IOException{
        int ret=0;byte c=read();
        while(c<=' ')c=read();
        boolean neg=(c=='-');
        if(neg)c=read();
        do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
        if(neg)return -ret;
        return ret;
    }

    public long nextLong() throws IOException{
        long ret=0;byte c=read();
        while(c<=' ')c=read();
        boolean neg=(c=='-');
        if(neg)c=read();
        do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
        if(neg)return -ret;
        return ret;
    }

    public double nextDouble() throws IOException{
        double ret=0,div=1;byte c=read();
        while(c<=' ')c=read();
        boolean neg=(c=='-');
        if(neg)c = read();
        do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
        if(c=='.')while((c=read())>='0'&&c<='9')
            ret+=(c-'0')/(div*=10);
        if(neg)return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException{
        bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);
        if(bytesRead==-1)buffer[0]=-1;
    }

    private byte read() throws IOException{
        if(bufferPointer==bytesRead)fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException{
        if(din==null) return;
        din.close();
    }
}
