package stdPrograms;

import java.util.Scanner;

 public class WarshallImp
{
	private int a[][],n;
	 WarshallImp() //constructor
	 {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter the number of vertices");
		 n=sc.nextInt();
		 a=new int[n][n];
		 System.out.println("Enter adjacency matrix");
		 for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j]=sc.nextInt();
		 sc.close();
	 }	
	 public void transitive_clousre()
	 {
		 int R[][]=new int[n][n]; //"R" is the final matrix that will have shortest distance between every pair of vertices
		 for(int i=0;i<n;i++)
			 for(int j=0;j<n;j++)
				 R[i][j]=a[i][j]; //Initialize solution matrix same as input matrix
				 
		 for(int k=0;k<n;k++)
			//{Pick all vertices as source one by one}
			 for(int i=0;i<n;i++)
				//{Pick all vertices as destination for the above picked source}
				 for(int j=0;j<n;j++)
					//{If vertex k is on the  path from i to j then update the value of R[i][j] to 1}
					 R[i][j]=(R[i][j]!=0) || ((R[i][k]!=0) && (R[k][j]!=0))?1:0;
		 printSolution(R,n);
	 }
	 void printSolution(int R[][],int n)
	 {
		 System.out.println("Transitive closure is:");
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
					System.out.print(R[i][j]+" "); //Print the solution matrix
				System.out.println();
			}	
	 }
	 
   public static void main(String[] args) 	
   {
		WarshallImp W=new WarshallImp(); //Object creation
		W.transitive_clousre();
   }
}
