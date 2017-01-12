# Visitor Pattern - 访问者模式

#### 一、 访问者（Visitor）模式

访问者模式的目的是封装一些施加于某种数据结构元素之上的操作。一旦这些操作需要修改的话，接受这个操作的数据结构则可以保持不变。

##### 问题提出

System.Collection命名空间下提供了大量集合操作对象。但大多数情况下处理的都是同类对象的聚集。换言之，在聚集上采取的操作都是一些针对同类型对象的同类操作。但是如果针对一个保存有不同类型对象的聚集采取某种操作该怎么办呢？

粗看上去，这似乎不是什么难题。可是如果需要针对一个包含不同类型元素的聚集采取某种操作，而操作的细节根据元素的类型不同而有所不同时，就会出现必须对元素类型做类型判断的条件转移语句。这个时候，使用访问者模式就是一个值得考虑的解决方案。

##### 访问者模式

访问者模式适用于数据结构相对未定的系统，它把数据结构和作用于结构上的操作之间的耦合解脱开，使得操作集合可以相对自由地演化。

数据结构的每一个节点都可以接受一个访问者的调用，此节点向访问者对象传入节点对象，而访问者对象则反过来执行节点对象的操作。这样的过程叫做"双重分派"。节点调用访问者，将它自己传入，访问者则将某算法针对此节点执行。

双重分派意味着施加于节点之上的操作是基于访问者和节点本身的数据类型，而不仅仅是其中的一者。


#### 二、 访问者模式的结构

如下图所示，这个静态图显示了有两个具体访问者和两个具体节点的访问者模式的设计，必须指出的是，具体访问者的数目与具体节点的数目没有任何关系，虽然在这个示意性的系统里面两者的数目都是两个。

![](DesignPattern-Visitor.png)

访问者模式涉及到抽象访问者角色、具体访问者角色、抽象节点角色、具体节点角色、结构对象角色以及客户端角色。

抽象访问者（Visitor）角色：声明了一个或者多个访问操作，形成所有的具体元素角色必须实现的接口。
具体访问者（ConcreteVisitor）角色：实现抽象访问者角色所声明的接口，也就是抽象访问者所声明的各个访问操作。
抽象节点（Node）角色：声明一个接受操作，接受一个访问者对象作为一个参量。
具体节点（Node）角色：实现了抽象元素所规定的接受操作。
结构对象（ObiectStructure）角色：有如下的一些责任，可以遍历结构中的所有元素；如果需要，提供一个高层次的接口让访问者对象可以访问每一个元素；如果需要，可以设计成一个复合对象或者一个聚集，如列（List）或集合（Set）。

#### 三、 示意性源代码

```c
// Visitor pattern -- Structural example
using System;
using System.Collections;

// "Visitor"
abstract class Visitor
{
  // Methods
  abstract public void VisitConcreteElementA(
    ConcreteElementA concreteElementA );
  abstract public void VisitConcreteElementB(
    ConcreteElementB concreteElementB );
}

// "ConcreteVisitor1"
class ConcreteVisitor1 : Visitor
{
  // Methods
  override public void VisitConcreteElementA(
    ConcreteElementA concreteElementA )
  {
    Console.WriteLine( "{0} visited by {1}",
      concreteElementA, this );
  }

  override public void VisitConcreteElementB(
    ConcreteElementB concreteElementB )
  {
    Console.WriteLine( "{0} visited by {1}",
      concreteElementB, this );
  }
}

// "ConcreteVisitor2"
class ConcreteVisitor2 : Visitor
{
  // Methods
  override public void VisitConcreteElementA(
    ConcreteElementA concreteElementA )
  {
    Console.WriteLine( "{0} visited by {1}",
      concreteElementA, this );
  }
  override public void VisitConcreteElementB(
    ConcreteElementB concreteElementB )
  {
    Console.WriteLine( "{0} visited by {1}",
      concreteElementB, this );
  }
}

// "Element"
abstract class Element
{
  // Methods
  abstract public void Accept( Visitor visitor );
}

// "ConcreteElementA"
class ConcreteElementA : Element
{
  // Methods
  override public void Accept( Visitor visitor )
  {
    visitor.VisitConcreteElementA( this );
  }

  public void OperationA()
  {
  }
}

// "ConcreteElementB"
class ConcreteElementB : Element
{
  // Methods
  override public void Accept( Visitor visitor )
  {
    visitor.VisitConcreteElementB( this );
  }

  public void OperationB()
  {
  }
}

// "ObjectStructure"
class ObjectStructure
{
  // Fields
  private ArrayList elements = new ArrayList();

  // Methods
  public void Attach( Element element )
  {
    elements.Add( element );
  }

  public void Detach( Element element )
  {
    elements.Remove( element );
  }

  public void Accept( Visitor visitor )
  {
    foreach( Element e in elements )
      e.Accept( visitor );
  }
}
```

Client test:
```c
/// <summary>
/// Client test
/// </summary>
public class Client
{
  public static void Main( string[] args )
  {
    // Setup structure
    ObjectStructure o = new ObjectStructure();
    o.Attach( new ConcreteElementA() );
    o.Attach( new ConcreteElementB() );

    // Create visitor objects
    ConcreteVisitor1 v1 = new ConcreteVisitor1();
    ConcreteVisitor2 v2 = new ConcreteVisitor2();

    // Structure accepting visitors
    o.Accept( v1 );
    o.Accept( v2 );
  }
}
```
结构对象会遍历它自己所保存的聚集中的所有节点，在本系统中就是节点ConcreteElementA和节点ConcreteElementB。首先ConcreteElementA会被访问到，这个访问是由以下的操作组成的：

ConcreteElementA对象的接受方法被调用，并将VisitorA对象本身传入；
ConcreteElementA对象反过来调用VisitorA对象的访问方法，并将ConcreteElementA对象本身传入；
VisitorA对象调用ConcreteElementA对象的商业方法operationA( )。
从而就完成了双重分派过程，接着，ConcreteElementB会被访问，这个访问的过程和ConcreteElementA被访问的过程是一样的。

因此，结构对象对聚集元素的遍历过程就是对聚集中所有的节点进行委派的过程，也就是双重分派的过程。换言之，系统有多少个节点就会发生多少个双重分派过程。


#### 四、 一个实际应用Visitor模式的例子
以下的例子演示了Employee对象集合允许被不同的Visitor（IncomeVisitor与VacationVisitor）访问其中的内容。
```c
// Visitor pattern -- Real World example
using System;
using System.Collections;

// "Visitor"
abstract class Visitor
{
  // Methods
  abstract public void Visit( Element element );
}

// "ConcreteVisitor1"
class IncomeVisitor : Visitor
{
  // Methods
  public override void Visit( Element element )
  {
    Employee employee = ((Employee)element);

    // Provide 10% pay raise
    employee.Income *= 1.10;
    Console.WriteLine( "{0}'s new income: {1:C}",
      employee.Name, employee.Income );
  }
}

// "ConcreteVisitor2"
class VacationVisitor : Visitor
{
  public override void Visit( Element element )
  {
    Employee employee = ((Employee)element);

    // Provide 3 extra vacation days
    employee.VacationDays += 3;
    Console.WriteLine( "{0}'s new vacation days: {1}",
      employee.Name, employee.VacationDays );
  }
}

// "Element"
abstract class Element
{
  // Methods
  abstract public void Accept( Visitor visitor );
}

// "ConcreteElement"
class Employee : Element
{
  // Fields
  string name;
  double income;
  int vacationDays;

  // Constructors
  public Employee( string name, double income,
    int vacationDays )
  {
    this.name = name;
    this.income = income;
    this.vacationDays = vacationDays;
  }

  // Properties
  public string Name
  {
    get{ return name; }
    set{ name = value; }
  }

  public double Income
  {
    get{ return income; }
    set{ income = value; }
  }

  public int VacationDays
  {
    get{ return vacationDays; }
    set{ vacationDays = value; }
  }

  // Methods
  public override void Accept( Visitor visitor )
  {
    visitor.Visit( this );
  }
}

// "ObjectStructure"
class Employees
{
  // Fields
  private ArrayList employees = new ArrayList();

  // Methods
  public void Attach( Employee employee )
  {
    employees.Add( employee );
  }

  public void Detach( Employee employee )
  {
    employees.Remove( employee );
  }

  public void Accept( Visitor visitor )
  {
    foreach( Employee e in employees )
      e.Accept( visitor );
  }
}

/// <summary>
/// VisitorApp test
/// </summary>
public class VisitorApp
{
  public static void Main( string[] args )
  {
    // Setup employee collection
    Employees e = new Employees();
    e.Attach( new Employee( "Hank", 25000.0, 14 ) );
    e.Attach( new Employee( "Elly", 35000.0, 16 ) );
    e.Attach( new Employee( "Dick", 45000.0, 21 ) );

    // Create two visitors
    IncomeVisitor v1 = new IncomeVisitor();
    VacationVisitor v2 = new VacationVisitor();

    // Employees are visited
    e.Accept( v1 );
    e.Accept( v2 );
  }
}
```

#### 五、 在什么情况下应当使用访问者模式
有意思的是，在很多情况下不使用设计模式反而会得到一个较好的设计。换言之，每一个设计模式都有其不应当使用的情况。访问者模式也有其不应当使用的情况，让我们
先看一看访问者模式不应当在什么情况下使用。

##### 倾斜的可扩展性

访问者模式仅应当在被访问的类结构非常稳定的情况下使用。换言之，系统很少出现需要加入新节点的情况。如果出现需要加入新节点的情况，那么就必须在每一个访问对象里加入一个对应于这个新节点的访问操作，而这是对一个系统的大规模修改，因而是违背"开一闭"原则的。

访问者模式允许在节点中加入新的方法，相应的仅仅需要在一个新的访问者类中加入此方法，而不需要在每一个访问者类中都加入此方法。

显然，访问者模式提供了倾斜的可扩展性设计：方法集合的可扩展性和类集合的不可扩展性。换言之，如果系统的数据结构是频繁变化的，则不适合使用访问者模式。

##### "开一闭"原则和对变化的封装

面向对象的设计原则中最重要的便是所谓的"开一闭"原则。一个软件系统的设计应当尽量做到对扩展开放，对修改关闭。达到这个原则的途径就是遵循"对变化的封装"的原则。这个原则讲的是在进行软件系统的设计时，应当设法找出一个软件系统中会变化的部分，将之封装起来。

很多系统可以按照算法和数据结构分开，也就是说一些对象含有算法，而另一些对象含有数据，接受算法的操作。如果这样的系统有比较稳定的数据结构，又有易于变化的算法的话，使用访问者模式就是比较合适的，因为访问者模式使得算法操作的增加变得容易。

反过来，如果这样一个系统的数据结构对象易于变化，经常要有新的数据对象增加进来的话，就不适合使用访问者模式。因为在访问者模式中增加新的节点很困难，要涉及到在抽象访问者和所有的具体访问者中增加新的方法。


#### 六、 使用访问者模式的优点和缺点
##### 访问者模式有如下的优点：

访问者模式使得增加新的操作变得很容易。如果一些操作依赖于一个复杂的结构对象的话，那么一般而言，增加新的操作会很复杂。而使用访问者模式，增加新的操作就意味着增加一个新的访问者类，因此，变得很容易。
访问者模式将有关的行为集中到一个访问者对象中，而不是分散到一个个的节点类中。
访问者模式可以跨过几个类的等级结构访问属于不同的等级结构的成员类。迭代子只能访问属于同一个类型等级结构的成员对象，而不能访问属于不同等级结构的对象。访问者模式可以做到这一点。
积累状态。每一个单独的访问者对象都集中了相关的行为，从而也就可以在访问的过程中将执行操作的状态积累在自己内部，而不是分散到很多的节点对象中。这是有益于系统维护的优点。
##### 访问者模式有如下的缺点：

增加新的节点类变得很困难。每增加一个新的节点都意味着要在抽象访问者角色中增加一个新的抽象操作，并在每一个具体访问者类中增加相应的具体操作。
破坏封装。访问者模式要求访问者对象访问并调用每一个节点对象的操作，这隐含了一个对所有节点对象的要求：它们必须暴露一些自己的操作和内部状态。不然，访问者的访问就变得没有意义。由于访问者对象自己会积累访问操作所需的状态，从而使这些状态不再存储在节点对象中，这也是破坏封装的。