
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020/3/11 12:26 上午
 */
public class CalculatorTest {

    private List<GoodItem> goodItemList;
    private Calculator calculator;

    @BeforeEach
    public void init() {

        goodItemList = new ArrayList<>();
        goodItemList.add(GoodItem.getInstance("wine", GoodType.DRINK, 15, 1));
        goodItemList.add(GoodItem.getInstance("cola", GoodType.DRINK, 5, 2));
        goodItemList.add(GoodItem.getInstance("pork", GoodType.MEAT, 25, 2));
        goodItemList.add(GoodItem.getInstance("chicken", GoodType.MEAT, 10, 5));
        goodItemList.add(GoodItem.getInstance("light", GoodType.ELECTRONICS, 100, 1));
        calculator = new Calculator(goodItemList);
    }
    // ? 商品类型当成接口
    // ? 三个纬度，一个是商品，一个是作用于商品项、总价的优惠券规则、可使用优惠券的规则
    // 组合？继承

    @Test
    public void should_normal_price() {
        double totalPrice = calculator.calculate();
        assertEquals(totalPrice, 225);
    }

    @Test
    public void should_return_80_percent_price() {
        double discount = 0.8;
        DiscountCalculator calculator = new DiscountCalculator(discount);
        CalculatorRule calculatorRule = new CalculatorRule(calculator, new TotalPermitRule());
        double totalPrice = this.calculator.calculateDiscount(calculatorRule);
        assertEquals(totalPrice, 225 * 0.8);
    }

    @Test
    public void should_return_full_reduction_price() {
        FullReductionCalculator fullReductionCalculator = new FullReductionCalculator(50,5,100,15);
        CalculatorRule calculatorRule = new CalculatorRule(fullReductionCalculator, new TotalPermitRule());
        double totalPrice = calculator.calculateDiscount(calculatorRule);
        assertEquals(totalPrice, 225 - 15);
    }

    @Test
    public void should_return_drink_80_percent_price(){
        double discount = 0.8;
        DiscountCalculator calculator = new DiscountCalculator(discount);
        TypePermitRule permitRule = new TypePermitRule(GoodType.DRINK);
        CalculatorRule calculatorRule = new CalculatorRule(calculator, permitRule);
        double totalPrice = this.calculator.calculateDiscount(calculatorRule);
        assertEquals(totalPrice, 225 - 5);
    }
}
