package demo.controller;

import java.util.ArrayList;
import java.util.Collections;

public class B {

    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(2);
        list.add(6);
        Collections.sort(list);
        System.out.println(list);
        String a="a";String b="b";String c=a+b;String d=new String("ab");
        System.out.println((a+b).equals(c));
        System.out.println(a+b==c);
        System.out.println(c==d);
        System.out.println(c.equals(d));



    }

}
