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

		boolean errore = true;
		
		
		//inserisco il numero di posti disponibili
		int postiDisponibili = 100;

		
		Evento newEvento = null;
		Oratore newOratore = null;
		Conferenza newConferenza = null;
		
		
		System.out.println("Vuoi assistere ad una conferenza o ad un evento?");
		System.out.println("Premi 1 per la conferenza, 2 per un evento, qualsiasi altro tasto per uscire");
		String risposta = scan.nextLine();
		switch(risposta) {
		case "1":
			System.out.println("Inserisci il nome dell'oratore");
			String nomeOratore = scan.nextLine();
			System.out.println("Inserisci il cognome dell'oratore");
			String cognomeOratore = scan.nextLine();
			System.out.println("Inserisci il titolo dell'oratore");
			String titoloOratore = scan.nextLine();
			System.out.println("Inserisci l'argomento della conferenza");
			String argomento = scan.nextLine();
			System.out.print("Inserisci il titolo dell'evento: ");
			String titolo = scan.nextLine();
			//chiedo all'utente giorno,mese ed anno separatamente
			System.out.print("Inserisci il giorno: ");
			int giorno = Integer.parseInt(scan.nextLine());
			System.out.print("Inserisci il mese: ");
			int mese = Integer.parseInt(scan.nextLine());
			System.out.print("Inserisci l'anno: ");
			int anno = Integer.parseInt(scan.nextLine());
			//unisco giorno mese ed anno in un'unica variabile
			LocalDate data=null;
			try {
				data=LocalDate.of(anno, mese, giorno);
			} catch (Exception e) {
				System.out.println ("giorno o mese non valido");
			}
			//creo l'oratore e la conferenza
			try {
				newOratore = new Oratore(nomeOratore, cognomeOratore, titoloOratore);
				newConferenza = new Conferenza(titolo, data, postiDisponibili, argomento, newOratore);
			} catch (NumberFormatException e1) {
				System.out.println("Errore. Numero inserito non valido");
			} catch (NullPointerException e1) {
				System.out.println(e1.getMessage());
			} catch (IllegalArgumentException e1) {
				System.out.println(e1.getMessage());
			} while(errore);
			errore = false;
			System.out.println("Hai selezionato l'evento "+ titolo + " in data "+ data + ", dell'oratore " + nomeOratore + ", sull'argomento " + argomento);
			break;
		case "2":{
			System.out.print("Inserisci il titolo dell'evento: ");
			String titolo1 = scan.nextLine();
			//chiedo all'utente giorno,mese ed anno separatamente
			System.out.print("Inserisci il giorno: ");
			int giorno1 = Integer.parseInt(scan.nextLine());
			System.out.print("Inserisci il mese: ");
			int mese1 = Integer.parseInt(scan.nextLine());
			System.out.print("Inserisci l'anno: ");
			int anno1 = Integer.parseInt(scan.nextLine());
			//unisco giorno mese ed anno in un'unica variabile
			LocalDate data1=null;
			try {
				data1=LocalDate.of(anno1, mese1, giorno1);
			} catch (Exception e) {
				System.out.println ("giorno o mese non valido");
			}
			// creo il nuovo evento
			try {
			newEvento = new Evento(titolo1, data1, postiDisponibili);
			errore = false;
		} catch (NumberFormatException e) {
			System.out.println("Errore. Numero inserito non valido");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} while(errore);
		errore = false;
		System.out.println("Hai selezionato l'evento "+ titolo1 + " in data " + data1);
		}
		default:
			System.out.println("Ciao.");
			errore = true;
			break;
		}
		

		//se non ci sono problemi di compilazione, si passa al prossimo step
		//booleana per restare dal do
		boolean restare = true;
		
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
				} catch (Exception e) {
					System.out.println(e.getMessage());
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
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Hai prenotato " + newEvento.getPostiPrenotati() + " posti e sono rimasti "
						+ newEvento.postiDisponibili() + " posti disponibili");
				break;
			default:
				System.out.println("Ciao.");
				restare = false;
				break;
				
			}
		} while (restare);

		System.out.println(newEvento + "\n" + "Posti prenotati: " + newEvento.getPostiPrenotati() + "\n"
				+ "Posti disponibili: " + newEvento.postiDisponibili());

		scan.close();
	}


	
}