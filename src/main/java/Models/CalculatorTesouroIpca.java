/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Scraping.ScrapingIPCA;
import Scraping.ScrapingTaxa;

/**
 *
 * @author Sávio Raires
 */
public class CalculatorTesouroIpca implements ICalculatorInvestiment{
    
    private ScrapingTaxa scrapingTaxa;
    
    private double getTaxaIpca(){
        scrapingTaxa = new ScrapingIPCA();
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
    public double calculateInvestment(int tempoInvestimento, int valorInvestido) {
        double taxaIPCA = 2.7/100;
        double diasUteis = getDiasUteis(tempoInvestimento);
        double taxaCompra = 0.06;
        double resultadoInvestimento = valorInvestido*(Math.pow(((1+taxaIPCA)*(1+taxaCompra)), (diasUteis/252)));
        return getNumeroArredondado(resultadoInvestimento, 2);
        //return getTaxaIpca();
    }
    
}
