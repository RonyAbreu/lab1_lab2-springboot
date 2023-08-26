[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/j_kghnjc)
# Laboratório - roteiro 1 - nossa primeira API REST

**Lembrete**: Ao criar seu projeto spring/java, selecione as dependência "DevTools", "Lombok" e "Spring Web" na criação do seu projeto. Lembre de selecionar maven como gerenciador de dependências e de empacotar em jar.

Neste primeiro lab o design da API REST a ser desenvolvida será dado, exceto os [métodos HTTP](https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Methods) a serem usados e os [códigos de retorno HTTP](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status). Com o tempo, o ideal é que cada um pense seu próprio *design* em termos de que recursos são expostos e quais as rotas para estes recursos. 

Imagine que estamos criando o embrião de um sistema que é uma rede social de alunos para avaliar e falar sobre disciplinas de seu curso específico, por exemplo, computação. 

No contexto da API abaixo uma Disciplina é uma entidade que tem os seguintes atributos: **id:int**, **nome:String**, **likes:int** e **notas:List<double>**. A nota da disciplina vem de uma média de notas atribuídas à disciplina pelos alunos. As disciplinas do sistema não podem ter nomes repetidos. 

Pensando apenas no recurso /disciplinas, use spring boot/MVC e java para desenvolver a seguinte API (não usaremos banco de dados ainda, assim não haverá persistência de dados):

**\<METODO HTTP\> /v1/api/disciplinas**

Adiciona a disciplina no sistema. A própria API deve se encarregar de gerar os identificadores únicos das disciplinas. No corpo da requisição HTTP deve estar um JSON com as informações de nome da disciplina a ser adicionada no sistema.

Retorna a disciplina que foi adicionada (incluindo o id gerado pelo sistema) e o \<código de resposta HTTP\> (ver [https://developer.mozilla.org/en-US/docs/Web/HTTP/Status](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)).


**\<METODO HTTP\> /v1/api/disciplinas (id numerico, nome, likes, nota)**

Retorna um JSON com todas as disciplinas já inseridas no sistema e o \<código de resposta HTTP\> (ver [https://developer.mozilla.org/en-US/docs/Web/HTTP/Status](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)). As disciplinas retornadas devem conter o id, nome, número de likes, a nota da disciplina (média de todas as notas da disciplina).


**\<METODO HTTP\> /v1/api/disciplinas/{id}**

Retorna um JSON que representa a disciplina cujo identificador único é id e o \<código de resposta HTTP\> (ver [https://developer.mozilla.org/en-US/docs/Web/HTTP/Status](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)). A disciplina retornada deve ter id, nome, número de likes e nota média. Pense em todas as possibilidades de erro e programe-se para elas com seus devidos códigos de resposta HTTP.


**\<METODO HTTP\> /v1/api/disciplinas/{id}/nome**

Atualiza o nome da disciplina de identificador id no sistema. No corpo da requisição HTTP deve estar um JSON com o novo nome da disciplina a ser atualizado no sistema.

Retorna a disciplina que foi atualizada (incluindo o id, novo nome, número de likes e nota média) e o \<código de resposta HTTP\> (ver [https://developer.mozilla.org/en-US/docs/Web/HTTP/Status](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)). Pense em todas as possibilidades de erro e programe-se para elas com seus devidos códigos.


**\<METODO HTTP\> /v1/api/disciplinas/{id}/nota**

Adiciona uma nota à disciplina de identificador id no sistema. No corpo da requisição HTTP deve estar um JSON com a nova nota da disciplina a ser adicionada no sistema.

Retorna a disciplina que foi atualizada (incluindo o id, nome, número de likes e a nova nota média) e o \<código de resposta HTTP\> (ver [https://developer.mozilla.org/en-US/docs/Web/HTTP/Status](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)). Pense em todas as possibilidades de erro e programe-se para elas com seus devidos códigos.

**\<METODO HTTP\> /v1/api/disciplinas/{id}/like**

Adiciona um like à disciplina de identificador id no sistema. Retorna a disciplina que foi atualizada (incluindo o id, nome, novo número de likes e a nota média) e o \<código de resposta HTTP\> (ver [https://developer.mozilla.org/en-US/docs/Web/HTTP/Status](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)). Pense em todas as possibilidades de erro e programe-se para elas com seus devidos códigos.

**\<METODO HTTP\> /v1/api/disciplinas/{id}**

Remove a disciplina de identificador id do sistema e retorna a disciplina que foi removida (um JSON) e o \<código de resposta HTTP\> (ver [https://developer.mozilla.org/en-US/docs/Web/HTTP/Status](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)). Pense em todas as possibilidades de erro e programe-se para elas com seus devidos códigos.


**\<METODO HTTP\> /v1/api/disciplinas/ranking**

Retorna todas as disciplinas inseridas no sistema ordenadas pela nota média (da maior para a menor) e o \<código de resposta HTTP\> (ver [https://developer.mozilla.org/en-US/docs/Web/HTTP/Status](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)).


**Seguem algumas dicas...**

O desenvolvimento é um ciclo. Não desenvolva todas as funcionalidades de uma só vez. Siga os passos:

1. Desenvolva uma funcionalidade
2. Teste a funcionalidade usando postman ou outra ferramenta de sua preferência
3. Vá para a próxima funcionalidade volte para o passo 1
4. Lembrem que o controlador conhece o serviço e o serviço conhece o repositório de disciplinas, temos essas camadas sempre!
5. Lembrem que cada método do controlador tem apenas 1 linha de código
6. Neste lab não estamos usando persistência ainda

Você irá desenvolver as seguintes classes:

Classe que será o controlador do recurso /disciplinas e será marcada com @RestController
Classe de serviço (@Service) que oferece serviços ao controlador para gerenciar a coleção de disciplinas da API - o repositório das disciplinas aqui será o próprio serviço.
Classe que representa a Disciplina. 
Outras classes auxiliares para transferência, por exemplo, classe um DTO de disciplina só com nome (para quando a disciplina for ser adicionada), uma com id, nome, número de likes e nota média...

Execute a sua aplicação na ide ou no terminal, dentro do diretório raiz do seu projeto com o seguinte comando (caso não esteja usando o DvTools)

$ ./mvnw spring-boot:run


# :wave: Laboratório - roteiro 2 - API com modelagem dos dados (relações JPA)

## 🤓 O que vamos aprender?

* Aprender a escrever APIs com dados persistentes usando um esquema de dados relacional e modelagem de relacionamentos JPA.

### Tecnologias envolvidas:
* ORM - Mapeamento objeto relacional (Hibernate é a implementação por trás do que usaremos)
* JPA - interface unificada para facilitar mapeamento de objetos para registros de tabelas e definir relações entre entidades

Lembrete: use o [spring initizlizr](https://start.spring.io) para criar seu projeto spring dentro ou fora da IDE. Dessa vez marque as dependências "_Spring Web Starter_", "_H2 Database_" e "_Spring Data JPA_" na configuração do seu projeto (além de "_Lombok_" e "_DevTools_").

Neste segundo lab o design da API REST a ser desenvolvida será dado novamente, na verdade, é muito parecido com o primeiro. Continuaremos o desenvolvimento do primeiro lab no contexto de disciplinas. Mas agora vamos adicionar persistência, vamos iniciar todas as disciplinas de uma vez. Relembrando, por enquanto, no contexto da nossa API, uma **Disciplina** é uma classe que tem os seguintes atributos: **id:long**, **nome:String**, **notas:List<Double>** e **likes:int**. Para este lab vamos adicionar algo mais... É possível associar comentários a disciplinas. Assim, *comentarios:List\<Comentario>* passa a ser mais uma informação associada à disciplina.

Um **Comentario** deve ter o seguinte estado: **id:long**, **dataDoComentario:LocalDate**, **texto:String**, **removido:boolean**, *disciplina:Disciplina*. Cada disciplina pode estar associada a muitos comentários, mas cada comentário está associado a apenas uma disciplina. Com essa nova funcionalidade vamos adicionar várias novas rotas na nossa API para o CRUD de comentários.

Também vamos começar a ter a noção de **Tag**. Uma tag é uma palavra (que pode ser simples ou composta) que os alunos que avaliam uma disciplina podem usar para caracterizar a disciplina. Uma disciplina então passa a estar associada a uma lista de tags que a representam, como, por exemplo: massante, muito teórica, rasgada, difícil, etc. A base de tags deve ser populada à medida que as disciplinas vão sendo tagueadas, assim, não deve ter na base de tags repetição de termos já usados. Cada tag pode estar associada a muitas disciplinas, e cada disciplina também pode estar associada a muitas tags.

O objetivo desta API é permitir que alunos comentem e deem likes nas disciplinas do curso de Sistemas de Informação.

### Povoando a base de disciplinas:
Temos um arquivo JSON [aulas/disciplinasSI.json](https://github.com/raquelvl/psoft/blob/master/aulas/disciplinasSI.json) já com os nomes de todas as disciplinas que devem ser criadas. A ideia é programar sua API para povoar o banco de dados com todas as disciplinas já existentes neste arquivo. [Neste documento](http://bit.ly/inicia-dados-json) encontra-se uma discussão sobre como ler dados de um json e adicionar ao banco de dados usando spring boot (você vai ter que entender e implementar o seu próprio). Lembre que a própria API deve se encarregar de gerar os identificadores únicos das disciplinas no banco (@GeneratedValues). Com isso, não precisaremos mais de uma rota na API para adicionar disciplinas. Outro lembrete: essa atividade envolve já o uso do banco, então você deve criar o repositório de Disciplinas e também o de comentários, marcar as classes que vão estar associadas ao banco como @Entity, e já deve ter configurado o banco em application.properties. (para testar você pode usar a rota GET /api/disciplinas que retornará todas as disciplinas inseridas no sistema).

### Use Spring Boot e java para desenvolver a seguinte API:

GET /api/disciplinas
Retorna um JSON (apenas com campos id, nome) com todas as disciplinas inseridas no sistema e código 200.

GET /api/disciplinas/{id}
Retorna um JSON que representa a disciplina completa (id, nome, nota média, número de likes e os comentários) cujo identificador único é id e código 200. Ou não retorna JSON e código 404 (not found) caso o id passado não tenha sido encontrado.

PATCH /api/disciplinas/likes/{id}
Incrementa em um o número de likes da disciplina cujo identificador é id.
Retorna a disciplina que foi atualizada (incluindo o id, nome e likes) e código 200. Ou não retorna JSON e código 404 (not found) caso o id passado não tenha sido encontrado.

PATCH /api/disciplinas/nota/{id}
Adiciona uma nova nota à lista de notas da disciplina de identificador id no sistema. No corpo da requisição HTTP deve estar um JSON com uma nova nota atribuída à disciplina. A nova nota da disciplina deve ser calculada como a média de todas as notas já recebidas, incluindo a nova nota passada nesta chamada. Se for a primeira nota sendo adicionada então esta nota é a que vai valer para a disciplina.
Retorna a disciplina que foi atualizada (incluindo o id, nome e nota média) e código 200. Ou não retorna JSON e código 404 (not found) caso o id passado não tenha sido encontrado.

POST /api/disciplinas/{id}/comentarios
Insere um novo comentário na disciplina de identificador id. No corpo da requisição HTTP deve estar um JSON com o novo comentário a ser adicionado na disciplina a ser atualizada no sistema.
Retorna a disciplina que foi atualizada (incluindo o id, nome e os comentarios atualizados) e código 200. Ou não retorna JSON e código 404 (not found) caso o id passado não tenha sido encontrado.

GET /api/disciplinas/{id}/comentarios
Retorna todos os comentários associadas à disciplina de identificadir id e código de resposta 200. Ou não retorna JSON e código 404 (not found) caso o id passado não tenha sido encontrado. Aqui deve ser possível usar algum parrâmetro que filtre os comentarios que contiverem algum padrão (usar @RequestParameter) se o usuário desejar.

POST /api/disciplinas/{id}/tags
Insere uma nova tag associada à disciplina de identificador id. No corpo da requisição HTTP deve estar um JSON com a tag a ser adicionada na disciplina a ser atualizada no sistema.
Retorna a disciplina que foi atualizada (incluindo o id, nome e as tags atualizadas) e código 200. Ou não retorna JSON e código 404 (not found) caso o id passado não tenha sido encontrado.

GET /api/disciplinas/ranking/notas
Retorna todas as disciplinas inseridas no sistema ordenadas pela nota (da maior para a menor) e código 200.

GET /api/disciplinas/ranking/likes
Retorna todas as disciplinas inseridas no sistema ordenadas pelo número de likes (da que tem mais likes para a que tem menos likes) e código 200.

GET /api/disciplinas/{id}/tags
Retorna todas as tags associadas a disciplina de código id e código 200. Ou não retorna JSON e código 404 (not found) caso o id passado não tenha sido encontrado.

GET /api/disciplinas/tags (?tag=str)
Retorna todas as disciplinas associadas à tag informada no parametro de busca (@RequestParameter) e código 200. Se nenhuma tag for informada não retorna nada.

Para todas as funcionalidades dessa API lembre de realizar o tratamento adequado de erros seguindo o que estudamos em sala (detalhes do problema - RFC 7807) e @RestControllerAdvice.

Seguem algumas dicas:

* Use o padrão DAO para acesso às bases de dados;
* Siga boas práticas de design, buscando desacoplamento utilize corretamente controladores, serviços e repositórios;
* Organize suas classes em packages com nomes significativos (xx.services, xx.controllers, xx.repositories, xx.entities, etc. - pode usar nomes em portugues também, mas mantenha a coerência, ou tudo em portugues ou tudo em ingles);
* Para ordenação aprenda a definir um novo método no repositório de disciplina seguindo o padrão de nomes dos métodos. Mais dicas [aqui](https://www.baeldung.com/spring-data-sorting).

**Não faça tudo de uma vez**. Desenvolva uma funcionalidade, teste, vá para a próxima… 🚀


