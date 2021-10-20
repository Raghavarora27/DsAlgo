public class client {

    public static void test() {
        HashMap map = new HashMap();
        map.put(100, 1);
        map.put(200, 2);
        map.put(300, 3);
        map.put(400, 4);

        // map.putIfAbsent(100, 5);
        // map.remove(200);
        // System.out.println(map.containsKey(200));
        // System.out.println(map.get(400));
        // System.out.println(map.size());

        System.out.println(map);
    }

    public static void main(String[] args) {
        test();
    }
}
