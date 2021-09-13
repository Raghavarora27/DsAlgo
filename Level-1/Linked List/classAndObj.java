public class classAndObj {
    public static class Phone {
        String brand;
        String color;
        String model;
        int ram;
        int battery;
        int storage;

        // Constructor
        // By default (behind the scene) constructor returns this / instance of class
        Phone(String brand, String color, String model, int ram, int battery, int storage) {
            this.brand = brand;
            this.battery = battery;
            this.ram = ram;
            this.storage = storage;
            this.color = color;
            this.model = model;
        }

        public String Display() {
            StringBuilder sb = new StringBuilder();
            sb.append("Brand: " + this.brand + "\n");
            sb.append("Model: " + this.model + "\n");
            sb.append("Color: " + this.color + "\n");
            sb.append("Ram: " + this.ram + "GB\n");
            sb.append("Storage: " + this.storage + "GB\n");
            sb.append("Battery: " + this.battery + "mAH\n");
            sb.append("\n");
            return sb.toString();
        }

        // whenever we try to print something using SYSO
        // then SYSO takes the printing value to toString() function then toString
        // functions prints this on the console...
        // @Override -- prevent mistakes
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Brand: " + this.brand + "\n");
            sb.append("Model: " + this.model + "\n");
            sb.append("Color: " + this.color + "\n");
            sb.append("Ram: " + this.ram + "GB\n");
            sb.append("Storage: " + this.storage + "GB\n");
            sb.append("Battery: " + this.battery + "mAH\n");
            sb.append("\n");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // Ph1 and ph2 are not interconnected with each other , they are making their
        // own instance of class in heap.
        // When we call ph1 then this becomes ph1 and print the details of ph1 and same
        // for ph2 as well
        Phone ph1 = new Phone("one Plus", "9r 5G", "Lake Blue", 8, 128, 4500);
        Phone ph2 = new Phone("one Plus", "9 Pro", "Lake Blue", 12, 256, 4500);

        System.out.println(ph1.ram);
        System.out.println(ph2);
    }
}