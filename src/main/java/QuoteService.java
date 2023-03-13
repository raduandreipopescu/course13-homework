import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class QuoteService {

    private List<Quote> quotes = new ArrayList<>();

    public QuoteService(List<Quote> quotes) {
        if (quotes == null) {
            this.quotes = new ArrayList<>();
        } else {
            this.quotes.addAll(quotes);
        }
    }

    public List<String> getAllQuotes() {
        List<String> results = new ArrayList<>();
        for (Quote quote : quotes) {
            results.add(quote.getQuote());
        }
        return results;
    }

    public List<Quote> getQuotesForAuthor(String author) {
        List<Quote> results = new ArrayList<>();
        for (Quote quote : quotes) {
            if (author.equals(quote.getAuthor())) {
                results.add(quote);
            }
        }
        return results;
    }

    public List<String> getAuthors() {
        List<String> results = new ArrayList<>();
        for (Quote quote : quotes) {
            String author = quote.getAuthor();
            if (!results.contains(author)) {
                results.add(author);
            }
        }
        return results;
    }

    public void setFavourite(int id) {
        quotes.get(id - 1).setFavorite(true);
    }

    public List<Quote> getFavourites() {
        List<Quote> results = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.isFavorite()) {
                results.add(quote);
            }
        }
        return results;
    }

    public String getRandomQuote() {
        Random randomNumber = new Random();
        return quotes.get(randomNumber.nextInt(0, quotes.size() - 1)).getQuote();
    }
}
