##idea安装 markdown
File->setting->plugins->搜索markdown，选择图中标识的进行install<br>
##关联markdown文件
![markdown文件关联](../images/markdown文件关联.png)
##markdown标题
标题是每篇文章都需要也是最常用的格式，在 Markdown 中，如果一段文字被定义为标题，只要在这段文字前加 # 号即可，markdown的标题可以自动换行，因此不需要加上br标签进行换行。<br>
# 一级标题
## 二级标题
### 三级标题
以此类推，总共六级标题，建议在井号后加一个空格，这是最标准的 Markdown 语法。
## markdown列表
文字前加上 - 或 * 即可变为无序列表，有序列表则直接在文字前加1. 2. 3. 符号要和文字之间加上一个字符的空格。Markdown 中的列表嵌套，通过在符号前增加空格来表示。同一级别下，前面的空格数目应该保持一致。<br>
* 首先
    - first
    - second
    - third
    - forth
* 其次
* 接下来
* 最后


<br>
1. 有序列表1
2. 有序列表2
3. 有序列表3 
4. 有序列表4
## markdown强调
*这是斜体*<br>
_这是斜体_<br>	
**这是粗体**<br>	
__这是粗体__<br>

## markdown引用
Markdown 中引用通过符号 '>' 来实现。'>' 符号后的空格，可有可无。如果要结束引用，需要一行空白行，来结束引用的区块。例如：
> 这是一段引用 
>> 引用套引用

引用结束了
## 图片与链接
图片与链接，在 Markdown 语法中表达类似，都是`[链接文字](链接地址)` 这样的形式。
* 图片为：`![]()`
* 链接为：`[]()`
## 表格
1. 表格第一行为标题，样式会被特殊处理
2. | 前后要留有空格
3. 只要是三个 - 字符表示分隔线
4. 通过 : 来区分，左对齐、居中、右对齐
```
| 1 | 2 | 3 |
| --- |:---:| ---:|
| aaa | bbbbbb | c |
| aaaaaa | b | ccc |
```
| 1 | 2 | 3 |
| :--- |:---:| ---:|
| aaa | bbbbbb | c |
| aaaaaa | b | ccc |
## 行内代码
如果要标记一小段行内代码，可以用反引号 ` 把它包起来 
## 区块代码
用三个反引号 ```，将代码块包起来。
在三个反引号后，加上语言说明，例如 ```java 这样，便指定了之后的代码采用 java 的高亮。
```java

    /**
     * 读取excel内容进行解析，返回客户信息
     *
     * @param file
     * @return
     * @throws SCMException
     */
    public List<DiscountUserInfo> readFile(MultipartFile file) throws SCMException {
        //todo 按行读取，校验里面客户编码，如果不符，throws SCMException
        checkCustomer("");
        List<DiscountUserInfo> userInfoList = Lists.newLinkedList();
        return userInfoList;
    }
```





