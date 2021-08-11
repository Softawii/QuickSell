# **Contratos**

## **UC04 - Buscar imóvel**

</br>

![](./../Diagramas/Diagrama_de_Sequencia/Buscar_Imovel.png)

</br>

### **Operação:** iniciarBusca() 
<hr>

**Responsabilidade:** Usuário inicia o processo de busca e o sistema apresenta a lista com todos os imóveis.
<hr>

**Referências cruzadas:** Caso de Uso: "UC04 - Buscar imóvel".
<hr>

**Pré-Condições:** 
- Existir pelo menos um imóvel na lista de imóveis.
<hr>

**Pós-Condições:** 
- Sistema apresenta a lista de imóveis para o usuário.
<hr>

</br> </br>

### **Operação:** filtrarImóveis(bairro, preço, tipoDeImovel)
<hr>

**Responsabilidade:** Usuário filtra os imóveis da lista de acordo com as suas preferências em bairro, preço e tipo de imóvel.
<hr>

**Referências cruzadas:** Caso de Uso: "UC04 - Buscar imóvel". Regra de Negócio : "RN02"
<hr>

**Pré-Condições:** 
- Lista de imóveis apresentada.
<hr>

**Pós-Condições:** 
- Imóveis filtrados da lista são apresentados para o usuário.
<hr>

</br> </br>

### **Operação:** selecionarImovel(idImovel)
<hr>

**Responsabilidade:** Selecionar o imóvel que o usuário deseja.
<hr>

**Referências cruzadas:** Caso de Uso: "UC04 - Buscar Imóvel".
<hr>

**Pré-Condições:** 
- Ter algum imóvel para ser selecionado.
- Usuário escolheu o imóvel.
<hr>

**Pós-Condições:** 
- Informações do imóvel exibidas para o usuário.
<hr>

</br> </br>

## **UC05 - Fazer Proposta por Imóvel**

</br>

![](./../Diagramas/Diagrama_de_Sequencia/Fazer_Proposta_por_Imovel.png)

</br>

### **Operação:** apresentarFormulárioDeProposta()  

**Responsabilidade:** Mostrar o formulário da proposta para ser preenchido pelo usuário.
<hr>

**Referências cruzadas:** Caso de Uso: "UC05 - Fazer proposta por imóvel".
<hr>

**Pré-Condições:** 
- Imóvel selecionado.
- Formulário de proposta definido.
<hr>

**Pós-Condições:** 
- Formulário é preenchido.
- Proposta criada.
- Proposta vinculada ao imóvel selecionado.
<hr>

</br> </br>

### **Operação:** enviarProposta() 

**Responsabilidade:** Enviar proposta do usuário ao corretor responsável pelo imóvel selecionado.
<hr>

**Referências cruzadas:** Caso de Uso: "UC05 - Fazer proposta por imóvel".
<hr>

**Pré-Condições:** 
- Proposta realizada.
- Imóvel vinculado a um corretor
<hr>

**Pós-Condições:** 
- Corretor recebe a proposta.
<hr>

</br> </br>

### **Operação:** confirmaPropostaEnviada()

**Responsabilidade:** Confirmar com o usuário que a proposta foi enviada ao corretor.
<hr>

**Referências cruzadas:** Caso de Uso: "UC05 - Fazer proposta por imóvel".
<hr>

**Pré-Condições:** 
- Proposta enviada para o corretor.
<hr>

**Pós-Condições:** 
- Cliente avisado que a proposta ja foi enviada.
- Finalizar processo de realização de proposta.
<hr>


<br /><br />

### _[Voltar para a tela inicial do repositório](/)_
