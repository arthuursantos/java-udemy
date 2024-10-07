package set003;

import set003.entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.util.*;

public class Program {
    public static void main(String[] args) {

        Set<LogEntry> users = new HashSet<>();
        String path = System.getenv("HOMEPATH")+"\\Ambiente de Trabalho\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.strip().split(" ");
                users.add(new LogEntry(fields[0], Date.from(Instant.parse(fields[1]))));
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(users.size());

    }
}
