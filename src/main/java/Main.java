import java.util.Scanner;

public class Main {

    public static void main(String ... args){

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(new Product("Cola", 5, 3));
        vendingMachine.addProduct(new Product("Water", 2, 2));
        vendingMachine.addProduct(new Product("Snickers", 3, 4));
        vendingMachine.addCoins(new Coin(1, 3));
        vendingMachine.addCoins(new Coin(2, 1));

        vendingMachine.startMachine();

    }


}
