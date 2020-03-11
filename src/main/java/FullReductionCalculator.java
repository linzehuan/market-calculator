/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020/3/11 7:42 上午
 */
public class FullReductionCalculator implements ICalculator {


    private final double smallFullPrice;
    private final double smallReductionPrice;
    private final double bigFullPrice;
    private final double bigReductionPrice;

    public FullReductionCalculator(double smallFullPrice, double smallReductionPrice, double bigFullPrice, double bigReductionPrice){

        this.smallFullPrice = smallFullPrice;
        this.smallReductionPrice = smallReductionPrice;
        this.bigFullPrice = bigFullPrice;
        this.bigReductionPrice = bigReductionPrice;
    }
    @Override
    public double calculate(double price) {

        if(price >= bigFullPrice){
            return price - bigReductionPrice;
        }
        if (price >= smallFullPrice) {
            return price - smallReductionPrice;
        }
        return 0;
    }
}
