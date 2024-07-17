package ro.simavi.mf.avr.aes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ro.simavi.mf.avr.aes.model.ImageList;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
@Service

public class RetrieveImageService {
    public ImageList getImageUrl() throws IOException, InterruptedException, JAXBException {
        URL url = new URL("https://api-gate2.movieglu.com/images/?film_id=184126");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        httpURLConnection.setRequestProperty("api-version", "v200");
        httpURLConnection.setRequestProperty("Authorization", "\tBasic TU9JRl9YWDo2ZDd4MXZoZElNc1o=");
        httpURLConnection.setRequestProperty("x-api-key", "gIRo7yNJsh1NkRZNrWf238BB6peYK9eV49VFhNZR");
        httpURLConnection.setRequestProperty("device-datetime", "2024-07-15T15:26:02.228Z");
        httpURLConnection.setRequestProperty("territory", "XX");
        httpURLConnection.setRequestProperty("client", "MOIF");
        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(response.toString());
            ImageList rootData = objectMapper.readValue(response.toString(), ImageList.class);
            return rootData;

        } else {
            System.out.println("GET request not worked");
        }

        for (int i = 1; i <= 8; i++) {
            System.out.println(httpURLConnection.getHeaderFieldKey(i) + " = " + httpURLConnection.getHeaderField(i));
        }
        return null;

    }
}
