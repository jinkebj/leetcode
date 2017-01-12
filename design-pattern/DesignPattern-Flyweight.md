# Flyweight Pattern - 享元模式

#### 一、 概述
Flyweight在拳击比赛中指最轻量级，即"蝇量级"，有些作者翻译为"羽量级"。这里使用"享元模式"更能反映模式的用意。

享元模式以共享的方式高效地支持大量的细粒度对象。享元对象能做到共享的关键是区分内蕴状态（Internal State）和外蕴状态（External State）。内蕴状态是存储在享元对象内部并且不会随环境改变而改变。因此内蕴状态并可以共享。

外蕴状态是随环境改变而改变的、不可以共享的状态。享元对象的外蕴状态必须由客户端保存，并在享元对象被创建之后，在需要使用的时候再传入到享元对象内部。外蕴状态与内蕴状态是相互独立的。

享元模式的应用

享元模式在编辑器系统中大量使用。一个文本编辑器往往会提供很多种字体，而通常的做法就是将每一个字母做成一个享元对象。享元对象的内蕴状态就是这个字母，而字母在文本中的位置和字模风格等其他信息则是外蕴状态。比如，字母a可能出现在文本的很多地方，虽然这些字母a的位置和字模风格不同，但是所有这些地方使用的都是同一个字母对象。这样一来，字母对象就可以在整个系统中共享。


#### 二、 单纯享元模式的结构

![](DesignPattern-Flyweight-1.png)

在单纯享元模式中，所有的享元对象都是可以共享的。单纯享元模式所涉及的角色如下：

抽象享元(Flyweight)角色：此角色是所有的具体享元类的超类，为这些类规定出需要实现的公共接口。那些需要外蕴状态(External State)的操作可以通过调用商业方法以参数形式传入。

具体享元(ConcreteFlyweight)角色：实现抽象享元角色所规定的接口。如果有内蕴状态的话，必须负责为内蕴状态提供存储空间。享元对象的内蕴状态必须与对象所处的周围环境无关，从而使得享元对象可以在系统内共享的。

享元工厂(FlyweightFactory)角色：本角色负责创建和管理享元角色。本角色必须保证享元对象可以被系统适当地共享。当一个客户端对象调用一个享元对象的时候，享元工厂角色会检查系统中是否已经有一个复合要求的享元对象。如果已经有了，享元工厂角色就应当提供这个已有的享元对象；如果系统中没有一个适当的享元对象的话，享元工厂角色就应当创建一个合适的享元对象。

客户端(Client)角色：本角色需要维护一个对所有享元对象的引用。本角色需要自行存储所有享元对象的外蕴状态。


#### 三、 单纯享元模式的示意性源代码
```c
// Flyweight pattern -- Structural example
using System;
using System.Collections;

// "FlyweightFactory"
class FlyweightFactory
{
  // Fields
  private Hashtable flyweights = new Hashtable();

  // Constructors
  public FlyweightFactory()
  {
    flyweights.Add("X", new ConcreteFlyweight());
    flyweights.Add("Y", new ConcreteFlyweight());
    flyweights.Add("Z", new ConcreteFlyweight());
  }

  // Methods
  public Flyweight GetFlyweight(string key)
  {
    return((Flyweight)flyweights[ key ]);
  }
}

// "Flyweight"
abstract class Flyweight
{
  // Methods
  abstract public void Operation( int extrinsicstate );
}

// "ConcreteFlyweight"
class ConcreteFlyweight : Flyweight
{
  private string intrinsicstate = "A";
  // Methods
  override public void Operation( int extrinsicstate )
  {
    Console.WriteLine("ConcreteFlyweight: intrinsicstate {0}, extrinsicstate {1}", 
      intrinsicstate, extrinsicstate );
  }
}

/// <summary>
/// Client test
/// </summary>
public class Client
{
  public static void Main( string[] args )
  {
    // Arbitrary extrisic state
    int extrinsicstate = 22;

    FlyweightFactory f = new FlyweightFactory();

    // Work with different flyweight instances
    Flyweight fx = f.GetFlyweight("X");
    fx.Operation( --extrinsicstate );

    Flyweight fy = f.GetFlyweight("Y");
    fy.Operation( --extrinsicstate );

    Flyweight fz = f.GetFlyweight("Z");
    fz.Operation( --extrinsicstate );
  }
}
```
#### 四、 复合享元模式的结构

单纯享元模式中，所有的享元对象都可以直接共享。下面考虑一个较为复杂的情况，即将一些单纯享元使用合成模式加以复合，形成复合享元对象。这样的复合享元对象本身不能共享，但是它们可以分解成单纯享元对象，而后者则可以共享。

复合享元模式的类图如下图所示：

![](DesignPattern-Flyweight-2.png)

享元模式所涉及的角色有抽象享元角色、具体享元角色、复合享元角色、享员工厂角色，以及客户端角色等。

抽象享元角色：此角色是所有的具体享元类的超类，为这些类规定出需要实现的公共接口。那些需要外蕴状态(External State)的操作可以通过方法的参数传入。抽象享元的接口使得享元变得可能，但是并不强制子类实行共享，因此并非所有的享元对象都是可以共享的。

具体享元(ConcreteFlyweight)角色：实现抽象享元角色所规定的接口。如果有内蕴状态的话，必须负责为内蕴状态提供存储空间。享元对象的内蕴状态必须与对象所处的周围环境无关，从而使得享元对象可以在系统内共享。有时候具体享元角色又叫做单纯具体享元角色，因为复合享元角色是由单纯具体享元角色通过复合而成的。

复合享元(UnsharableFlyweight)角色：复合享元角色所代表的对象是不可以共享的，但是一个复合享元对象可以分解成为多个本身是单纯享元对象的组合。复合享元角色又称做不可共享的享元对象。

享元工厂(FlyweightFactoiy)角色：本角色负责创建和管理享元角色。本角色必须保证享元对象可以被系统适当地共享。当一个客户端对象请求一个享元对象的时候，享元工厂角色需要检查系统中是否已经有一个符合要求的享元对象，如果已经有了，享元工厂角色就应当提供这个已有的享元对象；如果系统中没有一个适当的享元对象的话，享元工厂角色就应当创建一个新的合适的享元对象。

客户端(Client)角色：本角色还需要自行存储所有享元对象的外蕴状态。

注：由于复合享元模式比较复杂，这里就不再给出示意性代码。通过将享元模式与合成模式组合在一起，可以确保复合享元中所包含的每个单纯享元都具有相同的外蕴状态，而这些单纯享元的内蕴状态往往不同。该部分内容可以参考《Java与模式》第31章内容。


#### 五、 一个咖啡摊的例子

在这个咖啡摊(Coffee Stall)所使用的系统里，有一系列的咖啡"风味(Flavor)"。客人到摊位上购买咖啡，所有的咖啡均放在台子上，客人自己拿到咖啡后就离开摊位。咖啡有内蕴状态，也就是咖啡的风味；咖啡没有环境因素，也就是说没有外蕴状态。如果系统为每一杯咖啡都创建一个独立的对象的话，那么就需要创建出很多的细小对象来。这样就不如把咖啡按照种类(即"风味")划分，每一种风味的咖啡只创建一个对象，并实行共享。

使用咖啡摊主的语言来讲，所有的咖啡都可按"风味"划分成如Capucino、Espresso等，每一种风味的咖啡不论卖出多少杯，都是全同、不可分辨的。所谓共享，就是咖啡风味的共享，制造方法的共享等。因此，享元模式对咖啡摊来说，就意味着不需要为每一份单独调制。摊主可以在需要时，一次性地调制出足够一天出售的某一种风味的咖啡。

很显然，这里适合使用单纯享元模式。系统的设计如下：

```c
using System;
using System.Collections;

public abstract class Order
{
  // 将咖啡卖给客人
  public abstract void Serve();
  // 返回咖啡的名字
  public abstract string GetFlavor();
}

public class Flavor : Order
{
  private string flavor;

  // 构造函数，内蕴状态以参数方式传入
  public Flavor(string flavor)
  {
    this.flavor = flavor;
  }

  // 返回咖啡的名字
  public override string GetFlavor()
  {
    return this.flavor;
  }

  // 将咖啡卖给客人
  public override void Serve()
  {
    Console.WriteLine("Serving flavor " + flavor);
  }
}

public class FlavorFactory
{
  private Hashtable flavors = new Hashtable();

  public Order GetOrder(string key)
  {
    if(! flavors.ContainsKey(key))
      flavors.Add(key, new Flavor(key));

        return ((Order)flavors[key]);
  }

  public int GetTotalFlavorsMade()
  {
    return flavors.Count;
  }
}

public class Client
{
  private static FlavorFactory flavorFactory;
  private static int ordersMade = 0;

  public static void Main( string[] args )
  {
    flavorFactory = new FlavorFactory();

    TakeOrder("Black Coffee");
    TakeOrder("Capucino");
    TakeOrder("Espresso");
    TakeOrder("Capucino");
    TakeOrder("Espresso");
    TakeOrder("Black Coffee");
    TakeOrder("Espresso");
    TakeOrder("Espresso");
    TakeOrder("Black Coffee");
    TakeOrder("Capucino");
    TakeOrder("Capucino");
    TakeOrder("Black Coffee");

    Console.WriteLine("\nTotal Orders made: " + ordersMade);

    Console.WriteLine("\nTotal Flavor objects made: " + 
      flavorFactory.GetTotalFlavorsMade());
  }

  private static void TakeOrder(string aFlavor)
  {
    Order o = flavorFactory.GetOrder(aFlavor);
    // 将咖啡卖给客人
    o.Serve();

    ordersMade++;
  }
}
```
#### 六、 咖啡屋的例子
在前面的咖啡摊项目里，由于没有供客人坐的桌子，所有的咖啡均没有环境的影响。换言之，咖啡仅有内蕴状态，也就是咖啡的种类，而没有外蕴状态。

下面考虑一个规模稍稍大一点的咖啡屋(Coffee Shop)项目。屋子里有很多的桌子供客人坐，系统除了需要提供咖啡的"风味"之外，还需要跟踪咖啡被送到哪一个桌位上，因此，咖啡就有了桌子作为外蕴状态。

由于外蕴状态的存在，没有外蕴状态的单纯享元模式不再符合要求。系统的设计可以利用有外蕴状态的单纯享元模式。系统的代码如下：
```c
using System;
using System.Collections;

public abstract class Order
{
  // 将咖啡卖给客人
  public abstract void Serve(Table table);
  // 返回咖啡的名字
  public abstract string GetFlavor();
}

public class Flavor : Order
{
  private string flavor;

  // 构造函数，内蕴状态以参数方式传入
  public Flavor(string flavor)
  {
    this.flavor = flavor;
  }

  // 返回咖啡的名字
  public override string GetFlavor()
  {
    return this.flavor;
  }

  // 将咖啡卖给客人
  public override void Serve(Table table)
  {
    Console.WriteLine("Serving table {0} with flavor {1}", table.Number, flavor);
  }
}

public class FlavorFactory
{
  private Hashtable flavors = new Hashtable();

  public Order GetOrder(string key)
  {
    if(! flavors.ContainsKey(key))
      flavors.Add(key, new Flavor(key));

        return ((Order)flavors[key]);
  }

  public int GetTotalFlavorsMade()
  {
    return flavors.Count;
  }
}

public class Table
{
  private int number;

  public Table(int number)
  {
    this.number = number;
  }

  public int Number
  {
    get { return number; }
  }
}

public class Client
{
  private static FlavorFactory flavorFactory;
  private static int ordersMade = 0;

  public static void Main( string[] args )
  {
    flavorFactory = new FlavorFactory();

    TakeOrder("Black Coffee");
    TakeOrder("Capucino");
    TakeOrder("Espresso");
    TakeOrder("Capucino");
    TakeOrder("Espresso");
    TakeOrder("Black Coffee");
    TakeOrder("Espresso");
    TakeOrder("Espresso");
    TakeOrder("Black Coffee");
    TakeOrder("Capucino");
    TakeOrder("Capucino");
    TakeOrder("Black Coffee");

    Console.WriteLine("\nTotal Orders made: " + ordersMade);

    Console.WriteLine("\nTotal Flavor objects made: " + 
      flavorFactory.GetTotalFlavorsMade());
  }

  private static void TakeOrder(string aFlavor)
  {
    Order o = flavorFactory.GetOrder(aFlavor);

    // 将咖啡卖给客人
    o.Serve(new Table(++ordersMade));
  }
}
```

#### 七、 享元模式应当在什么情况下使用

当以下所有的条件都满足时，可以考虑使用享元模式：

一个系统有大量的对象。
这些对象耗费大量的内存。
这些对象的状态中的大部分都可以外部化。
这些对象可以按照内蕴状态分成很多的组，当把外蕴对象从对象中剔除时，每一个组都可以仅用一个对象代替。
软件系统不依赖于这些对象的身份，换言之，这些对象可以是不可分辨的。
满足以上的这些条件的系统可以使用享元对象。

最后，使用享元模式需要维护一个记录了系统已有的所有享元的表，而这需要耗费资源。因此，应当在有足够多的享元实例可供共享时才值得使用享元模式。


#### 八、 享元模式的优点和缺点
享元模式的优点在于它大幅度地降低内存中对象的数量。但是，它做到这一点所付出的代价也是很高的：

享元模式使得系统更加复杂。为了使对象可以共享，需要将一些状态外部化，这使得程序的逻辑复杂化。
享元模式将享元对象的状态外部化，而读取外部状态使得运行时间稍微变长。
