package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

    protected static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    protected LocalDate dueDate;
    protected Double amount;

    public Installment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String toString() {
        return dueDate.format(fmt) + " - " + String.format("%.2f", amount);
    }

//    @Override
//    public int compareTo(Installment other) {
//        return -getAmount().compareTo(other.getAmount());
//    }
}
