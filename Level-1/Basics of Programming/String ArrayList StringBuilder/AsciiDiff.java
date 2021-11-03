import java.util.*;

public class AsciiDiff {
    public static String asciidiff(String str){
		int n = str.length();
		StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
		for(int i=1;i<n;i++){
            sb.append(str.charAt(i) - str.charAt(i-1));
            sb.append(str.charAt(i));
		}

		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(asciidiff(str));
		scn.close();
	}

}
