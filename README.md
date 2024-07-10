# Payment Strategy System

Este projeto demonstra o uso do padrão de projeto Strategy para implementar diferentes métodos de pagamento em um sistema de carrinho de compras.

## Visão Geral

O padrão Strategy permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. Isso permite que o algoritmo varie independentemente dos clientes que o utilizam.

## Estrutura do Projeto

O projeto consiste nas seguintes classes principais:

- `Item`: Representa um item no carrinho de compras.
- `ShoppingCart`: Representa o carrinho de compras e contém a lógica para adicionar/remover itens e calcular o total.
- `PaymentStrategy`: Interface que define o método de pagamento.
- `CreditCardPayment` e `PayPalPayment`: Implementações concretas da `PaymentStrategy` para diferentes métodos de pagamento.

## Como Usar

1. **Adicionar Itens ao Carrinho**:
    - Crie uma instância de `ShoppingCart`.
    - Adicione itens ao carrinho usando o método `addItem(Item item)`.

2. **Definir Estratégia de Pagamento**:
    - Crie uma instância da estratégia de pagamento desejada (`CreditCardPayment` ou `PayPalPayment`).
    - Defina a estratégia de pagamento no carrinho usando o método `setPaymentStrategy(PaymentStrategy paymentStrategy)`.

3. **Realizar Pagamento**:
    - Chame o método `pay()` para realizar o pagamento usando a estratégia definida.

### Exemplo

```java
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("Book", 100);
        Item item2 = new Item("Pen", 50);

        cart.addItem(item1);
        cart.addItem(item2);

        // Pagar com cartão de crédito
        cart.setPaymentStrategy(new CreditCardPayment("John Doe", "1234567890123456", "786", "12/23"));
        cart.pay();

        // Pagar com PayPal
        cart.setPaymentStrategy(new PayPalPayment("myemail@example.com", "mypassword"));
        cart.pay();
    }
}
```

### Explicação Detalhada

- **Pacote e Importações**:
   - `package dio.digitalinnovation.gof.context;`: Define o pacote onde a classe `ShoppingCart` está localizada.
   - `import dio.digitalinnovation.gof.strategy.PaymentStrategy;`: Importa a interface `PaymentStrategy`, que será usada para definir a estratégia de pagamento.

- **Classe ShoppingCart**:
   - **Atributos**:
      - `private List<Item> items;`: Uma lista de itens que estão no carrinho de compras.
      - `private PaymentStrategy paymentStrategy;`: A estratégia de pagamento que será usada para processar o pagamento.

   - **Construtor**:
      - `public ShoppingCart() { this.items = new ArrayList<>(); }`: Inicializa a lista de itens como uma nova ArrayList.

   - **Métodos**:
      - `public void addItem(Item item) { items.add(item); }`: Adiciona um item à lista de itens do carrinho.
      - `public void removeItem(Item item) { items.remove(item); }`: Remove um item da lista de itens do carrinho.
      - `public int calculateTotal()`: Calcula o total dos preços dos itens no carrinho, iterando sobre a lista de itens e somando seus preços.
      - `public void setPaymentStrategy(PaymentStrategy paymentStrategy)`: Define a estratégia de pagamento a ser usada. Isso permite que a estratégia de pagamento seja configurada dinamicamente.
      - `public void pay()`: Calcula o total dos itens no carrinho e usa a estratégia de pagamento definida para processar o pagamento.

### Padrão Strategy

- **Interface PaymentStrategy**:
   - A interface `PaymentStrategy` define o método `pay(int amount)`, que deve ser implementado por qualquer classe que represente uma estratégia de pagamento específica.

- **Uso da Strategy**:
   - A `ShoppingCart` usa uma instância de `PaymentStrategy` para processar o pagamento, permitindo que diferentes estratégias de pagamento sejam aplicadas de forma intercambiável (por exemplo, pagamento por cartão de crédito, PayPal, etc.).

Esse design torna o código mais flexível e extensível, pois novas estratégias de pagamento podem ser adicionadas sem modificar a classe `ShoppingCart`.