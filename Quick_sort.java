package github;

import java.util.Random;
import java.util.Scanner;

public class Quick_sort 
{

	static int[] a = new int[500000];
    static int n;
	private static Scanner s;

	public static void main(String[] args) 
	{
		Random r = new Random();
		s = new Scanner(System.in);
		System.out.println("Enter the number of elements:");
		n = s.nextInt();
		int i;
		System.out.println("1. Best Case\n2. Average Case\n3. Worst Case");
		int ch = s.nextInt();
		switch(ch) 
		{
		    case 1: for(i=0;i<n;i++)
			    a[i] = n - i;
		        break;
		    case 2: for(i=0;i<n;i++)
			    a[i] = r.nextInt(1000);
		        break;
		    case 3: for(i=0;i<n;i++)
			    a[i] = i;
		        break;
		}
		long start = System.nanoTime();
		quickSort(0,n-1);
		long end = System.nanoTime();
		System.out.println("the sorted array is");
		for(i=0;i<n;i++)
			System.out.println(a[i]);
		System.out.println("Time elapsed: " + (end - start));
	}

	public static void quickSort(int low, int high)
	{
		if(low<high)
		{
			int j = partition(low,high+1);
			quickSort(low,j-1);
			quickSort(j+1,high);
		}
	}

	public static int partition(int low, int high)
	{
		int pivot = a[low];
		int i = low;
		int j = high;
		do	{
			do	{
				i++;
			}while(a[i]<pivot && i<high);
			do	{
				j--;
			}while(a[j]>pivot && j>low);
			if(i<j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}	
		} while(i<j);
		a[low]=a[j];
		a[j]=pivot;
		return j;
	}
}
