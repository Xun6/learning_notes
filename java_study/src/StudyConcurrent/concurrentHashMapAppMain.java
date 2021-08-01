package StudyConcurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 学习 ConcurrentHashMap 的运用
 */

public class concurrentHashMapAppMain {
    public static void main(String[] args) {
        // TODO ConcurrentHashMap本身对线程并发做了优化，将Map切分为16个segment，相当于一个map有16把锁，各管不同的segment
        Map<String, List<Integer>> map = new ConcurrentHashMap<>();
        String k1 = "k1";

        map.put(k1,new ArrayList<>());
        System.out.println("put:" + map.get(k1));  // 打印出k1的值
        //TODO ConcurrentHashMap 的key和value都不允许为null
//        map.put(null,new ArrayList<>()); //报错
//        map.put("",null); // 报错


        // TODO  putIfAbsent 是在key没有的情况下，才会放入这个 key-value对
        List<Integer> newList = new ArrayList<>();
        newList.add(999);
        map.putIfAbsent(k1,newList); //现在已经有了 k1 ，所以put不进去
        System.out.println("putIfAbsent:" + map.get(k1));

        // 使用lambda 加入一个值
        map.compute(k1,(k,v) ->{
            v.add(1);
            return v;
        });
        System.out.println("compute:"+ map.get(k1));

        // TODO 如果key对应的值存在，则执行lambda
        map.computeIfPresent(k1,(k,v) ->{
            v.add(999);
            return v;
        });
        System.out.println("computeIfPresent:" + map.get(k1));

        // TODO  和 putIfAbsent不一样，lambda里的代码只有在key缺失的情况下才会执行
        // TODO 所以虽然是尝试创建一个超出这个程序允许的内存大小的对象，但是因为已经有这个key了，所以lambda不会执行
        map.computeIfAbsent(k1,(k) -> new ArrayList<>(Integer.MAX_VALUE));
    }
}
