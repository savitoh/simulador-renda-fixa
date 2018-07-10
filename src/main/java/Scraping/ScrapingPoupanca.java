/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scraping;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Sávio Raires
 */
public class ScrapingPoupanca implements ScrapingTaxa{
    @Override
    public double getTaxa(){
        try {
            Document doc = Jsoup.connect("http://www4.bcb.gov.br/pec/poupanca/poupanca.asp").get();
            Element table = doc.select("tbody").get(0);
            Elements tr = table.select("tr");
            Element lastLinha = tr.last();
            Elements td = lastLinha.select("td");
            Element lastColuna = td.last();
            return Double.parseDouble(lastColuna.text().replace(',', '.'));
        } catch (IOException ex) {
            Logger.getLogger(ScrapingPoupanca.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
