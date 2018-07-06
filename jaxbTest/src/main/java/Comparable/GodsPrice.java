package Comparable;

public class GodsPrice implements java.util.Comparator<Goods> {

    @Override
    public int compare(Goods o1, Goods o2) {

        return -(o1.getPrice()-o2.getPrice()>0?1:o1.getPrice()-o2.getPrice()==0?0:-1);//默认为升序，前面加负号为降序
    }

}