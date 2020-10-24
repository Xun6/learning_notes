package extendsDemo;

import comm.StudyClass.Categroy;

public class ShellColorChangePhone extends Phone{
    private boolean enableShellColorChange;

    public ShellColorChangePhone(String name, String id, int count, double soldPrice, double purchasePrice, Categroy categroy,
                                 double screenSize, double cpuHZ, int memoryG, int storageG, String brand,
                                 String os, Merchandise_V7 gift){
        super(name,id,count,soldPrice,purchasePrice,categroy,screenSize,cpuHZ,memoryG,storageG,brand,os,gift);
        enableShellColorChange = false;
    }

    public boolean isEnableShellColorChange(){
        return enableShellColorChange;
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
