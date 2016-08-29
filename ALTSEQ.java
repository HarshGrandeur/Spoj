// http://www.spoj.com/problems/ALTSEQ/
import java.util.*;
import java.lang.*;
import java.io.*;

class ALTSEQ
{
    private static Reader sc;
    private static PrintWriter out;
   
    static int lis(int arr[],int n)
    {
          int lis[] = new int[n];
          int i,j,max = 0;
 

           for ( i = 0; i < n; i++ )
              lis[i] = 1;


        for (i = n-2; i >= 0; i--)
        {


            for (j = i+1; j < n; j++)
            {

                if (((arr[i] < 0 && arr[j] > 0 && -arr[i] < arr[j]) || (arr[i] > 0 && arr[j] < 0 && arr[i] < -arr[j])) && lis[i] < lis[j] + 1)
                {
                    lis[i] = lis[j] + 1;
                   
                }
            }

        }

 
           for ( i = 0; i < n; i++ )
              if ( max < lis[i] )
                 max = lis[i];
 
            return max;
    }
 
    public static void main (String[] args) throws IOException
    {
        int arr[];
        
        sc = new Reader ();
        out = new PrintWriter (System.out, true);

        int n;

            n=sc.nextInt();
            arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();

            }

            System.out.println(lis(arr,n));
          


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
