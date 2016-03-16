import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Ololo
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int a=0;
		for(int i=0;i<n;i++)
		{
			a=a^(Integer.parseInt(br.readLine()));
			
			
		}
		System.out.println(a);
		
	}
}
