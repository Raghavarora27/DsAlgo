import java.io.*;
import java.util.*;

public class PrintAllPalindromeSubStrings {
    
    public static boolean ispalindrome(String str,int si,int ei){
        while(si < ei){
            if(str.charAt(si) != str.charAt(ei))
                return false;
            si++;
            ei--;
        }
        return true;
    }

	public static void printAllSubstring(String str){
		int n = str.length();
		for(int i=0;i<n;i++){
		    for(int j=i;j<n;j++){
		        if(ispalindrome(str,i,j)){
		            String s = str.substring(i,j+1);
		            System.out.println(s);
		        }
		    }
		}
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		printAllSubstring(str);
	}

}