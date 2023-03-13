import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FileReader fileReader = new FileReader("src/main/resources/quotes.txt");
        List<Quote> quotes;

        try {
            quotes = fileReader.readLinesFromFile();


            QuoteService quoteService = new QuoteService(quotes);
            System.out.printf("Get all quotes (%d quotes):\n", quoteService.getAllQuotes().size());
            System.out.println(quoteService.getAllQuotes());

            String author = "Benjamin Franklin";
            System.out.printf("\nGet quotes for %s (%d quotes):%n", author, quoteService.getQuotesForAuthor(author).size());
            System.out.println(quoteService.getQuotesForAuthor(author));

            System.out.printf("\nGet distinct authors (%d authors):\n", quoteService.getAuthors().size());
            System.out.println(quoteService.getAuthors());

            quoteService.setFavourite(151);
            quoteService.setFavourite(2245);
            quoteService.setFavourite(5277);
            System.out.printf("\nGet favorite quotes (%d quotes):\n", quoteService.getFavourites().size());
            System.out.println(quoteService.getFavourites());

            System.out.println("\nRandom quotes: ");
            System.out.println(quoteService.getRandomQuote());
            System.out.println(quoteService.getRandomQuote());
            System.out.println(quoteService.getRandomQuote());

        } catch (IOException e) {
            System.out.println("File not found! " + e.getMessage());
        }
    }
}