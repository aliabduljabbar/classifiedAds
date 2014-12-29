package ad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.business.AdCoordinator;

public class CreateAd extends HttpServlet{

    public CreateAd(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        int quality = Integer.parseInt(request.getParameter("quality"));
        int price = Integer.parseInt(request.getParameter("price"));
        RequestDispatcher rd = null;

        AdCoordinator ad = new AdCoordinator();
        boolean result;
        result = ad.Create(title, quality, price);

        if(result)
            rd = request.getRequestDispatcher("success.jsp");
        else
            rd = request.getRequestDispatcher("Failure.jsp");

        rd.forward(request, response);
    }
}
