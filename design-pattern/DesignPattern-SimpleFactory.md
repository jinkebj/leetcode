# Simple Factory Pattern - 简单工厂模式

##### 1. 概述

　　将一个具体类的实例化交给一个静态工厂方法来执行，它不属于GOF的23种设计模式，但现实中却经常会用到。

#### 2. 模式中的角色

　　2.1 工厂类（Simple Factory): 只包含了创建具体类的静态方法。

　　2.2 抽象产品（Product）：定义简单工厂中要返回的产品。

　　2.3 具体产品（ConcreteProduct）：具体产品。

#### 3. 模式解读

##### 　　3.1 简单工厂模式的一般化类图

![](DesignPattern-SimpleFactory.png)

##### 　　3.2 简单工厂模式的代码实现
```c
    /// <summary>
    /// 简单工厂类，用sealed修饰，
    /// </summary>
    public class SimpleProductFactory
    {
        /// <summary>
        /// 使用静态方法，根据传入的参数来指定要实例化哪一种产品
        /// </summary>
        /// <param name="productType"></param>
        /// <returns></returns>
        public static Product CreateProduct(string productType)
        {
            Product product = null;
            switch (productType)
            {
                case "A":
                    product = new ConcreteProductA();
                    break;
                case "B":
                    product = new ConcreteProductB();
                    break;
            }

            return product;
        }
    }

    /// <summary>
    /// 抽象产品
    /// </summary>
    public abstract class Product
    {
        public Product()
        { }

        public abstract void Opration();
    }

    /// <summary>
    /// 具体产品 A
    /// </summary>
    public class ConcreteProductA : Product
    {
        public ConcreteProductA() { }

        public override void Opration()
        {
            // 产品A
        }
    }

    /// <summary>
    /// 具体产品 B
    /// </summary>
    public class ConcreteProductB : Product
    {
        public ConcreteProductB() { }

        public override void Opration()
        {
            //产品B
        }
    }
```

#### 4. 模式总结

##### 　　4.1 优点

　　　　4.1.1 职责单一，实现简单，且实现了客户端代码与具体实现的解耦。

　　　　4.1.2 工厂类是整个模式的关键.包含了必要的逻辑判断,根据外界给定的信息,决定究竟应该创建哪个具体类的对象.

　　　　4.1.3 通过使用工厂类,外界可以从直接创建具体产品对象的尴尬局面摆脱出来,仅仅需要负责“消费”对象就可以了。而不必管这些对象究竟如何创建及如何组织的．

　　　　4.1.4 明确了各自的职责和权利，有利于整个软件体系结构的优化。

##### 　　4.2 缺点

　　　　4.2.1 由于工厂类集中了所有实例的创建逻辑，违反了高内聚责任分配原则，将全部创建逻辑集中到了一个工厂类中；它所能创建的类只能是事先考虑到的，如果需要添加新的类，则就需要改变工厂类了。因此它是违背开放封闭原则的。

　　　　4.2.2 当系统中的具体产品类不断增多时候，可能会出现要求工厂类根据不同条件创建不同实例的需求．这种对条件的判断和对具体产品类型的判断交错在一起，很难避免模块功能的蔓延，对系统的维护和扩展非常不利；
　　　　注：这些缺点在工厂方法模式中得到了一定的克服。

##### 　　4.3 使用场景

　　　　4.3.1 工厂类负责创建的对象比较少；

　　　　4.3.2 客户只知道传入工厂类的参数，对于如何创建对象（逻辑）不关心；

　　　　4.3.3 由于简单工厂很容易违反高内聚责任分配原则，因此一般只在很简单的情况下应用。
