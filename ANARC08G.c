#include<stdio.h>

int main(void)
	{
     
		long long int n,i,j,testcase=1;
		long long int temp,temp1,answer;
		long long int ans[1005][3],arr[1005][1005];
		while(1)
		{
			
			scanf("%llu",&n);
			if(n==0)
				break;
        temp1=0;
		for(i=0;i<n;i++)
		{
			temp=0;
			for(j=0;j<n;j++)
			{
				scanf("%llu",&arr[i][j]);
				temp+=arr[i][j];
				
			}
			ans[i][0]=temp;
			temp1+=temp;
			
		}
		answer=0;
		
		for(i=0;i<n;i++)
		{
			temp=0;
			for(j=0;j<n;j++)
			{
				temp+=arr[j][i];
				
			}
			ans[i][1]=temp;
			ans[i][2]=ans[i][0]-ans[i][1];
			if(ans[i][2]>0)
				answer+=ans[i][2];
		}
		printf("%llu. %llu %llu\n",testcase,temp1,answer);
		testcase++;
		
		}


		
	}

