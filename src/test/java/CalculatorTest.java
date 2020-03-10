
import org.junit.jupiter.api.BeforeAll;
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

    @BeforeEach
    public void init(){
        goodItemList = new ArrayList<>();
        goodItemList.add(GoodItem.getInstance("wine", GoodType.DRINK, 15, 1));
        goodItemList.add(GoodItem.getInstance("cola", GoodType.DRINK, 5, 2));
        goodItemList.add(GoodItem.getInstance("pork", GoodType.MEAT, 25, 2));
        goodItemList.add(GoodItem.getInstance("chicken", GoodType.MEAT, 10, 5));
        goodItemList.add(GoodItem.getInstance("light", GoodType.ELECTRONICS, 100, 1));
    }
    // TODO 如果将 商品类型当成接口
    // 两个纬度，一个是商品，一个是作用于商品项、总价的优惠券规则

    @Test
    public void should_normal_price(){

        Calculator calculator = new Calculator();
        double totalPrice = calculator.calculate(goodItemList);
        assertEquals(totalPrice, 225);
    }

}
