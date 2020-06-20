package github;

import java.util.Scanner;

class Sum_Of_Subset 
{
	static int arr[];
	static int count;
	

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices");
		int n=sc.nextInt();
		arr=new int[n];
		System.out.println("Enter elements");
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		System.out.println("Enter sum total");
		int total=sc.nextInt();
		Subset(total,n-1,new boolean[n]);
		if(count==0)
			System.out.println("No solution");
		sc.close();
	}
	
	static void Subset(int total,int index,boolean []solution)
	{
		if(total==0)
			print(solution);
		else if(total<0 || index<0)
			return;
		else
		{
			boolean []tempSolution=solution.clone();
			tempSolution[index]=false;
			Subset(total,index-1,tempSolution);
			tempSolution[index]=true;
			Subset(total-arr[index],index-1,tempSolution);
		}
	}
	
	static void print(boolean[]solution)
	{
		count+=1;
		System.out.println("Solution: ");
		for(int i=0;i<solution.length;i++)
		{
			if(solution[i])
				System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
