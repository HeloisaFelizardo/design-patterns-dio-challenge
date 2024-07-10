package dio.digitalinnovation.gof;

import dio.digitalinnovation.gof.context.Item;
import dio.digitalinnovation.gof.context.ShoppingCart;
import dio.digitalinnovation.gof.strategy.CreditCardPayment;
import dio.digitalinnovation.gof.strategy.PayPalPayment;

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
