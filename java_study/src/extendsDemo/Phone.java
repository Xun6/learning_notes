package extendsDemo;

import comm.StudyClass.AbstractExpireDateMerchandise;
import comm.StudyClass.Categroy;

import java.util.Date;

/**
 * phone类 继承 Merchandise_V7类
 */
public class Phone extends AbstractExpireDateMerchandise {
    //给phone的特有属性
//    private double screenSize;
//    private double cpuHZ;
    // TODO protected可见性 = defualt + 对子类可见
    protected double screenSize;
    protected double cpuHZ;
    private int memoryG;
    private int storageG;
    private String brand;
    private String os;
    private static int MAX_BUY_ONE_ORDER = 5;    //类变量
    // TODO 用 final 修饰引用，最难理解
    private final Merchandise_V7 gift;

    public Phone(String name, String id, int count, double soldPrice, double purchasePrice, Categroy categroy,
                 double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os, Merchandise_V7 gift){

        super(name,id,count,soldPrice,purchasePrice,categroy);
        this.screenSize = screenSize;
        this.cpuHZ = cpuHZ;
        this.memoryG = memoryG;
        this.storageG = storageG;
        this.brand = brand;
        this.os = os;
        this.gift = gift;

//        this.setName(name);
//        this.setId(id);
//        this.setCount(count);
//        this.setSoldPrice(soldPrice);
//        this.setPurchasePrice(purchasePrice);
    }

    //-----实现的一个 AbstractExpireDateMerchandise类的抽象方法-----
    @Override
    public double actualValuesNow(double leftDatePercentage) {
        return getSoldPrice() * (leftDatePercentage + 0.5);
    }

    //一些基本方法
    public boolean meetCondition() {
        return true;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getCpuHZ() {
        return cpuHZ;
    }

    public void setCpuHZ(double cpuHZ) {
        this.cpuHZ = cpuHZ;
    }

    public int getMemoryG() {
        return memoryG;
    }

    public void setMemoryG(int memoryG) {
        this.memoryG = memoryG;
    }

    public int getStorageG() {
        return storageG;
    }

    public void setStorageG(int storageG) {
        this.storageG = storageG;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

//    public void setGift(Merchandise_V7 gift){
//        this.gift = gift;
//    }
    public Merchandise_V7 getGift(){
        return gift;
    }

    public String getName(){
        return this.brand + ":" + this.os + ":" + super.getName();
    }

    //商品描述
    public void describePhone(){
        System.out.println("此手机商品属性如下：");
//        descript();
        System.out.println("手机厂商为："+brand + ";系统为："+os+";硬件配置：\n"+
                "屏幕："+ screenSize +"寸\n" +
                "cpu主频："+cpuHZ + "GHz\n"+
                "内存"+memoryG+"G\n"+
                "存储空间"+storageG+"Gb\n");
    }

    // >> TODO 通过使用和父类方法签名一样，而且返回值也必须一样的方法，可以让子类覆盖掉(override)父类的方法。
    // TODO 也就是说，子类并不是只能把父类的方法拿过来，而且可以通过覆盖来替换其中不合适子类的方法

    public double buy(int count){
        System.out.println("Phone里面的buy(int count):");
        if(count > MAX_BUY_ONE_ORDER){
            System.out.println("购买失败，一次最多能购买"+ MAX_BUY_ONE_ORDER + "个");
            return -2;  //给前端判断的状态
        }
        return super.buy(count);

//        if(this.count < count){
//            System.out.println("购买失败，库存不足！");
//            return -1;
//        }
//        this.count -= count;
//        double cost = count * getSoldPrice();
//        System.out.println("共花费：" + cost);
//        return cost;
    }
}
