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
		 6.   Stampare a video il numero di posti prenotati e quelli disponibili 
		 
		 Modificare il metodo main in modo che al momento della creazione dell’evento venga 
	 richiesto se è una conferenza, e in tal caso valorizzare tutti i parametri. 
	 Quando si stampano i dettagli della Conferenza, oltre a data e titolo, devono apparire anche 
	 le informazioni sull’oratore e sull’argomento.*/
		
		Scanner scan = new Scanner(System.in);
		String risposta;
		int postiDisponibili = 100;
		
		boolean prosegui =true;
		
		Evento newEvento = null;
		Oratore newOratore = null;
		Conferenza newConferenza = null;
		String argomento = "lol";
		
		do {
			System.out.println("Vuoi assistere ad una conferenza? \nRispondi si per prenotare una conferenza, no per proseguire");
			risposta = scan.nextLine();
		} while (!risposta.equals("si") && !risposta.equals("no")); 
		
		
		
		if (risposta.equalsIgnoreCase("si")) {
			System.out.println("Nome oratore");
			String nomeOratore = scan.nextLine();
			System.out.println("Cognome oratore");
			String cognomeOratore = scan.nextLine();
			System.out.println("Titolo oratore");
			String titoloOratore = scan.nextLine();
			System.out.println("Argomento trattato");
			argomento = scan.nextLine();
			
			
			//Istanziare oratore
			try {
				newOratore = new Oratore(nomeOratore, cognomeOratore, titoloOratore);
			} catch (NullPointerException e) {
				System.out.println("Impossibile istanziare l'oratore: " + e.getMessage());
				prosegui=false;
			} 
		}
		if(prosegui) {	
		System.out.println("Inserisci i parametri di un nuovo evento \nInserisci il titolo");
		String titolo = scan.nextLine();
		System.out.println("Inserisci il giorno");
		int giorno = Integer.parseInt(scan.nextLine());
		System.out.println("Inserisci il mese");
		int mese = Integer.parseInt(scan.nextLine());
		System.out.println("Inserisci l'anno");
		int anno = Integer.parseInt(scan.nextLine());
		LocalDate dataEvento = null;
		try {
			dataEvento = LocalDate.of(anno, mese, giorno);
		} catch (Exception e) {
			System.out.println("Giorno o mese non valido");
		}
				
		//Istanziare l'evento e la conferenza ed effettuare i controlli
		try {
			newEvento = new Evento(titolo, dataEvento, postiDisponibili);
			newConferenza = new Conferenza(titolo, dataEvento, postiDisponibili, argomento, newOratore);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			prosegui=false;
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			prosegui=false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			prosegui=false;
		}
		
	}
		
		if(prosegui) {
			//se non ci sono problemi di compilazione, si passa al prossimo step
			
			do {
				System.out.println("Inserisca 1 per prenotare un posto, 2 per disdire un posto, qualsiasi altro tasto per uscire:");
				String scelta = scan.nextLine();
				switch (scelta) {
				case "1":
					System.out.println("Quanti posti vuoi prenotare?");
					int postiP = Integer.parseInt(scan.nextLine());
					try {
						for(int i=0; i<postiP; i++)
						newEvento.prenota();
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
						prosegui=false;
					} catch (Exception e) {
						System.out.println(e.getMessage());
						prosegui=false;						
					}
					System.out.println("Hai prenotato " + newEvento.getPostiPrenotati() + " posto/i e sono rimasti "
							+ newEvento.postiDisponibili() + " posti disponibili");
					break;
				case "2":
					System.out.println("Quanti posti vuoi disdire?");
					int postiD = Integer.parseInt(scan.nextLine());
					try {
						for(int j=0; j<postiD; j++)
						newEvento.disdici();
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
						prosegui=false;
					} catch (Exception e) {
						System.out.println(e.getMessage());
						prosegui=false;
					}
					System.out.println("Hai prenotato " + newEvento.getPostiPrenotati() + " posto/i e sono rimasti "
							+ newEvento.postiDisponibili() + " posti disponibili");
					break;
				default:
					System.out.println("Ciao, alla prossima");
					prosegui=false;
					break;
					
				}
			} while (prosegui);
			
			if(argomento =="lol") {
			System.out.println("\n\n"+newEvento.toString() + "\n" + "Posti prenotati: " + newEvento.getPostiPrenotati() + "\n"
					+ "Posti disponibili: " + newEvento.postiDisponibili());
			} else {
				System.out.println("\n\n"+newConferenza.toString() + "\n" + "Posti prenotati: " + newEvento.getPostiPrenotati() + "\n"
					+ "Posti disponibili: " + newEvento.postiDisponibili()) ;
			}
		}
			
		scan.close();
	}
	
}