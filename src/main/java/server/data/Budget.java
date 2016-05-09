package server.data;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
public class Budget {

    private String name;
    private String startDate;
    private String endDate;
    private int numDays;
    private int balance;

    public Budget(String name) {
        this.name = name;
    }

    public void setName(String name) { this.name = name; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public void setNumDays(int numDays) { this.numDays = numDays; }
    public void setBalance(int balance) { this.balance = balance; }

    public String getName() { return name; }
    public String getStartDate () { return startDate; }
    public String getEndDate() { return endDate; }
    public int getNumDays() { return numDays; }
    public int getBalance() { return balance; }

}
