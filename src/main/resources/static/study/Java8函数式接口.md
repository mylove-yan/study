## java8函数式接口
资料来源
> https://www.sohu.com/a/123958799_465959
> https://www.jianshu.com/p/52cdc402fb5d

### 引言

目前由于系统已经全面切换为JDK8，所以有必要系统的了解一下Java8的一些新特性，以便后续在日常工作中可以使用一些高级特性来提高编程效率。

因为Java8引入了函数式接口，在java.util.function包含了几大类函数式接口声明。这里第一篇主要研究一下Function相关的接口。

### 什么是函数式接口

所谓的函数式接口，当然首先是一个接口，然后就是在这个接口里面只能有一个抽象方法。

这种类型的接口也称为SAM接口，即Single Abstract Method interfaces

### 特点

1. 接口有且仅有一个抽象方法
2. 允许定义静态方法
3. 允许定义默认方法
4. 允许java.lang.Object中的public方法
5. 该注解不是必须的，如果一个接口符合"函数式接口"定义，那么加不加该注解都没有影响。加上该注解能够更好地让编译器进行检查。如果编写的不是函数式接口，但是加上了@FunctionInterface，那么编译器会报错


### 函数式接口文档说明

>函数式接口：<br>一个加上注解 @FunctionalInterface 的接口，例如接口 Comparator 。
 这样的接口只有一个抽象方法（ 方法被 public abstract 修饰，或是默认没有任何修饰）。注解 @FunctionalInterface 是一个信息型（ informative annotation ）的注解，标示接口是一个函数式的接口，区别于普通的接口。
 需要注意的是，函数式接口中的默认方法，因为他们已经有了默认实现，所以他们并不计入抽象方法。关于默认方法，以后会讲，此处暂时不展开。
 另外，函数式接口所定义的抽象方法若是和顶级类 Object 定义的抽象方法一样，该方法不计入函数式接口的抽象方法。比如，函数式接口定义了这样一个方法，“ int hashCode(); ”，因为 Object 顶级类也定义这样一个抽象方法，“ public native int hashCode(); ”，所以抽象方法 hashCode 不计入函数式接口的抽象方法。
 这时你在思考，为何这样的抽象方法不计入呢？原因很简单。
 Java 语法规定，任何类都有一个默认的上级类，那就是顶级类 Object，并对顶级 Object 的抽象方法做了默认实现。在本例中，函数式接口的实现类也是一样，它也默认继承了顶级类 Object ,并顶级类 Object 的抽象方法 hashCode 做了默认实现，这相当于，对函数式接口中定义的 hashCode 也做了默认实现，函数式接口的实现类若是不想覆盖抽象方法 hashCode ，保持默认实现，在 Java 语法上讲，完全没有问题。
 正是因为这些抽象方法（函数式接口和顶级类 Object 都定义的抽象方法），在函数式接口的实现类中可以不覆盖，所有它们不计入函数式接口的抽象方法。只有全新定义的抽象方法能被计入函数式接口的抽象方法，而且只有唯一的一个。

### FunctionalInterface注解

Java8的新引入，包含函数式的设计，接口都有@FunctionalInterface的注解。就像这个注解的注释说明一样，它注解在接口层面，且注解的接口要有且仅有一个抽象方法。具体就是说，注解在Inteface上，且interface里只能有一个抽象方法，可以有default方法。因为从语义上来讲，一个函数式接口需要通过一个***逻辑上的***方法表达一个单一函数。那理解这个单一就很重要了，单一不是说限制你一个interface里只有一个抽象方法，单是多个方法的其他方法需要是继承自Object的public方法，或者你要想绕过，就自己实现default。函数式接口自己本身一定是只有一个抽象方法。同时，如果是Object类的public方法，也是不允许的。

怎么理解，看几个例子。比如：你声明一个接口：
```java
@FunctionalInterface
public interface Func{
}
```
这会编译错，编译器会告诉你*no target method*。而如果加一个方法：
```java
@FunctionalInterface
public interface Func{
    void run();
}
```
这就OK了，一个函数式接口声明好了。再加一个呢？
```java
@FunctionalInterface
public interface Func{
    void run();
    void foo();
}
```
不ok，明确说了只有一个抽象方法嘛。但是如果换一种函数签名：
```java
@FunctionalInterface
public interface Func{
    boolean equal(Object o);
    
}
```
错误依旧，因为这个方法签名是Object类的public方法。而再改一下：
```java
@FunctionalInterface
public interface Func{
    boolean equal(Object o);
    void run();
}
```
这就OK了。一个抽象方法，一个Object的public方法，相安无事。Object还有其他方法，clone方法试试会怎么样？
```java
@FunctionalInterface
public interface Func{
    boolean equal(Object o);
    void run();
    Object clone();
}
```
这又不行了，因为前面明确说了，要是Object的public方法，而clone是protected的。

所以总结一句话就是：

函数式接口，有且仅有一个抽象方法，Object的public方法除外。
 
一个较为完整的例子
```java
// 正确的函数式接口
@FunctionalInterface
public interface TestInterface {
 
    // 抽象方法
    public void sub();
 
    // java.lang.Object中的public方法
    public boolean equals(Object var1);
 
    // 默认方法
    public default void defaultMethod(){
    
    }
    // 静态方法
    public static void staticMethod(){
 
    }
}
```
因为Java本身支持多接口实现，你定义一个Class可以implements多个interface。所以这个限制也没什么影响，如果想约定一个函数式接口来统一，也可以做一些默认的实现来达到一个接口多个抽象方法的目的，比如下面这种做法：

一个普通接口NonFunc：
```java
public interface NonFunc {
    void run();
    void foo();
}
```
函数式接口Func：
```java
@FunctionalInterface
public interface Func extends NonFunc{
    void go();
    default void run();
    default void foo();
}
```
实现的测试类：
```java
public class Test implements Func{
    @Override
    void go(){
    
    };
    @Override
    void run(){
        
    };
    @Override
    void foo(){
    };
}
```
函数式接口的一大特性就是可以被lambda表达式和函数引用表达式代替。也就是说声明这样的接口，是可以灵活的以方法来传参。

另一个大的话题是针对上文的***逻辑上的方法***。所谓逻辑上，就是说当你出现函数式接口多重继承其他接口时，如果继承的多个接口有相同的方法签名，那么也是OK的。而这种相同签名的方法，也包括了泛型的情况，以下的声明中的Z接口，都是函数式接口。

```java
interface X {
    int m(Iterable<String> arg);
}

interface Y {
    int m(Iterable<String> arg);
}

interface Z extends X, Y {

}
```
但是要注意的是，这种泛型的支持，是因为函数式接口的官方声明规范里要求类型可替换和子签名，不是因为泛型擦除。

最后，Java8里关于函数式接口的包是java.util.function，里面全部是函数式接口。主要包含几大类：Function、Predicate、Supplier、Consumer和*Operator（没有Operator接口，只有类似BinaryOperator这样的接口）。后面依次展开详细说明一下。

### Function

```java
@FunctionalInterface
public interface Function<T, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t);
}
```
函数意为将参数T传递给一个函数，返回R。即$R=Function(T)$

其默认实现了3个default方法，分别是compose、andThen和identity，对应的函数表达为：compose对应$V=Function(ParamFunction(T))$，体现嵌套关系；andThen对应$V=ParamFunction(Function(T))$，转换了嵌套的顺序；还有identity对应了一个传递自身的函数调用对应$Function(T)=T$。从这里看出来，compose和andThen对于两个函数f和g来说，f.compose(g)等价于g.andThen(f)。
```java
public class TestFunction {
    public static void main(String[] args) {
        Function<Integer,Integer> incr1 = x->x+1;
        Function<Integer,Integer> multiply = x-> x*2;
        int x = 2;
        System.out.println("f(x)=x+1,when x="+x+",f(x)="+incr1.apply(x));
        System.out.println("f(x)=x+1,g(x)=2x,when x="+x+",f(g(x))="+incr1.compose(multiply).apply(x));
        System.out.println("f(x)=x+1,g(x)=2x,when x="+x+",g(f(x))="+incr1.andThen(multiply).apply(x));
    }
}
```