## BigDecimal的用法详解
### BigDecimal有四种构造方法：
* BigDecimal(int)       创建一个具有参数所指定整数值的对象。
* BigDecimal(double) 创建一个具有参数所指定双精度值的对象。
* BigDecimal(long)    创建一个具有参数所指定长整数值的对象。
* BigDecimal(String) 创建一个具有参数所指定以字符串表示的数值的对象。
### 常用方法描述
* add(BigDecimal)        BigDecimal对象中的值相加，然后返回这个对象。
* subtract(BigDecimal) BigDecimal对象中的值相减，然后返回这个对象。
* multiply(BigDecimal)  BigDecimal对象中的值相乘，然后返回这个对象。
* divide(BigDecimal)     BigDecimal对象中的值相除，然后返回这个对象。
* toString()                将BigDecimal对象的数值转换成字符串。
* doubleValue()          将BigDecimal对象中的值以双精度数返回。
* floatValue()             将BigDecimal对象中的值以单精度数返回。
* longValue()             将BigDecimal对象中的值以长整数返回。
* intValue()               将BigDecimal对象中的值以整数返回。
## 格式化小数点
scale指的是你小数点后的位数。比如123.456则score就是3.
* BigDecimal.setScale()方法用于格式化小数点
* setScale(1)表示保留一位小数，默认用四舍五入方式 
* setScale(1,BigDecimal.ROUND_DOWN)直接删除多余的小数位，如2.35会变成2.3 
* setScale(1,BigDecimal.ROUND_UP)进位处理，2.35变成2.4 
* setScale(1,BigDecimal.ROUND_HALF_UP)四舍五入，2.35变成2.4
* setScaler(1,BigDecimal.ROUND_HALF_DOWN)四舍五入，2.35变成2.3，如果是5则向下舍
* setScaler(1,BigDecimal.ROUND_CEILING)接近正无穷大的舍入
* setScaler(1,BigDecimal.ROUND_FLOOR)接近负无穷大的舍入，数字>0和ROUND_UP作用一样，数字<0和ROUND_DOWN作用一样
* setScaler(1,BigDecimal.ROUND_HALF_EVEN)向最接近的数字舍入，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
