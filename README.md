# Teste de nivelamento técnico WeFin

## Solicitação:
- Criar um projeto que gerencia pessoa utilizando padrões de design.
- Deve receber dados e efetuar o cadastro. Dados de uma pessoa: nome, identificador e tipo Identificador;
- Verificar se a pessoa possui um CPF ou um CNPJ:
  - Caso o identificador da pessoa tenha 11 posições deve indicar que um CPF.
  - Se possuir 14 posições, deve indicar que um CNPJ.
- Deve validar se o identificador foi informado antes de verificar os tamanhos;
- A requisição deve ser tratada com método POST através de um endpoint gerado pelo Spring;
- Adicionar documentação no endpoint;
- Gravar a atualização no banco de dados.

## Tecnologias utilizadas:
- Java 8
- Spring Boot 2.7.7
- H2DB (banco local)

## Estrutura do projeto

- [Controller](src/main/java/com/wefin/tech/person/controller/) - Pacote contendo classes relacionadas ao endpoint responsável por gerenciar pessoas.
- [Domain](src/main/java/com/wefin/tech/person/domain/) - Pacote contendo classes que representam o domínio do projeto.
- [Dto](src/main/java/com/wefin/tech/person/dto/) - Pacote contendo classes utilizadas para transferir informações de um serviço para outro.
- [Repository](src/main/java/com/wefin/tech/person/repository/) - Pacote contendo classes utilizadas para acesso ao banco de dados.
- [Service](src/main/java/com/wefin/tech/person/service/) - Pacote contendo classes utilizadas para execução da regra de negócio relacionada a pessoas.
- [Util](src/main/java/com/wefin/tech/person/util/RegexUtils.java) - Pacote contendo classes utilitárias.