import java.util.PriorityQueue;
import java.util.Scanner;

public class Basic {
    public static void Int_MinPQ() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // By Default, Min Priority Queue

        for (int i = 10; i >= 1; i--) {
            pq.add(i * 10); // 100 90 80 70 60 50 40 30 20 10
        }

        while (pq.size() != 0) {
            System.out.println(pq.remove()); // lekin remove hote same 10 sabse phele aayega instead of 100 /// as By
                                             // Default min type priority Queue hoti h
        }
    }

    public static void Int_MaxPQ() {
        // here, a = this and b = other // isme hum other ke respect me this ki baat
        // karte h
        // this pe decision lenge other se respect se

        // this - other gives default behaviour
        // other - this gives reverse of default behaviour
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int i = 10; i >= 1; i--) {
            pq.add(i * 10);
        }

        while (pq.size() != 0) {
            System.out.println(pq.remove()); 
        }
    }

    public static class mobilePhone {
        String company = "";
        String model = "";
        int ram = 0;
        int storage = 0;
        int batteryBackup = 0;

        public mobilePhone(String company, String model, int ram, int storage, int batteryBackup) {
            this.company = company;
            this.model = model;
            this.ram = ram;
            this.storage = storage;
            this.batteryBackup = batteryBackup;
        }

        public mobilePhone() {

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Company: " + this.company + "\n");
            sb.append("Model: " + this.model + "\n");
            sb.append("ram: " + this.ram + "GB\n");
            sb.append("Storage: " + this.storage + "GB\n");
            sb.append("BatteryBackup: " + this.batteryBackup + "mAH\n\n");
            return sb.toString();
        }
    }

    // 2n(logn)
    public static void mobilePhoneDetails() {
        int n = sc.nextInt(); // Total number of input
        PriorityQueue<mobilePhone> pq = new PriorityQueue<>((a, b) -> {
            if (a.ram != b.ram)
                return b.ram - a.ram;
            else if (a.storage != b.storage)
                return b.storage - a.storage;
            else
                return b.batteryBackup - a.batteryBackup;
        });

        // nlog(n) -- n elements to be added and TC for adding 1 element is O(logn)
        for (int i = 0; i < n; i++) {
            pq.add(new mobilePhone(sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        // nlog(n)
        while (pq.size() != 0)
            System.out.println(pq.remove());
    }

    // sort 2d array on the basis of 1st index of 1d Array
    // TC :- 2nlog(n) + n*m
    public static void matrixPQ() {
        int[][] arr = { { 2, 6, 11, 3 }, { 8, 5, 16, 4 }, { 9, 7, 11, 13 }, { 8, 3, 12, 11 } };
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        // nlog(n)
        for (int[] a : arr)
            pq.add(a);

        // n(logn + m)
        while (pq.size() != 0) {
            int[] a = pq.remove(); // log(n)
            for (int ele : a)
                System.out.print(ele + " "); // O(m)
            System.out.println();
        }
    }

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Int_MinPQ();
        // Int_MaxPQ();
        // mobilePhoneDetails();
        matrixPQ();
    }
}
