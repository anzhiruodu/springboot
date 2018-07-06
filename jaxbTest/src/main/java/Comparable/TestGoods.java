package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestGoods {
    public static void main(String[] args){
        List<Goods> list = new ArrayList<Goods>();
        list.add(new Goods(120,"java实战开发经典100例",1500));
        list.add(new Goods(150,"java从入门到放弃",3000));
        list.add(new Goods(120,"java基础",1800));
        list.add(new Goods(180,"java高级语言",3500));
        list.add(new Goods(150,"c++入门",1000));

        System.out.println("排序前："+list);
        Collections.sort(list,new GodsPrice());
        System.out.println("##########价格排序###############");
        System.out.println("按照价格排序后：\n"+list);


    }
}
