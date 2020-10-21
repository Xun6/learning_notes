package extendsDemo;

import java.util.Objects;

public class Merchandise_V7 {
    private String name;  //商品名称
    private String id;   //商品id
    public int count;   //商品数量
    private double soldPrice;   //商品售价
    private double purchasePrice;  //商品进价

    public Merchandise_V7() {
        this("无名", "000", 0, 1, 1.1);

    }
    public Merchandise_V7(String name, String id, int count, double soldPrice, double purchasePrice){
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }

    public void describe() {
        System.out.println("商品名字叫做" + name + "，id是" + id + "。 商品售价是" + soldPrice
                + "。商品进价是" + purchasePrice + "。商品库存量是" + count +
                "。销售一个的毛利润是" + calculateProfit());
    }

    //计算毛利润
    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
//        if(profit <= 0){
//            return 0;
//        }
        return profit;
    }

    public double buy(int count) {
        System.out.println("Merchandise_V7里面的buy(int count):");
        if (this.count < count) {
            System.out.println("购买失败，库存不够");
            return -1;
        }
        this.count -= count;
        double cost = count * soldPrice;
        System.out.println("购买成功，花费为" + cost);
        return cost;
    }

    //重载的buy方法
    public double buy(boolean reallyBuy){
        System.out.println("Merchandise_V7里面的buy(boolean reallyBuy):");
        if(reallyBuy){
            return this.buy(1);
        } else{
            return -1;
        }
    }
    //-------------hashCode 和 equals方法学习
    //TODO hashCode 和 equals是我们最常覆盖的方法
    //TODO 覆盖的原则是，equals为true，hashCode就应该相等，这是一种约定俗成的规范
    //TODO 即equals为true是hashCode相等的充分非必要条件，hashCode相等是equals为true的必要不充分条件

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Merchandise_V7)) return false;
        Merchandise_V7 that = (Merchandise_V7) o;
        return this.getCount() == that.getCount() &&
                Double.compare(that.getSoldPrice(), getSoldPrice()) == 0 &&
                Double.compare(that.getPurchasePrice(), getPurchasePrice()) == 0 &&
                getName().equals(that.getName()) &&
                getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getCount(), getSoldPrice(), getPurchasePrice());
    }

    //------------------新增封装调用方法-----------------------
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }
    public double getSoldPrice(){
        return soldPrice;
    }
    public void setSoldPrice(double soldPrice){
        this.soldPrice = soldPrice;
    }
    public double getPurchasePrice(){
        return purchasePrice;
    }
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

}
