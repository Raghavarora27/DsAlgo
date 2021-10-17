import java.util.ArrayList;
import java.util.HashMap;

public class HM_Basics {
    public static void HashMapBasics() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 99);
        map.put("USA", 98); // O(1)
        map.put("China", 95); // update or set
        map.put("USA", 97); // remove duplicates but updates the value

        System.out.println(map.get("India")); // 99 // O(1)
        System.out.println(map.get("usa")); // null as key is not present

        // to overcome this use
        if (map.containsKey("usa")) // it search the key and return true or false
            System.out.println(map.get("usa"));

        map.remove("China"); // O(1)

        // Printing the keys using ArrayList
        // ArrayList<String> keys = new ArrayList<>(map.keySet());
        // System.out.println(keys);

        for (String key : map.keySet())
            System.out.println(key + " -> " + map.get(key));

        System.out.println(map);
    }

    public static void FrequencyMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // if(map.containsKey(ch)){
            //     map.put(ch, map.get(ch) + 1);
            // }
            // else{
            //     map.put(ch, 1);
            // }
            // Alternative of this if else
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        System.out.println(map);
    }
    
    public static void IndexOfCharacter(String str) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        
        // for (int i = 0; i < str.length(); i++) {
        //     char ch = str.charAt(i);
        //     if(!map.containsKey(ch))
        //         map.put(ch, new ArrayList<>());

        //     map.get(ch).add(i);
        // }
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>()); // if not present then it will add a new ArrayList
            map.get(ch).add(i);
        }

        for (char ch : map.keySet())
            System.out.println(ch + " -> " + map.get(ch));
    }

    public static void InsertionWithoutDuplicates(int [] arr1, int [] arr2){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int ele : arr1)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        
        for(int ele : arr2){
            if(map.containsKey(ele)){
                System.out.print(ele + " ");
                map.remove(ele);
            }
        }
    }
    
    public static void InsertionWithDuplicates(int [] arr1, int [] arr2){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int ele : arr1)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        
        for(int ele : arr2){
            if(map.containsKey(ele)){
                System.out.print(ele + " ");
                map.put(ele, map.get(ele)-1);
                if(map.get(ele) == 0)   map.remove(ele);
            }
        }
    }

    public static void highestfreq(String str){
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < str.length();i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0) + 1);
        }
        
        int MaxFreq = 0;
        char ans = '\u0000'; // represents null in character/String

        for(char ch : map.keySet()){
            if(map.get(ch) > MaxFreq){
                MaxFreq = map.get(ch);
                ans = ch;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        // int [] arr1 = {5,5,9,8,5,5,8,0,3};
        // int [] arr2 = {9,7,1,0,3,6,5,9,1,1,8,0,2,4,2,9,1,5};
        int [] arr1 = {1,1,2,2,2,3,5};
        int [] arr2 = {1,1,1,2,2,4,5};

        // HashMapBasics();
        // FrequencyMap("abaaabbcaddeff");
        // IndexOfCharacter("abaaabbcaddeff");
        InsertionWithDuplicates(arr1, arr2);
        // InsertionWithoutDuplicates(arr1, arr2);
    }
}