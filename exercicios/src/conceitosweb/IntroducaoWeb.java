package conceitosweb;

public class IntroducaoWeb {

	/* MARCOS IMPORTANTES
	 * 
	 * 	1950 / COMPUTADOR ELETRÔNICO
	 * 
	 * 	1960 / ARPANET - DEPARTAMENTO DE DEFESA AMERICANO
	 * 
	 * 	1970 / TCP/IP - ROBERT E.KAHN & VINT CERF
	 * 
	 * 	1980 / WWW - TIM BERNERS-LEE
	 * 
	 * 	1990 / INTERNET NO BRASIL
	 * 
	 * 	2000 / IG, REDES SOCIAIS, INTERNET EM CASA
	 */
	
	
	/*
	 * A internet nada mais é do que uma grande rede de computadores.
	 * 
	 * TOPOLOGIAS...
	 * 
	 * Centralizada - Vários computadores ligados a um nó central.
	 * 	Você tem uma rede da sua empresa que tem um switch e todos os computadores
	 *   são conectados nesse switch.
	 *  O switch é um nó central, uma vez que ele deixa de funcionar, toda a rede também para.
	 *  Um ponto central de comunicação e também um ponto central de falha.
	 *  
	 * Distribuída - É de fato a topologia assumida pela internet.
	 *  Não existe um poder central em cima da internet, na verdade, é um poder de todos.
	 *  
	 *  
	 * WEB(TEIA)
	 * 
	 * Você tem vários níveis de redes. Você tem, por exemplo, grandes backbones que
	 *  ultrapassam de um continente para outro.
	 * Você tem redes de nível 1, 2, 3.
	 */
	 
	/*
	 * A base da internet é o Protocolo TCP/IP - Transmission Control Protocol/Internet Protocol.
	 * O TCP é um protocolo da camada de transporte, orientado a conexão e é um protocolo confiável.
	 *  
	 *  
	 * Em contrapartida, você tem UDP - User Datagram Protocol.
	 * Esse é um protocolo não orientado à conexão e é um protocolo baseado no melhor esforço.
	 *  
	 * O UDP não tem essa confiabilidade que o TCP tem.
	 * Em alguns momentos o UDP é mais recomendado já que é um protocolo mais leve.
	 * Já o TCP tem o que chamamos de handshake. Há uma conversa preliminar com as duas pontas
	 *  para que de fato o dado seja transferido.
	 * Já o UDP é o de melhor esforço. Por exemplo, você está fazendo um streaming de dados,
	 *  que é algo rápido e não importa se, por exemplo, determinado pacote for perdido já
	 *  que no streaming o conteúdo é mais importante que seja entregue em tempo real. Então, o UDP
	 *  é mais apropriado. Porém, por norma acabamos utilizando o TCP na grande
	 *  maioria das aplicações voltadas para a internet.
	 *  
	 * O IP é o protocolo responsável por fazer essa comunicação entre redes. Roteamento entre redes.
	 */
	
	
	/*
	 * TCP/IP
	 * 
	 * É baseado em um padrão de projeto chamado layers. Ou seja, o TCP/IP, na verdade, nada mais é
	 *  um protocolo, que é uma aplicação, um software e esse software usa um padrão de projeto chamado layers.
	 * Ele é um dos grandes exemplos do padrão layers. Por que o protocolo como algo complexo ele é separado
	 *  em camadas, cada camada tendo sua própria responsabilidade.
	 *  
	 * Temos as camadas:
	 * 
	 * APLICAÇÃO
	 *  |	 ^
	 *  v 	 |
	 * TRANSPORTE
	 *  |	 ^
	 *  v 	 |
	 * INTERNET
	 *  |	 ^
	 *  v 	 |
	 * REDE/FÍSICA
	 * 
	 * Se você pegar essa mesma pilha e trazer ela para o modelo OSI, serão mais camadas.
	 * A dependência é, a camada de cima usa os serviços da camada de baixo. Sem ter dependência cíclica.
	 * 
	 * O importante aqui é destacar que esse protocolo segue o padrão de projetos layers, que dividi
	 *  um software maior em camadas, com cada camada tendo sua própria responsabilidade.
	 *  
	 * Responsabilidades:
	 * 
	 * REDE/FÍSICA 
	 * - Ethernet, Wi-Fi...
	 * 		Tipo de conexão física.
	 * - MAC address
	 * 		Endereço MAC, é o endereço relacionado a interface de rede que você está trabalhando.
	 * - Física(Hardware) e Enlace(Software)
	 * 		Aqui envolve duas camadas do modelo OSI. Que é a camada Física e Enlace.
	 * 		Enlace é uma comunicação de ponta a ponta. Saber se de fato o bit de paridade, sinais elétricos, ...
	 * 		Esse mundo físico do dado trafegando dentro dos canais de comunicação.
	 * 
	 * INTERNET
	 * - IP - Internet Protocol
	 * 		É o endereço que identifica uma máquina em uma rede.
	 *  	Você pode ter duas máquinas com o mesmo endereço IP?
	 *      Sim, desde que estejam em redes segregadas para não haver nenhum tipo de conflito.
	 *      Você pode ter um endereço IP válido na internet, um endereço IP que qualquer pessoa do mundo
	 *      pode chegar diretamente na sua máquina ou você pode ter um endereço IP local e algum tipo de
	 *       roteamento fazer com que os dados cheguem na sua máquina mesmo não tendo um endereço válido.
	 *      É aí que você tem a ideia de Gateway na rede, sendo a máquina que vai levar sua requisição para
	 *       fora de uma rede local dentro da sua empresa.
	 * - Conexão entre redes
	 * - Transferência de Pacotes
	 * 
	 * TRANSPORTE
	 * - TCP(Confiável), UDP(Melhor esforço)...
	 * 	TCP(Transmission Control Protocol) é mais confiável.
	 * 	UDP é bom se você tiver algo crítico, mais em tempo real, uma transmissão, por exemplo, em que você quer
	 *  transmitir ela de uma forma mais leve, sem que haja tantos tipos de handshake e coisas na comunicação.
	 *  Então, alguns serviços como, por exemplo, o DNS utiliza o UDP como base da sua comunicação.
	 * - Comunicação Host-A-Host
	 * - Confiabilidade, integridade...
	 * 
	 * APLICAÇÃO
	 * - HTTP, FTP, SMTP...
	 * 		
	 * - Comunicação Processo-A-Processo
	 * - Número da Porta
	 * 
	 * Essa é a camada que vamos trabalhar de forma mais forte,
	 *  a camada em que é importante que você conheça melhor.
	 * Aqui você tem uma comunicação processo a processo. Ou seja, não basta você comunicar o seu computador
	 *  com o computador do Google, você tem que comunicar o browser que está rodando no seu computador com
	 *  o servidor web que está provendo aquele site, sistema, ...
	 *  
	 * Anatomia do IPV4...
	 *  
	 *  Classe A - 192.168.100.230
	 *  
	 *  Um número separado em 4 partes e cada parte indo de 0 até 255.
	 *  Parte desse IP é destinada a identificar a rede em que o computador está e outra parte é destinado
	 *   para identificar o computador em uma rede.
	 *   
	 *  Classe A - 192.168.100.230
	 *  	Primeira parte(192) identifica a rede.
	 *  	Outras partes(168.100.230) identifica o computador dentro da rede.
	 *  Máscaras de sub-rede: 255.0.0.0
	 *  	
	 * 	Nesse cenário fica claro que você tem poucas redes e dentro de cada rede
	 *   você tem muitas e muitas máquinas.
	 *  São pouquíssimas redes de classe A que existem no mundo.
	 *  Dentro dessa organização, para definir o que é rede e o que é host, existe a máscaras de sub-rede.
	 *  A máscara de sub-rede é um número que está associado com o IP.
	 *  Qual a lógica de formação disso? A máscara de sub-rede tem o mesmo tamanho de um IP.
	 *  Sempre que na máscara de sub-rede determinado bit está marcado com 1,
	 *   significa que aquela parte do IP aponta para uma rede.
	 *  E sempre que ele estiver marcado como zero significa que o bit correspondente no IP
	 *   aponta para uma máquina.
	 *  Então, normalmente você divide uma máscara de sub-rede em determinado ponto que para o lado
	 *   esquerdo sempre tera bits 1 e para o lado direito sempre terá bits zero.
	 *  
	 *  Classe B - 192.168.100.230
	 *  	Primeira e segundas parte(192.168) identifica a rede.
	 *  	Outras partes(100.230) identifica o computador dentro da rede.
	 *  Máscaras de sub-rede: 255.255.0.0
	 *  Dificilmente você trabalha com endereços de classe B.
	 *  Normalmente você trabalha com endereços de classe C.
	 *  
	 *  Classe C - 192.168.100.230
	 *  	As três primeiras partes(192.168.100) mapeiam uma rede.
	 *  	A última parte(230) mapeia o host.
	 *  Máscaras de sub-rede: 255.255.255.0
	 *  Significa que você está limitado a mais ou menos 255 máquinas em uma rede classe C.
	 *  E você pode inclusive ter máscaras ainda mais restritas para, por exemplo, uma situação
	 *   em que você quer ter uma rede segregada que tenha apenas 10 máquinas. Isso é possível,
	 *   é só você mexer na máscara de sub-rede que você consegue restringir ainda mais a
	 *   quantidade de máquinas e aumentar ainda mais a quantidade de redes.
	 *  
	 * Esses três padrões são os padrões mais clássicos de como você organiza a rede.
	 * O importante é você entender que o endereço IP sozinho não diz a informação total sobre o IP.
	 * Ele precisa da máscara de sub-rede para que ele possa ser interpretado.
	 * Que parte do IP representa uma rede e que parte do IP representa um host.
	 * 
	 * Conceito de Porta...
	 * 
	 * Da para dizer que porta é um processo.
	 * 
	 * Imagine a situação:
	 * 
	 * Comp. 1         |   Comp. 2
	 * IP: 10.85.0.4   |   IP: 10.85.0.5
	 * 
	 *                  
	 * O Comp. 1 quer comunicar com o Comp. 2
	 * 
	 * Eles estão na mesma rede de classe C(10.85.0), então eles facilmente podem se comunicar.
	 * 
	 * Processos:
	 * 
	 * Comp. 1    |   Comp. 2
	 * Skype      |   Github Desk
	 * Chrome     |   Chrome
	 * Apache     |   Node
	 * Dropbox    |   MySQL
	 * 
	 * No Comp. 1 estão sendo rodados processos que usam portas, já que precisam da rede.
	 * Vamos supor que a partir do Comp. 1 você quer acessar o Comp. 2.
	 * Além de saber qual o IP que você quer se comunicar, você também precisa saber qual
	 *  é o processo. O processo é mapeado pela porta.
	 * Cada um desses processos precisa estar associado com um número(porta).
	 * Para haver uma conexão não apenas máquina a máquina, mas, processo a processo.
	 * Vamos supor que você quer a partir do Comp. 1 utilizando o Chrome acessar uma aplicação 
	 *  que está rodando no Node na porta 8080.
	 * Se você fosse acessar, por exemplo, uma página utilizando o protocolo HTTP,
	 *  por padrão é utilizado a porta 80, mas você pode ter o protocolo HTTP sendo executado 
	 *  a partir de uma aplicação que está associado a outra porta. No caso aqui, a porta 8080.
	 * É muito comum que em um ambiente de desenvolvimento você utilize outras portas, como
	 *  8080, 8000, 3003, ...
	 * Significa que lá na máquina Comp. 1 eu vou acessar "http://10.85.0.5:8080".
	 * Eu fiz isso a partir do Chrome, o Chrome dispara essa chamada para a máquina 10.85.0.5:8080,
	 *  chegou no Node, o Node vai lá e manda uma resposta para o browser.
	 */
}
