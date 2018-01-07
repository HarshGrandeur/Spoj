import java.util.*;
import java.io.*;

class BROKEN
{
  private static Reader sc;
  private static PrintWriter out;
  public static void main(String[] args) throws IOException
  {
    sc = new Reader ();
    out = new PrintWriter (System.out, true);
    //BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
    int num=sc.nextInt();
    //String ss="Hello ";
    //System.out.println((int)ss.charAt(5));
    while(num!=0)
    {
      int i=0;
      int j=1;
      String s=sc.readLine();  // input ther string
      HashMap<Character,Integer> map=new HashMap<Character,Integer>();

      int len=s.length();
      map.put(Character.valueOf(s.charAt(0)),Integer.valueOf("1"));
      int window=1;
      int sz=1;
      int max=1;
      Integer x=1;
      while(j<len)
      {
        sz=map.size();
        //System.out.println(sz);
        char ch=s.charAt(j);
        if(!map.containsKey(Character.valueOf(ch)) && sz>=num){
          //out.println("hye");
          //map.remove(Integer.valueOf((int)s.charAt(i)));
          //map.add(Integer.valueOf(ch));
          x=map.get(Character.valueOf(s.charAt(i)));
          //out.println(x+"i--"+i+"j-"+j);
          /*
          if(i==j)
          {
            j++;
            ch=s.charAt(j);
          }
          */


          if(x==1)
          {
            map.remove(Character.valueOf(s.charAt(i)));
            map.put(Character.valueOf(ch),Integer.valueOf("1"));
          }
          else
          {
            map.put(Character.valueOf(s.charAt(i)),x-1);
            //map.put(Character.valueOf(ch),Integer.valueOf("1"));
            j--;
          }
          j++;
          /*
          while(s.charAt(i)==(s.charAt(i+1)))
          {
            i++;
          }
          */
          i++;
        }
        else if(!map.containsKey(Character.valueOf(ch)))
        {
          //x=map.get(Character.valueOf(s.charAt(i)));
          map.put(Character.valueOf(ch),Integer.valueOf("1"));
          j++;

        }
        else
        {
          x=map.get(Character.valueOf(ch));
          map.put(Character.valueOf(ch),x+1);
          j++;
        }
      //  System.out.println(s.substring(i,j));
        if(j-i>max)
        max=j-i;

      }
      out.println(max);
      num=sc.nextInt();

    }
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
