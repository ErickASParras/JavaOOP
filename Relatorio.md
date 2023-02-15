<!--Heading-->
# Trabalho Programação 2
## Erick Augusto Santos Parras - l50059
<!--Heading-->
### O trabalho final acabou com um total de 10 arquivos, sendo que 2 foram dados pelo enunciado
1. Product
2. Freshness (Dado pelo enunciado)
3. Perishable
4. NonPerishable
5. Element (Dado pelo enunciado)
6. ElementMachine
7. MoneyMachine
8. ProductMachine
9. VendingMachine
10. Venda

### Descricao de cada classe, falando seu uso e explicando seus métodos que não sejam triviais (como setter, getter e construtores)

----
### Product - Classe para criar a base de cada produto, sendo a Parent class de Perishable e NonPerishable




` public Product(String produto, double preco) ` -> Construtor que recebe um produto e o seu valor

---------
### Perishable - Child class de Product, serve de classificacao de produtos que possuem uma data de validade, não possui volume como medida

`     public boolean isFromToday() ` -> Verifica a data do momento atual que o produto e criado e compara com a data de vencimento, se forem diferentes, retorna falso, caso contrário retorna verdadeiro


`public boolean isOutDated()` -> Verifica a data do momento atual que o produto e criado e compara com a data de vencimento, se a data atual ja estiver passado da data de vencimento, retorna verdadeiro, caso contrário retorna falso

------------------

### NonPerishable - Child class de Product, serve de classificacao de produtos que possuem não uma data de validade, possui volume como medida

`public NonPerishable(String produto, double quantidade, double volume)` -> construtor tendo volume como argumento

----------
### ElementMachine - Parent class para as classes ProductMachine e Money machine, a base para realizar grande parte das acções de suas child classes

` public void addThings(int count, T thing) ` -> Para adicionar um elemento na lista, e preciso verificar se ja existe um dele na lista,se for a primeira ocorrencia, e simplesmente adicionado ao fim da lista o novo objeto, e ele ja existir, e criado uma copia do objeto que esta na lista, e realizado a soma do count da lista com o que foi passado nos argumentos, apos a soma e guardado na copia do objeto e sao colocados para repor o objeto original da lista


`public boolean removeOneThing(T thing)` -> Para remover uma unidade do objeto, vai ser necessario verificar se existe o objeto, se existe, criar uma copia temporaria dele, subtrair -1 do seu contador e substituir pela sua versao presente na lista


`public void listAll()` -> E escrito no terminal cada elemento da lista no formato definido na interface Element

----

### MoneyMachine - Child class de ElementarMachine, tem o proposito de receber e guardar o dinheiro para compra e venda dos produtos na maquina, servindo basicamente como uma caixa registradora

`public void addMoney(int n, float dinheiro)` -> Adiciona uma quantidade x de dinhero y vezes, para simular diversas notas/moedas sendo inseridas

`public float getTotalValue()` -> Calcula o valor total guardado, somando as notas/moedas da maquina


------
### ProductMachine - Child class da ElementarMachine, recebe cada produto e serve como meio de adicionar, verificar se tem a existecia de algum produto em seu inventario e lista os produstos em ordem de valor

`public boolean hasProduct(Product produto)` -> Usa o argumento sendo recebido para comparar com cada objeto da lista, verificando se existe algum igual, retornando verdadeiro e falso caso contrário.

`public void listAllOrdered()` -> Organiza a lista pelos valores de cada produto em ordem crescente usando o método de bubblesort, e após organizar a lista, cada elemento e iterado uma ultima vez para escrever o resultado


-----

### VendingMachine - Maquina final, sendo feita por uma ProductMachine e uma MoneyMachine, podendo assim associar os dois e ao mesmo tempo sendo capaz de salvar cada maquina em um arquivo .dat, que pode ser resgatado mais tarde

`public static void saveMachine(VendingMachine maquina, String arquivo)` -> Recebe uma maquina e uma string que vai ser usado como nome do arquivo onde a VendingMachine dada sera salva por meio de ObjectOutputStream


`public static VendingMachine restoreMachin(String arquivo)` -> Recebe o nome de um arquivo, ou caminho para o mesmo, onde deve conter um aquivo salvo pelo método saveMachine, recuperando a maquina guardada por meio de ObjectInputStream

`public void Venda(Perishable compra, float pagamento)` -> método criado para solucionar a questão de vendas da maquina, vai ser verificado se os argumentos estão corretos, em seguida e encontrado o produto que esta sendo comprado, calculado o seu preco e retirado um do estoque, soma o valor da compra ao banco e se for necessário e possível devolver troco.


----

### Venda - apenas um exemplo simples da execução da máquina

-------
## Erro não resolvido no trabalho
* Durante o fim de semana final de produção do trabalho percebi que havia criado errado o método `` listAllOrdered() `` e quando organizei-o, implementando o bubblesort o `` toString() `` comecou a me devolver a referencia dos produtos em vez do próprio produto, para contornar isso eu "implementei" o toString() de forma modificada no fim do método.

* Os Métodos relacionados a criar ficheiros externos (pelo menos a parte de salvar a maquina, uma vez que não tive como verificar o método em relacao a carregar) as máquinas da classe VendingMachine estou a dar a excpetion de ``NotSerializableException `` mesmo que o eu implementasse a interface Serializabl
