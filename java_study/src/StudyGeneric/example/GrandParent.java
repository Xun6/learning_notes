package StudyGeneric.example;

public class GrandParent {
    private int num;

    //构造方法
    public GrandParent(int num){
        this.num = num;
    }
    public GrandParent(){
        this(-1);
    }

    //基本方法

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
