## maven 学习
### 约定配置
| 目录 | 目的 |
| --- | ---|
| ${basedir}	                     | 存放pom.xml和所有的子目录  |                                      
| ${basedir}/src/main/java	         | 项目的java源代码 |
| ${basedir}/src/main/resources	     | 项目的资源，比如说property文件，springmvc.xml |
| ${basedir}/src/test/java	         | 项目的测试类，比如说Junit代码 |
| ${basedir}/src/test/resources	     | 测试用的资源 |
| ${basedir}/src/main/webapp/WEB-INF | web应用文件目录，web项目的信息，比如存放web.xml、本地图片、jsp视图页面 |
| ${basedir}/target	                 | 打包输出目录 |
| ${basedir}/target/classes	         | 编译输出目录 |
| ${basedir}/target/test-classes     | 测试编译输出目录 |
| Test.java	                         | Maven只会自动运行符合该命名规则的测试类 |
| ~/.m2/repository	                 | Maven默认的本地仓库目录位置 |
### 设置 Maven 环境变量
新建系统变量 MAVEN_HOME，变量值：E:\Maven\apache-maven-3.3.9，编辑系统变量 Path，添加变量值：;%MAVEN_HOME%\bin
