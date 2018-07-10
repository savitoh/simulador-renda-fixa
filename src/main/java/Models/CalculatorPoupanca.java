/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Scraping.ScrapingPoupanca;
import Scraping.ScrapingTaxa;

/**
 *
 * @author Sávio Raires
 */
public class  CalculatorPoupanca implements ICalculatorInvestiment{
    
    private ScrapingTaxa scrapingTaxa;
    
    private double getRendimentoPoupanca() {
        scrapingTaxa = new ScrapingPoupanca();
        return scrapingTaxa.getTaxa();
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
        double resultadoInvestimento = valorInvestido;
        double taxaRendimentoPoupanca = getRendimentoPoupanca();
        for(int i=0; i<tempoInvestimento; i++)
            resultadoInvestimento += resultadoInvestimento*(taxaRendimentoPoupanca/100);
        return getNumeroArredondado(resultadoInvestimento, 2);
    }
    
}
