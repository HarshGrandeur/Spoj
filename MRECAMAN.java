import java.util.*;

class MRECAMAN
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		HashMap<Integer,Long> hm=new HashMap<Integer,Long>();
		HashSet<Long> hs=new HashSet<Long>();
		hm.put(new Integer(0),new Long(0));
		hs.add(new Long(0));
		long temp=0;
		for(int i=1;i<=500009;i++)
		{
			temp=hm.get(i-1)-i;
			if(!hs.contains(temp) && temp>0)
			{
				hm.put(new Integer(i),new Long(temp));
				hs.add(new Long(temp));
			}
			else
			{
				temp=hm.get(i-1)+i;
				hm.put(new Integer(i),new Long(temp));
				hs.add(new Long(temp));

			}


		}
		int input=sc.nextInt();
		while(input!=-1)
		{
			System.out.println(hm.get(input));
			input=sc.nextInt();

		}



	}
}
