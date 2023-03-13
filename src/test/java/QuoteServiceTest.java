import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class QuoteServiceTest {

    @Test
    @DisplayName("WHEN the a parameter is sent THEN the QuoteService is created corectly")
    public void testCorrectParameterCreation() {
        //GIVEN
        List<Quote> quotes = List.of(new Quote(1, "Beni", "Castravetele este verde", false));

        //WHEN
        QuoteService quoteService = new QuoteService(quotes);

        //THEN
        Assertions.assertThat(quoteService.getQuotes()).hasSize(1);
    }

    @Test
    public void testNullParameter() {
        QuoteService quoteService = new QuoteService(null);
        Assertions.assertThat(quoteService.getQuotes()).isEmpty();
    }

    @Test
    public void testEmptyListParameter() {
        QuoteService quoteService = new QuoteService(new ArrayList<>());
        Assertions.assertThat(quoteService.getQuotes()).isEmpty();
    }

    @Test
    @DisplayName("WHEN calling getALlQuotes corectly THEN the correct response is returned")
    public void testGetAllQuotes() {
        //GIVEN
        Quote quote1 = new Quote(1, "Mihai", "Time is money", false);
        Quote quote2 = new Quote(2, "Beni", "Castravetele este verde", false);
        List<Quote> quotes = new ArrayList<>();
        quotes.add(quote1);
        quotes.add(quote2);

        QuoteService quoteService = new QuoteService(quotes);

        //WHEN
        List<String> allQuotes = quoteService.getAllQuotes();

        //THEN
        Assertions.assertThat(allQuotes)
                .hasSize(2)
                .containsExactlyInAnyOrder("Time is money", "Castravetele este verde");

        Assertions.assertThat(quoteService.getQuotes()).hasSize(2);
        Assertions.assertThat(quoteService.getQuotes()).extracting("quote", "author")
                .containsExactlyInAnyOrder(Tuple.tuple("Time is money", "Mihai"), Tuple.tuple("Castravetele este verde", "Beni"));

        Assertions.assertThat(quoteService.getQuotes()).extracting("author").containsExactlyInAnyOrder("Beni", "Mihai");
    }
}