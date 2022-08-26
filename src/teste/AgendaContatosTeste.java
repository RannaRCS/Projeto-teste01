package teste;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgendaContatosTeste {

	@Test
	public void test() {
		
		// definindo o local do drive para o chrome 
		System.setProperty("webdriver.chrome.driver","chromedriver");

		//Abrindo o googlechrome
		WebDriver driver = new ChromeDriver();

		//maximizando a janela do navegador
		driver.manage().window().maximize();
		
		//acessar a página de cadastro de conta de usuário
		driver.get("http://sergiocontatos-001-site1.ftempurl.com/Account/Register");
		
		//preenchendo o nome do usuário
		int random =  new Random().nextInt(999999);
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Ranna Rechuem");
				
		// preenchendo email do usuario 
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("rannarcs123@gmail.com");
				
		//preenchendo a senha 
		driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys("Ranna123");
		
		//preencher confirmação de senha 
		driver.findElement(By.xpath("//*[@id=\"SenhaConfirmacao\"]")).sendKeys("Ranna123");
		
		//click no botao de cadastro 
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/form/div[5]/input")).click();
		
		//ler a mensagem obtida 
		String mensagem = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[2]/strong")). getText();
		
		//Comparando o resultado esperado X resultado obtido 
		assertEquals(mensagem, "Parabéns Ranna Rechuem, sua conta foi cadastrada com sucesso!");
		
		// fechar o navegador 
		driver.close();
		driver.quit();
		
	}
	
}

