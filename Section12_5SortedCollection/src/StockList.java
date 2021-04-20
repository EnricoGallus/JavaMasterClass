import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>( );
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock != item) {
                item.adjustStock(inStock.availableQuantity());
            }

            list.put(item.getName(), item);
            return item.availableQuantity();
        }

        return 0;
    }

    public boolean sellStock(String itemName, int quantity) {
        StockItem inStock = list.get(itemName);
        if (inStock != null && quantity > 0) {
            return inStock.finalizeStock(-quantity);
        }

        return false;
        /*StockItem inStock = list.getOrDefault(itemName, null);
        if (inStock != null && inStock.availableQuantity() >= quantity && quantity > 0) {
            return inStock.finalizeStock(-quantity);
        }

        return false;*/
    }

    public boolean reserveStock(String itemName, int quantity) {
        StockItem inStock = list.get(itemName);
        if (inStock != null && quantity > 0) {
            return inStock.reserveStock(quantity);
        }

        return false;
    }

    public boolean unreserveStock(String itemName, int quantity) {
        StockItem inStock = list.get(itemName);
        if (inStock != null && quantity > 0) {
            return inStock.unreserveStock(quantity);
        }

        return false;
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }

        return Collections.unmodifiableMap(prices);
    }

    public StockItem get(String itemName) {
        return list.get(itemName);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStockLis\n";
        double totalCost = 0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();
            s = s + stockItem + ". There are " + stockItem.availableQuantity() + " in stock. Value of items is ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value " + String.format("%.2f", totalCost);
    }
}
