package hashTable;


public class HashTable {
    private HashLinkedList[] empLinkedList;
    private int size;

    public HashTable(int size) {
        this.empLinkedList = new HashLinkedList[size];
        for (int i = 0; i < size; i++) {
            this.size = size;
            empLinkedList[i] = new HashLinkedList();
        }
    }

    public void add(Emp emp) {
        int number = HashMap(emp.getId());
        empLinkedList[number].add(emp);
    }

    public int HashMap(int number) {
        return number % size;
    }
    public void show(){
        for(int i=0;i<size;i++){
            empLinkedList[i].list(i);
        }
    }
    public void find(int n){
        Emp emps = empLinkedList[HashMap(n)].find(n);
        if(emps!=null){
            System.out.printf("在第%d个链表中找到,其id=%d\n"+HashMap(n)+1,emps.getId());
        }
        else System.out.println("None is found");
    }
}

class Emp {
    private int id;
    private String name;
    public Emp next;

    public Emp(String name, int id) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class HashLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = emp;
    }

    public void list(int index) {
        if (head == null) {
            System.out.println("第"+(index+1)+"个链表为空~~");
            return;
        }
        System.out.printf("第%d个链表的信息为", index +1);
        Emp temp = head;
        while (true) {
            System.out.printf("=> id=%d,name=%s\t\n", temp.getId(), temp.getName());
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }
    public Emp find(int index){
        if(head==null){
            return null;
        }
        Emp emp=head;
        while(true){
            if(emp.next==null){
                emp=null;
                break;
            }
            if(emp.getId()==index)
                break;
            emp=emp.next;
        }
        return emp;
    }
}