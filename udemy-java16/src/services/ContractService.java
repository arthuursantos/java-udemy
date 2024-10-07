package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {

    public void processContract(Contract contract, Integer months) {

        OnlinePaymentService paymentService = new PaypalService();

        for (int i = 1; i <= months; i++) {
            double amount = contract.getValue()/months;
            amount += paymentService.interest(amount, i);
            amount += paymentService.paymentFee(amount);
            LocalDate dueDate = contract.getDate().plusMonths(i);
            contract.setInstallment(new Installment(dueDate, amount));
        }
    }

}
