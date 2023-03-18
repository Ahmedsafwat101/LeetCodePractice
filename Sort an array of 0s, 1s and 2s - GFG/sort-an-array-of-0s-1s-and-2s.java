//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        if(a == null || n == 0) return ;
        int[]freqMap = new int[3];
        for(int i =0;i<a.length;i++){
            freqMap[a[i]]++;
        }
        int iterator = 0;
         for(int i =0;i<a.length;i++){
            if(freqMap[0]>0){
                a[i] = 0;
                freqMap[0]--;
            }else if(freqMap[1]>0){
                a[i] = 1;
                freqMap[1]--;
            }else if(freqMap[2]>0){
                a[i] = 2;
                freqMap[2]--;
            }
        }
    }
    
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends