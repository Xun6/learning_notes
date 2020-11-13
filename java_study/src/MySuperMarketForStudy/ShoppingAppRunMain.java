package MySuperMarketForStudy;

import MySuperMarketForStudy.implement.SimpleShopMan;
import MySuperMarketForStudy.interfaces.Customer;
import MySuperMarketForStudy.interfaces.ShopMan;
import MySuperMarketForStudy.interfaces.SuperMarket;

import static MySuperMarketForStudy.util.ShoppingUtil.*;

/**
 * 主程序运行
 */
public class ShoppingAppRunMain {
    public static void main(String[] args){
        // 创建一个超市
        SuperMarket superMarket = createSuperMarket();

        // 创建一个服务员
        ShopMan shopMan = new SimpleShopMan(superMarket);

        boolean open = true;
        // 是否开业
        while(open){
            // 实例化服务任务,并进行服务
            new ShoppingTask(shopMan).executeTask();
            output("是否想继续营业 ？(any others/no)");
            // 若输入在忽略空格/大小写的情况下不是 no，就继续营业 ！！！
            open = !input().next().trim().equalsIgnoreCase("no");
        }
        //打印营业清单
        superMarket.dailyReport();
    }
}



// 非公有类
class ShoppingTask{
    // 定义服务员变量
    private ShopMan shopMan;

    //构造方法
    public ShoppingTask(ShopMan shopMan){
        this.shopMan = shopMan;
    }

    // 服务顾客
    public void executeTask(){
        // 创建一个随机顾客
        Customer customer = createCustomer(true);
        //调取服务方法
        shopMan.serverCustomer(customer);
    }
}
