package ObjectDemo;

//组装手机  (自定义对象类型运用实例)
public class MyPhoneMaker {
    public static void main(String[] args){
        //创建一个手机对象
        Phone phone = new Phone();

        phone.hasFigurePrintUnlocker = true;
        phone.price = 19999;
        phone.screen = new Screen();
        phone.screen.size = 8.9;
        phone.screen.producer = "京东方";

        //创建对象
        CPU cpu = new CPU();
        cpu.speed = 3.5;
        cpu.producer = "三星";

        //创建对象
        Memory memory = new Memory();
        memory.capacity = 4;
        memory.producer = "三星";

        //创建对象
        Storage storage = new Storage();
        storage.capacity = 128;
        storage.producer = "Intel";

        //引用变量赋值
        phone.mainboard = new Mainboard();
        phone.mainboard.cpu = cpu;
        phone.mainboard.memory = memory;
        phone.mainboard.storage = storage;
        phone.mainboard.model = "A9999";
        phone.mainboard.year = 2020;


    }
}
