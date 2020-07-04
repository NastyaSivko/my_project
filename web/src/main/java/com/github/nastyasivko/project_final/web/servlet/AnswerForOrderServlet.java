//package com.github.nastyasivko.project_final.web.servlet;
//
//import com.github.nastyasivko.project_final.dao.UserAdministratorDao;
//import com.github.nastyasivko.project_final.dao.CostDao;
//import com.github.nastyasivko.project_final.dao.HotelRoomDao;
//import com.github.nastyasivko.project_final.dao.UserOrderDao;
//import com.github.nastyasivko.project_final.dao.impl.DefaultCostDao;
//import com.github.nastyasivko.project_final.dao.impl.DefaultHotelRoomDao;
//import com.github.nastyasivko.project_final.dao.impl.DefaultUserOrderDao;
//import com.github.nastyasivko.project_final.dao.impl.DefaultUserAdministratorDao;
//import com.github.nastyasivko.project_final.model.Cost;
//import com.github.nastyasivko.project_final.model.UserOrder;
//import com.github.nastyasivko.project_final.web.WebUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/answerfororder")
//public class AnswerForOrderServlet extends HttpServlet {
//    final HotelRoomDao hotelRoomDao = DefaultHotelRoomDao.getInstance();
//    final UserAdministratorDao userAdministratorDao = DefaultUserAdministratorDao.getInstance();
//    final UserOrderDao userOrderDao = DefaultUserOrderDao.getInstance();
//    final CostDao costDao = DefaultCostDao.getInstance();
//    final String name = "project";
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserOrder userOrder = (UserOrder) req.getSession().getAttribute("userOrderAnswer");
//        List<String> listNumber = hotelRoomDao.getNumberRoom(name, userOrder.getNameRoom(), userOrder.getBeds());
//        List<Cost> costList = costDao.getListCosts(name);
//        req.setAttribute("number", listNumber);
//        req.setAttribute("costList", costList);
//        WebUtils.forwardToJsp("answerForOrder", req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userLogin = req.getParameter("userLogin");
//        String nameRoom = req.getParameter("nameRoom");
//        String bed = req.getParameter("bed");
//        String[] answer = req.getParameterValues("answer");
//        String[] numberRoom = req.getParameterValues("numberRoom");
//        String[] costRoom = req.getParameterValues("costs");
//
//        UserOrder userOrderNew = userOrderDao.getUserOrder(name, new UserOrder(null, userLogin, nameRoom, bed));
//
//        if (answer[0].equals("YES")) {
//            userAdministratorDao.saveApprovedOrder(name, userOrderNew, Integer.parseInt(numberRoom[0]), new Cost(null, Integer.parseInt(costRoom[0])));
//            userAdministratorDao.deleteNewOrders(name, userOrderNew);
//        }
//
//        if (answer[0].equals("NO")) {
//            userAdministratorDao.saveDeniedOrder(name, userOrderNew);
//            userAdministratorDao.deleteNewOrders(name, userOrderNew);
//        }
//
//        req.getSession().setAttribute("message", "Ответ отправлен");
//        resp.sendRedirect("/hotel-kempinski/vieworder");
//    }
//}
