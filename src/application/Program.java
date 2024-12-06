package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entiites.LogEntry;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter file full path");

		String path = "C:\\Users\\WINDOWS 11\\eclipse-workspace\\ExercicioResolvidoHashSetJava\\lista.txt";

		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {

			Set<LogEntry> set = new HashSet<LogEntry>();

			String line = bf.readLine();

			while (line != null) {

				String[] vet = line.split(" ");

				String username = vet[0];
				Date moment = Date.from(Instant.parse(vet[1]));

				set.add(new LogEntry(username, moment));

				line = bf.readLine();

			}

			System.out.println("Total users: " + set.size());

		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}

		sc.close();

	}

}
