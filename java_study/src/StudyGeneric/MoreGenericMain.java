package StudyGeneric;

import StudyGeneric.example.Children;
import StudyGeneric.example.GrandParent;
import StudyGeneric.example.Parent;
import extendsDemo.GamePointCard;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 */
public class MoreGenericMain {
    public static void main(String[] args){

        List<Children> childrenList = new ArrayList<>();
        // TODO 如下，泛型类型不管继承关系，只管严格的匹配
        // TODO 换句话说，children 是 parent 的子类，但是 List<Children> 不是 List<Parent>的子类
//        parentMathod(childrenList);
        //=================

        extMathod(childrenList);
        // TODO 同样的道理，可以创建协变的引用，使其可以接受List引用的泛型类型为 Parent或他的子类
        List<? extends Parent> parentList = null;
        parentList = new ArrayList<Children>();
        parentList = new ArrayList<Parent>();
//        parentList = new ArrayList<GrandParent>();  // 不可指向其父类

        // TODO 逆变于协变正好相反，语法如下，允许类型为Parent及其父类
        List<? super Parent> list = null;
        list = new ArrayList<Parent>();
        list = new ArrayList<GrandParent>();
//        list = new ArrayList<Children>(); // 不可指向其子类
    }


    // TODO 使用协变声明参数，语法如下，表示这个参数可以接受List引用的泛型类型为 Parent或他的子类
    public static void extMathod(List<? extends Parent> extParame){

    }

    /**
     * Parent类型的元素作为入参
     * @param extparama
     */
    public static void parentMathod(List<Parent> extparama){

    }
}
