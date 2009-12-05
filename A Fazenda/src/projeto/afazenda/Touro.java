package projeto.afazenda;

/**
 * Classe Touro
 * 
 * @author Grupo 7 - A Fazenda
 * @version 1.0 09/10/2009
 * 
 */
public class Touro extends Bovino {
	
	private int ID;
	
	public Touro(String nome, int idade) throws Exception {
		super(nome, idade);		
	}
	
	/**
	 * 
	 * @return o ID do Touro
	 */
	public int getID() {
		return this.ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}

	@Override
	public String toString() {
		return "Touro: " + getNome() + " | ID: " + getID();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Touro))
			return false;
		Touro outro = (Touro) o;
		if (getNome().equals(outro.getNome()) && getIdade() == outro.getIdade()) {
			return true;
		}
		return false;
	}

}
