package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GoogleBooksApi {

    private static final String  API_URL = "https://www.googleapis.com/books/v1/volumes?q=isbn";
    private static final String API_KEY = "AIzaSyD0KN45-mfnO9acboW1a2o1oeOlr-hnNB0";
//    private static final Logger LOGGER = Logger.getLogger(GoogleBooksApi.class.getName());

    public JsonObject buscarLivroPorIsbn(String isbn) throws IOException {
        String url = API_URL + isbn + "&key=" + API_KEY;
        try (CloseableHttpClient HttpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = HttpClient.execute(request)) {
                String jsonResponse = EntityUtils.toString(response.getEntity());
//                    LOGGER.log(Level.INFO, "Response from API: " + jsonResponse);
                return JsonParser.parseString(jsonResponse).getAsJsonObject();


            } catch (IOException e) {
//                    LOGGER.log(Level.SEVERE, "Error while making request to API" + e.getMessage(), e);
                throw e;
            }
        }
    }
}

//ISBN O pequeno principe: 9786556407067
