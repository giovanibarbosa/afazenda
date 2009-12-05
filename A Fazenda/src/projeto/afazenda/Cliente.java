package projeto.afazenda;

/**
 * Classe que representa um Cliente
 * @author Gruopo 07 - A Fazenda
 *
 */
public class Cliente {

	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	
	/**
	 *  Construtor Cliente
	 * @param nome
	 * @param cpf
	 * @param endereco
	 * @param telefone
	 * @throws Exception se o nome cpf ou telefone forem invalidos
	 */
	public Cliente(String nome,String cpf,String endereco, String telefone)throws Exception{
		if(nome == null || !nome.matches("[a-zA-Z[ ]]+") || nome.isEmpty()){
			throw new Exception("Nome invalido, digite um nome!");
		}
		if(cpf == null || !cpf.matches("[0-9]{11}")){
			throw new Exception("Cpf invalido!");
		}
		
		if(endereco == null || endereco.isEmpty()){
			throw new Exception("Endereco invalido!");
		}
		if (telefone == null || telefone.length() != 10){
			throw new Exception("Telefone Invalido");
		}
		this.nome=nome;
		this.cpf=cpf;
		this.endereco=endereco;
		if (telefone.isEmpty()) {
			this.telefone = "Sem telefone";
		} else {
			this.telefone = telefone;
		}
	}
	
	/**
	 * 
	 * @return Nome do cliente.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * recebe um novo nome
	 * @param novoNome
	 */
	public void setNome(String novoNome){
		if (novoNome.matches("[a-zA-Z[ ]]+")){	
			this.nome=novoNome;
		}
	}
	
	/**
	 * 
	 * @return CPF do cliente.
	 */
	public String getCpf() {
		return cpf.substring(0,3) + "." + cpf.substring(3,6) + "." + 
		cpf.substring(6,9) + "-" + cpf.substring(9,11);
	}
	
	/**
	 * recebe novo telefone
	 * @param novoTelefone
	 */
	public void setTelefone(String novoTelefone){
		if (novoTelefone.equals("")) {
            telefone="Sem Telefone";
        }
		if (novoTelefone.matches("[0-9]{10}")) {
			this.telefone = novoTelefone;
		}
    }
	
	/**
	 * retorna o telefone com a formatacao correta
	 * (00)0000-0000
	 * @return telefone
	 */

	public String getTelefone() {
		if (telefone==null || telefone.equals("Sem telefone")) {
			return "Sem Telefone";
		}
		else {
			return "("+telefone.substring(0,2)+")"+telefone.substring(2,6)+"-"+telefone.substring(6,10);
		}
	}
	
	/**
	 * 
	 * @return Endereco do cliente.
	 */
		
	public String getEndereco() {
		return endereco;
	}
	
	/**
	 * recebe novo endereco
	 * @param endereco
	 * @throws lanca excecao se o endereco for invalido
	 */
	
	public void setEndereco(String endereco){
		if (!(endereco == null) || !(endereco.equals("")) ) {
			this.endereco = endereco;
		}
	}
	
	@Override
	public String toString(){
		return "Nome: "+getNome()+
				"\nCpf: "+getCpf()+
				"\nTelefone: "+getTelefone()+
				"\nEndereco: "+getEndereco();
	}
	
}
