package HashTab;

import java.util.Scanner;

/**
 * @author Yan
 * @create 2023-03-27 19:26
 **/
public class hashTableDemo {
    public static void main(String[] args) {
        EmpLinkedList empLinkedList = new EmpLinkedList();
        HashTab hashTab = new HashTab(7);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add：添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("delete：删除雇员");
            System.out.println("exit：退出系统");
            System.out.println("find：查找雇员");
            String key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("请输入id");
                    int i = scanner.nextInt();
                    System.out.println("请输入name");
                    String n = scanner.next();
                    Emp emp = new Emp(i,n);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入id");
                    int id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "delete":
                    System.out.println("请输入id");
                    int d = scanner.nextInt();
                    hashTab.deleteById(d);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }

        }

    }
}
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    public HashTab(int size){
        this.size = size;
        empLinkedListArray = new  EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    public void add(Emp emp){
        int empLinkedListNO = hashFun(emp.id);
        empLinkedListArray[empLinkedListNO].add(emp);
    }
    public void list(){
        for (int i = 0; i < empLinkedListArray.length; i++) {
            empLinkedListArray[i].list(i);
        }
    }
    public void findEmpById(int id){
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if(emp != null){
            System.out.printf("在第%d条链表中找到雇员 id=%d\n",empLinkedListNO+1,id);
        }else {
            System.out.println("未找到！");
        }

    }
    public void deleteById(int id){
        int i = hashFun(id);
        empLinkedListArray[i].deleteById(id);
    }
    public int hashFun(int id){
        return id % size;
    }

}

class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class EmpLinkedList{
    public Emp head;
    public static void test1(){
        System.out.println("1");
    }
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }
    public void list(int no){
        if(head == null){
            System.out.println("第"+(no+1)+"条链表为空!");
            return;
        }
        System.out.print("第"+(no+1)+"条链表的信息为");
        Emp curEmp = head;
        while (true){
            System.out.printf("=> id=%d,=> name=%s\t",curEmp.id,curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表为空！");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;

        }
        return curEmp;
    }
    public void deleteById(int id){
        if(head == null){
            System.out.println("链表为空");
            return;
        }
        int flag = 0;
        Emp curEmp = head;
        while (true){
            if (head.id == id){
                flag = 2;
                head = curEmp.next;
                break;
            }
            if (curEmp.next == null){
                break;
            }
            if (curEmp.next.id == id){
                flag = 1;
                break;
            }
            curEmp = curEmp.next;
        }
        if (flag == 1){
            curEmp.next = curEmp.next.next;
        }
        if (flag == 0){
            System.out.println("未找到！");
        }
    }
}
