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
	
    public int length() // tamaño de la lista
    {
	int counter = 0;
	nodo temp = head;
		
	while(temp != null)
	{
            counter += 1;
            temp = temp.next;
	}
		
	return counter;
    }
    
    public nodo get(int index)
    {
	if(index < this.length())
	{
            nodo temp = head;
			
            for(int i = 0; i < index; i++)
		temp = temp.next;
			
            return temp;
	}
		
	return null;
    }
	
    public nodo binarySearch(int value, int lowerBound, int upperBound)
    {
	int middleElement = (lowerBound + upperBound)/2;
	int tempId = get(middleElement).id;
		
	ñif(lowerBound == upperBound)
	{
            if(tempId == value)
		return get(middleElement);
            else
		return null;
	}else
	{
            if(tempId == value)
		return get(middleElement);
            else
		if(value < tempId)
                    return binarySearch(value, lowerBound, middleElement);
		else
                    return binarySearch(value,  middleElement + 1, upperBound);
	} 
    }
    
    public Lista quickSort(Lista unsorted)
    {
    	if(unsorted.length() <= 1)
	    return unsorted;
	else
	{
            nodo pivot = unsorted.head;
            Lista less_sublist = new Lista();
            Lista greater_sublist = new Lista();
	    		
	    nodo temp = unsorted.head.next; 
	    while(temp != null)
	    {
	    	if(temp.id < pivot.id)
                    less_sublist.insertAtEnd(temp.clone());
	    	else
                    greater_sublist.insertAtEnd(temp.clone());
	    		
	    	temp = temp.next;
            }
	    		
	    less_sublist = quickSort(less_sublist);
            greater_sublist = quickSort(greater_sublist);
	    		
	    pivot.next = greater_sublist.head;
	    less_sublist.insertAtEnd(pivot);
	    return less_sublist;
	}
    }
	
    public void reverse()
    {
	Stack tempStack = new Stack();
	nodo temp = head;
		
	while(temp != null)
	{
	    tempStack.Push(temp.clone());
	    temp = temp.next;
	}
	head =  tempStack.head;
    }
}
