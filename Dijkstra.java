package github;

import java.util.*;

public class Dijkstra
{
	static int infinity=999;
	public static void main(String args[]) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of vertices"); 
		int n=scan.nextInt(); 
		int adj[][]=new int[n+1][n+1]; 
		System.out.println("Enter the adjacency matrix (Let 999 represent the value infinity)");
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				adj[i][j]=scan.nextInt(); 
		 System.out.println("Enter the source vertex");
		 int src=scan.nextInt();
		 int dist[]=new int[n+1];
		 dijkstra_algo(n,adj,src,dist);
		 display(src,n,dist);
	}
	static void display(int src,int n,int dist[]) 
	{
		System.out.println("The shortest path from "+src+" to all other vertices is:"); 
		for(int i=1;i<=n;i++)
			System.out.println("Shortest distance from "+src+" to "+(i)+" is "+dist[i]); 
		return;
	}
	static void dijkstra_algo(int n,int adj[][],int src,int dist[])
	{
		int visited[]=new int[n+1];
		int min_dist,unvis=0; 
		for(int i=1;i<=n;i++)
		{ 
			dist[i]=adj[src][i];
			visited[i]=0;
		}
		visited[src]=1;
		for(int i=2;i<=n;i++) 
		{
			min_dist=infinity; 
			for(int j=1;j<=n;j++) 
			{
				if(visited[j]==0)
				{
					if(dist[j]<min_dist)
					{
						min_dist=dist[j];
						unvis=j;
					}
				}
			}
			visited[unvis]=1; 
			for(int v=1;v<=n;v++)
			{
				if(visited[v]==0) 
				{
					if((dist[unvis]+adj[unvis][v])<dist[v]) 
						dist[v]=dist[unvis]+adj[unvis][v];
				}
			}
		}
		return; 
		}
	}
