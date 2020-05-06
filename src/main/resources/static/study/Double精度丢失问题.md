## 问题描述
如下代码所示
```java
public class DoublePrecision {

    public static void main(String[] args) {
        double number1 = 1;
        double number2 = 20.2;
        double number3 = 300.03;
        double result = number1 + number2 + number3;
        System.out.println(result);
    }
}
```
结果：321.22999999999996<br>
在使用Java中double 进行运算时，经常出现精度丢失的问题，总是在一个正确的结果左右偏0.0000**1。float和double只能用来做科学计算或者是工程计算，在商业计算中我们要用 java.math.BigDecimal。
## 解决方法
在需要精确的表示两位小数时我们需要把他们转换为BigDecimal对象，然后再进行运算。另外需要注意，使用BigDecimal(double val)构造函数时仍会存在精度丢失问题，建议使用BigDecimal(String val)。这就需要先把double转换为字符串然后在作为BigDecimal(String val)构造函数的参数。转换为BigDecimal对象之后再进行加减乘除操作，这样精度就不会出现问题了。这也是为什么有关金钱数据存储都使用BigDecimal。<br>
代码详情参考：com\example\study\doublestudy\DoublePrecision.java
