package stocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class StocksPortfolioTest {
    @Mock
    IStockMarket market;

    @InjectMocks
    StocksPortfolio portfolio;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTotalValue() {
        // Load the mock with the proper expectations (when...thenReturn)
        when(market.getPrice("EBAY")).thenReturn(4.0);
        when(market.getPrice("MSFT")).thenReturn(1.5);
        // execute the test
        portfolio.addStock(new Stock("EBAY", 2));
        portfolio.addStock(new Stock("MSFT", 4));

        double result = portfolio.getTotalValue();

        assertEquals(14.0, result);
        verify(market, times(2)).getPrice(anyString());
    }

}
