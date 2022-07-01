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
	private static String nome;
	private static String cognome;
	private String titolo;

	public Oratore(String nome, String cognome, String titolo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.titolo = titolo;
		
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	
	public static String oratore() {
		
		return "L'oratore " + nome + " " + cognome;
	}
}
