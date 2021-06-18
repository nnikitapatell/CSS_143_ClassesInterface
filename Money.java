
import java.io.Serializable;
/**
 * Write a description of class Money here.
 * Invariants:
 * Our internal cents should be between [0-99] at all times
 * Our internal Cents and Dollars should never be < 0, at all times
 *
 * @author Nikita Patel
 * @version 1
 */
public class Money implements Comparable <Object>, Cloneable, Serializable{
    //private data members to avoid privacy leaks
    private int dollars = 0;
    private int cents = 0;

    /**
     * Method main
     *
     * @param args A parameter
     */
    public static void main(String[] args) {
        Money money4 = new Money(1,99);
        System.out.println("Compare Money(1): " + money4.compareTo(new Money(3,20)));
        System.out.println("Compare Money(0): " + money4.compareTo(new Money(1,99)));
        System.out.println("Compare Money (-1): " + money4.compareTo(new Money(1,29)));
        System.out.println();
        //print the clone of money 4
        System.out.println("Clone:" + money4.clone());
    }

    /**
     * Money Constructor
     * This constructor initializes dollars to dol and cents to 0
     *
     * @param dol A parameter
     */
    public Money(int dol) {
        //dollars is set to dol
        this.dollars = dol;
        //cents is set to 0
        this.cents = 0;
    }

    /**
     * Money Constructor - sets this objects(dollars and cents) to dol and cent
     * This constructor initializes dollars and cents accordingly
     *
     * @param dol  A parameter
     * @param cent A parameter
     */
    public Money(int dol, int cent) {
        //dollars is initialized to dol
        this.dollars = dol;
        //cents is initialized to cent
        this.cents = cent;
    }

    /**
     * Money Constructor is a copy constructor for the class
     * This constructor could redirect to one of the ones above  (call this() to call a different constructor )
     *
     * @param other A parameter
     */
    public Money(Money other) {
        //check is othe is null or other is not an instance of money 
        if (other == null || other instanceof Money == false){
            System.err.println("Invalid!");
            System.exit(0);
        }
        //otherwise set this (dollars/cents) to other dollars and cents
        else {
            this.dollars = other.dollars;
            this.cents = other.cents;
        }
    }

    /**
     * Method setMoney- sets dollars and cents
     * Sets our dollars and cents, accordingly
     * This function should also make use of setters for dollars and cents
     * PRE: dol and cent cant be null
     * POST:set cents to cent adn set dollars to dollar
     *
     * @param dol  A parameter
     * @param cent A parameter
     * @return The return value
     */
    public void setMoney(int dol, int cent) {
        //sets our dollars and cents
        setDollars(dol);
        setCents(cent);
    }

    public double getMoney( ){
        //gets the money amount as a double
        return dollars + cents /100.0;
    }

    /**
     * Method toString- Prints out a Money object, such as “$3.75”
     * 
     * @return The return value
     */
    public String toString(){
        //prints money with dollars and  cents
        return "$" + this.dollars + "." + this.cents;
    }

    /**
     * Method add- Adds the int passed into the function to dollars
     * PRE: none
     * @param dol A parameter
     */
    public void add(int dol) {
        //sets the dollars by adding the dol passed through adn the dollars
        setDollars(getDollars() + dol);
    }

    /**
     * Method add
     * Adds to dollars and cents the two ints passed into the function.
     * PRE:none
     * 
     * @param dol  A parameter
     * @param cent A parameter
     */
    public void add(int dol, int cent) {
        //newDollars is set dollars added the int passed into the function
        int newDollars = (getDollars() + dol);
        //newCents is set cents added the int passed into the function
        int newCents = (getCents() + cent);
        //check if the newCents are greater than 99
        if (newCents > 99){
            //temporaryVaraibleForDollars is set to newCents/ 100
            int temporaryVaraibleForDollars = (newCents / 100);
            //temporaryVariableForCents
            int temporaryVariableForCents = (newCents % 100);
            setDollars(newDollars + temporaryVaraibleForDollars);
            setCents(temporaryVariableForCents);
        }
        //otherwise,
        else{
            //set dollars to newDollars
            setDollars(newDollars);
            //set Cents to newCents
            setCents(newCents);
        }
    }

    /**
     * Method add- Adds to this object the dollars and cents stored in the other object.
     *
     * @param other A parameter
     */
    public void add(Money other) {
        //Adds to this object the dollars stored in the other object
        int newDollars = other.getDollars() + getDollars();
        //Adds to this object the cents stored in the other object
        int newCents = other.getCents() + getCents();
        //check if newCents is greater than 99
        if (newCents > 99) {
            //temporaryDollars are set to newCents divided by 100
            int temporaryDollars = (newCents / 100);
            //temprorary cents are set to newCents mod 100
            int temporaryCents = (newCents % 100);
            //setDollars to newDollars + temporaryDollars
            setDollars(newDollars + temporaryDollars);
            //set cents to the temporaryCents
            setCents(temporaryCents);
        } 
        //otherwise
        else {
            //Set dollars to newDollars
            setDollars(newDollars);
            //set cents to newCents
            setCents(newCents);
        }
    }

    /**
     * Method getDollars- returns the dollars of this object
     * PRE: none
     *
     * @return The return value
     */
    public int getDollars() {
        //return dollars
        return this.dollars;
    }

    /**
     * Method setDollars- sets the dollars for this object
     * PRE: dollar can't be null
     * POST: this.dollar is set to dollar
     *
     * @param dollars A parameter
     */
    public void setDollars(int dollar) {
        //set dollars to dollar
        this.dollars = dollar;
    }

    /**
     * Method getCents- returns the cents of this object
     * PRE: none
     * 
     * @return The return value
     */
    public int getCents() {
        //return cents
        return this.cents;
    }

    /**
     * Method setCents- sets the cents to this object
     * PRE: cent must be between 0 and 99
     * POST: this.cent is set ot cent
     * @param cents A parameter
     */
    public void setCents(int cent) {
        //check if cent is greater than 99 or cent is less than 0
        if(cent > 99 || cent < 0){
            //if so, print error me
            System.err.println("Invalid input!");
            System.exit(-1);
        }else{
            //set cents to cent
            this.cents = cent;
        }
    }

    /**
     * Method equals
     * Determines if this money object is equal to that Money object
     *
     * @param o A parameter
     * @return The return value
     */
    public boolean equals (Object theObject){
        //check if o is null or if o is 
        if (theObject == null || theObject instanceof Money == false) {
            return false;
        }
        //create object that
        Money that = (Money) theObject;
        return this.cents == that.cents && this.dollars == that.dollars;
    }

    /**
     * Method compareTo
     *
     * @param other A parameter
     * @return The return value
     */
    public int compareTo(Object other){
        Money obj = (Money) other;
        if (getClass() != obj.getClass())
        //throw new  IllegalArgumentException
            throw new  IllegalArgumentException();
        //check if obj.getDollars is greater than getDollars
        if(obj.getDollars() > getDollars()){
            //return 1
            return 1;
        } 
        //else if check is obj getDOllar is less than getdollars
        else if(obj.getDollars() < getDollars()){
            //return -1
            return -1;
        } 
        //otherwise        
        else{
            //check if obj.getCents is equal to get cents
            if(obj.getCents() == getCents()){
                //return 0
                return 0;
            }
            //else if check if getcents is greater than getcents
            else if(obj.getCents() > getCents()){
                //return 1
                return 1;
            }
            //else
            else{                
                //return -1
                return -1;
            }
        }
    }

    /**
     * Method clone
     *
     * @return The return value
     */
    public Money clone(){
        //try 
        try{
            //money object 
            Money m = (Money) super.clone();
            //retuen money object m
            return m;
        }
        //catch clone not supported exception
        catch(CloneNotSupportedException e){
            //print stack trace
            e.printStackTrace();
            //throw run time exception
            throw new RuntimeException();
        }
    }
}