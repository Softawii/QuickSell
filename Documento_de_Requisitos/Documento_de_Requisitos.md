# Documento de Requisitos

## **QuickSell**

## **Imor Tal**

**Projeto: Nº1**

**Versão**  **3****. ****0**

**Histórico de Alterações**

| **Data** | **Versão** | **Descrição** | **Autor** |
| --- | --- | --- | --- |
| 18/10/19 | 1.0 | Análise do projeto | Gabriel Perez, Sérgio Rezende, Bruno Almeida, Guilherme Silva, Eduardo Vieira. |
| 05/11/19 | 2.0 | Ajuste do projeto | Gabriel Perez, Sérgio Rezende, Bruno Almeida, Guilherme Silva, Eduardo Vieira. |
| 01/07/21 | 3.0 | Aprimoramento do projeto | Isaque Diniz,Sérgio Rezende,Bruno Almeida,Guilherme Silva,Eduardo Vieira,Nicolas Magalhães. |

1. **Introdução**

Este documento tem por objetivo apresentar os requisitos que o sistema deve atender em diferentes níveis de detalhamento. Dessa forma, serve como acordo entre as partes envolvidas – cliente e analista/desenvolvedor.

2. **Escopo**

O sistema (QuickSell) tem como principal missão automatizar o sistema de registro de imóveis e acelerar as vendas da imobiliária Imor Tal, através de um sistema web que permitirá o contato direto entre usuários e corretores, agilizando a comunicação e a visualização dos imóveis.

Através do site o cliente conseguirá, além de procurar seu imóvel ideal, propor a venda de suas próprias propriedades.

Além disso, nossos funcionários poderão receber essas propostas dos clientes, registrar e anunciar novos imóveis e gerenciar de forma automática e mais organizada o registro de compras e vendas da imobiliária.

3. **Definições, siglas e abreviações**

RF = Requisito funcional

RNF = Requisito não funcional

RN = Regras de negócio

CPF = Cadastro de Pessoas Físicas

RG = Registro Geral

4. **Referências**

Mini-mundo - Matrícula de Alunos -: Sigaa, UFRRJ.

Google Material Design -:[https://design.google/](https://design.google/)

5. **Técnicas de Elicitação de Requisitos**

Visto a especificidade da área de atuação do projeto, percebemos que a melhor opção seria a entrevista, pois, dessa maneira, seria possível entender quais as necessidades reais de um sistema de vendas e compras de imóveis, otimizando a montagem e permitindo que nosso cliente tenha um bom uso do produto. Além disso, é imprescindível manter uma boa comunicação com o cliente para obtermos feedback em relação ao sistema.

6. **Requisitos Específicos**
   
6.1. **Requisitos Funcionais**

- RF001: O sistema deve possuir uma opção para cadastro do usuário.

- RF002: O sistema deve possuir uma opção de entrada para usuários já cadastrados.

- RF003: O sistema deve receber a proposta do usuário para a imobiliária.

- RF004: O sistema deve permitir que o usuário tenha acesso a todas as ofertas da imobiliária.

- RF005: O sistema deve oferecer um meio de busca de imóveis.

- RF006: O sistema deve oferecer filtros de busca. (RF005)

- RF007: O sistema deve oferecer um chat de comunicação entre cliente e imobiliária.

- RF008: O sistema deve fornecer opção de cadastro de novos corretores. (RF001)

- RF009: O sistema deve permitir que os corretores anunciem imóveis para os usuários.

- RF010: O sistema deve permitir que os corretores acessem as propostas dos clientes.

- RF011: O sistema deve possibilitar o cadastro de imóveis.

- RF012: O sistema deve possibilitar a edição de informações de usuários.

- RF013: O sistema deve possibilitar a edição de informações de imóveis.

- RF014: O sistema deve fornecer opção de remoção de corretores.

- RF015: O sistema deve permitir a remoção da conta de um usuário.

- RF016: O sistema deve gerar relatórios com a relação de todos os imóveis disponíveis para a venda.

- RF017: O sistema deve gerar relatórios com a relação de todos os imóveis vendidos.

- RF018: O sistema deve gerar relatórios sobre a frequência de compras e vendas de seus clientes.

- RF019: O sistema deve gerar relatórios com a relação dos clientes que compraram mais de um imóvel com a imobiliária.

- RF020: O sistema deve gerar relatórios com a relação dos clientes que venderam mais de um imóvel para a imobiliária.

- RF021: O sistema deve permitir que o usuário tenha acesso a suas informações.

6.2. **Regras de Negócio**

- RN001: O sistema deve permitir o cadastro de clientes que forneçam nome, CPF, endereço, telefone e e-mail. (RF001)

- RN002: O sistema deve possibilitar o filtro por preço de imóveis e por bairro. (RF006)

- RN003: Apenas administradores podem cadastrar novos corretores. (RF008)

- RN004: O chat deverá conter filtro de palavras. (RF007)

- RN005: O sistema não deve apresentar as ofertas de clientes para outros clientes.

- RN006: O sistema deve permitir o cadastro de um imóvel, disponibilizado por parte do cliente, ao apresentar as informações: proprietário atual, endereço, Bairro, Área (m²) e Descrição do mesmo. (RF011)

- RN007: Os relatórios com a relação de todos os imóveis disponíveis para a venda devem incluir as informações: endereço, Bairro, Área (m²), descrição, proprietário antigo (o atual é a administradora) e o Preço Mínimo para venda. (RF016)

- RN008: Os relatórios com relação de todos os imóveis vendidos devem incluir as informações: Bairro, Proprietário antigo, proprietário novo, preço de venda (ao proprietário novo) e o Preço de compra (pela imobiliária). (RF017)

- RN009 - Os relatórios dos clientes que compraram e/ou venderam mais de um imóvel com a imobiliária devem incluir as informações de nome, CPF, endereço e telefone. (RF019) (RF020)

6.3. **Requisitos Não-Funcionais**

1. Requisitos Não-Funcionais de portabilidade:

- RNF001: O sistema deve ser operacional no Google Chrome, Mozilla Firefox,Microsoft Edge, Opera, Brave e Safari.

2. Requisitos Não-funcionais de segurança:

- RNF002: O Sistema deverá proteger os dados dos clientes e corretores de acordo com a Lei Geral da Proteção de Dados.

3. Requisitos Não-funcionais de usabilidade:

- RNF003: O sistema deve ser prático e simples, seguindo as vertentes do Design Material do Google.

4. Requisitos Não-funcionais de Confiabilidade:

- RNF004: O sistema deverá realizar 1 backup por dia, às 2:00.

- RNF005: O backup não deverá interferir no fluxo de acesso de usuários.