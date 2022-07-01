package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	 /* La consegna è di creare una classe  Evento  che abbia  le seguenti proprietà: 
		    titolo 
		    data 
		    numero di posti totali (cioè la capienza della location) 
		    numero di posti prenotati 
		 Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel 
		 costruttore  , tranne posti prenotati   che va inizializzato a 0. 
		 Inserire il controllo che la data non sia già passata e che il numero di posti totali sia un 
		 numero positivo. In caso contrario sollevare opportune eccezioni. 
		 Aggiungere metodi  getter  e  setter  in modo che: 
		    titolo sia in lettura e in scrittura 
		    data sia in lettura e scrittura 
		    numero di posti totali sia solo in lettura 
		    numero di posti prenotati sia solo in lettura 
		 Vanno inoltre implementati dei  metodi public  che svolgono  le seguenti funzioni: 
		 1.   prenota  : aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha più 
		 posti disponibili deve sollevare un’eccezione. 
		 2.   disdici  : riduce di uno i posti prenotati. Se l’evento  è già passato o non ci sono 
		 prenotazioni deve sollevare un’eccezione. 
		 3.   l’override  del metodo  toString()  in modo che venga  restituita una stringa 
		 contenente: data formattata - titolo 
		 Aggiungere eventuali  metodi  (public e private)  che  vi aiutino a svolgere le funzioni richieste. */
	
	//attributi
	private String titolo;
	private LocalDate data;
	private int postiTotali, postiPrenotati;
	
	//formattazione data
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	//costruttori con i valori gia inizializzati
	
	public Evento (String titolo, LocalDate data, int postiTotali, int postiPrenotati) throws NullPointerException, NumberFormatException {
		
		validaTitolo(titolo);
		validaData(data);
		validaPostiTotali(postiTotali);
		
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		postiPrenotati = 0;
	}
	
	//getters e setters
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws NullPointerException {
		validaTitolo(titolo);
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws NullPointerException, IllegalArgumentException {
		validaData(data);
		this.data = data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	//metodi private per validare i dati
	private void validaTitolo(String titolo) throws NullPointerException {
	    if (titolo == null) {
	      throw new NullPointerException("Il titolo non può essere vuoto");
	    }
	  }
	private void validaData(LocalDate data) throws NullPointerException, IllegalArgumentException {
	    if (data == null) {
	      throw new NullPointerException("La data non può essere vuota");
	    }
	    if (data.isBefore(LocalDate.now())) {
	      throw new IllegalArgumentException("La data non può essere nel passato");
	    }
	  }
	private void validaPostiTotali (int postiTotali) throws NumberFormatException {
		if (postiTotali < 0) {
			throw new NumberFormatException ("Il numero di posti totali non può essere negativo");
		}
	}
	
	//metodi public per l'utente se vuole prenotare o disdire
	public void prenotareTicket () throws Exception {
		if (data.isBefore(LocalDate.now())) {
		      throw new IllegalArgumentException("La data non può essere nel passato");
		    }		
		if (postiPrenotati == postiTotali) {
			throw new Exception ("Non c'é nemmeno un posto disponibile");
		} else {
			postiPrenotati++;
		}
	}
	
	public void disdireTicket () throws Exception {
		if (data.isBefore(LocalDate.now())) {
		      throw new IllegalArgumentException("La data non può essere nel passato");
		    }		
		if (postiPrenotati == 0) {
			throw new Exception ("Non ci sono biglietti venduti");
		} else {
			postiPrenotati--;
		}
	}
	
	private String dataFormattata() {
		return formatter.format(data);
	}
	@Override
	public String toString() {
		
		return "Evento del : " + dataFormattata()+ " - " + titolo ;
	}
}
