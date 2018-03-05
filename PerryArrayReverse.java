/*PROGRAM: Lab2 Array Reverse
 * AUTHOR: Leah Perry
 * Class: CIS260 Algorithms and Data Structures
 * Due Date: March 27, 2016
 * SUMMARY: Demonstrates array reversal algorithms
 */

import java.io.IOException;

public class PerryArrayReverse {
	public static void main(String[]args) throws IOException {
		int[] array={1,2,3,4,5,6,7,8,9,10};
		long startTime;
		long endTime;
		long elapsed;
		System.out.println("Original array: ");
		PrintArray(array);
		
		startTime = System.nanoTime();
		array=MethodA(array);
		endTime = System.nanoTime();
		elapsed = endTime - startTime;
		System.out.printf("MethodA:\t%s nanoseconds\n", elapsed);
		PrintArray(array);
		
		startTime = System.nanoTime();
		array=MethodB(array);
		endTime = System.nanoTime();
		elapsed = endTime - startTime;
		System.out.printf("MethodB:\t%s nanoseconds\n", elapsed);
		PrintArray(array);
		
		startTime = System.nanoTime();
		MethodC(array,0,array.length-1);
		endTime = System.nanoTime();
		elapsed = endTime - startTime;
		System.out.printf("MethodC:\t%s nanoseconds\n", elapsed);
		PrintArray(array);
	}
	
	
	public static int[] MethodA(int[] a){
		int i = 0;
		int j = a.length-1;
		int k;
		while(i<j){
			k=a[i];
			a[i]=a[j];
			a[j]=k;
			i++;
			j--;
		}//end while
		return a;
	}//end MethodA
	
	public static int[] MethodB(int[] a){
		int[] b = new int[a.length];
		for(int j=a.length-1; j >= 0; j--){
			b[a.length-1-j] = a[j];
		}//end for
		return b;
	}//end methodB

	public static void MethodC(int[] a, int i, int j){
		int k;
		if(i==j){
			return;
		}//end if
		if(j-i==1){
			k=a[i];
			a[i]=a[j];
			a[j]=k;
			return;
		}
		k=a[i];
		a[i]=a[j];
		a[j]=k;
		MethodC(a , i+1, j-1);
	}//end MethodC

	public static void PrintArray(int[] a){
		for(int i=0; i<a.length-1; i++){
			System.out.print(a[i] + ", ");
		}//end for
		System.out.println(a[a.length-1]);
	}//end PrintArray
}//end PerryArrayReverse
