package github;
import java.util.Scanner;
public class Prims_algorithm
{
	public static void main(String []args)
	{ 
		int n;
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter the number of vertices");
		n=sc.nextInt();
		int cA[][]=new int[n][n];
		int visited[]=new int[n]; 
		int unvisited[]=new int[n];
		System.out.println("Enter the cost adjacency matrix"); 
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++)
				cA[i][j]=sc.nextInt();
		System.out.println("Enter the source vertex");
		int sV=sc.nextInt();
		visited[sV-1]=1;
		for(int i=0;i<n;i++)
		{
			if(i!=sV-1)
				unvisited[i]=1; 
		}
		int index,minCost,source; index=minCost=source=0;
		System.out.println("Edgeset:");
		for(int i=1;i<n;i++)
		{
			int min=9999; 
			for(int j=0;j<n;j++)
			{
				if(visited[j]==1)
				{
					for(int k=0;k<n;k++)
					{
						if((unvisited[k]==1)&&(cA[j][k]!=9999))
						{
							if(min>cA[j][k])
							{
								min=cA[j][k]; source=j; index=k;
							}
						}
					}
				}
			}
			visited[index]=1;
			unvisited[index]=0; 
			System.out.print("("+(source+1)+","+(index+1)+")");
			minCost+=min;
		}
		System.out.println("\n The minimum cost of the spanning tree = "+minCost);
		sc.close();
	}
}
