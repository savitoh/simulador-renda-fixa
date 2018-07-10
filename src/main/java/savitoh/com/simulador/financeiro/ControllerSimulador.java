/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savitoh.com.simulador.financeiro;

import Models.CalculatorPoupanca;
import Models.CalculatorTesouroIpca;
import Models.CalculatorTesouroSelic;
import Models.ICalculatorInvestiment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sávio Raires
 */
@WebServlet(name = "ControllerSimulador", urlPatterns = {"/ControllerSimulador"})
public class ControllerSimulador extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ICalculatorInvestiment calculatorInvestiment;
        String investimentoEscolhido = request.getParameter("investimentoEscolhido");
        int duracaoInvestimento = Integer.parseInt(request.getParameter("duracaoInvestimento"));
        int valorInvestido = Integer.parseInt(request.getParameter("valorInvestido"));
        response.setContentType("text/plain");
        
        if(investimentoEscolhido.equalsIgnoreCase("selic")) {
            calculatorInvestiment = new CalculatorTesouroSelic();
            double resultado = calculatorInvestiment.calculateInvestment(duracaoInvestimento, valorInvestido);
            response.getWriter().write(Double.toString((resultado)));  
        }
        else if(investimentoEscolhido.equalsIgnoreCase("ipca")) {
            calculatorInvestiment = new CalculatorTesouroIpca();
            double resultado = calculatorInvestiment.calculateInvestment(duracaoInvestimento, valorInvestido);
            response.getWriter().write(Double.toString((resultado)));
        }
        
        else if(investimentoEscolhido.equalsIgnoreCase("poupanca")) {
            calculatorInvestiment = new CalculatorPoupanca();
            double resultado = calculatorInvestiment.calculateInvestment(duracaoInvestimento, valorInvestido);
            response.getWriter().write(Double.toString((resultado)));
        }       
    }    
}
