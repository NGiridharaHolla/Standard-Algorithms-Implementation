package stdPrograms;

import java.util.Scanner;

class FloydImp 
{
	private int weight[][],n;
	FloydImp() //Constructor
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices");
		n=sc.nextInt();
		weight=new int[n][n];
		System.out.println("Enter weight of matrix: enter 9999 for infinity");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				weight[i][j]=sc.nextInt(); //Initialize weight matrix or solution matrix
		sc.close();
	}
	public void shortestPath()
	{
		for(int k=0;k<n;k++)
		//{Pick all vertices as source one by one}
			for(int i=0;i<n;i++) 
				//{Pick all vertices as destination for the above picked source}
				for(int j=0;j<n;j++)
					//{If vertex k is on the shortest path from i to j then update the value of weight[i][j]}
					weight[i][j]=Math.min(weight[i][j], weight[i][k]+weight[k][j]); //Finding the shortest path
		solutionMatrix(); //Call solution matrix to print the solution
	}
	public void solutionMatrix()
	{
		System.out.println("The distance matrix of shortest paths lenght is");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(weight[i][j]+" "); //Print the solution
			}
			System.out.println();
		}	
	}
	
    public static void main(String[] args)
	{
		FloydImp Fl=new FloydImp(); //Object craetion
		Fl.shortestPath();
	}
}
