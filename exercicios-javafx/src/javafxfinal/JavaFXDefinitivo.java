package javafxfinal;

public class JavaFXDefinitivo {

	// LTS(Long Term Support) - São versões estáveis que tem como objetivo serem
	//  usadas em produção. Você tem a garantia de que vai utilizá-la em
	//  produção e ter um supote de mais longo prazo.

	/*
	 * Em: Preferences -> Java -> Build Path -> User Libraries
	 * 
	 * Você consegue adicionar as suas bibliotecas. Bibliotecas do usuário. A
	 * bibliotecas do usuário é atrelada para aquele workspace específico.
	 * 
	 * Após definir o nome, adicione arquivos JARs externos. É importante nos
	 * arquivos JARs você adicionar também o "Source attachment". Para ter acesso à
	 * documentação. Edite cada um dos arquivos adicionando como "External File" o
	 * JRC.
	 * 
	 * É necessário configurar o Build Path para utilização de qualquer biblioteca.
	 * Também é preciso requerir aos pacotes que serão utilizados no module-info.
	 */

	/*
	 * System.exit(0); // 0 significa que você finalizou a aplicação sem erro.
	 * Por convenção, um status diferente de zero indica encerramento anormal. 
	 * "System.exit(0);" == "Runtime.getRuntime().exit(0);".
	 * 
	 */
	
	/* Utilizando arquivos "css" e "fxml".
	 * 
	 * "getResource()" recebe uma String e retorna uma URL.
	 * "toExternalForm()" tranforma uma URL em String.
	 * 
	 * String arquivoCSS = getClass().getResource("/fxml/Login.css").toExternalForm();
     * URL arquivoFXML = getClass().getResource("/fxml/Login.fxml");
     * GridPane raiz = FXMLLoader.load(arquivoFXML);
     * 
     * Scene cena = new Scene(raiz, 350, 350);
     * cena.getStylesheets().add(arquivoCSS);
     * 
     * 
     * A pagina uigradients ajuda a encontrar gradients.
     * Inspecione o gradiente e pegue o código css equivalente.
	 */
	
	/*
	 * Biblioteca ControlsFX ajuda.
	 */
	
}