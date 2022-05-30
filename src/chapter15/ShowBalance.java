package chapter15;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/show-balance")

//MVC
 //- get paremeter from user
//- create the business layer object that returns the interface
//- call interface method pass in request parameter which returns bean class
//- store bean class return into request.setAttribute
//-based on the bean class decide which page you want to go


public class ShowBalance extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    String customerId = request.getParameter("customerId");
    CustomerLookupService service = new CustomerSimpleMap();
    Customer customer = service.findCustomer(customerId);  // OK to pass null or empty String to findCustomer
    request.setAttribute("customer", customer);
    
    String address;
    if (customer == null) {
      request.setAttribute("badId", customerId);
      request.setAttribute("badname", "Bad Name");
      address = "/WEB-INF/results/unknown-customer.jsp";
    } else if (customer.getBalance() < 0) {
      address = "/WEB-INF/results/negative-balance.jsp";
    } else if (customer.getBalance() < 10000) {
      address = "/WEB-INF/results/normal-balance.jsp";
    } else {
      address = "/WEB-INF/results/high-balance.jsp";
    }
    RequestDispatcher dispatcher =
      request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}