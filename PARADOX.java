import java.io.*;
import java.util.*;
class PARADOX
{
    private static Reader sc;
    private static PrintWriter out;
    public static void main(String[] args) throws IOException
    {

        sc = new Reader ();
        out = new PrintWriter (System.out, true);
        Scanner sc1=new Scanner(System.in);
        int testcase=sc1.nextInt();
        int n1=0;
        int n2=0;

        int temp1=20000;

        while(testcase!=0)
        {
            int[][] statements=new int[testcase+1][testcase+1];

            for(int i=1;i<=testcase;i++)
            for(int j=1;j<=testcase;j++)
                statements[i][j]=temp1;
            for(int i=1;i<=testcase;i++)
            {
                int x=sc1.nextInt();
                String in=sc1.next();
                //out.println(in+"*");
                if(in.equals("true"))
                {
                    statements[i][x]=2;
                    //out.println(in+"*");
                }
                else
                    statements[i][x]=1;


            }

            for(int i=1;i<=testcase;i++)
            for(int k=1;k<=testcase;k++)
            for(int j=1;j<=testcase;j++)
            {
                if(statements[k][j]>statements[k][i]+statements[i][j])
                {
                    statements[k][j]=statements[k][i]+statements[i][j];
                }

            }
            boolean ans=true;

            for(int i=1;i<=testcase;i++)
            {
                int temp=statements[i][i];
                //out.println(temp%2+"-");

                if(temp<10000 && temp%2==1  )
                  {
                    ans=false;
                    break;
                  }


            }
            if(!ans)
            {
              out.println("PARADOX");
            }
            else
                out.println("NOT PARADOX");

          testcase=sc1.nextInt();
        }
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
