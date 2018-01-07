#include <stdio.h>


int gcd(int a, int b)
{
    if (a == 0)
        return b;
    return gcd(b%a, a);
}


int main()
{
    int testcase, a,b,c;
   scanf("%d",&testcase);

    int s=1;
    while(testcase-->0)
    {
       scanf("%d",&a);
       scanf("%d",&b);
       scanf("%d",&c);

       int g=gcd(a,b);
       if(c%g ==0)
       {
         printf("Case %d: Yes\n", s);
       }
       else
       {
          printf("Case %d: No\n", s);

       }
       s++;
    }
    return 0;
}
