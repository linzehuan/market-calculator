/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020/3/11 7:19 上午
 */
public class DiscountCalculator implements ICalculator {


    private double discount;

    public DiscountCalculator(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculate(double price) {
        return price * discount;
    }
}
