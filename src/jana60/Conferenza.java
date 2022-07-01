package jana60;

import java.time.LocalDate;

public class Conferenza extends Evento {
	
	 /* Creare una classe Conferenza che estende Evento, che ha anche gli attributi 
	    argomento 
	    oratore 
	 l’oratore, a sua volta, è caratterizzato da: 
	    nome 
	    cognome 
	    titolo 
	 Modificare il metodo main in modo che al momento della creazione dell’evento venga 
	 richiesto se è una conferenza, e in tal caso valorizzare tutti i parametri. 
	 Quando si stampano i dettagli della Conferenza, oltre a data e titolo, devono apparire anche 
	 le informazioni sull’oratore e sull’argomento.*/
	
	//attributi della classe conferenza
	private String argomento;
	private Oratore oratore;
	
	
	//costruttori ereditati dalla classe evento più i propri
	public Conferenza(String titolo, LocalDate data, int postiTotali, String argomento, Oratore oratore)
			throws NullPointerException, NumberFormatException, IllegalArgumentException {
		super(titolo, data, postiTotali);
		notnull(argomento);
		this.argomento = argomento;
		this.oratore = oratore;
	}
	
	private void notnull(String argomento) throws NullPointerException{
		if (argomento == null || argomento.isBlank()) {
			throw new NullPointerException("L'argomento non può essere vuoto!");	
		}
	}
	@Override
	public String toString() {
		return super.toString() + oratore.oratore() + ", ha discusso di " + argomento + ", un bell'applauso";
	}

}
