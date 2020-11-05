package extendsDemo;

import ObjectDemo.CPU;
import comm.StudyClass.AbstractExpireDateMerchandise;
import comm.StudyClass.Categroy;
import comm.StudyClass.ExpireDateMerchandise;

import java.util.Date;

/**
 * phone类 继承 Merchandise_V7类
 */
public class Phone extends Merchandise_V7 implements ExpireDateMerchandise {
    private Date produceDate;
    private Date expirationDate;
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
    private double speeds;
    // TODO 用 final 修饰引用，最难理解
    private final Merchandise_V7 gift;
    //--新增静态内部类---------------------
    private CPU cpu;

    //----新增接口引用变量----
    private extendsDemo.UnitSpec cpuu;

    //==基本方法===
    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public extendsDemo.UnitSpec getCpuu() {
        return cpuu;
    }

    public void setCpuu(extendsDemo.UnitSpec cpuu) {
        this.cpuu = cpuu;
    }



    //TODO 接口可以定义为静态内部接口------------------
    public static interface UnitSpec{
        public double getNumSpec();

        public String getProducer();
    }
    //TODO 静态内部类，就是在类中使用static修饰的类
    //TODO 静态内部类和静态方法，静态变量一样，都是类的静态组成部分
    //TODO 静态内部类也是类，在继承、实现接口方面都是一样的。
    public static class CPU {
        private double speed;
        private String producer;

        //构造方法
        public CPU(double speed,String producer){
            this.speed = speed;
            this.producer = producer;
        }

        //getter\setter方法
        public double getSpeed(){
            //静态内部类还可以调用外部类（phone）中的 private的属性
            Phone phone = null;
            phone.memoryG = 99;
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public String getProducer() {
            return producer;
        }

        public void setProducer(String producer) {
            this.producer = producer;
        }

        //toString方法
        @Override
        public String toString() {
            return "CPU{" +
                    "speed=" + speed +
                    ", producer='" + producer + '\'' +
                    '}';
        }
    }

    public void useStaticClass(){
        //TODO 外部类也可以访问静态内部类中的 private属性
        this.cpu.producer = "";
    }

    public Phone(String name, String id, int count, double soldPrice, double purchasePrice, Categroy categroy,
                 double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os, Merchandise_V7 gift){

        super(name,id,count,soldPrice,purchasePrice,categroy);
        this.screenSize = screenSize;
        //在外部构造方法内new 静态内部类的实例
        this.cpu = new CPU(cpuHZ,"default");
        this.cpuHZ = cpuHZ;
        this.memoryG = memoryG;
        this.storageG = storageG;
        this.brand = brand;
        this.os = os;
        this.gift = gift;

        //---新增局部变量--
        double localCpuHZ = cpuHZ;


        //TODO =====匿名类语法,实现接口内的抽象方法，类似new出一个对象==========
        //TODO 语法如下：new后面跟着一个接口 或 抽象类
        this.cpuu = new extendsDemo.UnitSpec() {
            @Override
            public double getNumSpec() {
                return 0;
            }

            @Override
            public String getProducer() {
                return "default";
            }
        };

        //================实现接口======
        //TODO 局部内部类，是在类的方法中直接定义类
        //TODO 局部内部类，不可以包含任何静态的成分
        //TODO 局部内部类，不可以有访问控制符
//        class CPUU implements UnitSpec{
//            //可以final static 基本数据类型变量
//            final static int abc = 999;
//            private String producer;
//
//            //构造方法
//            public CPUU(String producer){
//                this.producer = producer;
//            }
//            @Override
//            public double getNumSpec() {
//                //仅做数据演示，无实际意义
//                //TODO 局部内部类可以访问参数和局部变量，但是它俩必须是实际final的，即不能再对他赋值
//                return Math.max(Phone.this.speeds,Math.max(cpuHZ,localCpuHZ));
//            }
//
//            @Override
//            public String getProducer() {
//                return producer;
//            }
//        }

//        this.setName(name);
//        this.setId(id);
//        this.setCount(count);
//        this.setSoldPrice(soldPrice);
//        this.setPurchasePrice(purchasePrice);
    }

    //-----实现的一个 AbstractExpireDateMerchandise类的抽象方法-----
//    @Override
//    public double actualValuesNow(double leftDatePercentage) {
//        return getSoldPrice() * (leftDatePercentage + 0.5);
//    }

    //-----实现接口的方法----
    @Override
    public Date getProduceDate() {
        return produceDate;
    }

    @Override
    public Date getExpireDate() {
        return expirationDate;
    }

//    @Override
//    public double leftDatePercentage() {
//        return 0;
//    }

    @Override
    public double actualValuesNow(double leftDatePercentage) {
        return 0;
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
                "cpu信息" + cpu +
                "\ncpu主频："+cpuHZ + "GHz\n"+
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



// >> TODO 非公有类，不能访问类的 private的属性
class Memory{
    private long capacity;
    private String producer;

    //构造方法
    public Memory(long capacity,String producer){
        this.capacity = capacity;
        this.producer = producer;
    }

    public void test(){
        //不能访问类的 private属性
//        Phone p = null;
//        p.MemoryG = 9;
    }

    //getter/setter方法

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
