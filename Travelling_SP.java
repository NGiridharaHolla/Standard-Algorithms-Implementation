package github;

import java.util.ArrayList;
import java.util.Scanner;

class Travelling_SP 
{
	static int [][] graph;
	static int n,src;
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of cities");
		n=sc.nextInt();
		graph=new int[n][n];
		System.out.println("Enter adjacency matrix");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				graph[i][j]=sc.nextInt();
		System.out.println("Enter soujrce city");
		src=sc.nextInt();
		ArrayList<Integer> set=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			if(i==src-1)
				continue;
			set.add(i);
		}
		int path[]=new int[n+1];
		int cost=tsp(src-1,set,path);
		System.out.println("Total cost:"+cost);
		path[0]=src-1;
		path[n]=src-1;
		System.out.print("Path: ");
		for(int i=n;i>=0;i--)
			System.out.println((path[i]+1)+" ");
		System.out.println();
	}
	
	static int tsp(int v,ArrayList<Integer> set, int[] path)
	{
		if(set.isEmpty())
		{
			return graph[v][src-1];
		}
		int size=set.size();
		ArrayList <Integer> subset;
		int minCost=Integer.MAX_VALUE;
		for(Integer i:set)
		{
			subset =new ArrayList <Integer>(set);
			subset.remove(i);
			int [] tempPath=new int[n+1];
			int cost=graph[v][i]+tsp(i,subset,tempPath);
			if(cost<minCost)
			{
				minCost=cost;
				tempPath[size]=i;
				copyCentralArray(path,tempPath,size);
			}
		}
		return minCost;
	}
	
	static void copyCentralArray(int []dist,int [] src,int size)
	{
		for(int i=1;i<=size;i++)
		{
			dist[i]=src[i];
		}
	}

}
