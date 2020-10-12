package extendsDemo;

public class ShellColorChangePhone extends Phone{
    private boolean enableShellColorChange;

    public ShellColorChangePhone(String name,String id,int count,double soldPrice,double purchasePrice,
                                 double screenSize,double cpuHZ,int memoryG,int storageG,String brand,
                                 String os){
        super(name,id,count,soldPrice,purchasePrice,screenSize,cpuHZ,memoryG,storageG,brand,os);
        enableShellColorChange = false;
    }


    @Override
    public double buy(int count){
        System.out.println("ShellColorChangePhone里的buy(int count):");
        if(count < 2){
            System.out.println("买一送一了解一下，不单卖哦！！！");
            return -3;
        }
        return super.buy(count);
    }
}
