package br.com.cod3r.exerciciossbfinal;

public class PadraoMVC {

	// CONCEITOS - 1. VISAO GERAL
	
	/*
	 * - MODEL
	 *   Seria o coração da sua aplicação.
	 *   No model é onde ficaria as suas regras de negócio, entidades, camada de acesso a dados, ...
	 *   
	 * - VIEW
	 *   Ela é a responsável por renderizar a resposta.
	 *   Seja em aplicações desktop ou web(foco da aula).
	 *   Nesse caso, ela é a responsável por renderizar a página como resposta para a requisição.
	 *   Ou seja, renderizar a página significa que você vai trabalhar na view
	 *    com JS, CSS, HTML, Template Engine, ...
	 *    
	 * - CONTROLLER
	 *   No meio desses 2 temos o controller, coordenando o fluxo de dados.
	 *   O controller é o cara que faz o intermédio de todo o fluxo.
	 *   
	 *   
	 * EXPLICAÇÃO COM EXEMPLO REAL:
	 * 
	 * Imagine que você está na frente de um prédio.
	 * 
	 * Você tem que entregar uma requisição para alguém que trabalha lá.
	 * Você não sabe o andar e nem em qual sala essa pessoa se encontra.
	 * A única coisa que você tem é o nome dela na requisição.
	 * 
	 * Ao entrar no prédio, a primeira coisa que você vê é a recepcionista.
	 * Ela vai te dar as informações necessárias para você entregar esse request.
	 * Ela te diz o seguinte: 
	 * 		"Você não pode levar essa requisição em mãos para essa pessoa!
	 * 		  Mas, temos funcionários do prédio que podem levar essa requisição
	 * 		  e vão trazer a resposta para você.".
	 * 
	 * 
	 * O prédio representa a minha aplicação MVC.
	 * 
	 * Quando entro com uma requisição dentro da minha aplicação MVC, a primeira pessoa
	 *  que recepciona essa minha requisição representa o meu framework MVC, ou
	 *  em alguns contextos, isso é chamado de "front Controller".
	 * Esses frameworks MVC, assim como a secretária, podem acessar algum arquivo de 
	 *  metadados como um XML, JSON, ...
	 * Dentro desse arquivo vai ter, por exemplo, o mapeamento das rotas. Ou seja, qual Url
	 *  aponta para qual método. 
	 * Esse framework vai ter toda essa inteligência para coordenar o fluxo dessas
	 *  requisições e encaminhar para os lugares certos.
	 *  
	 * Então, quando você entrega a requisição para a recepcionista, ela vai chamar alguém
	 *  e dizer: "Essa requisição tem que ser atendida por fulano que está na sala 413."
	 * Essa pessoa que vai levar a requisição, que vai encarregar-se de pegar as
	 *  informações para trazer a resposta, é o CONTROLLER.
	 * Ou seja, o CONTROLLER, na verdade, pede para o MODEL as informações necessárias,
	 *  ele conhece quais informações ele precisa para renderizar a VIEW.
	 * 
	 * 
	 */
	
	
	/*
	 * Em um primeiro momento você tem o BROWSER gerando uma requisição a partir de uma Url.
	 * Essa requisição vai bater no seu WEB SERVER, podendo ser por exemplo, um Tomcat, Nginx, Apache, ...
	 * Chegando no seu WEB SERVER, a partir da Url ele vai saber para qual aplicação ele vai direcionar.
	 * Vamos supor que só tenha uma aplicação. Ele direciona para a aplicação que é o alvo da requisição.
	 * Dentro da aplicação o seu framework vai saber para onde que ele vai direcionar.
	 * A primeira camada que vai receber a sua requisição, dentro do modelo MVC é a camada CONTROLLER.
	 * 
	 *  BROWSER
	 * 	   |
	 * 	   v
	 * WEB SERVER
	 *     |
	 * 	   v
	 * APLICAÇÃO
	 *     |
	 * 	   v 
	 * CONTROLLER
	 * 
	 * Essa demonstração serve para as duas próximas explicações do fluxo.
	 * 
	 */
	
	
	
	
	// 2. FLUXO SEM NECESSIDADE DE ACESSAR DADOS
	
	/*
	 * Nesse caso, não é necessário passar pela camada MODEL.
	 * MODEL é a camada que se liga ao banco de dados.
	 * Então, nesse primeiro cenário eu estou apenas querendo mostrar uma tela, por exemplo, no browser.
	 * Sem que haja a necessidade de dados para renderizar essa tela.
	 * 
	 * Fluxo: 
	 * O BROWSER vai gerar uma requisição.
	 * Essa requisição vai chegar no meu CONTROLLER.
	 * 
	 * ------------------------------------------------------------------------------------------------------------
	 * 
	 * BROWSER --requisição--> CONTROLLER
	 *    
	 * ------------------------------------------------------------------------------------------------------------
	 *    
	 *    
	 * O CONTROLLER vai ver que para atender essa requisição, como por exemplo,
	 *  exibir a tela inicial do sistema com menu, não é necessário ir no banco de dados ou validar alguma regra.
	 * É um sistema simples, então eu vou simplesmente encaminhar a minha requisição para a VIEW.
	 * 
	 * ------------------------------------------------------------------------------------------------------------
	 * 
	 * BROWSER --requisição--> CONTROLLER --encaminha-->  VIEW
	 *    
	 * ------------------------------------------------------------------------------------------------------------
	 *    
	 *    
	 * A VIEW vai renderizar a resposta e essa resposta é enviada para o BROWSER.
	 * 
	 * ------------------------------------------------------------------------------------------------------------
	 * 
	 * BROWSER --requisição--> CONTROLLER --encaminha-->  VIEW
	 *    ^                                                 |
	 *    |_____________________resposta____________________|
	 *    
	 * ------------------------------------------------------------------------------------------------------------
	 *    
	 *    
	 */
	
	
	
	
	// 3. FLUXO COM DADOS
	
	/*
	 * 
	 * Fluxo: 
	 * O BROWSER vai gerar uma requisição.
	 * Essa requisição vai chegar no meu CONTROLLER.
	 * 
	 * ------------------------------------------------------------------------------------------------------------
	 * 
	 * BROWSER --requisição--> CONTROLLER
	 * 
	 * ------------------------------------------------------------------------------------------------------------     
	 *     
	 *                                                        
	 * O CONTROLLER vai ver que para atender essa requisição, como por exemplo,
	 *  exibir a lista de clientes cadastrados, é necessário ir no banco de dados.
	 * Ele encaminha essa requisição para o MODEL, pedindo a lista de clientes cadastrados.
	 * 
	 * ------------------------------------------------------------------------------------------------------------
	 * 
	 * BROWSER --requisição--> CONTROLLER --instancia--> MODEL
	 *     
	 * ------------------------------------------------------------------------------------------------------------
	 *          
	 *                                                        
	 * O MODEL vai na base, ler as informações, pega e devolve essa lista de clientes cadastrados para o CONTROLLER.
	 * 
	 * ------------------------------------------------------------------------------------------------------------
	 * 
	 * BROWSER --requisição--> CONTROLLER <--instancia--> MODEL
	 *                                                      |
	 *                                                    acessa
	 *                                                      |
	 *                                                      v
	 *                                                     ...
	 *                                                        
	 * ------------------------------------------------------------------------------------------------------------
	 *     
	 *                                                        
	 * O CONTROLLER nesse momento ele pode precisar de mais dados, como por exemplo, a lista dos clientes que estão
	 *  desativados. Então, ele vai no MODEL novamente, pega a lista dos clientes desativados e retorna.
	 *  Podendo repetir esse fluxo diversas vezes. Até ele ter todos os dados necessários para rendezizar a VIEW.
	 *  
	 * ------------------------------------------------------------------------------------------------------------
	 *  
	 * BROWSER --requisição--> CONTROLLER *<--instancia-->* MODEL
	 *                                                        |
	 *                                                      acessa
	 *                                                        |
	 *                                                        v
	 *                                                       ...
	 *                                                        
	 * ------------------------------------------------------------------------------------------------------------
	 *             
	 *                                                        
	 * Ele pega e passa esses dados para a VIEW.
	 * 
	 * ------------------------------------------------------------------------------------------------------------
	 * 
	 * BROWSER --requisição--> CONTROLLER *<--instancia-->* MODEL
	 *                              |                         |
	 *                          encaminha                   acessa
	 *   VIEW                       |                         |
	 *    |_________________________|                         v
	 *                                                       ...
	 *                                                        
	 * ------------------------------------------------------------------------------------------------------------
	 *          
	 *                                                        
	 * A VIEW vai renderizar a resposta, utilizando como insumo esses dados.
	 * A resposta sendo renderizada, ela é enviada para o BROWSER.
	 * 
	 * ------------------------------------------------------------------------------------------------------------
	 * 
	 * BROWSER --requisição--> CONTROLLER *<--instancia-->* MODEL
	 *    ^                         |                         |
	 *    |                     encaminha                   acessa
	 *   VIEW                       |                         |
	 *    |_________________________|                         v
	 *                                                       ...
	 * ------------------------------------------------------------------------------------------------------------
	 * 
	 */
}




