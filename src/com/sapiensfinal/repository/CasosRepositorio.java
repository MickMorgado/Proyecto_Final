package com.sapiensfinal.repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CasosRepositorio {

	public CasosRepositorio(WebDriver navegador) {
	
		this.driver = navegador;
		PageFactory.initElements(driver, this);
		
	}
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]")
	WebElement listaProd;
	
	@FindBy(id="cart-total")
	WebElement montoCarrito;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[2]")
	WebElement BotonD;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]")
	WebElement BotonA;
		
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[5]/button")
	WebElement BotonE;
	
	public WebElement elementoLista() {
		return listaProd;
	}
	
	public WebElement totalCarrito() {
		return montoCarrito;
	}
	
	public WebElement botonDeseosMac() {
		return BotonD;
	}
	
	public WebElement botonAgregarMac() {
		return BotonA;
	}
	
	public WebElement botonEliminar() {
		return BotonE;
	}

}
