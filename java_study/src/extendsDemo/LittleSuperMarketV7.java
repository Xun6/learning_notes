package extendsDemo;



/** 一个小超市类 */
public class LittleSuperMarketV7 {
    public String superMarketName;    //超市名称
    public String address;    //超市地址
    public int parkingCount;   //停车位数量
    public double incomingSum;   //收入总和
    public Merchandise_V7[] merchandisesV7;   //商品数组
    public int[] merchandiseSold;  //对应商品售卖数数组

    /**
     * 初始化小超市
     * @param superMarketName
     * @param address
     * @param parkingCount
     * @param merchandiseCount 商品种类数
     * @param count  每种商品缺省库存
     */
    public LittleSuperMarketV7(String superMarketName,String address,int parkingCount,int merchandiseCount,
                               int count){
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;

        //初始化新增手机赠品
        Merchandise_V7 giftForPhone = new Merchandise_V7(
                "手机赠品-64G储存卡",
                "GIFT001",
                1,
                120,
                60
        );

        merchandisesV7 = new Merchandise_V7[merchandiseCount];
        for(int i=0; i <merchandisesV7.length; i++){
            //创建手机，手机壳变色手机，和普通商品都放在商品数组
            Merchandise_V7 m = null;
            if(i >0 & i%100 ==0){
                m = new ShellColorChangePhone(
                        "商品"+i,
                        "ID"+i,
                        count,
                        1999,
                        999,
                        4.5,
                        3.5,
                        4,
                        128,
                        "三星",
                        "Android",
                        giftForPhone
                );
            } else if (i >0 & i%10 == 0) {
                m = new Phone(
                        "商品" + i,
                        "ID"+ i,
                        count,
                        1999,
                        999,
                        4.5,
                        3.5,
                        4,
                        128,
                        "索尼",
                        "Android",
                        giftForPhone
                );
            } else {
                double purchasePrice = Math.random() * 200;
                m = new Merchandise_V7(
                        "商品" + i,
                        "ID" + i,
                        count,
                        purchasePrice * (1 + Math.random()),
                        purchasePrice
                );
            }
            //用创建商品，给商品数组的第i个引用赋值
            merchandisesV7[i] = m;
        }
        merchandiseSold = new int[merchandisesV7.length];
    }

    // 简单的访问成员变量

    public String getSuperMarketName() {
        return superMarketName;
    }

    public String getAddress() {
        return address;
    }

    public int getParkingCount() {
        return parkingCount;
    }

    public double getIncomingSum() {
        return incomingSum;
    }

    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setParkingCount(int parkingCount) {
        this.parkingCount = parkingCount;
    }

    public void setIncomingSum(double incomingSum) {
        this.incomingSum = incomingSum;
    }

    public void setMerchandises(Merchandise_V7[] merchandises) {
        this.merchandisesV7 = merchandises;
    }

    public void setMerchandiseSold(int[] merchandiseSold) {
        this.merchandiseSold = merchandiseSold;
    }

    //一些特殊的逻辑

    /**
     * 得到利润最高的商品
     * @return
     */
    public Merchandise_V7 getBiggestProfitMerchandise(){
        Merchandise_V7 curr = null;
        for(int i = 0; i < merchandisesV7.length; i++){
            Merchandise_V7 m = merchandisesV7[i];
            if(curr == null || curr.calculateProfit() < m.calculateProfit()){
                curr = m;
            }
        }
        return curr;
    }

    /**
     * 根据索引获取商品
     * @param merchandiseIndex
     * @return
     */
    public Merchandise_V7 getMerchandiseOf(int merchandiseIndex){
        if(merchandiseIndex < 0 || merchandiseIndex >= merchandisesV7.length){
            return null;
        }
        return merchandisesV7[merchandiseIndex];
    }

    /**
     * 赚钱
     * @param toBeAdded
     */
    public void addIncomingSum(double toBeAdded){
        this.incomingSum += toBeAdded;
    }

    /**
     * 花钱
     * @param toBeSpent
     * @return
     */
    public boolean spendMoney(double toBeSpent){
        if(toBeSpent > incomingSum){
            return false;
        }
        incomingSum -= toBeSpent;
        return true;
    }
}
