/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scraping;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sávio Raires
 */
public class ScrapingSelic implements ScrapingTaxa{
     @Override
    public double getTaxa() {
        try {
            JsonElement jsonSelic = getJsonSelic();
            return jsonSelic.getAsJsonObject().get("valor").getAsDouble();
        } catch (IOException ex) {
            Logger.getLogger(ScrapingSelic.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private JsonElement getJsonSelic() throws MalformedURLException, IOException {
        URL url = new URL("http://api.bcb.gov.br/dados/serie/bcdata.sgs.4189/dados/ultimos/1?formato=json/valor");
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); 
        JsonElement jsonSelic = root.getAsJsonArray().get(0);
        return jsonSelic;
    } 
}
