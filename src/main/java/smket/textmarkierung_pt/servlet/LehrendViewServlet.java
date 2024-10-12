package smket.textmarkierung_pt.servlet;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LehrendViewServlet", value = "/lehrendView")
public class LehrendViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LehrendViewServlet(){
        super();
    }

    //Servlet: arbeitet mit Dateien vom HTTP Request

    //HttpServletRequest: nimmt Daten vom HTTP request entgegen und bearbeitet diese

    //HttpServletResponse: die Antwort auf die request


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("lehrendView.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }



    public void destroy() {
    }
}