package conceitosweb;

public class ProtocoloHTTP {

	/*
	 * PROTOCOLO HTTP
	 * 
	 * HyperText Transfer Proto(Protocolo de transferência de hipertexto)
	 * 
	 * Nada mais é que um texto que tem links associado.
	 * Antigamente quando você estava lendo um livro e no meio do livro tinha, por exemplo, fulano de tal
	 *  em 1900 e bolinha disse no livro tal que isso era verdade, por isso, concluo que isso aqui.
	 *  
	 * Então, dentro de um texto você já tinha referências em textos normais.
	 * Na web essas referências estariam a 1 clique de distância.
	 * Você não precisaria consultar outro livro para de fato encontrar aquela referência.
	 * Você clica e encontra outro texto linkado para ter as informações que você referênciou.
	 * Então, a ideia de você ter outro texto linkado é o conceito do HyperText.
	 * Historicamente o protocolo de fato iniciou com transferência de hiper texto, de textos linkados.
	 * Depois de um tempo que foi envoluindo para imagens, vídeos, streaming, ...
	 * A maior parte do tráfego da web sem dúvida é encima do protocolo HTTP.
	 * Então o que a gente tem aqui no caso do HyperText, como já foi dito, nada mais é que documentos
	 *  escritos em HTML(HyperText Markup Language - Linguagem de marcação de HiperTexto).
	 *  E você tem textos linkados. Lógico que hoje você tem não só de uma página para outra, mas,
	 *   um documento HTML faz referência para outros formatos de arquivos como css, javaScript, imagens, ...
	 * Entao, o HiperTexto tem muito haver também com a história da web por que começou com texto linkados,
	 *  mas, na verdade, protocolo HTTP hoje roda diversos formatos encima dele.
	 *  
	 * Características...
	 * 
	 * - Camada de Aplicação
	 * Se a gente for colocar ele dentro da pilha TCP IP, ele faz parte da camada de aplicação.
	 * Ou seja, ele está lá na última camada, a camada mais alto nível. Então nós como desenvolvedores
	 *  interagimos muito com o protocolo HTTP, a gente precisa conhecer ele mais a fundo do que precisa,
	 *  por exemplo, conhecer o resto da pilha que tem mais a ver propriamente com a parte de infra.
	 * 
	 * - Stateless
	 * O protocolo HTTP é um protocolo Stateless. Ou seja, quando uma máquina manda uma requisição HTTP
	 *  para um servidor, para o servidor e para a máquina é como se eles estivessem fazendo a comunicação
	 *  pela primeira vez. Por que dentro do protocolo em si não existe o estado da conversação.
	 *  Você não sabe se está fazendo a primeira requisição ou a centésima.
	 * O protocolo em si é stateless, você pode ter aplicações em cima do protocolo, como por exemplo,
	 *  um servidor web que dentro dele tem uma session do usuário, e no momento em que você faz uma
	 *  requisição em cima de um heather por exemplo, em cima da requisição vai o ID da session. Então,
	 *  quando você chega no servidor, esse ID consegue resgatar um espaço de memória que tem suas
	 *  informações, seu carrinho de compra, ...
	 * Mas, nativamente o protocolo é stateless. Ou seja, não tem estado.
	 *  Toda conexão é como se fosse a primeira vez. Você abre a conexão manda os dados e recebe os dados
	 *  de volta, mas o protocolo em si é stateless.
	 *  
	 * - Cliente-Servidor
	 * Ele é muito fortemente baseado no conceito de requisição e resposta. Eu mando uma requisição para
	 *  o servidor baseado na URL, então, eu mando uma URL com um conjunto de parâmetros, faço uma
	 *  requisição e recebo algo como resposta. Essa resposta pode ser um arquivo texto no formato JSON,
	 *  essa resposta pode ser um HTML, um vídeo mandado via streaming, ...
	 * Mas fato é que com o protocolo baseado nessa arquitetura clente-servidor, você tem um cliente que
	 *  manda uma requisição a partir de uma URL, mais um conjunto de parâmetros, mais um conjunto
	 *  de heathers, cookies, ...
	 * Manda essa requisição, essa requisição é atendida por um servidor.
	 * O cliente é que fez a requisição, o servidor é que manda a resposta baseado na requisição feita.
	 * 
	 * - TCP/IP
	 * Além disso, sabemos que esse protocolo opera em cima da stack, da pilha TCP/IP.
	 * 
	 * - HTML, CSS, JS, Mídias...
	 * Por norma, esse é um protocolo que vai te retorna conteúdos para formar uma página web.
	 * Então, começa a partir do HTML, provavelmente quando o HTML é interpretado pelo browser ele
	 *  vai perceber que além do HTML que já veio, tem uma referência a um CSS, aí abre uma requisição,
	 *  tem uma referência para um JS que faz outra requisição, tem uma referência para uma imagem,
	 *  um vídeo, ...
	 *  E ele vai montando a página até que a página fique completamente carregada.
	 * Via de regra, as resposta que vem a partir de uma requisição HTTP, é usando esses dados.
	 * Também pode ter por exemplo JSON, que é somente dados. Você vai ver que existe essas nuâncias
	 *  dependendodo tipo de arquitetura que você escolha para trabalhar na sua aplicação.
	 *   
	 * Fluxo...
	 * 
	 * 1 - Usuário informa a URL
	 * www.google.com.br
	 * 
	 * Primeiro o usuário vai no browser e coloca a URL que ele quer obter essas informações.
	 * 
	 * 2 - Browser gera a requisição
	 *  GET / HTTP / 1.1
	 *  Host: www.google.com.br 
	 * 
	 * Uma vez que essa requisição é mandada, claro que tem outros detalhes aí de rede como dns, mas é
	 *  feita uma requisição no raiz usando o protocolo HTTP versão 1.1 para o host "www.google.com.br".
	 *  
	 * 3 - Servidor Web gera a resposta
	 *  HTTP / 1.1 200 0K
	 *  content-Type: text/html; charset=UTF-8
	 *  date: Mon, 30 Abril 2018 17:00:02 GMT
	 *  connection: close
	 *  content-Length: 438
	 *  -------------------
	 *  <html> ...
	 * 
	 * Após essa requisição ser enviada e chegar no servidor de destino a partir da stack TCP/IP,
	 *  você tem um servidor gerando uma resposta, HTTP / 1.1, uma resposta do tipo 200(bem-sucedida).
	 * Ele manda um conjunto de cabeçalhos na resposta. Tando a requisição quando a resposta tem 
	 *  cabeçalhos, informando a data, tamanho do conteúdo, ...
	 * E no corpo da resposta vem de fato a página HTML que você requeriu a partir da URL que você
	 *  informou no browser.
	 * 
	 * 4 - Browser exibe a página
	 * Uma vez que chega a resposta o browser vai pegar aquela resposta e renderizar para você.
	 * Obviamente para montar uma página HTML não é feita uma única requisição, se você abrir o console
	 *  de desenvolvedor você vai ver que são várias requisições. São fontes, imagens, css, JS,
	 *  normalmente vem o HTML que referência tudo isso e a partir disso ele vai baixando várias
	 *  imagens, fontes, ...
	 * Para compor a sua página completamente.
	 * O fluxo básico, entra com a URL, é gerado a partir do browser uma requisição, essa requisição
	 *  quando você digita na caixinha de texto no browser e aperta enter é uma requisição do tipo
	 *  GET. Existem outros tipos de requisição, o protocolo HTTP tem alguns verbos, como o GET, POST,
	 *  PUT, DELETE, OPTION, TRACE, ...
	 * Então, ele tem vários verbos e esses verbos são formas diferentes de você fazer requisições.
	 * Historicamente dois deles são os mais importantes, o GET e o POST.
	 * Depois do advento dos web services alguns outros métodos foram ressuscitados.
	 * O PUT, DELETE, o próprio OPTIONS também é usado na comunicação de web services.
	 * 
	 */
	
	
	/* 
	 * Métodos do HTTP
	 * 
	 * GET, POST,
	 * PUT, DELETE, TRACE, OPTIONS, CONNECT, HEAD.
	 * 
	 * Requisição e resposta
	 * 
	 * Cliente ----     URL + Params    ----> Servidor
	 * Cliente <---  HTML, CSS, JS, ...  ---- Servidor
	 * 
	 * No desenvolvimento web, o fluxo de requisição e resposta acontece diversas vezes para montar uma página.
	 * Por isso, uma técnica muito comum é minimizar a quantidade de arquivos e requisições para melhorar o desempenho do site.
	 * Por exemplo, imagine uma aplicação que usa 60 arquivos JavaScript separados. Em vez de carregar cada um individualmente,
	 *  é mais eficiente minificá-los (comprimir o código ao máximo) e juntá-los em um único arquivo. No entanto,
	 *  se esse arquivo ficar muito grande, pode ser necessário dividi-lo para não sobrecarregar a carga inicial da página.
	 * O motivo para essa otimização está no funcionamento do protocolo TCP/IP. Cada requisição feita pelo navegador envolve um
	 *  "handshake" de comunicação, ou seja, um processo de abertura de conexão que inclui o envio e o recebimento de confirmações
	 *  antes da transferência real dos dados. Quanto mais requisições forem feitas, maior será o impacto na performance da página.
	 * Além da redução do número de arquivos, outras estratégias podem ser usadas para melhorar o carregamento do site.
	 * Um exemplo são as CDNs (Content Delivery Networks), redes de servidores distribuídos em vários locais.
	 * Quando um usuário acessa um site, os arquivos estáticos (como imagens, CSS e JavaScript) são carregados a partir do servidor
	 *  mais próximo ou do que tem menor latência, reduzindo o tempo de resposta.
	 * Resumindo, diminuir a quantidade de requisições melhora o desempenho, mas é importante encontrar um equilíbrio.
	 * Arquivos muito grandes podem ser um problema, então, em alguns casos, é melhor dividi-los e carregá-los conforme necessário.
	 * Como o protocolo HTTP é stateless (não mantém o estado entre as requisições),
	 *  cada comunicação entre cliente e servidor precisa passar por esse processo repetidamente.
	 * 
	 *  
	 * Requisição via GET
	 * Cabeçalho:
	 *  GET /search?q=web+moderno&hl=pt-BR HTTP/1.1
	 *  host: www.google.com.br
	 *  user-Agent: Mozilla/5.0 (Mocintosh; Intel Mac OS...
	 *  ...
	 * 
	 * Requisições do tipo get você tem a URL e você tem parâmetros da requisição.
	 * 
	 * Ex:
	 * 
	 * URL que estou usando para fazer a requisição:
	 * 		https://www.google.com.br/search
	 * 
	 * Depois da URL eu vou separa a URL dos parâmetros.
	 * 
	 * 		https://www.google.com.br/search?q=web+moderno
	 * 
	 * URL: "https://www.google.com.br/search"
	 * Divisor entre a URL e os parâmetros que serão passados na requisição: "?"
	 * Parâmetros organizados em: chave "q" | igual "=" | valor "web+moderno"
	 * 
	 * 		https://www.google.com.br/search?q=web+moderno&hl=pt-BR
	 * 		obs: "hl" significa "host language"
	 * 
	 * Aqui eu tenho dois parâmetros.
	 * O primeiro parâmetro "q" que representa uma query com o seu valor sendo "web+moderno".
	 * Query é a consulta que eu vou fazer em cima do serviço "search".
	 * E o outro parâmetro dizendo qual é a lingua da máquina host para que ele possa retornar o resultado.
	 * 
	 * Então, na verdade, quando você tem uma requisição do tipo GET, os parâmetros vão no corpo da URL,
	 *  os parâmetros vão na própria URL.
	 * Quando você tem outros tipos de requisição, como a POST, os parâmetros vão no corpo da requisição.
	 * 
	 * É importante você perceber que, esse tipo de abordagem é oportuna? Claro que é, quando você quer,
	 *  por exemplo, fazer um bookmark, você quer salvar uma determinada URL específica. Não somente a URL,
	 *  mas, os parâmetros que você usou para chegar em um determinado resultado.
	 * É importante que você tenha os parâmetros na URL para que você consiga esse tipo de coisa.
	 * Por outro lado, se você estiver acessando, por exemplo, um serviço de login, você vai querer que a
	 *  sua senha apareça diretamente na URL? Nesse caso não é interessante.
	 * Para esse tipo de cenário, você tem requisições do tipo POST, que os parâmetros vão no corpo da 
	 *  requisição. Quer dizer que se eu passar os parâmetros no corpo da requisição a minha
	 *  requisição vai ser segura? Não. Para você ter uma requisição segura você precisa ter a sua
	 *  requisição executando em cima de um protocolo HTTPS. Que é exatamente o que está acontecendo aqui
	 *  "https://www.google.com.br/search?q=web+moderno&hl=pt-BR".
	 * HTTPS é um protocolo seguro que faz com que a comunicação da máquina cliente para a máquina servidor
	 *  seja criptografada.
	 * 
	 * Então temos que a grande informação marcante da requisição do tipo GET é que os parâmetros vão
	 *  diretamente dentro da URL. O corpo nesse caso irá vazio.
	 *  
	 * Requisição via POST
	 * Cabeçalho:
	 *  POST /signin HTTP/1.1
	 *  host: accounts.google.com
	 *  user-Agent: Mozilla/5.0 (Mocintosh; Intel Mac OS...
	 *  ...
	 * Corpo:
	 *  continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service
	 *  =mail&rm=false&ltmpl=default&scc=1&ss=1&osid=1&emr=1&f.req
	 *  =%5B%22fulano%40gmail.com
	 *  
	 */
	
	
	// DESISTI POR LEVAR MUITO TEMPO PARA ESCREVER TUDO ISSO!
	// CADA ARQUIVO DESSE É UMA DO TOTAL DE 10 AULAS!
	// OBS: NÃO TERMINEI DE ESCREVER SOBRE ESSA AULA DO PROTOCOLO HTTP.
	
}
