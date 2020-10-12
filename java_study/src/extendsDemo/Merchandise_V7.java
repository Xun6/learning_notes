package extendsDemo;

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
