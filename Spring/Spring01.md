### 模拟Spring的Bean工厂

Spring的BeanFactory和ApplicationContext想必大家经常听，下面来模拟一下这两者的关系和实现。

Spring的BeanFactory ，就是一个容器，是用一个map实现的，就是从配置文件读取

 ```xml
 <bean id="v" class="com.bjsxt.spring.factory.Train"/> 
 ```

这样的配置，遍历解析这样的xml配置，以id为key，class后的类全限定名用反射生成的对象为value，放到这个map中去。当用的时候，直接map.get(id); 获取这个Bean对象。

ClassPathXmlApplicationContext是BeanFactory的一种实现。这里模拟这种实现。

这里模拟Spring的Bean工厂：

```java
public interface BeanFactory {
	Object getBean(String id);
}
```

ClassPathXmlApplicationContext  :

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

xml配置：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans>
  <bean id="v" class="com.lhy.springfactory.Car"/>
	<bean id="trian" class="com.lhy.springfactory.Train"/>
  <!--  //v=com.bjsxt.spring.factory.Car  -->
</beans>
```

Train.java

```java
public class Train implements Moveable{
	@Override
	public void run() {
		System.out.println("小火车呜呜呜...");
	}
}
```

 Car.java 

```java
public class Car implements Moveable{
	@Override
	public void run() {
		System.out.println("冒着烟奔跑中...");
	}
}
```

测试程序：

```java
public static void main(String[] args) throws Exception{
		
		BeanFactory f = new ClassPathXmlApplicationContext("com/lhy/springfactory/applicationContext.xml");
		Object o = f.getBean("v");
		Moveable m = (Moveable)o;
		m.run();
		
		Train trian = (Train)f.getBean("trian");
		trian.run();	
	}
```

打印：

v com.lhy.springfactory.Car

trian com.lhy.springfactory.Train

冒着烟奔跑中...

小火车呜呜呜...

结论：

这样，就把类配置在了配置文件里。进一步，还可以在配置文件描述类与类之间的关系。





[详细代码]: https://github.com/lhy1234/DesignPattern_Factory

粗糙版BeanFactory和ApplicationContext已经体验完了，下面开始详细学习。

### BeanFactory和ApplicationContext区别

Spring本质其实就是通过一个配置文件描述Bean与Bean之间的依赖关系，利用java反射功能实例化Bean并建立Bean之间的依赖关系。Spring的IoC容器在完成这些底层工作的基础上，还提供了Bean实例缓存，生命周期管理，Bean实例代理，事件发布，资源装载等高级服务。

#### BeanFactory：

​		俗称：bean工厂 或 IoC容器，是Spring最核心的接口，Spring框架的基础设施，面向Spring本身。



#### ApplicationContext：

​		俗称：应用上下文 或 Spring容器，是建立在BeanFactory基础之上，提供了更多面向应用的功能，提供了国际化支持和框架事件体系，面向程序员，都使用ApplicationContext而不使用BeanFactory







### 核心的类

**BeanDefinition：**

​	注释， 一个 BeanDefinition 描述了一个 Bean 实例，实例包含属性值、构造方法参数值以及更多实现信息。该 BeanDefinition 只是是一个最小的接口，主要目的是允许修改属性值和其他 Bean 元数据 。

说白了 就是解析xml后的bean标签后，创建的bean对象的包装类。管理Spring中的各种对象，以及它们之间依赖关系。控制反转都是围绕对BeanDefinition 的处理来完成的。

**ListableBeanFactory：**

​	定义了访问容器中Bean基本信息的若干方法，如查看Bean的个数，获取某一类型Bean的配置名、查看容器中是否包括某一Bean等。

 **HierarchicalBeanFactory ：**

​	父子级联的IoC容器的接口，子容器可以通过接口方法访问父容器。	

 **ConfigurableBeanFactory ：**

​		增强了IoC容器的可定制性。定义了设置类装载器、属性编辑器、容器初始化后置处理器等方法。

 **AutowireCapableBeanFactory ：**











