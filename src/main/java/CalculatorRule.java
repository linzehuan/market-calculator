/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020/3/11 7:27 上午
 */
public class CalculatorRule {

    private final ICalculator calculator;
    private final PermitRule permitRule;

    public CalculatorRule(ICalculator calculator, PermitRule permitRule) {

        this.calculator = calculator;
        this.permitRule = permitRule;
    }

    public double calculate(GoodItem goodItem){
        if (permitRule.isPermit(goodItem)) {
            return calculator.calculate(goodItem.getItemPrice());
        }
        return goodItem.getItemPrice();
    }
    public ICalculator getCalculator() {
        return calculator;
    }

    public PermitRule getPermitRule() {
        return permitRule;
    }
}
