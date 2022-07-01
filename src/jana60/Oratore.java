package jana60;

public class Oratore {
	
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
	
	//attributi classe Oratore
	private String nome;
	private String cognome;
	private String titolo;

	public Oratore(String nome, String cognome, String titolo) {
		super();
		notnull(nome, cognome, titolo);
		this.nome = nome;
		this.cognome = cognome;
		this.titolo = titolo;	
	}
	
	//metodi not null per oratore
	private void notnull(String nome, String cognome, String titolo) throws NullPointerException{
		if (nome == null || nome.isBlank()) {
			throw new NullPointerException("L'oratore ha un nome!");	
	  }if (cognome == null || cognome.isBlank()) {
		throw new NullPointerException("L'oratore ha un cognome!");	
	  }	if (titolo == null || titolo.isBlank()) {
		throw new NullPointerException("L'oratore ha un titolo!");	
	  }	
	}
		
		
	
		
	
	
	
	
	public String oratore() {
		
		return "L'oratore " + nome + " " + cognome + ", di titolo " + titolo;
	}
}
