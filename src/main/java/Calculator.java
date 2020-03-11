import java.util.List;

/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020/3/11 7:03 上午
 */
public class Calculator {

    private List<GoodItem> goodItemList;

    public Calculator(List<GoodItem> goodItemList) {

        this.goodItemList = goodItemList;
    }

    public double calculate() {
        return this.goodItemList.stream().mapToDouble(GoodItem::getItemPrice).sum();
    }

    public double calculateDiscount(CalculatorRule calculatorRule) {
        if (calculatorRule.getPermitRule() instanceof ITotalRule) {
            return calculatorRule.getCalculator().calculate(calculate());
        }
        if (calculatorRule.getPermitRule() instanceof IItemRule) {
            return this.goodItemList.stream()
                    .mapToDouble(calculatorRule::calculate)
                    .sum();
        }
        return calculate();
    }
}
