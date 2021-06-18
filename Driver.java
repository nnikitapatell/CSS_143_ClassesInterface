/**
 * Write a description of class Driver here.
 *
 * @author Nikita Patel
 * @version 1
 */
//create a driver class
public class Driver{
    public static void main(String[] args){
        //create a Money object set to 2.99
        Money money1 = new Money(2, 99);
        //create another Money object and copy money1 to money2
        Money money2 = new Money(money1);

        //set the amount of money for money 1 set to 3.99
        money1.setMoney(3,99);

        //set the amount of money for money 2 set to 4.99
        money2.setMoney(4, 99);
        //create another Money object and set the amount of money for money3 set to 100.55
        Money money3 = new Money(100, 55);
        //set the amount of money for money 3 set to 2.59
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
        
        //Bill class object bill3
        Bill bill3 = new Bill(amount, dueDate, "Donut shop");
        //set new money amount value
        bill3.setAmount(money1);
        //set new paidDate
        paidDate.setDate(01, 01, 2019);
        //set paidDate to the paidDate
        bill3.setPaid(paidDate);
        
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
        
        //create a Date object
        Date theDate = new Date(3,19,2019);
        Date theDate1 = new Date(1,19,2002);
        //print date value
        System.out.println("Date value:" + theDate.toString());
        //print if date is after (boolean)
        System.out.println("is the data after 3/20/2020?" + theDate.isAfter(new Date(3,20,2029)));
        //uses the compares method
        System.out.println("Compare Dates(1): " + theDate.compareTo(new Date(3,20,2017)));
        System.out.println("Compare Dates (0): " + theDate.compareTo(new Date(3,19,2019)));
        System.out.println("Compare Dates (-1): " + theDate1.compareTo(theDate));
        System.out.println();
        
        
        Money money4 = new Money(1,99);
        System.out.println("Compare Money(1): " + money4.compareTo(new Money(3,20)));
        System.out.println("Compare Money(0): " + money4.compareTo(new Money(1,99)));
        System.out.println("Compare Money (-1): " + money4.compareTo(new Money(1,29)));
        System.out.println();
        System.out.println("Compare Bill(1): " + bill1.compareTo(bill2));
        System.out.println("Compare Bill (-1): " + bill2.compareTo(bill3));
        System.out.println("Compare Bill (0): " + bill3.compareTo(bill3));
        
        System.out.println();
        //creates an object
        ArrayList theListObject = new ArrayList();
        //inserts bill to index 1
        theListObject.insert(bill1, 0);
        //calls tostring
        System.out.println(theListObject.toString());
        
        //add bill2
        theListObject.add(bill2);
        //add bill3
        theListObject.add(bill3);
        //add bill4
        theListObject.add(bill4);
        //calls toString
        System.out.println(theListObject.toString());       
    }
}

        
       
