package com.atguigu.java;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Yan
 * @create 2022-12-23 14:34
 **/
interface Human{
    String getBelief();
    void eat(String food);
}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃：" + food);
    }
}

class ProxyFactory{
    //调用此方法 返回一个代理类对象
    public static Object getProxyInstance(Object obj){//obj:被代理类的对象

        MyInvocationHandler invocationHandler = new MyInvocationHandler();

        invocationHandler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),invocationHandler);

    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }
    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行方法a的功能就生命在invoke（）中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();
        //method即为代理类对象调用的方法，此方法也就作为了被代理对象要调用的方法
        //obj：被代理类的对象
        Object invoke = method.invoke(obj, args);
        humanUtil.method2();
        return invoke;


    }
}
class HumanUtil{
    public void method1(){
        System.out.println("通用方法一");
    }
    public void method2(){
        System.out.println("通用方法二");
    }
}


public class Proxytest {
    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();
        //proxyInstance：代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动的调用被代理类中的同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");
        System.out.println("**************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}
