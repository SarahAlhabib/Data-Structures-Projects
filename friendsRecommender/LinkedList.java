public class LinkedList<T> implements List<T>{

private Node<T> head;
private Node<T> current;

public LinkedList(){
   head=current=null;
}

public boolean empty(){
   return head==null;
}

public boolean full(){
   return false;
}

public boolean last(){
   return current.next==null;
}

public void findFirst(){
   current=head;
}

public void findNext(){
   current=current.next;
}

public T retrieve(){
   return current.data;
}

public void update(T e){
   current.data=e;
}

public void insert(T e){
   Node<T> tmp;
   if(empty())
      head=current=new Node<T>(e);
   else{
      tmp=current.next;
      current.next=new Node<T>(e);
      current=current.next;
      current.next=tmp;
      }
}

public void remove(){
   if(current==head)
      head=head.next;
   else{
      Node<T> tmp=head;
      while(tmp.next!=current)
         tmp=tmp.next;
      tmp.next=current.next;
      }
   if(current.next==null)
      current=head;
   else
      current=current.next;
 }

public boolean findFirstEle(Cond<T> cnd){

   Node<T> tmp= head;
   if(!empty()){
   while(tmp.next!=null){
      if(cnd.test(tmp.data))
      {  current=tmp;
         return true; }
      tmp=tmp.next;
   }
   if(cnd.test(tmp.data))
      {  current=tmp;
         return true; }}
   return false;
}


public List<T> findAllEle(Cond<T> cnd){
   
   Node<T> tmp=head;
   LinkedList<T> l = new LinkedList<T>();
   if(!empty()){
   while(tmp.next!=null){
      if(cnd.test(tmp.data))
      l.insert(tmp.data);
      tmp=tmp.next;
   }
   
   if(cnd.test(tmp.data))
      l.insert(tmp.data);}
      
   return l;
}
}  


      
   