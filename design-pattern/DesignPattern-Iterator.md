# Iterator Pattern - 迭代器模式

#### 概述：

   在现在的电视机中，我们使用[后一个]和[前一个]按钮可以很方便的换台，当按下[后一个]按钮时，将切换到下一个预置的频道。想象一下在陌生的城市中的旅店中看电视。当改变频道时，重要的不是几频道，而是节目内容。如果对一个频道的节目不感兴趣，那么可以换下一个频道，而不需要知道它是几频道。

   这个其实就是我们迭代器模式的精髓：提供一种方法顺序访问一个聚合对象中各个元素, 而又不需暴露该对象的内部表示。

#### 类图和实例：
![](DesignPattern-Iterator.png)

迭代器模式由以下角色组成：
1．迭代器角色（Iterator）：迭代器角色负责定义访问和遍历元素的接口。
2．具体迭代器角色（Concrete Iterator）：具体迭代器角色要实现迭代器接口，并要记录遍历中的当前位置。
3．集合角色（Aggregate）：集合角色负责提供创建具体迭代器角色的接口。
4．具体集合角色（Concrete Aggregate）：具体集合角色实现创建具体迭代器角色的接口——这个具体迭代器角色于该集合的结构相关。

```c
#include <iostream>  
#include <vector>  
using namespace std;  
  
template<class Item>  
class Iterator  
{  
public:  
    virtual void first()=0;  
    virtual void next()=0;  
    virtual Item* currentItem()=0;  
    virtual bool isDone()=0;  
    virtual ~Iterator(){}  
};  
  
template<class Item>  
class ConcreteAggregate;  
  
template<class Item>  
class ConcreteIterator : public Iterator <Item>  
{  
    ConcreteAggregate<Item> * aggr;  
    int cur;  
public:  
    ConcreteIterator(ConcreteAggregate<Item>*a):aggr(a),cur(0){}  
    virtual void first()  
    {  
        cur=0;  
    }  
    virtual void next()  
    {  
        if(cur<aggr->getLen())  
            cur++;  
    }  
    virtual Item* currentItem()  
    {  
        if(cur<aggr->getLen())  
            return &(*aggr)[cur];  
        else  
            return NULL;  
    }  
    virtual bool isDone()  
    {  
        return (cur>=aggr->getLen());  
    }  
};  
  
template<class Item>  
class Aggregate  
{  
public:  
    virtual Iterator<Item>* createIterator()=0;  
    virtual ~Aggregate(){}  
};  
  
template<class Item>  
class ConcreteAggregate:public Aggregate<Item>  
{  
    vector<Item >data;  
public:  
    ConcreteAggregate()  
    {  
        data.push_back(1);  
        data.push_back(2);  
        data.push_back(3);  
    }  
    virtual Iterator<Item>* createIterator()  
    {  
        return new ConcreteIterator<Item>(this);  
    }  
    Item& operator[](int index)  
    {  
        return data[index];  
    }  
    int getLen()  
    {  
        return data.size();  
    }  
};  
  
int main()  
{  
    Aggregate<int> * aggr =new ConcreteAggregate<int>();  
    Iterator<int> *it=aggr->createIterator();  
  
    for(it->first();!it->isDone();it->next())  
    {  
        cout<<*(it->currentItem())<<endl;  
    }  
    delete it;  
    delete aggr;  
    return 0;  
}
```

#### 实现要点：
1．迭代抽象：访问一个聚合对象的内容而无需暴露它的内部表示。
2．迭代多态：为遍历不同的集合结构提供一个统一的接口，从而支持同样的算法在不同的集合结构上进行操作。
3．迭代器的健壮性考虑：遍历的同时更改迭代器所在的集合结构，会导致问题。

#### 适用性：
1．访问一个聚合对象的内容而无需暴露它的内部表示。 
2．支持对聚合对象的多种遍历。 
3．为遍历不同的聚合结构提供一个统一的接口(即, 支持多态迭代)。

#### 其他：
1．在C++下可以参看 STL iterators 的实现。
2．在.NET下实现Iterator模式，对于聚集接口和迭代器接口已经存在了，其中IEnumerator扮演的就是迭代器的角色，而IEnumerable则扮演的就是抽象聚集的角色，她只有一个GetEnumerator()方法，如果集合对象需要具备跌代遍历的功能，就必须实现该接口。
3．在Java下可以参看集合类型迭代器（java.util.Iterator，java.util.Enumeration）。