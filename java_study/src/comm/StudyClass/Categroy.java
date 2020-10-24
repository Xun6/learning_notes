package comm.StudyClass;

/**
 * 枚举类，定义商品的门类
 */
public enum Categroy {
    //TODO 必须在开始以如下方式创建所有的枚举对象
    FOOD(1),
    COOK(3),
    SNACK(5),
    CLOTHES(7),
    ELECTRIC(9);
    //可以有属性
    private int id;

    //TODO 构造方法必须是private, 不写也默认是 private，不可在外面被调用
    private Categroy(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Categroy{" +
                "id=" + id +
                '}';
    }
}
