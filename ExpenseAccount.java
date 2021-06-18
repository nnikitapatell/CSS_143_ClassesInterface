
import java.io.IOException;
/**
 * Write a description of class ExpenseAccount here.
 *
 * @author Nikita Patel
 * @version 1
 */
public class ExpenseAccount <Object extends Bill> extends ArrayList<Object>  {
    //private insatance vairables 
    private ArrayList listOfBills = new ArrayList();
    private Money amountSpent;
    private static Money testMoney = new Money(1); 
    private static Date testDate = new Date(4, 15, 2020); 
    private int totalTransactions = 0;

    public static void main(String[] args){
        ExpenseAccount<Bill> a = new ExpenseAccount<Bill>(); 
        a.add(new Bill(testMoney, testDate, "Lollipop"));
        System.out.println(a.toString()); 
        System.out.println(a.getAverageBillCost());
        System.out.println(a.getDollars());

    }

    /**
     * ExpenseAccount Constructor
     *
     */
    public ExpenseAccount(){
        //call super
        super();
    }

    /**
     * ExpenseAccount Constructor
     *
     * @param bill A parameter
     */
    public ExpenseAccount(Bill bill){
        if(bill == null){
            //if it is exit
            System.exit(0);
            //print input is null
            System.out.println("input is null");
        }
        listOfBills.add(bill);
    }

    /**
     * Method add
     *
     * @param input A parameter
     * @return The return value
     * @Override
     */
    public void add( Bill input, int index) {
        super.add(input, index);
        amountSpent.add(input.getAmount());
        totalTransactions++;
    }

    /**
     * Method getAverageBillCost
     *
     * @return The return value
     */
    public double getAverageBillCost(){
        if(amountSpent != null){
            double retVal = 0.0;
            retVal = amountSpent.getMoney()/(double) totalTransactions;
            //return the avarage 
            return retVal;
        }
        return -1;           
    }
    

    /**
     * Method getMoney
     *
     * @return The return value
     */
    public Money getDollars(){
        //return new money
        return new Money(amountSpent);
    }

    /**
     * Method insert
     *
     * @param obj A parameter
     * @param index A parameter
     * @Override
     */
    public void insert(Object obj, int index){
        if(obj == null){
            //if it is exit
            System.exit(0);
            //print input is null
            System.out.println("input is null");
        }
        listOfBills.insert(obj,index);        
    }
}
