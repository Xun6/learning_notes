package StudyCollection;

import java.util.*;

public class WhatIsCollectionAppMain {
    public static void main(String[] args){
//        Collection collection = null;
//        Date date = new Date();
//        MyLinkList myLinkList = new MyLinkList();
//        myLinkList.add(date);


        //----------------------------------

//        printCollection(addElementsToCollection(new ArrayList()));
//        printCollection(addElementsToCollection(new LinkedList()));

        printList((List) addElementsToCollection(new ArrayList()));
        printList((List) addElementsToCollection(new MyLinkList()));

    }

    //添加元素
    public static Collection addElementsToCollection(Collection collection){
        for(int i =0; i < 10; i++){
            collection.add("str" + (i % 5));
        }
        return collection;
    }

    // 输出元素
    public static void printCollection(Collection collection){
        System.out.println();
        System.out.println("输出" + collection.getClass() + "中的元素，共"+ collection.size() + "个");
        try{
            for(Object element : collection) {
                System.out.println(element);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    // 输出元素
    public static void printList(List list){
        System.out.println();
        System.out.println("输出" + list.getClass() + "中的元素，共" + list.size() + "个");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
