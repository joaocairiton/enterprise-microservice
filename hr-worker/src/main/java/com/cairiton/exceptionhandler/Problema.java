package com.cairiton.exceptionhandler;

import java.io.Serializable;
import java.time.LocalDateTime;



public class Problema implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	
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
	
	

}
