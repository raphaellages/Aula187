package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
public class Program {

	public static void main(String[] args) {
		Scanner sc=null;
		Locale.setDefault(Locale.US);
		//String patch = "C:\\Users\\rapha\\Documents\\Workspace_eclipse\\Aula187\\in.txt";
		//BufferedReader br = new BufferedReader(new FileReader(patch));
		String patch = "C:\\Users\\rapha\\Documents\\Workspace_eclipse\\Aula187\\in.txt";
		File sourceFile = new File(patch);
		try (BufferedReader br = new BufferedReader(new FileReader(patch))){
			String line = br.readLine();
			while (line != null) {
				String[] product = line.split(",");
				double totalPrice = Double.parseDouble(product[1])*Double.parseDouble(product[2]);
				String newLine = product[0]+","+String.format("%.2f", totalPrice);
				System.out.println(product[0]+","+String.format("%.2f", totalPrice));
				line = br.readLine();
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\rapha\\Documents\\Workspace_eclipse\\Aula187\\out.csv", true))){
				bw.write(newLine);
				bw.newLine();
				}
				catch(IOException e) {
					System.out.println("Error"+ e.getMessage());
				}
			}
		}
		catch (IOException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		finally {
			
		}
	}

}
