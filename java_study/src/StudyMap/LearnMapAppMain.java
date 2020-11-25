package StudyMap;

import java.util.HashMap;
import java.util.Map;

public class LearnMapAppMain {
    public static void main(String[] args){
        // 初始化的列表长度
        Map<String,String> map = createMap(99);

        // TODO 通过get方法，得到传递的 key 对应的 value
        // TODO 注意：get方法并没有使用泛型，他的类型是Object
        System.out.println(map.get("key20"));

        // TODO 如果没有key，或key对应的值就是null，就返回null
        System.out.println(map.get(new Object()));
        System.out.println(map.get("key999"));

        // TODO 注意：不是每种Map的实现都允许key 和 value 为null
        map.put(null,"value of null key");
        map.put("testnull",null);
        System.out.println("key is null :" + map.get(null));
        System.out.println("value is null :" + map.get("testnull"));
        System.out.println(map.size()); // map的长度

        // TODO 删除 key得值
        System.out.println("-------------如下删除key---------------");
        String beremoved = "key10";
        System.out.println("删除之前得值是：" + map.get(beremoved));
        map.remove(beremoved); //调用删除方法
        System.out.println("删除之后的值是：" + map.get(beremoved));

        // TODO 遍历key 和 value
        System.out.println("---------------如下遍历key 和 value-----------------------");
        //通过Entry类来遍历 Map, entrySet表示健值对, Entry是内部类
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println("key为：" + entry.getKey() + " value为：" + entry.getValue());
        }


        System.out.println("===========如下仅遍历key==============");
        for(String key : map.keySet()){
            System.out.println(key);
        }
        System.out.println("===========如下仅遍历value==============");
        for(String value : map.values()){
            System.out.println(value);
        }

    }


    /**
     * 创建一个 HashMap 实例，按照泛型的定义，存入 key 和 value
     * @param size 列表大小
     * @return  返回列表对象
     */
    public static Map<String,String> createMap(int size){
        Map<String,String> mapList = new HashMap<>();
        for(int i =0; i < size; i++){
            //TODO 加入第一个为 key，第二个为 value
            mapList.put("key" + i,String.valueOf(Math.random()));
        }
        return mapList;
    }
}
