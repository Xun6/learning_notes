package StudyCollection;

import java.util.*;

/**
 * 使用引用实现 List 接口
 */
public class MyLinkList implements List {

    //使用静态内部类，抽象出链表中的一个节点
    static class ListNode{
        ListNode prev;
        ListNode next;
        Object value;

        // 静态内部类的构造方法
        public ListNode(ListNode prev,ListNode next,Object value){
            this.prev = prev; // 表示链表中前一个元素
            this.next = next; // 表示链表中后一个元素
            this.value = value; // 表示链表中当前元素
        }
    }

    private ListNode start = null; // 表示链表开始的元素
    private ListNode tail = null;  // 表示链表最后的元素
    private int size = 0;  //表示链表元素计数

    // 实现接口的方法
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        ListNode curr = start;  // 表示从开始元素开始
        // 循环匹配
        while(curr != null){
            if(Objects.equals(curr.value,o)){
                return true;
            }
            curr = curr.next; // 表示赋值给下一个，继续匹配
        }

        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        // 新建一个元素node
        ListNode NewList = new ListNode(tail,null,o);
        System.out.println(NewList);
        if(start == null){
            start = NewList;
        }

        if(tail != null){
            tail.next = NewList;
        }
        tail = NewList;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        start = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        // 如果不符合索引范围，抛出异常
        if(index > size || index <0){
            throw new IndexOutOfBoundsException("out of bound " + size + " for " + index );
        }
        ListNode cur = start;  // 表示从开始元素进行匹配
        for(int i =0; i < index; i++){
            cur = cur.next;
        }
        return cur.value; // 返回当前元素
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
