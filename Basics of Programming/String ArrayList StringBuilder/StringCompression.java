import java.io.*;
import java.util.*;

public class StringCompression {

	public static String compression1(String str){
	    if(str.length() == 1)   return str;
		int n = str.length();
		int i = 1;
		String s = str.charAt(0) + "";
		
		while(i < n){
		    while(i < n && s.charAt(s.length()-1) == str.charAt(i)){
		        i++;
		    }
		    
		    if(i < n){
		        s += str.charAt(i);
		        i++;
		    }
		}
		return s;
	}
    
// aaaaaabbbbbcdeee
	public static String compression2(String str){
		if(str.length() == 1)   return str;
		int n = str.length();
		int i = 1;
		String s = str.charAt(0) + "";
		
		while(i < n){
		    int count = 1;
		    while(i < n && s.charAt(s.length()-1) == str.charAt(i)){
		        i++;
		        count++;
		    }
		    
		    if(count > 1)
		        s += count;
		    
		    if(i < n){
		        s += str.charAt(i);
		        i++;
		    }
		}
        return s;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}