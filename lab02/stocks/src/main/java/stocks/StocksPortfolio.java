package stocks;

import java.util.ArrayList;
import java.util.List;

public class StocksPortfolio {
    private String name;
    private List<Stock> stocks = new ArrayList<Stock>();
    private IStockMarket stockMarket;

    public IStockMarket getMarketService() {
        return this.stockMarket;
    }

    public void setMarketService(IStockMarket marketService) {
        this.stockMarket = marketService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalValue() {
        double total = 0;
        for (Stock item : stocks) {
            total = total + (stockMarket.getPrice(item.getName()) * item.getQuantity());
        }
        ;
        return total;
    }

    public void addStock(Stock newStock) {
        this.stocks.add(newStock);
    }
}
