import java.util.*;
import java.io.*;


class NUMDIV
{
    private static Reader sc;
    private static PrintWriter out;
    public static void main(String[] args) throws IOException
    {
      sc = new Reader ();
      out = new PrintWriter (System.out, true);
      //int testcase=sc.nextInt();
      boolean[] prime=new boolean[32005];
      prime[1]=true;
      ArrayList<Integer> al=new ArrayList<Integer>();
      //al.add(2);
      for(int i=2;i<=180;i+=2)
      {
          if(!prime[i])
          {

            int j=2*i;
            while(j<=32004)
            {
                prime[j]=true;
                //al.add(j);
                j+=i;
            }
          }


      }
      for(int i=2;i<=32004;i++)
      {
        if(!prime[i])
          al.add(i);

      }


      int a=sc.nextInt();
      int b=sc.nextInt();
      int n=sc.nextInt();
      int res=0;
      int temp=0;
      for(int i=a;i<=b;i++)
      {
          temp=i;
          int total=1;
          int k=0;
          for(int j=al.get(k);j*j<=temp;j=al.get(++k))
          {
              int count=0;
              while(temp%j==0)
              {
                  count++;
                  temp/=j;
              }
              total *=count+1;
          }
          if(temp!=1)
              total*=2;
          if(total==n)
              res++;
      }
      System.out.println(res);

    }


}





/** Faster input **/
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
        byte[] buf=new byte[1000000]; // line length
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
