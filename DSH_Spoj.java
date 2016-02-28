import java.util.*;
import java.io.*;
class DSH_Spoj
{
	public static void main(String[] args) throws IOException
	{
		Map<Character,Integer> m=new HashMap<Character,Integer>();
		m.put('a',16);
		m.put('b',17);
		m.put('c',18);
		m.put('d',19); m.put('e',20); m.put('f',21); m.put('g',22); m.put('h',23);
		m.put('i',24); m.put('j',25); m.put('k',26); m.put('l',27);m.put('m',28);
		m.put('n',20);m.put('o',21);m.put('p',22);m.put('q',23);m.put('r',24);m.put('s',25);
		m.put('t',26);m.put('u',18);m.put('v',19);m.put('w',20);m.put('x',21);m.put('y',22);m.put('z',23);
		
		Scanner sc=new Scanner(System.in);
		
		
		//BufferedReader br=new BufferedReader(new FileReader("in.txt"));
		//String s=br.readLine();
		//BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		//String s=sc.next();
		
		while(sc.hasNext())
		{
			String s=sc.next();
			int count=0;
			for(int i=0;i<s.length();i++)
			{
				System.out.print(m.get(s.charAt(i))+" ");
				
				if(m.get(s.charAt(i))>23)
					count++;
			}
			System.out.println();
			
			if(count==0)
				System.out.print("no one.");
			else
				System.out.print(count);
			System.out.println();			
			//s=sc.next();
			//s=br.readLine();
			//s=sc.next();
		}
		System.exit(0);
		
	}
}
