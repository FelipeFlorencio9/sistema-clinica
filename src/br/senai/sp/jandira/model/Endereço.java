package br.senai.sp.jandira.model;

public class Endereço {
	private String cep;
	private String cidade;
	private String logradouro;
	private String bairro;
	private String pontoDeReferência;
	private String numero;
	private String tipo;
	private Estados estado;
	private String complemento;

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setPontoDeReferência(String pontoDeReferência) {
		this.pontoDeReferência = pontoDeReferência;
	}

	public String getPontoDeReferência() {
		return pontoDeReferência;
	}

	public void setNúmero(String número) {
		this.numero = número;
	}

	public String getNúmero() {
		return numero;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getEndereçoCompleto() {
		return "CEP: " + cep + "Cidade: " + cidade + "Logradouro" + logradouro + "Bairro: " + bairro
				+ "Ponto de Referência: " + pontoDeReferência + "Número: " + numero + "Tipo: " + tipo + "Estado: "
				+ estado + "Complemento: " + complemento;
	}

}
