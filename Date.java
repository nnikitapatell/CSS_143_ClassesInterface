
import java.io.Serializable;
/**
 * Write a description of class Date here.
 * Invariants:
 * All days should be between [1-31]
 * All months should be between [1-12]
 * All years should be between [2014-2024]
 * @author Nikita Patel
 * @version 1
 */
public class Date implements Comparable<Object>, Serializable {
    //private instance variables
    private int day;
    private int month;
    private int year;

    /**
     * Method main
     *
     * @param args A parameter
     */
    public static void main(String[] args) {
        //create a Date object
        Date theDate = new Date(3,19,2019);
        Date theDate1 = new Date(1,19,2002);

        System.out.println("Compare Dates(1): " + theDate.compareTo(new Date(3,20,2017)));
        System.out.println("Compare Dates (0): " + theDate.compareTo(new Date(3,19,2019)));
        System.out.println("Compare Dates (-1): " + theDate1.compareTo(theDate));
        System.out.println();
        System.out.println("Clone: " + theDate.clone());
    }

    /**
     * Date Constructor
     *
     * @param month A parameter
     * @param day A parameter
     * @param year A parameter
     */
    public Date(int monthInput, int dayInput, int yearInput){
        //set the date 
        setDate(monthInput, dayInput, yearInput);
    }

    /**
     * Date Constructor- copy constructor
     *
     * @param other A parameter
     */
    public Date(Date other){
        //copies month, day and year
        this.month = other.getMonth();
        this.day = other.getDay();
        this.year = other.getYear();
    }

    /**
     * Method setDate
     * PRE: theMonthInput, theDayInput, theYearInput are all not null
     * POST: sets the month, day, and year
     *
     * @param theMonthInput A parameter
     * @param theDayInput A parameter
     * @param theYearInput A parameter
     */
    public void setDate(int theMonthInput, int theDayInput, int theYearInput){
        //set the month
        setMonth(theMonthInput);
        //set the day
        setDay(theDayInput);
        //set the year
        setYear(theYearInput);
    }

    /**
     * Method getMonth
     * PRE: none
     *
     * @return The return value
     */
    public int getMonth(){
        //return the month
        return this.month;
    }

    /**
     * Method setMonth- All months should be between [1-12]
     * PRE: All months should be between [1-12]
     * POST: this.month is set to theMonthInput
     *
     * @param theMonth A parameter
     */
    public void setMonth(int theMonthInput){
        //check if the Month is greater or equal to 1 and if theMonth is less than or equal to 12
        if (theMonthInput >= 1 && theMonthInput <= 12) {
            //if so, set month to the Month
            this.month = theMonthInput;
        } 
        //otherwise 
        else {
            //print error message
            System.err.println("All months should be between [1-12]");
        }
    }

    /**
     * Method getDay
     * PRE: none
     *
     * @return The return value
     */
    public int getDay(){
        //return the day
        return this.day;
    }

    /**
     * Method setDay- All days should be between [1-31]
     * PRE:  All days should be between [1-31]
     * POST: this.day is set to theDay
     * 
     * @param theDay A parameter
     */
    public void setDay (int theDay){
        //check if theDay is greater or equal to 1 and less than or equal to 31
        if (theDay >= 1 && theDay <= 31) {
            //if the day is between 1 and 31 then set the instance var to this
            this.day = theDay;
        }
    }

    /**
     * Method getYear
     * PRE: none
     *
     * @return The return value
     */
    public int getYear(){
        //return year
        return this.year;
    }

    /**
     * Method setYear- All years should be between [2014-2024]
     * PRE: All years should be between [2014-2024]
     * POST: this.year is set to theYear
     *
     * @param theYear A parameter
     */
    public void setYear(int theYear){
        //check if theYear is greater than or equal to 2014 and if it is less than the year 2024
        if (theYear >= 2014 && theYear <= 2024){
            //set the instance variable equal to theYead
            this.year = theYear; 
        }
    }

    /**
     * Method equals- Determines if this Date object is equal to that Date object
     *
     * @param otherObject A parameter
     * @return The return value
     */
    @Override
    public boolean equals(Object otherObject){
        //check if otherObject is equal to null or otherObject is not instance of Date class 
        if (otherObject == null || otherObject instanceof Date == false){
            //return false
            return false;
        }
        //create object that
        Date that = (Date)otherObject;
        //return if this Date object is equal to that Date object
        return this.getMonth() == that.getMonth() &&
        this.getDay() == that.getDay() &&
        this.getYear() == that.getYear();
    }

    /**
     * Method toString- Prints out a Date object, such as “12/25/2017”
     *
     * @return The return value
     */
    @Override
    public String toString() {
        //return m/d/y
        return getMonth() + "/" + getDay() + "/" + getYear();
    }

    public boolean isAfter(Date compareTo){
        //compare years
        int compare = Integer.compare(compareTo.year, year);
        //check if compare is equal to 0
        if(compare == 0){
            //compare is set to compare months
            compare = Integer.compare(compareTo.month, month);
            //check if compare is equal to 0
            if(compare == 0){
                //set compare to compare days
                compare = Integer.compare(compareTo.day, day);
                //return compare < 0
                return compare < 0;  
            }
            //otherwise
            else{
                //return compare <0
                return compare < 0;
            }
        }
        //otherwise
        else{
            //return compare < 0
            return compare < 0;
        }
    }

    /**
     * Method compareTo
     *
     * @param theObject A parameter
     * @return The return value
     */
    public int compareTo(Object theObject) throws NullPointerException {
        //check if theObject is null
        if (theObject == null){
            //throw exception
            throw new NullPointerException();
        }

        //create an object
        Date obj = (Date) theObject;
        //check if year is less than obj.year
        if(this.year < obj.year)
        //return -1;
            return -1;
        else if(this.year > obj.year)
        //return 1
            return 1;
        else{
            // return this.day - obj.day
            return this.day - obj.day;
        }
    }

    /**
     * Method clone
     *
     * @return The return value
     */
    public Date clone(){
        try{
            //creat an object of Date class
            Date d =(Date) super.clone();
            //return d
            return d;
        }
        //catch exception
        catch (CloneNotSupportedException e){
            //print stack trace
            e.printStackTrace();
            //throw run time eexception
            throw new RuntimeException();
        }
    }

}