package comm.StudyClass;

import extendsDemo.Merchandise_V7;

import java.util.Date;

//TODO 抽象类用abstract修饰，抽象类可以继承别的类或抽象类，也可以实现接口
//TODO 抽象类可以有抽象方法也可以没有，抽象方法可以来自实现的接口，也可以自定义
//TODO 抽象类不可以被实例化
public abstract class AbstractExpireDateMerchandise extends Merchandise_V7 implements ExpireDateMerchandise {
    private Date produceDate;
    private Date expirationDate;

    //构造方法
    public AbstractExpireDateMerchandise(String name,String id,int count,double soldPrice,double purchasePrice,
                                         Date produceDate,Date expirationDate){
        super(name,id,count,soldPrice,purchasePrice);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
    }

    public AbstractExpireDateMerchandise(Date produceDate,Date expirationDate){
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
    }

    public AbstractExpireDateMerchandise(String name, String id, int count, double soldPrice, double purchasePrice) {
        super(name,id,count,soldPrice,purchasePrice);
    }
    public AbstractExpireDateMerchandise(String name, String id, int count, double soldPrice, double purchasePrice,Categroy categroy) {
        super(name,id,count,soldPrice,purchasePrice,categroy);
    }


    public boolean notExpireInDays(int days) {
        return daysBeforeExpire() > days;  //剩余保质期是否大于 参数值
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public Date getExpireDate() {
        return expirationDate;
    }

    public double leftDatePercentage() {
        return 0;
    }

    public double actualValuesNow(double leftDatePercentage) {
        return getSoldPrice();
    }

//-----------------------------
    /**
     *
     * @return
     */
    private long daysBeforeExpire(){
        long expireTime = expirationDate.getTime(); //获取过期时间，单位 毫秒
        long left = expireTime - System.currentTimeMillis();  //剩余保质期时间，单位毫秒
        if(left < 0){
            return -1;
        }
        //计算剩余保质期天数
        return left/(24 * 3600 * 1000);
    }

    /**
     *
     * @return
     */
    private long daysAfterProduce(){
        long ProduceTime = produceDate.getTime(); //获取过期时间，单位 毫秒
        long past = System.currentTimeMillis() - ProduceTime;  //单位毫秒
        if(past < 0){
            return -2;
        }
        //计算剩余保质期天数
        return past / (24 * 3600 * 1000);
    }

}
