/**
 * DLList
 *
 * @author Wangkun
 * @create 2021-01-26-21:47
 **/
public class LinkedListDeque<GeneList> {
    private int size = 0;
    private DLList sentinel;
    private DLList sentFront = new DLList(null,null,null);
    private DLList sentBack = new DLList(null,null,null);
    private DLList gr;
    public class DLList{
        public GeneList item;
        public DLList prev, next;
        public DLList(GeneList x, DLList pre, DLList n){
            item = x;
            prev = pre;
            next = n;
        }
    }
    public LinkedListDeque(){
        size = 0;
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
    }
    public LinkedListDeque(GeneList item){
        sentFront.next = new DLList(item, sentFront, sentBack);
        sentBack.prev = sentFront.next;
        size = 1;
    }
    public void addFirst(GeneList item){
        sentFront.next.prev = new DLList(item, sentFront, sentFront.next);
        sentFront.next = sentFront.next.prev;
        size = size + 1;
        gr = sentFront;
    }
    public void addLast(GeneList item){
        sentBack.prev.next = new DLList(item, sentBack.prev, sentBack);
        sentBack.prev = sentBack.prev.next;
        size = size + 1;
    }
    public boolean isEmpty(){
        return size != 0;    //if size = 0, then 0 != 0 is false;
                             // if size > 0,then proper int > 0 is true;
    }
    public int size() {
        return size;
    }
    public void printDeque(){

    }
    public DLList removeFirst(){
        if (size == 0){
            return null;
        }
        DLList firstRemove;
        firstRemove = sentFront.next;
        sentFront.next = sentFront.next.next;
        sentFront.next.prev = sentFront;
        gr = sentFront;
        return firstRemove;

    }
    public DLList removeLast(){
        if (size == 0){
            return null;
        }
        DLList lastRemove;
        lastRemove = sentBack.prev;
        sentBack.prev = sentBack.prev.prev;
        sentBack.prev.next = sentBack;
        return lastRemove;
    }
    public DLList get(int index){
        if ((index + 1) > size){
            return null;
        }
        int i = 0;
        DLList getindex = sentFront;
        while (i <= index){
            getindex = getindex.next;
            i = i + 1;
        }
        return getindex;
    }
    public DLList getRecursive(int index){
        if ((index + 1) > size){
            return null;
        }
        if (index == 0){
            return gr.next;
        } else{
            gr = gr.next;
            return getRecursive(index - 1);
        }

    }

}
