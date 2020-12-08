import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    private Map<Product, Integer> productStock;
    private Map<Coin, Integer> coinStock;

    private List<Product> products = new ArrayList<>();
    private List<Coin> coins = new ArrayList<>();

    public void startMachine() {
        displayProducts();
        System.out.println("Select you product by inserting the product code");
        int userInputCode = ScannerUtils.getIntFromConsole();
        selectProduct(userInputCode);
    }

    public void selectProduct(int productCode) {
        if (checkProduct(productCode)) {
            Product selectedProduct = getSelectedProduct(productCode);
            displayProductPrice(selectedProduct);
            payProduct(selectedProduct.getPrice());
        } else {
            System.out.println("The product is not available. Please select another product");
            selectProduct(ScannerUtils.getIntFromConsole());
        }
    }

    public Coin selectCoin(int coinCode) {
        if (checkCoin(coinCode)) {
            return getSelectedCoin(coinCode);
        } else {
            System.out.println("The coin is not available. Please insert another coin");
            return selectCoin(ScannerUtils.getIntFromConsole());
        }
    }

    public void payProduct(int price) {
        displayCoins();
        System.out.println("Insert coin by typing coinCode");
        Coin coin = selectCoin(ScannerUtils.getIntFromConsole());
        checkValueCoins(price, coin.getValue());
    }

    public void checkValueCoins(int price, int coinValue) {
        if (price > coinValue) {
            System.out.println("You need to insert more coins till " + (price - coinValue));
            payProduct(price - coinValue);
        } else if (price < coinValue) {
            giveProductAndRest(coinValue - price);
        } else {
            giveProduct();
        }
    }

    public void giveProduct() {
        System.out.println("pick your product. Thank you!");
//        productStock.put(product, productStock.get(product) - 1);
    }

    public void giveProductAndRest(int chain) {
        giveProduct();
        System.out.println("Here is the chain: " + chain);
    }

    public Coin getSelectedCoin(int coinCode) {
        for (Coin coin : coins) {
            if (coin.getCode() == coinCode) {
                return coin;
            }
        }
        return null;
    }


    public Product getSelectedProduct(int productCode) {
        for (Product product : products) {
            if (product.getCode() == productCode)
                return product;
        }
        return null;
    }

    public void displayProductPrice(Product product) {
        System.out.println("The price of the selected product is: " + product.getPrice());
    }

    public boolean checkProduct(int productCode) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode() == productCode) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCoin(int coinCode) {
        for (Coin coin : coins) {
            if (coin.getCode() == coinCode) {
                return true;
            }
        }
        return false;
    }

    public void displayProducts() {
        System.out.println(products);
    }

    public void displayCoins() {
        System.out.println(coins);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addCoins(Coin coin) {
        coins.add(coin);
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }
}
