/**
 * @author Lin Zehuan
 * @description
 * @email lzh@kapark.cn
 * @date 2020/3/11 7:35 上午
 */
public class TotalPermitRule implements PermitRule, ITotalRule {
    @Override
    public boolean isPermit(GoodItem goodItem) {
        return true;
    }
}
