package com.bluestroy.designpattern.factory;

import com.bluestroy.designpattern.factory.pizza.CheesePizza;
import com.bluestroy.designpattern.factory.pizza.PepperPizza;
import com.bluestroy.designpattern.factory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Troy on 2016/10/8.
 */
public class OrderPizza  {
    public OrderPizza() {
        Pizza pizza=null;
        String orderType ;
        do {
            orderType = getType();
            if (orderType.equals("cheese")){
                pizza = new CheesePizza();
            }else if (orderType.equals("pepper")){
                pizza = new PepperPizza();
            }else break;
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }

    private String getType(){
        try {
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input pizza type: ");

            return strin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
