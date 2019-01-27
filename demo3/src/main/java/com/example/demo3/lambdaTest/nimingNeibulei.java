package com.example.demo3.lambdaTest;

/**
 * @Author: SiJie Zhi
 * @Date: 2019/1/27 19:30
 */
public class nimingNeibulei {
    public pr dest() {
        return new pr() {
            public void print1() {
                System.out.println("Hello world!!");
            }
        };
    }

    public static void main(String args[])
    {
        nimingNeibulei c=new     nimingNeibulei();
        pr hw=c.dest();
        hw.print1();
    }
}
interface pr
{
    void print1();
}

