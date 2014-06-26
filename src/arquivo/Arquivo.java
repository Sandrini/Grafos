package arquivo;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;



public class Arquivo{


	public Scanner readFile() throws FileNotFoundException {
		//testa se arquivo existe, senao existe permite a criacao do arquivo ou encerra
		Scanner scanner = new Scanner(new FileReader("grafo.txt"));
		return scanner;
	}//fim teste

}//fim classe arquivo