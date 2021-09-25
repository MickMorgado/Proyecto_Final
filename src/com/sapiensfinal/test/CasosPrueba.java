package com.sapiensfinal.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.sapiensfinal.repository.CasosRepositorio;

public class CasosPrueba {

	WebDriver customDriver = new ChromeDriver();
	WebDriverWait espera = new WebDriverWait(customDriver, 20);
	CasosRepositorio repositorio = new CasosRepositorio(customDriver);
	
	
	@BeforeSuite
	public void abrirNavegador() {
		customDriver.get("https://winstoncastillo.com/robot-selenium/index.php?route=common/home");
		customDriver.manage().window().maximize();
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		customDriver.close();		
	}
	
	@Test
	public void agregarProducto() throws InterruptedException	{
		
		//Obtener número de elementos en Featured y comparar que son 4
				WebElement listaProductos = repositorio.elementoLista();
				List <WebElement> productosMostrados = listaProductos.findElements(By.tagName("h4"));
				System.out.println("Número de productos listados en feature :" + " " + productosMostrados.size());
				Assert.assertEquals(productosMostrados.size(), 4);
				
				//Obtener y comparar número de Items y precio
				System.out.println("El carrito tiene: " + " " + repositorio.totalCarrito().getText() + " Puedes proceder");
				Assert.assertEquals(repositorio.totalCarrito().getText(), "0 item(s) - $0.00");
				
				//Agregar a lista lista de deseos y obtener mensaje de error
				repositorio.botonDeseosMac().click();
				Thread.sleep(2000);
				//Assert.assertEquals(customDriver.findElement(By.xpath("//*[@id=\"common-home\"]/div[1]")).getText(), "You must login or create an account to save MacBook Pro to your wish list! x"); 
				
				//Agregar Item al carrito y verificar cantidad y Precio
				repositorio.botonAgregarMac().click();
				Thread.sleep(2000);
				System.out.println("El carrito tiene: " + " " + repositorio.totalCarrito().getText());
				Assert.assertEquals(repositorio.totalCarrito().getText(), "1 item(s) - $602.00");		
	}
	
	
	@Test(dependsOnMethods= {"agregarProducto"})
	public void borrarElemento() throws InterruptedException {

		//Inicio del caso 2
		System.out.println("Ejecución del segundo caso de prueba");
		
		//Verificar que hat elementos en el carrito
		Assert.assertNotEquals(repositorio.totalCarrito().getText(), "0 item(s) - $0.00");
		System.out.println("El carrito tiene: " + " " + repositorio.totalCarrito().getText() + " Puedes proceder");
		
		//Eliminar producto de carrito 
		repositorio.totalCarrito().click();
		repositorio.botonEliminar().click();
		
		//Verificar que se eliminó el item
		Thread.sleep(2000);
		Assert.assertEquals(repositorio.totalCarrito().getText(), "0 item(s) - $0.00");
		System.out.println("El carrito tiene: " + " " + repositorio.totalCarrito().getText() + " Item eliminado");
		
	}
	
}
