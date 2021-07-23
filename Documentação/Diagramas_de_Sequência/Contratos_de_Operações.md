# **Contratos**

## **UC04 - Buscar imóvel**

</br>

### **Operação:** iniciarBusca() 
<hr>

**Responsabilidade:** Usuário inicia o processo de busca e o sistema apresenta a lista com todos os imóveis.
<hr>

**Referências cruzadas:** Caso de Uso: "UC04 - Buscar imóvel".
<hr>

**Pré-Condições:** 
- Ter algum imóvel para ser selecionado.
- Buscar e escolher o imóvel.
<hr>

**Pós-Condições:** 
- Informações do imóvel enviadas.
<hr>

</br> </br>

### **Operação:** selecionarImovel(idImovel)
<hr>

**Responsabilidade:** Selecionar o imóvel que será usado na operação.
<hr>

**Referências cruzadas:** Caso de Uso: "UC04 - Buscar Imóvel".
<hr>

**Pré-Condições:** 
- Ter algum imóvel para ser selecionado.
- Buscar e escolher o imóvel.
<hr>

**Pós-Condições:** 
- Informações do imóvel enviadas.
<hr>

</br> </br>

## **UC05 - Fazer Proposta por Imóvel**

</br>

### **apresentarFormulárioDeProposta()**  

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

### **enviarProposta()**  

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

### **confirmaPropostaEnviada()**  

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


