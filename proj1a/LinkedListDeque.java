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
    private DLList gr = sentFront;

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
        DLList semi = new DLList(item, sentFront, sentFront.next);
        DLList sfn = sentFront.next;
        sfn.prev = semi;
        sentFront.next = semi;
        size = size + 1;
    }
    public void addLast(GeneList item){

        DLList semi = new DLList(item, sentBack.prev, sentBack);
        DLList sbp = sentBack.prev;
        sbp.next = semi;
        sentBack.prev = semi;
        size = size + 1;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque(){
        int i = 0;
        DLList pd = sentFront;
        while (i < size){
            System.out.print(" " + pd.next.item + " ");
            pd = pd.next;
            i = i + 1;
        }
    }
    public GeneList removeFirst(){
        if (size == 0){
            return null;
        }
        DLList firstRemove = sentFront.next;
        DLList sfnn = sentFront.next.next;
        sentFront.next = sfnn;
        sfnn.prev = sentFront;
        size = size - 1;
        return firstRemove.item;

    }
    public GeneList removeLast(){
        if (size == 0){
            return null;
        }
        DLList lastRemove = sentBack.prev;
        DLList sbpp = sentBack.prev.prev;
        sbpp.next = sentBack;
        sentBack.prev = sbpp;
        size = size - 1;
        return lastRemove.item;
    }
    public GeneList get(int index){
        if ((index + 1) > size){
            return null;
        }
        int i = 0;
        DLList getindex = sentFront;
        while (i <= index){
            getindex = getindex.next;
            i = i + 1;
        }
        return getindex.item;
    }
    public GeneList getRecursive(int index){

        if ((index + 1) > size){
            return null;
        }
        if (index == 0){
            GeneList gene = gr.next.item;
            gr = sentFront;
            return gene;
        }
        gr = gr.next;
        return getRecursive(index - 1);
    }

}
