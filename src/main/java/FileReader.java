import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@AllArgsConstructor
public class FileReader {

    private final String filePath;

    public List<Quote> readLinesFromFile() throws IOException {
        List<Quote> quotes = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath));
        String readLine;
        int quoteId = 1;

        while ((readLine = bufferedReader.readLine()) != null) {
            quotes.add(splitReadLine(readLine, quoteId));
            quoteId++;
        }

        bufferedReader.close();
        return quotes;
    }

    private Quote splitReadLine(String readLine, int quoteId) {
        String[] partOfReadLine = readLine.split(Pattern.quote("~"));
        return new Quote(quoteId, partOfReadLine[0], partOfReadLine[1], false);
    }
}
