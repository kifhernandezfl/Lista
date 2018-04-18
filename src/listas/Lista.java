package listas;

import java.io.*;

public class Lista 
{
    nodo head = null;
	
    public boolean isEmpty()
    {
        return head == null ? true : false;
	/*
	* if(head == null)
	* 		return true;
	* else 
	* 		return false;
	*/
    }
	
    public void printList()
    {	
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	nodo temp = head;
		
	try
	{   
            bw.write("Grades: \n");
            while(temp!=null)
            {
		bw.write(temp.atoString());
		temp=temp.next;
            }
	bw.flush();
	}
	catch(Exception ex) {ex.printStackTrace();}
    }
	
    public void insertAtBegin(nodo newnodo)
    {
	newnodo.next = head;
	head = newnodo;
    }
	
    public void  insertAtEnd(nodo newnodo)
    {
	if(isEmpty())
            head = newnodo;
	else
	{
            nodo temp = head;
			
            while(temp.next != null)
		temp = temp.next;
			
            temp.next = newnodo;
	}
    }
	
    public void insertAt(nodo newnodo)
    {
        nodo temp = head;
	nodo aft = temp.next;
	newnodo.next = aft;
	temp.next=newnodo;
    }
	
    public void insertAtIndex(nodo newnodo, int index)
    {
	nodo temp = head;
		
	for(int i=0; i<index-1; i++)
            temp = temp.next;
		
	newnodo.next = temp.next;
	temp.next = newnodo;
    }
	
    public void deleteAtBegin()
    {
	nodo temp = head;
	head = head.next;
	temp = null;
	System.gc();
    }
	
    public void deleteAtEnd()
    {
        nodo temp = head;
			
            while(temp.next.next != null)
            {
                temp = temp.next;
            }
     
        temp.next = null;		      
    }
	
    public void deleteAtIndex(int index)
    {
        nodo temp = head;
        nodo toDelete;
		
        for(int i=0; i<index-1; i++)
            temp = temp.next;
		
        toDelete = temp.next;
        temp.next = temp.next.next;
        toDelete = null;
        System.gc();
    }
}