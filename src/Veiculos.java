
public class Veiculos {
	private int id;
	private String marca;
	private String modelo;
	private int ano;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public Veiculos() {}
	
	public Veiculos(String marca, String modelo, int ano) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}
	
	public String[] toLinha() {
		String [] funcionario = new String[] {""+this.id, this.marca, this.modelo, this.ano+""};
		return funcionario;
	}
	
	public String toString() {
		return "ID: " + this.id + "\n" + "Marca: " + this.marca + "\n" + "Modelo: " + this.modelo + "\n" + "Ano: " + this.ano + "\n";
	}
}
