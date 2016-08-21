import java.util.*;

class HASHIT
{
	static boolean[] flag;
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		while(testcase>0)
		{
			flag=new boolean[101];
			HashSet<String> hs=new HashSet<String>(); // to check insertion ofduplicte elements
			String[] hash=new String[101];
			int count=0;
			int n=sc.nextInt();
			for(int i=0;i<n;i++)
			{
				String s=sc.next();
				String temp=s.substring(0,3);
				int x=-1;
				//System.out.println(temp);
				String str=s.substring(4,s.length());
				if(temp.equals("ADD"))
				{
					if(str.length()<1)
						continue;
					if(!hs.contains(str))
						hs.add(str);
					else
						continue;
					x=HASH(str);
					count++;
					if(flag[x]==false)
					{
						hash[x]=str;
						flag[x]=true;
					}
					else
					{

						int ans=resolve_collisions(str);
						if(ans==-1)
						{
							count--;
							continue;
						}
						else
						{
							hash[ans]=str;
							flag[ans]=true;
						}

					}

				}
				else
				{
					if(!hs.contains(str))
						continue;
					hs.remove(str);


					count--;
					for(int j=0;j<101;j++)
					{
						if(flag[j]==true && hash[j].equals(str))
						{
							flag[j]=false;
						}
					}

				}
				



			}
			System.out.println(count);
			for(int i=0;i<101;i++)
			{
				if(flag[i]==true)
				{
					System.out.println(i+":"+hash[i]);
				}
			}
			testcase--;

		}
		//System.out.println(HASH("Polski"));


	}
	static public int HASH(String s)
	{
		int x=0;
		for(int i=0;i<s.length();i++)
		{
			x+=s.charAt(i)*(i+1);

		}
		return (19*x)%101;
	}
	static int resolve_collisions(String s)
	{
		int ans=-1;
		for(int j=1;j<20;j++)
		{
			int temp=(HASH(s)+j*j+23*j)%101;
			if(flag[temp]==false)
			{
				ans=temp;
				break;
			}
		}
		return ans;

	}
}
