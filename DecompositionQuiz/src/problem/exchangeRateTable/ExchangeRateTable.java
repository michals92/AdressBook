package problem.exchangeRateTable;

import java.util.Hashtable;
import java.util.Map;

/**
 * This class represents exchange rate table.
 *
 * @author Petr Adamek
 */
class ExchangeRateTable {

    private Map<String,Double> exchangeRates = new Hashtable<String, Double>();

    public void setExchangeRate(String currency, double exchangeRate) {
        if (exchangeRate <= 0) {
            throw new IllegalArgumentException("Exchange rate must be grater than zero");
        }
        exchangeRates.put(currency, exchangeRate);
    }
    public double getExchangeRate(String currency) {
        return exchangeRates.get(currency);
    }

    public double convert(String targetCurrency, double amount) {
        double exchangeRate = exchangeRates.get(targetCurrency);
        return exchangeRate * amount;
    }

}