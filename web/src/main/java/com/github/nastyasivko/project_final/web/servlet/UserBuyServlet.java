package com.github.nastyasivko.project_final.web.servlet;

import com.github.nastyasivko.project_final.dao.HotelDao;
import com.github.nastyasivko.project_final.dao.NewOrdersDao;
import com.github.nastyasivko.project_final.dao.UserOrderDao;
import com.github.nastyasivko.project_final.dao.impl.DefaultHotelDao;
import com.github.nastyasivko.project_final.dao.impl.DefaultNewOrderDao;
import com.github.nastyasivko.project_final.dao.impl.DefaultUserOrderDao;
import com.github.nastyasivko.project_final.model.LoginUsers;
import com.github.nastyasivko.project_final.model.Room;
import com.github.nastyasivko.project_final.model.UserOrder;
import com.github.nastyasivko.project_final.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userbuy")
public class UserBuyServlet extends HttpServlet {
    final HotelDao hotelDao = DefaultHotelDao.getInstance();
    final UserOrderDao userOrderDao = DefaultUserOrderDao.getInstance();
    final NewOrdersDao newOrdersDao = DefaultNewOrderDao.getInstance();
    final String name = "project";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Room> listRoom = hotelDao.getRoomBeds(name);
        req.setAttribute("listRooms", listRoom);
        WebUtils.forwardToJsp("userBuy", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] roomName = req.getParameterValues("listName");
        String[] roomBed = req.getParameterValues("listBed");
        LoginUsers  user =(LoginUsers) req.getSession().getAttribute("authUser");
        UserOrder userOrder = new UserOrder(null,user.getLogin(),roomName[0], roomBed[0]);

        userOrderDao.saveUserOrder(name, userOrder);
        newOrdersDao.saveNewOrder(name, userOrder);
        req.setAttribute("done", "Вы отправили заказ");

        WebUtils.forwardToJsp("pageUser", req, resp);
    }
}
