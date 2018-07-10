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
public class ScrapingIPCA implements ScrapingTaxa{
    
    @Override
    public double getTaxa() {
        try {
            Document doc = Jsoup.connect("https://www.tororadar.com.br/investimento/bovespa/o-que-e-ipca-e-inflacao-acumulada").get();
            Element table = doc.select("tbody").get(0);
            Elements tr = table.select("tr");
            Element linha = tr.get(2);
            Element  lastColuna = linha.select("td").last();   
            return Double.parseDouble(lastColuna.text().replace(',', '.'));
        } catch (IOException ex) {
            Logger.getLogger(ScrapingIPCA.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
