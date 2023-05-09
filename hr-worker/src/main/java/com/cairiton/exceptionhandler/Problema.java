package com.cairiton.exceptionhandler;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;



public class Problema implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campos;
	
	public Problema() {}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
public static class Campo {
	
	
		
		private String name;
		private String mensagem;
		
		public Campo () {}
		
		public String getName() {
			return name;
		}
		public String getMensagem() {
			return mensagem;
		}

		public Campo(String name, String mensagem) {
			super();
			this.name = name;
			this.mensagem = mensagem;
		}
		
		
	}
	
	
	
	

}
