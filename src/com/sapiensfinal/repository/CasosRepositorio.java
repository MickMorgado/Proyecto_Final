package com.sapiensfinal.repository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")
	WebElement BotonAgregarIphone;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[3]/div/div[3]/button[1]")
	WebElement BotonAgregarCinema;
	
	@FindBy(xpath="//*[@id=\"cart\"]/button")
	WebElement BotonListaCarrito;
		
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")
	WebElement BotonVerCarrito;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody")
	WebElement TablaCarrito;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[5]/button")
	WebElement BotonE;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul")
	WebElement VistaProducto;
	
	
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
	
	public WebElement botonAgregarIphone() {
		return BotonAgregarIphone;
	}
	
	public WebElement botonAgregarCinema() {
		return BotonAgregarCinema;
	}
	
	public WebElement botonEliminar() {
		return BotonE;
	}
	
	public WebElement botonListaCarrito() {
		return BotonListaCarrito;
	}
	
	public WebElement botonVerCarrito() {
		return BotonVerCarrito;
	}
	
	public WebElement tablaCarrito() {
		return TablaCarrito;
	}

	public WebElement vistaProductos() {
		return VistaProducto;
	}
	
}
