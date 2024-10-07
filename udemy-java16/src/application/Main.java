package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato: ");
        System.out.print("Número: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Valor do contrato: ");
        double amount = sc.nextDouble();

        System.out.print("Entre com o número de parcelas: ");
        int months = sc.nextInt();
        sc.nextLine();

        Contract contract = new Contract(number, date, amount);
        ContractService contractService = new ContractService();
        contractService.processContract(contract, months);

        System.out.println("\nParcelas: ");
//        Collections.sort(contract.getInstallments());
        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

    }
}
