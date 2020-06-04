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