package github;

import java.util.Scanner;
public class Greedy_knapsack
{
	double weight[];
	double benefit[]; 
	double ratio[];
	double W; 
	Greedy_knapsack()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of objects:");
		int nItems =scan.nextInt(); 
		weight=new double[nItems];
		benefit=new double[nItems];
		ratio=new double[nItems];
		System.out.println("Enter the object's weights");
		for(int i=0;i<nItems;++i) 
			weight[i]=scan.nextDouble();
		System.out.println("Enter the object's profits");
		for(int i=0;i<nItems;++i)
			benefit[i]=scan.nextDouble();
		for(int i=0;i<nItems;++i)
			ratio[i]=benefit[i]/weight[i];
		System.out.println("Enter the Capacity of the knapsack: ");
		W=scan.nextDouble(); 
		scan.close();
	}
	int getNext() 
	{
		double highest=0;
		int index=-1;
		for(int i=0;i<benefit.length;++i)
		{
			if(ratio[i]>highest)
			{
				highest=ratio[i]; 
				index=i;
			}
		}
		return index;
	}
	void fill()
	{
		double cW=0;
	    double cB=0;
	    System.out.print("\nObjects considered:");
	    while(cW<W)
	    {
	    	int item=getNext();
	    	if(item==-1)
	    		break;
	    	System.out.print((item+1)+" ");
	    	if(cW+weight[item]<=W)
	    	{
	    		cW+=weight[item];
	    		cB+=benefit[item]; 
	    		ratio[item]=0;
	    	}
	    	else
	    	{
	    		cB+=(ratio[item]*(W-cW));
	    		cW+=(W-cW);
	    		break; 
	    	}
	    }
	    System.out.println("\nThe Optimal Solution i.e. Max Benefit= "+cB);
	  }
	public static void main(String []args)
	{ 
		Greedy_knapsack fk=new Greedy_knapsack(); 
		fk.fill();
	}
}


