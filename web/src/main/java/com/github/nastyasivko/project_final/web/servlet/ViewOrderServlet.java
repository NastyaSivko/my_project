package com.github.nastyasivko.project_final.web.servlet;

import com.github.nastyasivko.project_final.dao.AdministratorDao;
import com.github.nastyasivko.project_final.dao.impl.UserAdministratorDao;
import com.github.nastyasivko.project_final.model.UserOrder;
import com.github.nastyasivko.project_final.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/vieworder")
public class ViewOrderServlet extends HttpServlet {
    final String name = "project";
    final AdministratorDao userAdministratorDao = UserAdministratorDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserOrder> userOrders = userAdministratorDao.getUsersOrders(name);
        int count = userOrders.size();
        req.setAttribute("pageCount", ((count / 3) + 1));
        int pageNumber;
        try {
         pageNumber = Integer.parseInt(req.getParameter("page"));
        }
        catch (NumberFormatException e) {
            pageNumber = 1;
        }
        List<UserOrder> orderList = userAdministratorDao.getNewOrdersForPage(name, pageNumber);
        if(orderList.size() == 0) {
            req.setAttribute("message", "Нет новых заказов");
            WebUtils.forwardToJsp("viewOrder", req, resp);
            return;
        }
        req.setAttribute("orderList", orderList);
        req.setAttribute("currentPage",pageNumber);
        WebUtils.forwardToJsp("viewOrder", req, resp);
    }

}
