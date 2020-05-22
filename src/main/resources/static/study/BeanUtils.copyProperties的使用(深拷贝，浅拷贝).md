## BeanUtils.copyProperties的使用(深拷贝，浅拷贝) 
> 文章原创地址 https://blog.csdn.net/enthan809882/article/details/104956537/ 

### 使用场景
开发中经常遇到，把父类的属性拷贝到子类中。通常有2种方法：
1. 一个一个set
2. 用BeanUtils.copyProperties

很显然BeanUtils更加方便，也美观很多。
那么任何情况都能使用BeanUtils么，当然不是。要先了解他。

### BeanUtils是深拷贝，还是浅拷贝?
是浅拷贝。<br>
浅拷贝： 只是调用子对象的set方法，并没有将所有属性拷贝。(也就是说，引用的一个内存地址)<br>
深拷贝： 将子对象的属性也拷贝过去。

### 什么情况适合用BeanUtils
如果都是单一的属性，那么不涉及到深拷贝的问题，适合用BeanUtils。
### 有子对象就一定不能用BeanUtils么
并不绝对，这个要区分考虑：
1. 子对象还要改动。
2. 子对象不怎么改动。

虽然有子对象，但是子对象并不怎么改动，那么用BeanUtils也是没问题的。

具体事例参考com.example.study.copy,三种情况都是为了说明BeanUtils.copyProperties使用的是浅拷贝