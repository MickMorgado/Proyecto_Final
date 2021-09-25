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
				System.out.println("El carrito tiene: " + " " + repositorio.totalCarrito().getText() + " Carrito vacio");
				Assert.assertEquals(repositorio.totalCarrito().getText(), "0 item(s) - $0.00");
				
				//Agregar a lista lista de deseos y obtener mensaje de error
				repositorio.botonDeseosMac().click();
				Thread.sleep(2000);
				//Assert.assertEquals(customDriver.findElement(By.xpath("//*[@id=\"common-home\"]/div[1]")).getText(), "You must login or create an account to save MacBook Pro to your wish list! x"); 
				
				//Agregar Item al carrito y verificar cantidad y Precio
				repositorio.botonAgregarMac().click();
				Thread.sleep(2000);
				System.out.println("Se agregó: " + " " + repositorio.totalCarrito().getText());
				Assert.assertEquals(repositorio.totalCarrito().getText(), "1 item(s) - $602.00");		
	}
	
	
	@Test(dependsOnMethods= {"agregarProducto"})
	public void borrarElemento() throws InterruptedException {

		//Inicio del caso 2
		
		//Verificar que hat elementos en el carrito
		Assert.assertNotEquals(repositorio.totalCarrito().getText(), "0 item(s) - $0.00");
		System.out.println("El carrito contiene: " + " " + repositorio.totalCarrito().getText() );
		
		//Eliminar producto de carrito 
		repositorio.totalCarrito().click();
		repositorio.botonEliminar().click();
		
		//Verificar que se eliminó el item
		Thread.sleep(2000);
		Assert.assertEquals(repositorio.totalCarrito().getText(), "0 item(s) - $0.00");
		System.out.println("El carrito tiene: " + " " + repositorio.totalCarrito().getText() + " Item eliminado");
		
	}
	
	@Test(dependsOnMethods= {"borrarElemento"})
	public void agregarVarios() throws InterruptedException {

		for (int Repeat = 1; Repeat < 4; Repeat++) {
			
			if(Repeat == 1 )
			
			{
				repositorio.botonAgregarMac().click();
				System.out.println("Producto n° "+ Repeat + " Agregado");
				Thread.sleep(2000);
				Repeat++;
			}
			if (Repeat == 2 )
			{
				repositorio.botonAgregarIphone().click();
				System.out.println("Producto n° "+ Repeat + " Agregado");
				Thread.sleep(2000);
				Repeat++;
			}
			if (Repeat == 3 )
			
			{
				repositorio.botonAgregarCinema().click();
				System.out.println("Producto n° "+ Repeat + " Agregado");
				Thread.sleep(2000);
				Repeat++;
			}

	}
		
		
		
	}

	
	@Test(dependsOnMethods= {"agregarVarios"})
	public void validarCarrito() throws InterruptedException {

	
		//Verificar carrito
		repositorio.botonListaCarrito().click();
		Assert.assertTrue(repositorio.vistaProductos().isEnabled());
		Assert.assertEquals(repositorio.totalCarrito().getText(), "3 item(s) - $847.20");
		
		//Ir a la página verificar carrito
		repositorio.botonVerCarrito().click();
		Assert.assertEquals(customDriver.getTitle(), "Shopping Cart");
		
		WebElement listaCarrito = repositorio.tablaCarrito();
		List <WebElement> productosAgregados = listaCarrito.findElements(By.className("text-center"));
		Assert.assertEquals(productosAgregados.size(), 3);
		System.out.println("Número de productos diferentes agregados al carrito  :" + " " + productosAgregados.size());
	
		
		
	}

	
	
}
