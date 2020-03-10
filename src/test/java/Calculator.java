import java.util.List;

/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020/3/11 7:03 上午
 */
public class Calculator {
    public double calculate(List<GoodItem> goodItemList) {
        return goodItemList.stream().mapToDouble(GoodItem::getItemPrice).sum();
    }
}
