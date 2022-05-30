//package midterm;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//@WebServlet("/shoppingList")
//
//public class ShoppingList extends HttpServlet {
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException{ //TODO Auto-generated method stub
//		response.setContentType("text/html");
//		
//		HttpSession session = request.getSession();
//		synchronized (session) {
//			@SuppressWarnings("unchecked")
//			List<SimpleItem> previousItems =
//				(List<SimpleItem>)session.getAttribute("previousItems");
//			if (previousItems ==  null) {
//					previousItems = new ArrayList <SimpleItem>();
//			}
//			String itemName = request. getParameter (itemName);
//			if ((itemName != null) && (itemName.trim().equals(""))) {
//					SimpleItem item = findItem(itemName, previousItems);
//					if (item != null) {
//						item.incrementItemCount();
//					} else {
//							item = new SimpleItem(itemName);
//							previousItem.add(item);
//						}
//			}
//		
//	};
//}
//	
