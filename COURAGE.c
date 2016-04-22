#include<stdio.h>

#include<stdlib.h>
#include<limits.h>
#define min(a,b) (a<b?a:b)
    struct node
    {
		long long int s,m;
    };

 struct node tree[1000000];
 long long int app[100001];

    long long int getMid(long long int s,long long int e) {
	return s + ((e - s) / 2);
    }

	struct node init(long long int ss,long long int se,long long int si)
	{
		struct node aa,bb;
		long long int mid;
		if(ss==se)
		{
			tree[si].s=tree[si].m=app[ss];
	    return tree[si];
		}
		mid=getMid(ss,se);
		aa=init(ss,mid,2*si+1);
		bb=init(mid+1,se,2*si+2);
		tree[si].s=aa.s+bb.s;
		tree[si].m=min(aa.m,bb.m);
		return tree[si];
	}
	
	struct node update(long long int ss,long long int se,long long int si,long long int diff,long long int i)
	{
				
		long long int mid;
		struct node aa,bb;
			
		
		//printf("Value of si %lld and si %lld\n",tree[si].s,si);
		if(ss==se)
		{
			
			//printf("MIN, SUM ini value of  %lld %lld\n ",tree[si].m,tree[si].s);
			tree[si].s=tree[si].s + diff;
			tree[si].m=tree[si].s;
			//printf("MIN final value of  %lld \n ",tree[si].m);
			//printf("MIN, SUM final value of  %lld %lld\n ",tree[si].m,tree[si].s);
			return tree[si];
			
		}
		
		mid=getMid(ss,se);
		if(i<=mid)
		{
			aa=update(ss,mid,2*si+1,diff,i);
			bb=tree[2*si+2];
		}
		else{
			aa=tree[2*si+1];
			bb=update(mid+1,se,2*si+2,diff,i);
			
		}
		//tree[si].s=aa.s+bb.s;
		tree[si].s=aa.s+bb.s;
		tree[si].m=min(aa.m,bb.m);
		return tree[si];
				
	}

	struct node query(long long int ss,long long int se,long long int qs,long long int qe,long long int si)
	{
		long long int mid;
		struct node aa,bb,cc;
		if (qs <= ss && qe >= se)
	    return tree[si];

		if(qs>se || qe<ss)
		{

			aa.s=0;
			aa.m = 9999999999999;
			return aa;

		}
		mid=getMid(ss,se);
		aa=query(ss,mid,qs,qe,2*si+1);
		bb=query(mid+1,se,qs,qe,2*si+2);
		cc.s=aa.s+bb.s;
		cc.m=min(aa.m,bb.m);
		return cc;
	}




	int main(void)
	{

		long long int n,p,x,y,i,s;	
		struct node hh;
	    char in[10];
		scanf("%lld",&n);
		for(i=0;i<n;i++)
			scanf("%lld",&app[i]);
		for(i=0;i<1000000;i++)
			tree[i].m=INT_MAX;
		
		//printf("%lld",tree[25].m);
		init(0,n-1,0);
		scanf("%lld",&p);
		while(p>0)
		{

			scanf("%s",in);
			scanf("%lld",&x);
			scanf("%lld",&y);
			if(in[0]=='E')
				update(0,n-1,0,-x,y);

			if(in[0]=='G')
				update(0,n-1,0,x,y);

			if(in[0]=='C')
			{
				hh=query(0,n-1,x,y,0);
				s=hh.s-hh.m;
				//printf("min %lld\n",hh.m);
				printf("%lld\n",s);
			}
			p--;

		}


	}

