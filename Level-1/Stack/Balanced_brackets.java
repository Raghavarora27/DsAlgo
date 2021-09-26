import java.util.LinkedList;
import java.util.*;

public class Balanced_brackets {

    public static boolean Brackets(String str) {
        LinkedList<Character> st = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                st.addFirst(ch);
            else {
                if (ch == ')' || ch == ']' || ch == '}') {
                    if (st.size() == 0)
                        return false; // more closing brackets
                    else if (ch == ')' && st.getFirst() != '(')
                        return false;
                    else if (ch == ']' && st.getFirst() != '[')
                        return false;
                    else if (ch == '}' && st.getFirst() != '{')
                        return false;
                    else
                        st.removeFirst();
                } 
            }
        }
        return st.size() == 0; // more opening brackets
    }

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = sc.nextLine();

        System.out.println(Brackets(str));
    }

}
