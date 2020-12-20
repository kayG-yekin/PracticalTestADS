import java.util.*;
public class SequentialSearch<Key, Value> {
   
    private int size;
    private Node head;


    private class Node {
        private Key key;           
        private Value val;
        private Node next;  

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next ;
            
        }
    }
    public SequentialSearch() {
        size=0;
        head = null; 
     }

   
    public int size() {
        return size;
    }

   
    public boolean isEmpty() {
        if(size==0)
        {
            return true;
        }
        return false;
    }

    
    public boolean contains(Key key) {
        if(key==null)
        throw new IllegalArgumentException("You fool!! issa error");
       
         else if(get(key)==null)
            {
                return false;
            }
        return true;
        
    }

    
    public Value get(Key key) {
        for(Node x=head;x!=null;x=x.next){
              if (key == x.key) 
                return x.val;
        }
        return null;
        }
    

   
    public void put(Key key, Value val) {
       if (key == null) {
            System.out.println("Key cannot be null");
            return; 
          
        }
        Node newest = new Node(key,val,null);
        if(head==null)
            {
                head=newest;
                size++;
            }
        else if(head.next==null || head.next!=null){
            for (Node x = head; x != null; x = x.next) {
            if (key==x.key) {
                x.val = val;
                return;
            }
        }
        newest.next=head;
        head=newest;
        size++;
    }

}

    
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null"); 
        head = delete(head, key);
        
    }

   
    private Node delete(Node x, Key key) {
     if (x == null) 
            return null;
        if (x.key==key) {
            size--;  
            return x.next; 
        }
        x.next = delete(x.next, key);
        return x;

    
    }

    
    public Iterable<Key> keys()  {
        LinkedList<Key> link = new LinkedList<Key>();
        for (Node x = head; x != null; x = x.next)
        link.add(x.key);
        return link; 
    }
   
    public static void main(String[] args) {
        SequentialSearch<String, Integer> obj = new SequentialSearch<String, Integer>();
       
        System.out.println(obj.isEmpty());
        obj.put("Agile",2);
        obj.put("Bosque",4);
        System.out.println(obj.get("Agile"));

        obj.put("Exo",6);
        obj.put("Java",5);
        System.out.println(obj.isEmpty());
        System.out.println(obj.size());
        System.out.println(obj.contains("Scripts"));
        System.out.println(obj.keys());

        obj.put("Crystal",1);
        System.out.println(obj.size());
        obj.put("Java",8);
        obj.put("Dylan",7);

        System.out.println(obj.get("Java"));
        System.out.println(obj.contains("Crystal"));

        obj.delete("Bosque");
        System.out.println(obj.keys());

    }
}

   

