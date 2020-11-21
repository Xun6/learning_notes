package StudyGeneric;

/**
 * 自定义的泛型约束类
 */
public class MyGenericClass<First,Second> {
    // 定义变量
    //TODO 实际两个引用都是object类型的
    private First first;
    private Second second;

    // 构造方法
    public MyGenericClass(First first,Second second){
        this.first = first;
        this.second = second;
    }

    // 基本方法

    public First getFrist() {
        return first;
    }

    public void setFrist(First frist) {
        this.first = frist;
    }

    public Second getSecond() {
        return second;
    }

    public void setSecond(Second second) {
        this.second = second;
    }


    // 自定义的泛型约束方法
    public <Another> Another getAnother(Object o){
        return (Another) o;
    }
}
