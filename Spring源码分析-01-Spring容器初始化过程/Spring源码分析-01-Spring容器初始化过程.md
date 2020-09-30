#	Spring源码分析

要想学好Springboot、SpringCloud、SpringSecurity、SpringMVC...等这些玩意，Spring是基石，学好Spring才是硬（eng）道理。

##	Spring是什么东东？

Spring是一个java框架，引入jar后就可以开发我们的应用。

Spring是一个生态，提供了一系列衍生的产品，springboot、springcloud...等等。

要是有人问你什么是Spring，你肯定会说，Spring是个Bean工厂...，Spring提供了两大核心功能：**IoC和AOP**   ,IoC容器管理所有的bean，AOP面向切面编程，balabalabala......

### 啥是Bean工厂？

工厂，是造东西的。

Bean工厂，那就是造Bean的。工厂就是自主生产自己的产品，不再依赖于new。任何方法，里面控制了产生对象的逻辑，都可以叫工厂方法。

单例模式，就可以说是最简单的工厂模式，里的getInstance();方法，有人就叫他静态工厂方法：

```java
public class Car {
	private static Car car = new Car();
	private Car(){}
	
	public static Car getInstance(){
		return car;
	}
}
//当需要Car的时候，直接调用Car.getInstance();方法就可以了，这里的Car类就相当于一个Car工厂，至于里面是单例还是多例，返回是同一辆Car还是不同的Car，由你的工厂方法自己控制。你在getInstance()方法里可以做各种判断，比如有驾照我才返回Car等等。
```

这里就不细讲普通工厂和抽象工厂的区别了，只是举个简单例子说明什么是工厂。

**Spring的Bean工厂**  

再如 有Moveable接口，让Car实现Movable接口，我们使用的时候，Moveable m = **new** Car();  Spring说，你别自己new了，你给我配置到配置文件里去，java可以读取配置文件，通过反射生成对象：

<img src="D:\Z_lhy\学习\Spring\Spring-Study\Spring源码分析-01-Spring容器初始化过程\1.png" style="margin-left:10px" />

spring.properties：

```properties
VehicleType=com.lhy.springfactory.Car
```

```java
public static void main(String[] args) throws Exception{
	Properties props = new Properties();
		props.load(Test.class.getClassLoader().getResourceAsStream("com/lhy/springfactory/spring.properties"));

		String vehicleTypeName = props.getProperty("VehicleType");
		System.out.println(vehicleTypeName);
		//反射生成对象
		Object o = Class.forName(vehicleTypeName).newInstance();
		Moveable m = (Moveable)o;
		m.run();
	}
//打印结果：
com.lhy.springfactory.Car
冒着烟奔跑中...
把配置文件换成或者Trian:
VehicleType=com.lhy.springfactory.Train
执行测试代码，打印：
com.lhy.springfactory.Train
小火车呜呜呜...
```

这样只是改了配置文件，就可以动态控制生成的类了。代码都不用动，Spring就是这样的思路。

当你在最开始看Spring教程的时候，肯定看见过下面的代码（下面是使用Spring所要依赖的最小的包）：

<img src="D:\Z_lhy\学习\Spring\Spring-Study\Spring源码分析-01-Spring容器初始化过程\2.png" style="margin-left:10px" />

```java
Car的实现：
public class Car implements Moveable{
	@Override
	public void run() {
		System.out.println("冒着烟奔跑中...");
	}
}
飞机的实现：
public class Plane implements Moveable{

	@Override
	public void run() {
		System.out.println("扇着翅膀飞呀飞...");
	}
}

```

applicationContext.xml：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

  <bean id="v" class="com.bjsxt.spring.factory.Train"/>
</beans>

```

```java
package com.bjsxt.spring.factory;
import java.io.IOException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception {
		BeanFactory f = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object o = f.getBean("v");
		Moveable m = (Moveable)o;
		m.run();
	}
}
打印：
小火车呜呜呜...
换成Car，打印：
冒着烟奔跑中...
```

new ClassPathXmlApplicationContext() 就相当于启动了一个Bean工厂，或者说是Spring容器。

下面来模拟Spring的Bean工厂

Spring的BeanFactory ，就是一个容器，是用一个map实现的，就是从配置文件读取 <bean id=*"v"* class=*"com.bjsxt.spring.factory.Train"*/> 这样的配置，遍历解析这样的xml配置，以id为key，class后的类全限定名用反射生成的对象为value，放到这个map中去。当用的时候，直接map.get(id); 获取这个Bean对象。

ClassPathXmlApplicationContext是BeanFactory的一种实现，这里模拟这种实现。

自定义一个BeanFactory：

```java
public interface BeanFactory {
	Object getBean(String id);
}
```

自定义一个ClassPathXmlApplicationContext  :

```java
public class ClassPathXmlApplicationContext implements BeanFactory{
	//存放一个个Bean对象的容器，
	private Map<String, Object> container = new HashMap<String, Object>();
	
	// 构造方法找到配置文件，读取xml配置文件
	public ClassPathXmlApplicationContext(String fileName) throws Exception{
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(this.getClass().getClassLoader()
				.getResourceAsStream(fileName));
		Element root = doc.getRootElement();
		List list = XPath.selectNodes(root, "/beans/bean");
		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			Element bean = (Element) list.get(i);
			String id = bean.getAttributeValue("id");
			String clazz = bean.getAttributeValue("class");
			Object o = Class.forName(clazz).newInstance();
			container.put(id, o);
			System.out.println(id + " " + clazz);
		}
	}

	//读取配置文件，读取id为传进来的id的Bean，实例化
	@Override
	public Object getBean(String id) {
		return container.get(id);
	}
}

```

applicationContext.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans>
  <bean id="v" class="com.lhy.springfactory.Car"/>
	<bean id="trian" class="com.lhy.springfactory.Train"/>
  <!--  //v=com.bjsxt.spring.factory.Car  -->
</beans>

```

```java
public static void main(String[] args) throws Exception{
		
		BeanFactory f = new ClassPathXmlApplicationContext("com/lhy/springfactory/applicationContext.xml");
		Object o = f.getBean("v");
		Moveable m = (Moveable)o;
		m.run();
		
		Train trian = (Train)f.getBean("trian");
		trian.run();
		
	}
//打印：
v com.lhy.springfactory.Car
trian com.lhy.springfactory.Train
冒着烟奔跑中...
小火车呜呜呜...

这样，就把类配置在了配置文件里,更灵活了。
```

这个private Map<String, Object> container = new HashMap<String, Object>();就是一个简化版的Spring容器。

#### 所谓的控制反转是个啥

IoC说的是，之前需要一个对象的时候，需要自己去new，我记得刚学Servlet+MVC的时候，写的crud的项目就大概是这样子的，比如UserServiceImpl

```java
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    public UserServiceImpl(){
        this.userDao = new UserDaoImpl();//此处需要Dao的时候需要自己new
    }
}
```

在UserService里面当你需要UserDao的时候，你需要自己去new，控制权在你手里。

有了Spring之后，对象由Spring容器创建，需要的时候直接从Spring容器中去拿就行了，在applicationContext.xml的配置文件：

```xml
  <!-- 配置service -->
    <bean id="userService" class="com.xxoo.service.impl.UserServiceImpl">
        <property name="userDao" ref="userDao"></property>
    </bean>
    <!-- 配置Dao -->
    <bean id="userDao" class="com.xxoo.dao.impl.userDaoImpl"/>
```

这样，Bean的创建不由你控制了，由Spring控制了，控制权从你手里跑到了Spring手里，这就是所谓的（IoC）控制反转。









