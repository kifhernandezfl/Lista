import gc

class Lista:
    def __init__(self):
        self.head = None
        
    def isEmpty(self):
        return self.head == None
    
    def insertAtBegin(self,Nodo):
        Nodo.next = self.head
        self.head = Nodo
        
    def insertAtEnd(self,Nodo):
        if isEmpty():
            self.head = Nodo
        else:
            temp = self.head
            
            while temp.next != None:
                temp = temp.next
                
                temp.next = Nodo
    
    def insertAtIndex(self,Nodo,index):
        temp = self.head
        
        for i in range(0,index-1):
            temp = temp.next
            
        Nodo.next = temp.next
        temp.next = Nodo.next
        
    def deleteAtBegin(self):
        temp = self.head
        self.head = self.head.next
        temp = None
        gc.collect()
    
    def deleteAtEnd(self):
        temp = self.head
        
        while temp.next.next != None:
            temp = temp.next
            
        temp.next = None
    
    def deleteAtIndex(self,index):
        temp = self.head
        toDelete 
        
        for i in range(0,index-1):
            temp = temp.next
            
        toDelete = temp.next
        temp.next = temp.next.next
        toDelete = None
        gc.collect()
    
    def length(self):
        counter = 0
        temp = self.head
        
        while temp != None:
            counter +=1
            temp = temp.next
        
        return counter
    
    def get(self,index):
        if index < this.length():
            temp = self.head
            
            for i in range(0,index):
                temp = temp.next
                
            return temp
        
        return None
        
    def binarySearch(self,value,lower,upper): 
        middle = (lower + upper) // 2
        tempId = get(middle).ID
        
        if lower == upper:
            if tempId == value:
                return get(middle)
            else:
                return None
        else:
            if value < tempId:
                return binarySearch(value, lower, middle)
            else:
                return binarySearch(value, middle + 1, upper)
    
    def quickSort(self, unsorted):
        if len(unsorted) <= 1:
            return unsorted
        else:
            pivot = unsorted.head
            less_sublist = Lista()
            greater_sublist = Lista()
            
            temp = unsorted.head.next 
            while temp != None:
                if temp.ID < pivot.ID:
                    less_sublist.insertAtEnd(temp.clone())
                else:
                    greater_sublist.insertAtEnd(temp.clone())
                    
                temp = temp.next
            
            less_sublist = quickSort(less_sublist)
            greater_sublist = quickSort(greater_sublist)
            
            pivot.next = greater_sublist.head
            less_sublist.insertAtEnd(pivot)
            return less_sublist
            
        
    
        
        
        




