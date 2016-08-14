class NIMGAME
{
	public static void main(String [] args)
	{
		int a, b, c;
		a = 2;
		b = 1;
		for (int i = 1; i < 16; i++)
		{

			System.out.println(a);
			c = b + a;
			b = a; a = c;
		}

	}
}
