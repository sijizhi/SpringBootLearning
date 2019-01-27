package com.example.demo3.lambdaTest;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/27 17:25
 */
public class Lambda {

    public static void main(String[] args) {
        MyEat myEat1=new MyEatImpl();
        myEat1.eat("apple");
        MyEat myEat2=new MyEat() {
            @Override
            public void eat(String thing) {
                System.out.println("eat " +thing);
            }
        };
        myEat2.eat("banana");
        //没有参数时使用
       // MyEat myEat3=()->System.out.println("函数式编程 省略了方法（接口必须是一个方法）");
       // myEat3.eat();
         MyEat myEat3=(String thing)->System.out.println("函数式编程 省略了方法（接口必须是一个方法）"+thing);
         myEat3.eat("水果");
    }



}

 interface  MyEat{
     void eat(String thing);
}

class MyEatImpl implements MyEat{
    @Override
    public void eat(String thing) {
        System.out.println("eat " +thing);
    }
}
