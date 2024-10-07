package streams003;

import streams003.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        String path = System.getenv("HOMEPATH") + "\\Ambiente de Trabalho\\in.csv";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Enter base salary: ");
        double baseSalary = sc.nextDouble();
        sc.nextLine();

        List<String> filteredEmails = employees.stream()
                .filter(p -> p.getSalary() > baseSalary)
                .map(Employee::getEmail)
                .sorted(String::compareTo)
                .toList();

        System.out.printf("Email of people whose salary is more than R$%.2f\n", baseSalary);
        filteredEmails.forEach(System.out::println);

        double sumSalaryM = employees.stream()
                .filter(p -> p.getName().charAt(0) == 'M')
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

        System.out.println("Sum of salary whose name starts with 'M': "+sumSalaryM);

        sc.close();

    }
}
