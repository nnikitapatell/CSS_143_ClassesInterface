
import java.io.Serializable;
/**
 * Write a description of class Bill here.
 * Invariants:
 * The internal paid date should be on or earlier than the due date.
 * @author Nikita Patel
 * @version 1
 */
public class Bill implements Comparable<Object>, Cloneable, Serializable{
    //Money object
    private Money amount;
    //Date object
    private Date dueDate;
    //Date object
    private Date paidDate;
    //a String containing the company or institution who issued the bill
    private String originator;
    public static void main(String[] args){
        //create a Money object
        Money money1 = new Money(2, 99);
        //create another Money object and copy money1 to money2
        Money money2 = new Money(money1);

        //set the amount of money for money 1
        money1.setMoney(3,99);

        //set the amount of money for money 2
        money2.setMoney(4, 99);
        //create another Money object and set the amount of money for money3
        Money money3 = new Money(100, 55);
        //set the amount of money for money 3
        money3.setMoney(2,59);

        //Create objects dueDate and paidDate for Date class
        Date dueDate = new Date(03, 30, 2019); //new Date class obj, set to a date
        Date paidDate = new Date(03, 18, 2019); //new paidDate class obj, set to a date

        //create object amount for Money class
        Money amount = new Money(money2); //new Bill class obj that is set to an amount

        //create object bill1 for Bill class
        dueDate.setYear(2016);
        Bill bill1 = new Bill(amount, dueDate, "Coffee shop");
        //checks if the paid date is before the due date and set the paidDate to Bill1
        bill1.setAmount(money3);
        bill1.setPaid(paidDate);
        System.out.println("Bill1: " + bill1);
        System.out.println();
        
        //create a object bill2 with same as first Bill object
        Bill bill2 = new Bill(bill1);
        //set new Money amount value for bill2
        bill2.setAmount(money2);
        //set new value for paidDate
        paidDate.setDate(06, 04, 2019);
        //set bill2 to paidDate on second Bill obj
        bill2.setPaid(paidDate);
        //set the dueDate on second Bill object
        bill2.setDueDate(new Date(06, 21, 2019));
        dueDate.setYear(2015);
        System.out.println("Bill2: " + bill2);
        System.out.println();
        
        //Bill class object bill3
        Bill bill3 = new Bill(amount, dueDate, "Donut shop");
        //set new money amount value
        bill3.setAmount(money1);
        //set new paidDate
        paidDate.setDate(01, 01, 2019);
        //set paidDate to the paidDate
        bill3.setPaid(paidDate);
        System.out.println("Bill3: " + bill3);
        System.out.println();
        
        //create a object bill4 with same as third Bill object       
        Bill bill4 = new Bill(bill3);
        //set new Money amount value for bill4
        bill4.setAmount(money2);
        //set new value for paidDate
        paidDate.setDate(06, 04, 2019);
        //set bill2 to paidDate 
        bill4.setPaid(paidDate);
        //set the dueDate 
        bill4.setDueDate(new Date(06, 04, 2019));
        System.out.println("Bill4: " + bill4);
        System.out.println();
        
        //create a Date object
        Date theDate = new Date(3,19,2019);
        //print date value
        System.out.println("Date value:" + theDate.toString());
        //print if date is after (boolean)
        System.out.println("is the data after 3/20/2019?" + theDate.isAfter(new Date(3,20,2019)));
        //uses the compares method
        
        System.out.println("Compare Bill(1): " + bill1.compareTo(bill2));
        System.out.println("Compare Bill (0): " + bill2.compareTo(bill4));
        System.out.println("Compare Bill (-1): " + bill4.compareTo(bill3));
        System.out.println();
        System.out.println("Clone: " + bill1);        
    }
    /**
     * Bill Constructor- constructor (null for paidDate)
     *
     * @param amount A parameter
     * @param dueDate A parameter
     * @param originator A parameter
     */
    public Bill(Money amountInput, Date dueDateInput, String originatorInput){
        //set amount, due date, and originator inputs
        setAmount(amountInput);
        setDueDate(dueDateInput);
        setOriginator(originatorInput);
        //null for paidDate
        paidDate = null;
    }

    /**
     * Bill Constructor- is a copy constructor
     *
     * @param toCopy A parameter
     */
    public Bill(Bill toCopy){
        //make deep copy of objects 
        this(toCopy.getAmount(), toCopy.getDueDate(), toCopy.getOriginator());
    }

    /**
     * getDueDate method- returns the dueDate
     * PRE: None
     * @param toCopy A parameter
     */
    public Date getDueDate(){
        //return due date
        return new Date(this.dueDate);
    }

    /**
     * Method getOriginator- return the originator
     * PRE: None
     * @return The return value
     */
    public String getOriginator(){
        //return originator
        return new String(this.originator);
    }

    /**
     * Method setOriginator- change the originator
     * PRE: None
     * @param theOriginator A parameter
     */
    public void setOriginator(String theOriginatorInput){
        //check if theOriginator is null
        if (theOriginatorInput == null) { 
            //print error message and exit
            System.err.println("No originator entered.");
            System.exit(0);
        } 
        //if its not null
        else { //if not null, set instance var to input
            //set the input to the originator to the input
            this.originator = new String(theOriginatorInput);
        }
    }

    /**
     * Method isPaid- return true if bill has been paid
     * 
     * @return The return value
     */
    public boolean isPaid(){
        //check if date is not null
        if (getPaidDate() != null){
            //check if the paidDate and the dueDate are the same or older than the current date
            if (getPaidDate().getYear() <= getDueDate().getYear() &&
            (getPaidDate().getMonth() <= getDueDate().getMonth()) &&
            (getPaidDate().getDay() <= getDueDate().getDay())){
                //return true
                return true;
            }
        }
        //return flase
        return false;
    }

    /**
     * Method setPaidDate
     * PRE: onDay can't be null
     * POST: this.paidDate is set to new Date(setPaidObject);
     * @param onDay A parameter
     */
    public void setPaid(Date onDay){
        //check if onDay is null
        if (onDay == null){
            //print error message ang exit
            System.err.println("No date has been entered.");
            System.exit(-1);
        } else {
            Date setPaidObject = new Date(onDay);
            //set a new instance/object of Date class and use it to store input value
            this.paidDate = new Date(setPaidObject);
            //set the instance var equal to this input value
        }
    }

    /**
     * Method unpaidBill
     * PRE: none
     * POST: set this.paidDate to null
     */
    public void setUnpaid() {
        //make the bill unpaid by setting it to null
        this.paidDate = null;
    }

    /**
     * Method setDueDate
     * PRE: nextDate cant be null
     * POST: set this.dueDate to new Date(dueDate2)
     *
     * @param nextDate A parameter
     */
    public void setDueDate(Date nextDate){
        //if input is null, print error message and then exit
        if (nextDate == null){
            System.err.println("No date has been entered.");
            System.exit(-1);
        } else {
            //if the input has a value create new object and store input
            Date dueDate2 = new Date(nextDate);
            //then set the instance variable to this input
            this.dueDate = new Date(dueDate2);
        }
    }

    /**
     * Method setAmount
     * PRE: amt cant be null
     * POST: set this.amount to new Money(amount2)
     * @param amt A parameter
     */
    public void setAmount(Money amt){
        //if input is null, print error message and then exit
        if (amt == null) {
            System.err.println("No amount has been entered.");
            System.exit(-1);
        } else {
            //if the input has a value create new object and store input
            Money amount2 = new Money(amt);
            //then set the instance variable to this input
            this.amount = new Money(amount2);
        }
    }

    /**
     * Method getAmount
     * PRE: None
     * 
     * @return The return value
     */
    public Money getAmount(){
        //return amount
        return new Money(this.amount);
    }

    /**
     * Method getPaidDate
     * PRE: None
     * 
     * @return The return value
     */
    public Date getPaidDate(){
        //return paid date
        return new Date(this.paidDate);
    }

    /**
     * Method toString-  build a string that reports the amount,
     * when its due, to whom, whether paid, and if paid, the date paid.
     * 
     * @return The return value
     */
    @Override
    public String toString(){
        //reports the amount,when its due, to whom, whether paid, and if paid, the date paid.
        String results = ("Amount: " + getAmount() + "\nDue: " +
                getDueDate() + "\nOriginator: " + getOriginator());
        //check if paidDate is not null
        if (paidDate != null) {
            results+= ("\nWas the payment made?: " + isPaid() + "\nDate Paid: " + getPaidDate());
        }
        //return results
        return results;
    }

    /**
     * Method equals-  determine if the two bills are identical
     *
     * @param other A parameter
     * @return The return value
     */
    @Override
    public boolean equals(Object other){
        //if other is null or an instance of the class then return false
        if (other == null || other instanceof Bill == false){
            //return false
            return false;
        } 
        //otherwise,
        else {
            //create object that
            Bill that = (Bill) other;
            //create new object to store input
            return this.amount == that.amount &&
            this.dueDate == that.dueDate &&
            this.originator == that.originator;
            //returns true if amount, dueDate and originator are equal to each other
        }
    }

    /**
     * Method compareTo
     *
     * @param obj A parameter
     * @return The return value
     */
    public int compareTo(Object other) throws NullPointerException {
        //check if other is null
        if (other == null){
            //throw exception
            throw new NullPointerException();
        }
        //create an object
        Bill theObject = (Bill) other;
        //check if amount compared to the objectamoutn is greater than 0
        if (this.amount.compareTo(theObject.amount) > 0){
            //return 1
            return 1;
        }
        //check if amount compared to the objectamoutn is ;ess than 0
        else if (this.amount.compareTo (theObject.amount) < 0){
            //return -1
            return -1;
        } 
        //else 
        else 
            //return 0
            return 0;
    }
    
    /**
     * Method clone
     *
     * @return The return value
     */
    public Bill clone(){
        //try
        try {
            //create an object of Bill class
            Bill b = (Bill) super.clone();
            //set due date to cloned due date
            b.dueDate = (Date) dueDate.clone();
            //set paid date to cloned paid date
            b.paidDate = (Date) paidDate.clone();
            //set amount to cloned amount
            b.amount = (Money) amount.clone();
            //return b
            return b;
        }
        //catch exeception
        catch(CloneNotSupportedException e){
            //print stack trace
            e.printStackTrace();
            //throw run time exception
            throw new RuntimeException();
        }
    }
}