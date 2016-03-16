import java.util.*;
class SBank
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		while(testcase>0)
		{
			int n=sc.nextInt();
			StringBuilder[] s=new StringBuilder[n];
			for(int i=0;i<n;i++)
				s[i]=new StringBuilder("");
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<6;j++)
				{
					String ss=sc.next();
					s[i].append(ss);
				}
			}
			String[] str=new String[n];
			for(int i=0;i<n;i++)
				str[i]=new String(s[i].toString());
			Arrays.sort(str);
			/*
			for(int i=0;i<n;i++)
				System.out.println(str[i]);
			*/
			
			LinkedHashMap<String,Integer> m=new LinkedHashMap<String,Integer>();
			 for (String a : str) {
            Integer freq = m.get(a);
            m.put(a,(freq == null) ? 1 : freq + 1);
        }
		Set keys=m.keySet();
			Iterator itr=keys.iterator();
			while(itr.hasNext())
			{
				String key = (String) itr.next();
       Integer value =  m.get(key);
       System.out.println(key.substring(0,2)+" "+key.substring(2,10)+" "+key.substring(10,14)+" "+key.substring(14,18)+" "+
	   key.substring(18,22)+" "+key.substring(22,26)+" "+value);
			}
			
			testcase--;
		}
	}
}
