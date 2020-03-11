/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020/3/11 8:15 上午
 */
public class TypePermitRule implements PermitRule,IItemRule{

    private GoodType goodType;

    public TypePermitRule(GoodType goodType) {

        this.goodType = goodType;
    }
    @Override
    public boolean isPermit(GoodItem goodItem) {
        return goodItem.getType() == goodType;
    }
}
