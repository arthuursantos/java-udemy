package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int taxPayers = sc.nextInt(); sc.nextLine();

        List<Pessoa> payersList = new ArrayList<>();
        for (int i = 1; i <= taxPayers; i++) {
            System.out.printf("%nTax Payer #%d%n", i);
            System.out.print("Name: ");
            String nome = sc.nextLine();
            System.out.print("Anual income: ");
            double rendaAnual = sc.nextDouble(); sc.nextLine();
            System.out.print("Individual or company (i/c): ");
            char type = sc.next().charAt(0);
            switch (Character.toUpperCase(type)) {
                case 'I':
                    System.out.print("Health expenditures: ");
                    double gastosSaude = sc.nextDouble(); sc.nextLine();
                    payersList.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
                    break;
                case 'C':
                    System.out.print("Number of employees: ");
                    int employees = sc.nextInt(); sc.nextLine();
                    payersList.add(new PessoaJuridica(nome, rendaAnual, employees));
                    break;
            }
        }

        double sumTaxes = 0;
        System.out.printf("%nTAXES PAID: %n");
        for (Pessoa pessoa : payersList) {
            System.out.printf("%s: $%.2f%n", pessoa.getNome(), pessoa.getRendaAnual());
            sumTaxes += pessoa.calcImposto();
        }

        System.out.printf("%nTOTAL TAXES: $%.2f%n", sumTaxes);

        sc.close();
    }
}
