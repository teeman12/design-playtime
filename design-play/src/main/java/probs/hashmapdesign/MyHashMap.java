package probs.hashmapdesign;

import java.util.ArrayList;
import java.util.List;


public class MyHashMap<K extends MyKey,V>  {

    int size;
    List<Node<K,V>> buckets;
    PairList<K,V> pairList;

    public MyHashMap() {
        buckets = new ArrayList<>(100);
        size = buckets.size();
        pairList = new PairList<>();
        for(int i=0; i< size; i++){
            buckets.set(i, new Node<K,V>(null, null));
        }

    }

    public void add(K key, V value){
        Node<K, V> node = searchNode(key);
        if(node != null){
            node.setValue(value);
        }
        else{
            int ix = key.hashCode()%size;
            Node<K,V> nNode = new Node<>(key, value);
            nNode.setNext(buckets.get(ix));
            buckets.set(ix, nNode);
            pairList.add(nNode.getlNode());
        }
    }

    public V search(K key) {
        Node<K, V> node = searchNode(key);
        if (node == null) {
            return null;
        }
        return node.getValue();
    }

    public List<K> getKeys(){
        return pairList.getKeys();
    }

    public List<V> getValues(){
        return  pairList.getValues();
    }

    // todo: add delete function as well
    //make PairList as DLL for delete
    //public void delete(K k) { }
    private Node<K,V> searchNode(K key){
        int ix = key.hashCode()%size;
        Node<K,V> node = buckets.get(ix);
        while(node!= null && ! key.equals(node.getKey())){
            node = node.getNext();
        }

        return  node;
    }




    private static class Node<MK extends MyKey, MV>{
        private LNode<MK,MV> lNode;
        private Node<MK,MV> next;

        public Node(MK key, MV value) {
            lNode = new LNode<>(key, value);

        }

        public MK getKey() {
            return lNode.getKey();
        }

        public MV getValue() {
            return lNode.getValue();
        }

        public void setValue(MV value) {
            lNode.setValue(value);
        }


        public Node<MK,MV> getNext() {
            return next;
        }

        public void setNext(Node<MK,MV> next) {
            this.next = next;
        }

        public LNode<MK, MV> getlNode() {
            return lNode;
        }
    }

    private static class LNode<MK extends MyKey, MV>{
        private MK key;
        private MV value;
        private LNode<MK,MV> next;

        public LNode(MK key, MV value) {
            this.key = key;
            this.value = value;
        }

        public MK getKey() {
            return key;
        }

        public void setKey(MK key) {
            this.key = key;
        }

        public MV getValue() {
            return value;
        }

        public void setValue(MV value) {
            this.value = value;
        }

        public LNode<MK, MV> getNext() {
            return next;
        }

        public void setNext(LNode<MK, MV> next) {
            this.next = next;
        }
    }

    private static class PairList<MK extends MyKey,MV> {
        private LNode<MK,MV> head;

        void add(LNode<MK,MV> node){
            if(head==null){
                head = node;
            }
            else {
                node.setNext(head);
                head = node;
            }
        }

        List<MK> getKeys(){
            List<MK> keys = new ArrayList<>();
            LNode<MK,MV> curNode = head;
            while(curNode!=null){
                keys.add(curNode.getKey());
            }

            return keys;
        }

        List<MV> getValues(){
            List<MV> values = new ArrayList<>();
            LNode<MK,MV> curNode = head;
            while(curNode!=null){
                values.add(curNode.getValue());
            }

            return values;
        }
    }

}
