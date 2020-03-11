/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020/3/11 12:20 上午
 */
public class GoodItem {

    private String name;

    private double price;

    private GoodType type;
    
    private int count;

    public static GoodItem getInstance(String name, GoodType type, double price, int count) {
        return new GoodItem(name, type, price, count);
    }

    public GoodItem(String name,GoodType type, double price, int count) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public GoodType getType() {
        return type;
    }

    public void setType(GoodType type) {
        this.type = type;
    }

    public  double getItemPrice() {
        return this.price * this.count;
    }
}
