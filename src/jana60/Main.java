package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 /* 1.   Creare una classe  Main  di test, in cui si chiede all’utente  di inserire un nuovo evento 
		 con tutti i parametri. 
		 2.   Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni 
		 vuole fare e provare ad effettuarle, implementando opportuni controlli e gestendo 
		 eventuali eccezioni. 
		 3.   Stampare a video il numero di posti prenotati e quelli disponibili 
		 4.   Chiedere all’utente se e quanti posti vuole disdire 
		 5.   Provare ad effettuare le disdette, implementando opportuni controlli e gestendo 
		 eventuali eccezioni 
		 6.   Stampare a video il numero di posti prenotati e quelli disponibili */
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Benvenuto, inserisci il titolo dell'evento che vuoi vedere");
		String inputTitolo= scan.nextLine();
		System.out.println("Inserisci il giorno dell'evento");
	    int inputGiorno = scan.nextInt();
	    System.out.println("Inserisci il mese dell'evento");
	    int inputMese = scan.nextInt();
	    System.out.println("Inserisci l'anno dell'evento");
	    int inputAnno = scan.nextInt();
	    LocalDate dataEvento = LocalDate.of(inputAnno, inputMese, inputGiorno);
	    try {
	      dataEvento = LocalDate.of(inputAnno, inputMese, inputGiorno);
	    } catch (Exception e) {
	      System.out.println("Giorno o mese non valido");
	    }
	    
	    try {
			Evento newEvento = new Evento(inputTitolo, dataEvento, 1000);
			System.out.println("L'evento " + inputTitolo + " in data " + dataEvento + " è prenotato");
		} catch (NumberFormatException e) {
			System.out.println("errore " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("errore " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("errore " + e.getMessage());
		}
	    
	    
		
		
		
		
		
		
	    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		scan.close();
	}

}
