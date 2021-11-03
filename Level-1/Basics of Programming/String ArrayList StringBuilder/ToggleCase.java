import java.util.*;

public class ToggleCase {

	public static String toggleCase(String str){
		int n = str.length();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
		    char ch = str.charAt(i);
		    if(ch >= 'a' && ch <= 'z')  sb.append((char) (ch - 'a' +'A'));
		    else    sb.append((char) (ch + 'a' -'A'));
		}

		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
		scn.close();
	}

}