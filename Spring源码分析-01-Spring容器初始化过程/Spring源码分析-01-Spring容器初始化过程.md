#	Spring源码分析

要想学好Springboot、SpringCloud、SpringSecurity、SpringMVC...等这些玩意，Spring是基石，学好Spring才是硬（eng）道理。

##	Spring是什么东东？

Spring是一个java框架，引入jar后就可以开发我们的应用。

Spring是一个生态，提供了一系列衍生的产品，springboot、springcloud...等等。

Spring是极具扩展性的，源码里面可以看到，很多方法的空的实现，类、接口层次结构关系异常复杂。

搞懂了这些，就可以为所欲为了，在工作中为所欲为，在面试中为所欲为。

**Spring的两大核心：IoC和AOP**

### 所谓的IoC控制反转是个啥

一个例子说的明明白白：

IoC说的是，之前需要一个对象的时候，需要自己去new，我记得刚学Servelet+MVC的时候，写的crud的项目就大概是这样子的，比如UserServiceImpl

```java
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    public UserServiceImpl(){
        this.userDao = new UserDaoImpl();//此处需要Dao的时候需要自己new
    }
}
```

在UserService里面当你需要UserDao的时候，你需要自己去new，控制权在你手里。

有了Spring之后，对象由Spring容器创建，需要的时候直接从Spring容器中去拿就行了，最早的时候大概是这样式的，项目里一般都有个applicationContext.xml的配置文件，把所有用到的bean都配置在xml中：

```xml
  <!-- 配置service -->
    <bean id="userService" class="com.xxoo.service.impl.UserServiceImpl">
        <property name="userDao" ref="userDao"></property>
    </bean>
    <!-- 配置Dao -->
    <bean id="userDao" class="com.xxoo.dao.impl.userDaoImpl"/>
```

这样，Bean的创建不由你控制了，由Spring控制了，控制权从你手里跑到了Spring手里，这就是所谓的（IoC）控制反转。

### 	IoC容器&Bean工厂，到底是个啥玩意?

提到Spring，一直都在说Spring是个IoC容器，Spring替你掌管着Bean，放在了IoC容器，到底啥是IoC容器？

当你刚开始学Spring的时候，一定看到过老师写下面的代码：

定义一个Spring的配置文件 ，beans.xml ：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    <bean id="car" class="com.nb.nbbase2.beans.Car"/>
    
</beans>
```

Car.java ：

```java
public class Car {
    private String brand;
    private String color;
    private Integer maxSpeed;
	//....省略getter setter
}
```

Test方法：

```java
@Test
public void testCTX() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    Car car = ctx.getBean("car",Car.class);
    System.err.println(car.toString());
}

//注：最原始的启动BeanFactory，XmlBeanFactory已被废弃，ApplicationContext是面向程序员的，BeanFactory是面向Spring本身的，能用ApplicationContext的地方就不要用BeanFactory（一般我们也不用）
ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
Resource resource = resolver.getResource("beans.xml");
//被废弃
BeanFactory factory = new XmlBeanFactory(resource);
```

上边的test方法，通过读取beans.xml，就启动了一个Spring容器，然后把xml配置文件里的com.nb.nbbase2.beans.Car ，new了一个对象，放进了Spring容器，神奇不神奇？刚开始看视频里面这么讲，只是知道“哦，这样就能启动一个Spring容器并且获取对象”。在马士兵老师十几年前的老视频，介绍了什么是Bean工厂。

工厂，是造东西的。Bean工厂，那就是造Bean的。工厂就是自主生产自己的产品，不再依赖于new，比如单例模式，就是一个最简单的工厂。































