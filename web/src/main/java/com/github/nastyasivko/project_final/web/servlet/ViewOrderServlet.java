//package com.github.nastyasivko.project_final.web.servlet;
//
//import com.github.nastyasivko.project_final.dao.UserAdministratorDao;
//import com.github.nastyasivko.project_final.dao.impl.DefaultUserAdministratorDao;
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
//@WebServlet("/vieworder")
//public class ViewOrderServlet extends HttpServlet {
//    final String name = "project";
//    final UserAdministratorDao userAdministratorDao = DefaultUserAdministratorDao.getInstance();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<UserOrder> userOrders = userAdministratorDao.getUsersOrders(name);
//        int count = userOrders.size();
//        if (count % 3 == 0) {
//            req.setAttribute("pageCount", (count / 3));
//        } else {
//            req.setAttribute("pageCount", ((count / 3) + 1));
//        }
//        int pageNumber;
//        if (req.getParameter("page") != null) {
//            pageNumber = Integer.parseInt(req.getParameter("page"));
//        } else {
//            pageNumber = 1;
//        }
//        List<UserOrder> orderList = userAdministratorDao.getNewOrdersForPage(name, pageNumber);
//        if (orderList.size() == 0) {
//            req.setAttribute("message", "Нет новых заказов");
//            WebUtils.forwardToJsp("viewOrder", req, resp);
//            return;
//        }
//        req.setAttribute("orderList", orderList);
//        req.setAttribute("currentPage", pageNumber);
//        WebUtils.forwardToJsp("viewOrder", req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userLogin = req.getParameter("userLogin");
//        String nameRoom = req.getParameter("nameRoom");
//        String bed = req.getParameter("bed");
//
//        UserOrder userOrder = new UserOrder(null, userLogin, nameRoom, bed);
//        req.getSession().setAttribute("userOrderAnswer", userOrder);
//
//        resp.sendRedirect("/hotel-kempinski/answerfororder");
//    }
//}
