#include <stdio.h>
#define MAX(a,b) ((a) > (b) ? a : b)

int main(void) {
	// your code here
	int testcase,i,row,col,j,max;
	int dp[150][150];
	int arr[150][150];
	scanf("%d",&testcase);
	while(testcase>0)
	{
		scanf("%d",&row);
		scanf("%d",&col);
		for(i=0;i<row;i++)
		{
			for(j=0;j<col;j++)
			{
				scanf("%d",&arr[i][j]);
			}

		}
		for(i=0;i<col;i++)
			dp[0][i]=arr[0][i];

		for(i=1;i<row;i++)
		{
			for(j=0;j<col;j++)
			{
			if(j==0)
					{
						dp[i][j]=MAX((arr[i][j]+dp[i-1][j]),(arr[i][j]+dp[i-1][j+1]));
					}
					else if(j==col-1)
					{
						dp[i][j]=MAX((arr[i][j]+dp[i-1][j]),(arr[i][j]+dp[i-1][j-1]));

					}
					else{
						dp[i][j]=MAX((arr[i][j]+dp[i-1][j]),MAX((arr[i][j]+dp[i-1][j-1]),(arr[i][j]+dp[i-1][j+1])));
					}
			}
		}
		max=dp[row-1][0];
			for(i=1;i<col;i++)
			{
				if(dp[row-1][i]>max)
					max=dp[row-1][i];

			}
			printf("%d\n",max);
			testcase--;
	}


	return 0;
}
