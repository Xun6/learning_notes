package extendsDemo;

/**
 * 定义一个抽象类
 */
public abstract class UnitSpecAbs {
    private double spec;
    private String produceStr;

    //构造方法
    public UnitSpecAbs(double spec,String produceStr){
        this.spec = spec;
        this.produceStr = produceStr;
    }

    //基本方法

    public double getSpec() {
        return spec;
    }

    public void setSpec(double spec) {
        this.spec = spec;
    }

    public String getProduceStr() {
        return produceStr;
    }

    public void setProduceStr(String produceStr) {
        this.produceStr = produceStr;
    }

    //抽象方法
    public abstract double getNumSpec();

    public abstract String getProducer();

}
