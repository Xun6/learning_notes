package MySuperMarketForStudy.implement;

import MySuperMarketForStudy.interfaces.*;

import static MySuperMarketForStudy.util.ShoppingUtil.output;

/**
 * 服务员实现类
 */
public class SimpleShopMan implements ShopMan {
    //定义引用变量
    private SuperMarket superMarket;

    private static final int MAX_BUY_DEFAULT = 9; // 定义静态变量，给一个缺省值

    /**
     * 构造方法，带参数
     * @param superMarket 超市，表示明确服务员在哪个超市工作
     */
    public SimpleShopMan(SuperMarket superMarket){
        this.superMarket = superMarket;
    }


    // 实现接口的方法
    @Override
    public void serverCustomer(Customer customer) {
        int maxTypeToBuy = MAX_BUY_DEFAULT; // 缺省默认值
        //明确顾客逛的 商品种树
        if(customer instanceof absCustomer){
            maxTypeToBuy = ((absCustomer) customer).getGuangCount(); //若缺省，使用定义的缺省值
        }
        //初始化，购物车大小
        ShoppingCar shoppingCar = new ShoppingCar(maxTypeToBuy);
        //调用开始购买前的方法
        customer.startShopping();

        //服务顾客购买商品(满足条件：顾客不想结账 且 购物车还没满)
        while(!customer.wantToCheckout() && shoppingCar.canHold()){
            Category category = customer.chooseCategory(); // 询问顾客选择的商品类别
            // 没选类别，继续询问
            if(category == null){
                continue;
            }
            // 选择类别后，随机挑选几件商品出来
            Merchandise[] toChoose = superMarket.getRandomMerchandiseOfCategory(category);
            //遍历商品，推荐顾客购买
            for(Merchandise m : toChoose){
                if(m == null){
                   continue;
                }
                // 保存顾客购买商品数
                int buyCount = customer.buyMerchandise(m);
                if (buyCount > 0){
                    //加入购物车,并购买，一个类别只买一个
                    shoppingCar.add(m,buyCount);
                    break;
                }
            }
        }


        //结算
        double oringinCost = shoppingCar.calculateOriginCost();  // 原始花费
        double finalCost = oringinCost; // 最终花费

        double savedMoney = 0;  // 节省多少钱
        //判断顾客是否是有会员卡的
        if(customer instanceof HasCard){
            Card card = ((HasCard) customer).getCard();  // 取出顾客的会员卡
            // 调用方法计算节省的金额
            savedMoney = card.processCardDiscount(oringinCost,finalCost,customer,shoppingCar);
            finalCost -= savedMoney;
        }

        // 顾客支付的金额
        double earnMoney = customer.payFor(shoppingCar,finalCost);

        // 加入超市的收入里
        superMarket.addEarnedMoney(earnMoney);

        //打印小票
        output("顾客：" + customer.getCustId() + " 的购物清单如下：");
        output(shoppingCar.toString());
        output("优惠金额为：" + savedMoney);
        output("实付金额为：" + earnMoney);
    }
}
