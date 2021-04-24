package StudyTimedTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class LearnDate {
    public static void main(String[] args) {
        operateTime(); // 操作时间

        initCalendar(); // 自定义时间

        setTimeManually(); // 人为手动设置时间
    }

    private static void setTimeManually() {
        Calendar c2 = Calendar.getInstance();
        // 人为设置一个时间（年月日时分秒）
        c2.set(2021,Calendar.THURSDAY,20,21,36,58);
        Date d = c2.getTime();
        System.out.println(d);

        // TODO SimpleDateFormat不是线程安全的，对线程共用一个 instance会有问题
        // 指定日期显示格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒", Locale.SIMPLIFIED_CHINESE);
        System.out.println(sdf.format(d));
    }

    private static void initCalendar() {
        Calendar c1 = Calendar.getInstance();
        // 设置一个毫秒单位时间
        c1.setTimeInMillis(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(10));
        // 也可设置一个给定的时间
        c1.setTime(new Date());
    }

    private static void operateTime() {
        // TODO 获取 Calendar实例，默认当前时间
        Calendar calendar = Calendar.getInstance();
        System.out.println();
        System.out.println(calendar);
        // TODO 可以对时间进行加减
        calendar.add(Calendar.DAY_OF_YEAR,100); // 加上100天
        calendar.add(Calendar.MINUTE,100); // 加上100分钟
        // TODO 方便得到 Date对象
        Date date = calendar.getTime();
        System.out.println(date);
    }
}
