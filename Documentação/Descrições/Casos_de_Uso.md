# **Diagrama de Casos de uso**

![](./../Diagramas/Caso_de_Uso/Caso_de_Uso.png)

# **Descrição dos Casos de uso**
## Links
- [**UC01 - Cadastrar usuário**](#uc01---cadastrar-usuário)

- [**UC02 - Cadastrar corretor**](#uc02---cadastrar-corretor)

- [**UC03 - Realizar login**](#uc03---realizar-login)

- [**UC04 - Buscar imóvel**](#uc04---buscar-imóvel)

- [**UC05 - Fazer proposta por imóvel**](#uc05---fazer-proposta-por-imóvel)

- [**UC06 - Registrar imóvel**](#uc06---registrar-imóvel)

- [**UC07 - Acessar propostas**](#uc07---acessar-propostas)

- [**UC08 - Editar proposta**](#uc08---editar-proposta)

- [**UC09 - Emitir relatório**](#uc09---emitir-relatório)

- [**UC10 - Remover cadastro**](#uc10---remover-cadastro)

- [**UC11 - Editar cadastro da conta**](#uc11---editar-cadastro-da-conta)

- [**UC12 - Editar cadastro do imóvel**](#uc12---editar-cadastro-do-imóvel)

- [**UC13 - Acessar perfil**](#uc13---acessar-perfil)

- [**UC14 - Registrar venda**](#uc14---registrar-venda)


<br /><br />



## **UC01 - Cadastrar usuário**  

**Lista de atores:** Usuário.
<hr>

**Visão geral:** O usuário irá efetuar o cadastro no sistema da imobiliária.  
<hr>

**Referências cruzadas:** Requisitos: RF001.  
<hr>

**Pré-Condições:** Não há. 
<hr>

**Pós-Condições:** O usuário é cadastrado e possui uma conta no sistema. 
<hr>

**Fluxo Principal:**

1. O usuário fornece os dados requeridos. (FE01)
2. O sistema verifica os dados do usuário. (FE02)
3. O sistema confirma o cadastro.  
4. O sistema redireciona o usuário para a tela de autenticação.
5. Caso de uso encerrado.  
<hr>

**Fluxos de exceção:** 

**-FE01:** O usuário não tem conexão segura.

1. O sistema informa que a conexão do usuário não é segura.
2. Caso de uso encerrado.

**-FE02:** Dados inválidos **.**

1. O sistema informa qual(is) dado(s) está(ão) errado(s).
2. O caso de uso retorna ao passo 1 do fluxo principal.
<hr>

[Links](#links)  



<br /><br />



## **UC02 - Cadastrar corretor**

**Lista de atores:** Administrador.
<hr>

**Visão geral:** O administrador valida o corretor no sistema.
<hr>

**Referências cruzadas:** Requisitos: RF008. Casos de uso: UC01.
<hr>

**Pré-Condições:** O corretor deve estar cadastrado no sistema.
<hr>

**Pós-Condições:** O administrador valida com sucesso o corretor no sistema.
<hr>

**Fluxo Principal:**

1. O administrador busca a conta do corretor.
2. O administrador adiciona os privilégios do corretor.
3. O sistema notifica o novo corretor informando a situação de sua conta.
4. O caso de uso é encerrado.
<hr>

**Fluxo de exceção:**

**-FE01:** Conta do usuário não encontrada.

1. Sistema notifica que a conta não foi encontrada.
2. Caso de uso encerrado.
<hr>

[Links](#links)  



<br /><br />


## **UC03 - Realizar login**

**Lista de atores:** Usuário
<hr>

**Visão geral:** O sistema faz a autenticação do usuário no sistema.
<hr>

**Referências cruzadas:** Requisitos: RF002. Casos de uso: UC01.
<hr>

**Pré-Condições:** O usuário deve estar cadastrado no sistema.
<hr>

**Pós-Condições:** O usuário consegue acessar o sistema após realizar login
<hr>

**Fluxo Principal:**

1. O usuário informa seus dados de autenticação. (FA01) (FE01)
2. O sistema faz a autenticação dos dados. (FE02)
3. O sistema confirma a autenticação do usuário.
4. O caso de uso é encerrado.
<hr>

**Fluxos alternativos:**

**-FA01:** O usuário esqueceu sua senha.

1. O usuário informa o seu e-mail cadastrado.
2. O sistema notifica que enviará um e-mail ao usuário cadastrado.
3. O caso de uso retorna para o passo 1 do fluxo principal.
<hr>

**Fluxos de exceção:**

**-FE01:** O usuário não tem conexão segura.

1. O sistema informa que a conexão do usuário não é segura.
2. O caso de uso retorna.

**-FE02:** Dados inválidos.

1. O sistema informa qual(is) dado(s) está(ão) errado(s).
2. O caso de uso retorna para o passo 1 do fluxo principal.
<hr>

[Links](#links)  



<br /><br />



## **UC04 - Buscar imóvel**

**Lista de atores:** Usuário.
<hr>

**Visão geral:** O usuário faz uma busca por um imóvel no sistema.
<hr>

**Referências cruzadas:** Requisitos: RF004, RF005 e RF006.
<hr>

**Pré-Condições:** O usuário precisa ter realizado login.
<hr>

**Pós-Condições:** O usuário deverá ser capaz de ver as ofertas que deseja do sistema.
<hr>

**Fluxo Principal:**

1. O sistema oferece a lista com todos os imóveis ao usuários.
2. Usuário procura o imóvel desejado.(FA01)
3. O usuário seleciona o imóvel.
4. O sistema exibe as informações do imóvel.
5. Caso de Uso encerrado.
<hr>

**Fluxos alternativos:**

**-FA01:** Filtro de busca.

1. O sistema oferece a opção de filtrar as buscas.
2. O usuário escolhe a opção desejada.
3. O sistema apresenta os imóveis filtrados.(FE01)
4. O caso de uso retorna para o passo 2 do fluxo principal.
<hr>

**Fluxos de exceção:**

**-FE01:** Não possui imóveis com as características de busca.

1. O sistema informa que não há imóveis disponíveis com aquele perfil de pesquisa.
2. O caso de uso retorna para o passo 1 do fluxo principal.
<hr>

[Links](#links)  



<br /><br />



## **UC05 - Fazer proposta por imóvel**

**Lista de atores:** Usuário.
<hr>

**Visão geral:** Permite que o usuário demonstre seu interesse pelo imóvel e contate o responsável pelo mesmo.
<hr>

**Referências cruzadas:** Requisitos: RF004 e RF010. Casos de uso: UC04.
<hr>

**Pré-Condições:** O usuário precisa ter realizado login e escolher o imóvel desejado.
<hr>

**Pós-Condições:** O usuário prossegue a negociação com o corretor.
<hr>

**Fluxo Principal:**

1. O usuário confirma o interesse pelo imóvel.
2. O sistema apresenta os campos para o preenchimento da proposta.
3. O usuário preenche os campos. (FE01)
4. O sistema informa ao proprietário responsável o interesse sobre o imóvel.
5. O caso de uso é encerrado.
<hr>

**Fluxos de exceção:**

**-FE01:** Proposta inválida.

1. O sistema informa que a proposta não é válida.
2. Caso de uso retorna para o passo 3 do fluxo principal.
<hr>

[Links](#links)  



<br /><br />



## **UC06 - Registrar imóvel**

**Lista de atores:** Usuário.
<hr>

**Visão geral:** O usuário faz o registro de um imóvel no sistema para vender.
<hr>

**Referências cruzadas:** Requisitos: RF011. Casos de uso: UC08.
<hr>

**Pré-Condições:** O usuário precisa ter realizado login.
<hr>

**Pós-Condições:** O imóvel é registrado no sistema.
<hr>

**Fluxo Principal:**

1. O sistema apresenta o formulário de cadastro.
2. O usuário preenche o formulário requisitado.
3. O sistema verifica os dados informados. (FE01)
4. O sistema confirma o estado do registro.
5. O caso de uso é encerrado.
<hr>

**Fluxos de exceção:**

**-FE01:** Dados inválidos.

1. O sistema informa qual(is) dado(s) está(ão) errado(s).
2. O caso de uso retorna para o passo 2 do fluxo principal.
<hr>

[Links](#links)  



<br /><br />



## **UC07 - Acessar propostas**

**Lista de atores:** Usuário.
<hr>

**Visão geral:** O usuário verá as propostas que foram feitas sobre o seu imóvel.
<hr>

**Referências cruzadas:** Requisitos: RF010. Casos de uso: UC05.
<hr>

**Pré-Condições:** O usuário deve estar autenticado no sistema.
<hr>

**Pós-Condições:** O usuário consegue ver as propostas sobre seu imóvel.
<hr>

**Fluxo Principal:**

1. O usuário acessa suas propostas. (FE01)
2. O usuário escolhe a proposta que deseja ver.
3. O sistema apresenta as informações da proposta.
4. Caso de uso encerrado.
<hr>

**Fluxos exceção:**

**-FE01:** O usuário não possui imóveis a venda.

1. O sistema informa que é necessário registrar imóveis para receber propostas.
2. Caso de uso encerrado.
<hr>

[Links](#links)  



<br /><br />



## **UC08 - Editar proposta**

**Lista de atores:** Usuário.
<hr>

**Visão geral:** Irá permitir que o usuário altere atributos de uma proposta ja feita.
<hr>

**Referências cruzadas:** Requisitos: RN011. Casos de uso: UC07.
<hr>

**Pré-Condições:** O usuário precisa ter realizado login e acessar a proposta.
<hr>

**Pós-Condições:** A proposta é editada com sucesso.
<hr>

**Fluxo Principal:**

1. O usuário solicita edição da proposta.
2. O usuário preenche os campos com as informações alteradas
3. O usuário confirma a ação.
4. O sistema confirma a edição da proposta.
5. O caso de uso é encerrado.
<hr>

[Links](#links)  



<br /><br />



## **UC09 - Emitir relatório**

**Lista de atores:** Corretor e administrador.
<hr>

**Visão geral:** O sistema irá fornecer relatórios com as informações específicas requisitadas.
<hr>

**Referências cruzadas:** Requisitos: RF016, RF017, RF018, RF019 e RF020.
<hr>

**Pré-Condições:** O corretor deve estar autenticado no sistema.
<hr>

**Pós-Condições:** O relatório é emitido com sucesso.
<hr>

**Fluxo Principal:**

1. O corretor seleciona quais relatórios deseja gerar.
2. O corretor confirma a ação.
3. O sistema apresenta o relatório com as definições escolhidas pelo usuário.
4. Caso de uso encerrado.
<hr>

**Fluxos de exceção:**

**-FE01:** Nenhum relatório foi escolhido

1. O sistema informa que nenhum relatório foie escolhido.
2. O caso de uso retorna ao passo 1 do fluxo principal.
<hr>

[Links](#links)  



<br /><br />



## **UC10 - Remover cadastro**

**Lista de atores:** Administrador.
<hr>

**Visão geral:** O sistema permitirá que o administrador remova o cadastro do usuário ou apenas os privilégios do corretor.
<hr>

**Referências cruzadas:** Requisitos: RF014 e RF015.
<hr>

**Pré-Condições:** O corretor deve estar autenticado no sistema.
<hr>

**Pós-Condições:** Conta removida ou privilégios de corretor removidos.
<hr>

**Fluxo Principal:**

1. O administrador busca o usuário.
2. O administrador solicita a remoção do cadastro de um usuário ou o privilégio de corretor da conta.
3. O sistema pede a confirmação.
4. O administrador confirma a ação.
5. O sistema remove o cadastro de um usuário ou privilégio de corretor da conta.
6. O sistema notifica o usuário sobre a situação de sua conta.
7. Caso de uso encerrado.
<hr>

**Fluxos alternativos:**

**-FA01:** O administrador não confirma a ação.

1. O sistema cancela a ação.
2. Caso de uso encerrado.
<hr>

**Fluxos de exceção:**

**-FE01:** Usuário não encontrado.

1. O sistema notifica que o usuário buscado é inválido e/ou não existe.
2. O caso de uso retorna ao passo 1 do fluxo principal.
<hr>

[Links](#links)  



<br /><br />



## **UC11 - Editar cadastro da conta**

**Lista de atores:** Usuário.
<hr>

**Visão geral:** O sistema permitirá que o usuário faça alterações em suas informações do perfil.
<hr>

**Referências cruzadas:** Requisitos: RF012.
<hr>

**Pré-Condições:** O usuário deve estar autenticado no sistema.
<hr>

**Pós-Condições:** Dados editados com sucesso.
<hr>

**Fluxo Principal:**

1. O usuário acessa suas informações.
2. O usuário solicita edição de um campo.
3. O usuário preenche a nova informação.
4. O sistema pede a confirmação.
5. O usuário confirma a ação.
6. Caso de uso encerrado
<hr>

**Fluxos alternativos:**

**-FA01:** O usuário não confirma a ação.

1. O sistema cancela a ação.
2. Caso de uso encerrado
<hr>

**Fluxos de exceção:**

**-FE01:** Dado com formatação inadequada.

1. O sistema notifica o dado inválido.
2. O caso de uso retorna ao passo 3 do fluxo principal.
<hr>

[Links](#links)  



<br /><br />



## **UC12 - Editar cadastro do imóvel**

**Lista de atores:** Usuário.
<hr>

**Visão geral:** O sistema permitirá que o usuário faça alterações em suas informações dos imóveis.
<hr>

**Referências cruzadas:** Requisitos: RF013.
<hr>

**Pré-Condições:** O usuário deve estar autenticado no sistema.
<hr>

**Pós-Condições:** Dados editados com sucesso.
<hr>

**Fluxo Principal:**

1. O usuário acessa seus imóveis.
2. O usuário escolhe o imóvel que deseja alterar.
3. O usuário solicita edição de um campo.
4. O usuário preenche a nova informação.
5. O sistema pede a confirmação.
6. O usuário confirma a ação.
7. Caso de uso encerrado.
<hr>

**Fluxos alternativos:**

**-FA01:** O usuário não confirma a ação.

1. O sistema cancela a ação.
2. Caso de uso encerrado
<hr>

**Fluxos de exceção:**

**-FE01:** Dado com formatação inadequada.

1. O sistema notifica o dado inválido.
2. O caso de uso retorna ao passo 3 do fluxo principal.
<hr>

[Links](#links)  



<br /><br />



## **UC13 - Acessar perfil**

**Lista de atores:** Usuário.
<hr>

**Visão geral:** O sistema permitirá que o usuário acesse o perfil de um usuário verificando suas informações.
<hr>

**Referências cruzadas:** Requisitos: RF021.
<hr>

**Pré-Condições:** O usuário deve estar autenticado no sistema.
<hr>

**Pós-Condições:** Página de perfil acessada.
<hr>

**Fluxo Principal:**

1. O usuário solicita o acesso ao perfil.
2. O sistema redireciona o usuário para o perfil.
3. Caso de uso encerrado.
<hr>

[Links](#links)  



<br /><br />



## **UC14 - Registrar venda**

**Lista de atores:** Corretor.
<hr>

**Visão geral:** O sistema permitirá que o corretor registre suas vendas de imóveis da imobiliária.
<hr>

**Referências cruzadas:** Requisitos: RF007.
<hr>

**Pré-Condições:** O corretor deve estar autenticado no sistema e acessar a proposta que deu inicio a negociação da venda.
<hr>

**Pós-Condições:** Estado do imóvel atualizado como vendido.
<hr>

**Fluxo Principal:**

1. O corretor solicita o registro da venda.
2. O sistema pede o valor final da negociação.
3. O corretor informa o valor. (FE01)
4. O sistema atualiza o estado do Imóvel.
5. O sistema confirma a operação.
6. Caso de uso encerrado.
<hr>

**Fluxos de exceção:**

**-FE01:** Valor inserido inválido.

1. O sistema notifica o dado inválido.
2. O caso de uso retorna ao passo 3 do fluxo principal.
<hr>

[Links](#links)


<br /><br />

### _[Voltar para a tela inicial do repositório](../)_
