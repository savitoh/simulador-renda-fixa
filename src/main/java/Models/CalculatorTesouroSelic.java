/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Scraping.ScrapingSelic;
import Scraping.ScrapingTaxa;

/**
 *
 * @author Sávio Raires
 */
public class CalculatorTesouroSelic implements ICalculatorInvestiment{
    
     private ScrapingTaxa scrapingTaxa;

    private double getTaxaSelic() {
        scrapingTaxa = new ScrapingSelic();
        return scrapingTaxa.getTaxa();
    }
    
    private int getDiasUteis(int tempoInvestimento) {
        return tempoInvestimento*21;
    }
    
    private double getNumeroArredondado(double valor, int casas) {
        double arredondado = valor;
        arredondado *= (Math.pow(10, casas));
        arredondado = Math.floor(arredondado);
        arredondado /= (Math.pow(10, casas));
	return arredondado;
    }
    
   
    @Override
    public double calculateInvestment(int tempoInvestimento, int valorInvestimento) {
        double taxaSelic = getTaxaSelic()/100;
        double diasUteis = getDiasUteis(tempoInvestimento);
        double resultadoInvestimento = valorInvestimento*(Math.pow((1+taxaSelic),(diasUteis/252)));
        return getNumeroArredondado(resultadoInvestimento, 2);
    }   
    
}
