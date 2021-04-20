import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s: stockList.Items().keySet()) {
            System.out.println(s);
        }

        System.out.println();

        Basket timsBasket = new Basket("Tim");
        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        if (!sellItem(timsBasket, "car", 1)) {
            System.out.println("There are no more cars in stock");
        }

        sellItem(timsBasket, "spanner", 5);
        //System.out.println(timsBasket);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);
        //System.out.println(timsBasket);

        //System.out.println(stockList);

        Basket basket = new Basket("Customer");

        sellItem(basket, "cup", 100);
        sellItem(basket, "juice", 5);
        removeItem(basket, "cup", 1);
        System.out.println(basket);

        removeItem(timsBasket, "car", 1);
        removeItem(timsBasket, "cup", 9);
        removeItem(timsBasket, "car", 1);
        System.out.println("cars removed:" +  removeItem(timsBasket, "car", 1));
        System.out.println(timsBasket);

        removeItem(timsBasket, "bread", 1);
        removeItem(timsBasket, "cup", 3);
        removeItem(timsBasket, "juice", 4);
        removeItem(timsBasket, "cup", 3);
        System.out.println(timsBasket);

        System.out.println("\nDisplay stock list before and after checkout for customer");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

        /*temp = new StockItem("pen", 1.12);
        stockList.Items().put(temp.getName(), temp);*/
        /*stockList.Items().get("car").adjustStock(2000);
        stockList.get("car").adjustStock(-1000);
        System.out.println(stockList);
        System.out.println(stockList.PriceList());*/

        System.out.println("\nDisplay stock list before and after checkout for tims basket");
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);
    }

    public static boolean sellItem(Basket basket, String itemName, int quantity) {
        StockItem stockItem = stockList.get(itemName);
        if (stockItem == null) {
            System.out.println("We don't sell " + itemName);
            return false;
        }

        if (stockList.reserveStock(itemName, quantity)) {
            return basket.addToBasket(stockItem, quantity);
        }

        return false;
    }

    public static boolean removeItem(Basket basket, String itemName, int quantity) {
        StockItem stockItem = stockList.get(itemName);
        if (stockItem == null) {
            System.out.println("We don't sell " + itemName);
            return false;
        }

        if (basket.removeFromBasket(stockItem, quantity)) {
            return stockList.unreserveStock(itemName, quantity);
        }

        return false;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item: basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }

        basket.checkout();
    }
}
