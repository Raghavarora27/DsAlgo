public class classAndObj{
    public static class Phone{
        String brand;
        String color;
        String model;
        int ram;
        int battery;
        int storage;

        Phone(String brand,String color,String model,int ram,int battery,int storage){
            this.brand = brand;
            this.battery = battery;
            this.ram = ram;
            this.storage = storage;
            this.color = color;
            this.model = model;
        }
    }

    public static void main(String [] args){
        Phone ph1 = new Phone("one Plus", "9r 5G", "Lake Blue", 8, 128, 4500);
        Phone ph2 = new Phone("one Plus", "9 Pro", "Lake Blue", 12, 256, 4500);

        System.out.println(ph1.ram);
        System.out.println(ph2.model);
    }
}