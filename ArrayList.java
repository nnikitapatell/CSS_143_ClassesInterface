import java.util.Iterator;
/**
 * ArrayList from previous homework
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class called ArrayList
public class ArrayList<T> implements Iterable<Object>, Cloneable, Comparable{
    //Private object array to avoiding privacy leak
    private Object[] listArrayOfObjects;
    //private int variable to avoid privacy leak
    private int sizeOfArrayList = 0;

    /**
     * ArrayList Constructor
     *
     * @param object A parameter
     */
    private ArrayList(Object object) {
        //checks if object is null or not an instanxe of arraylist
        if (object == null || !(object instanceof ArrayList)) {
            throw new IllegalArgumentException("ArrayList was null, or simply not an ArrayList.");
        } else {
            //casting
            ArrayList<Object> that = (ArrayList<Object>) object;
            this.listArrayOfObjects = new Object[that.size()];
            for (int i = 0; i < that.size(); i++) {
                this.listArrayOfObjects[i] = (Object) that.get(i); //make sure it's a "T"
            }
            this.sizeOfArrayList = that.size();
        }
    }

    /**
     * Method clone
     *
     * @return The return value
     */
    public ArrayList<Object> clone() {
        return new ArrayList<Object>((Object) this);
    }

    /**
     * ArrayList no argument Constructor
     *
     */
    public ArrayList(){
        //length of List as 1000
        this.listArrayOfObjects = new Object[100];
        //size of the array set to 0
        this.sizeOfArrayList = 0;
    }

    /**
     * Method insert- The insert method will insert an object element to a specific index
     * and move the rest of the object array elements to the right to make space for that
     * element at that specific index.
     *
     * @param newObj A parameter
     * @param index A parameter
     */
    public void insert(Object obj, int index){
        //call helper method to resize the array
        helperMethodToResizeArray(100);
        //check if index of list is not null
        if (listArrayOfObjects[index] != null){
            //loop through the arrayList
            for (int i = size(); i < index; i++){
                //set the index i to i-1
                this.listArrayOfObjects[i] = this.listArrayOfObjects[i-1];
            }
        }
        //set index of list to Object obj
        this.listArrayOfObjects[index] = obj;
        //increment size
        this.sizeOfArrayList++;
    }

    /**
     * Method helperMethodToResizeArray- is a helper method to resize the array 
     *
     * @param increment A parameter
     */
    public void helperMethodToResizeArray(int increment){
        //create an array
        Object[] newListArrayOfObjects = new Object[increment + sizeOfArrayList];
        //iterate through the for loop
        for (int i = 0; i < size() ; i++){
            // set the elements of the old list to the new list  
            this.listArrayOfObjects[i] = newListArrayOfObjects[i];
        }
        // old list is see to the new list
        this.listArrayOfObjects = newListArrayOfObjects;
    }

    /**
     * Method add
     *
     * @param obj A parameter
     * @return 
     */
    public void add(Object obj){
        //check if the obj is not null
        if (obj != null){
            //the size of the list is set to obj
            this.listArrayOfObjects[size()] = obj;
            //increment the list
            this.sizeOfArrayList++;
        }

    }

    /**
     * Method arrayShiftRight
     *
     * @param shiftIndex A parameter
     */
    private void arrayShiftRight(int shiftIndex) {
        //iterate to shift array to the right
        for (int i = sizeOfArrayList-1; i >= shiftIndex; i--) {
            listArrayOfObjects[i+1] = listArrayOfObjects[i];
        }
    }

    /**
     * Method arrayShiftLeft
     *
     * @param shiftIndex A parameter
     */
    private void arrayShiftLeft(int shiftIndex) {
        //iterate to shift to the left
        for (int i = shiftIndex; i < listArrayOfObjects.length - 1; i++) {
            listArrayOfObjects[i] = listArrayOfObjects[i+1];
        }
    }

    /**
     * Method isFull
     *
     * @return The return value
     */
    private boolean isFull() {
        return this.sizeOfArrayList >= listArrayOfObjects.length;
    }

    /**
     * Method add- add a generic type at a particular index
     *
     * @param objectToAdd A parameter
     * @param index A parameter
     */
    public void add(Object objectToAdd, int index) {
        //check if not null
        if (objectToAdd != null) {
            //check if full
            if (this.isFull()) {
                //increase the array size by doubling
                helperMethodToResizeArray(this.sizeOfArrayList * 2); 
                //check if index is located in the middle of the array
                if (index < this.size()) { 
                    this.arrayShiftRight(index);
                    listArrayOfObjects[index] = objectToAdd;
                }
                //check if the index is after the array
                if (index >= this.size()) { 
                    helperMethodToResizeArray(index + 1);
                    listArrayOfObjects[index] = objectToAdd;
                }

            } 
            //otherwise
            else {
                //if index is located in the middle of the array
                if (index < this.size()) { 
                    this.arrayShiftRight(index);
                    listArrayOfObjects[index] = objectToAdd;
                }
                //check if the item is placed after the array
                if (index >= this.size()) { 
                    helperMethodToResizeArray(index + 1);
                    listArrayOfObjects[index] = objectToAdd;
                }
            }
            //increment size
            this.sizeOfArrayList++; 
        }
    }

    /**
     * Method remove- Removes and returns the object at the specified index.  
     * THe program will move the elements to the left until there is no empty space
     *
     * @param index A parameter
     * @return The return value
     */
    public Object remove(int index){
        //check if the index is negative or if the index of the array is null
        if (index < 0 || this.listArrayOfObjects[index] == null){ 
            //print the message adn exit the program
            System.err.println("There is an Error in the program"); 
            System.exit(-1);
        }
        //store Object being removed into a retVal variable
        Object retVal = this.listArrayOfObjects[index]; 

        //iterate over array
        for (int i = index; i < size()-1; i++){ 
            //shift the array elements to the left, starting one after the specified index
            listArrayOfObjects[i] = this.listArrayOfObjects[i+1];             
        }

        //clear out the last element
        this.listArrayOfObjects[this.sizeOfArrayList] = null; 
        //reduce number of elements by one because we removed one Object from the arrayList
        this.sizeOfArrayList--; 

        //returns the removed Object from the arrayList
        return retVal; 
    }

    /**
     * Method isEmpty- checks if arraylist is empty. if it is it will return ture and otherwise 
     * it will return false
     *
     * @return The return value
     */
    public boolean isEmpty(){
        //check if this element is 0
        if(this.sizeOfArrayList  == 0){
            //return true
            return true;
        }
        //otherwise
        else{
            //return false           
            return false;
        }
    }

    /**
     * Method size- is getter method for size of the arrayList
     *
     * @return The return value
     */
    public int size(){
        //return this element
        return this.sizeOfArrayList;
    }

    /**
     * Method toString- formats  and prints out the elements in the arraylist
     *
     * @return The return value
     */
    @Override
    public String toString(){
        //set str to [
        String str ="[";
        //iterate through the loop
        for(int i = 0; i < this.sizeOfArrayList; i++){
            str = str + "\n" + listArrayOfObjects[i];
        }
        //return str and }
        return str + "]";
    }

    /**
     * Method indexOf- Returns -1 if not found and index number if found
     *
     *
     * @param obj A parameter
     * @return The return value
     */
    public int indexOf(Object theObject){
        //Iterate through the loop
        for (int i = 0; i< this.sizeOfArrayList; i++){
            //check if index i of the list is equal to theObject
            if(listArrayOfObjects[i].equals(theObject)){
                //return index i
                return i;
            }
        }
        //index of object not found
        return -1;
    }

    /**
     * Method equals- Compare sizes and elements in the data structure. Return true if 
     * they are the same arrayLists if not then it return false
     *
     * @param obj A parameter
     * @return The return value
     */
    public boolean equals(Object o){
        //create an object objectOfList
        ArrayList objectOfList = (ArrayList) o;
        //check if element is not equal to the size of the Object list
        if(this.sizeOfArrayList != objectOfList.size()){
            return false;
        }
        //iterate through the loop
        for(int i = 0; i < this.sizeOfArrayList; i++){
            //check if the index i of list is not equal to object of List 
            if(!listArrayOfObjects[i].equals(objectOfList.listArrayOfObjects[i])){
                //return false
                return false;
            }
        }
        //return true
        return true;
    }

    /**
     * Method get- this method returns the object at index specified
     *
     * @param index A parameter
     * @return The return value
     */
    public Object get(int index){
        //theObject is set to null
        Object theObject = null;
        //check is index is greater than or equal to this.element
        if(index >= this.sizeOfArrayList){
            //throw exception
            throw new IndexOutOfBoundsException();
        }
        //set obj to index of list
        theObject = listArrayOfObjects[index];
        //return theObject
        return theObject;
    }

    /**
     * Method compareTo
     *
     * @param o A parameter
     * @return The return value
     */
    public int compareTo(Object o) {
        int retVal = 0;
        if (o == null || !(o instanceof ArrayList)) {
            throw new IllegalArgumentException("compareTo() method with either a null or something that wasn't an ArrayList.");
        }
        ArrayList<Object> that = (ArrayList<Object>) o;
        for (int i = 0; i < sizeOfArrayList; i++) {
            //check if amount compared to the objectamoutn is greater than 0
            if (((Comparable) this.get(i)).compareTo(that.get(i)) > 0){
                //return 1
                retVal++;
            }
            //check if amount compared to the objectamoutn is ;ess than 0
            else if (((Comparable) this.get(i)).compareTo(that.get(i)) < 0){
                //return -1
                retVal--;
            } 
            //else 
            else 
            //return 0
                retVal=retVal;
        }  
        return retVal;
    }

    /**
     * Method iterator
     *
     * @return The return value
     */
    public Iterator<Object> iterator() {
        return new IteratorClass();
    }

    /*
     * Class IteratorClass  that implements Iterator
     */
    public class IteratorClass implements Iterator<Object> {
        //instance vairiable to track index
        private int iterIndexTracker = 0;

        /**
         * Method hasNext- tells us that there is still more data 
         *
         * @return The return value
         */
        @Override
        public boolean hasNext() {
            return iterIndexTracker < sizeOfArrayList && listArrayOfObjects[iterIndexTracker] != null;
        }

        /**
         * Method next- returns the data object located at the iterator
         *
         * @return The return value
         */
        @Override
        public Object next() {
            return (Object) listArrayOfObjects[iterIndexTracker++];
        }

        /**
         * Method remove
         *
         */
        @Override
        public void remove() {
        }
    }
}
