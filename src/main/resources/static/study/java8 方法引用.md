## java8 方法引用
> https://blog.csdn.net/qq_41446768/article/details/87931438

### 方法的引用
方法的引用是用来直接访问类或者实例的已经存在的方法或者构造方法，方法引用提供了一种引用而不执行方法的方式，
如果抽象方法(函数式接口的抽象方法)的实现恰好可以使用另外一个方法来实现，就有可能使用方法引用。
### 方法引用的分类
| 类型 | 语法 | 对应的lambda表达式 |
| :---: |:---:| :---:|
| 静态方法引用 | 类名::staticMethod | (args) -> 类名.staticMethod(args) |
| 实例方法引用 | inst::instMethod | (args) -> inst.instMethod(args) |
| 对象方法引用 | 类名::instMethod | (inst,args)  ->类名.instMethod(args) |
| 构造方法引用 | 类名::new | (args) -> new 类名(args) |

### 分类概述
1. 静态方法引用<br>
如果函数式接口的实现恰好可以通过调用另一个静态方法实现，那么就可以使用静态方法引用
2. 实例方法引用<br>
如果函数式接口的实现恰好可以通过调用一个实例的实例方法来实现，那么就可以使用实例方法引用
3. 对象方法引用<br>
抽象方法的第一个参数类型刚好是实例方法的类型，抽象方法剩余的参数恰好可以当作实例方法的参数。
如果函数式接口的实现能由上面说的实例方法调用来实现的话，那么就可以使用对象方法
4. 构造方法引用<br>
如果函数式接口的实现恰好可以通过调用另一个类的构造方法来实现，那么就可以使用构造方法引用.

### 静态方法引用
具体事例 com.example.study.method.StaticExample
### 实例方法引用
具体事例 com.example.study.method.ExampleExample
### 对象方法引用
具体事例 com.example.study.method.ObjectExample
### 构造方法引用
具体事例 com.example.study.method.Example5
























