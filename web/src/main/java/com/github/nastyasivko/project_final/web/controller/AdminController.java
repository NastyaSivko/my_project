package com.github.nastyasivko.project_final.web.controller;

import com.github.nastyasivko.project_final.dao.CostDao;
import com.github.nastyasivko.project_final.dao.HotelRoomDao;
import com.github.nastyasivko.project_final.dao.UserAdministratorDao;
import com.github.nastyasivko.project_final.dao.UserOrderDao;
import com.github.nastyasivko.project_final.model.Cost;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserAdministratorDao userAdministratorDao;
    private final CostDao costDao;
    private final HotelRoomDao hotelRoomDao;
    private final UserOrderDao userOrderDao;

    public AdminController(UserAdministratorDao userAdministratorDao, CostDao costDao, HotelRoomDao hotelRoomDao, UserOrderDao userOrderDao) {
        this.userAdministratorDao = userAdministratorDao;
        this.costDao = costDao;
        this.hotelRoomDao = hotelRoomDao;
        this.userOrderDao = userOrderDao;
    }

    @GetMapping()
    public String get(HttpServletRequest rq, UsernamePasswordAuthenticationToken authentication) {
        return "admin";
    }

    @GetMapping(value = "/vieworder")
    public String getOrder(HttpServletRequest rq, UsernamePasswordAuthenticationToken authentication) {
        List<UserOrder> userOrders = userAdministratorDao.getUsersOrders();
        int count = userOrders.size();
        if (count % 3 == 0) {
            rq.setAttribute("pageCount", (count / 3));
        } else {
            rq.setAttribute("pageCount", ((count / 3) + 1));
        }
        int pageNumber;
        if (rq.getParameter("page") != null) {
            pageNumber = parseInt(rq.getParameter("page"));
        } else {
            pageNumber = 1;
        }
        List<UserOrder> orderList = userAdministratorDao.getNewOrdersForPage(pageNumber);
        if (orderList.size() == 0) {
            rq.setAttribute("message", "Нет новых заказов");
            return "redirect:/viewOrder";
        }
        rq.setAttribute("orderList", orderList);
        rq.setAttribute("currentPage", pageNumber);
        return "redirect:/viewOrder";
    }

    @PostMapping(value = "/vieworder")
    public String setOrder(HttpServletRequest rq, UsernamePasswordAuthenticationToken authentication) {
        String userLogin = rq.getParameter("userLogin");
        String nameRoom = rq.getParameter("nameRoom");
        String bed = rq.getParameter("bed");
        String dateStart = rq.getParameter("dateStart");
        String dateEnd = rq.getParameter("dateEnd");

        String[] strStart;
        String[] strEnd;
        String delimeter = "\\.";
        strStart = dateStart.split(delimeter);
        strEnd = dateEnd.split(delimeter);
        final GregorianCalendar calendarStart = new GregorianCalendar();
        final GregorianCalendar calendarEnd = new GregorianCalendar();

        calendarStart.set(parseInt(strStart[0]), parseInt(strStart[1]),parseInt(strStart[2]));
        calendarStart.set(parseInt(strEnd[0]), parseInt(strEnd[1]),parseInt(strEnd[2]));

        UserOrder userOrder = new UserOrder(null, userLogin, nameRoom, bed, calendarStart.getTime(), calendarEnd.getTime());
        rq.getSession().setAttribute("userOrderAnswer", userOrder);

        return "redirect:/answerfororder";
    }

    @GetMapping(value = "/answerfororder")
    public String getAnswer(HttpServletRequest rq) {
        UserOrder userOrder = (UserOrder) rq.getSession().getAttribute("userOrderAnswer");
        List<String> listNumber = hotelRoomDao.getNumberRoom(userOrder.getNameRoom(), userOrder.getBeds());
        List<Cost> costList = costDao.getListCosts();
        rq.setAttribute("number", listNumber);
        rq.setAttribute("costList", costList);
        return "redirect:/answerForOrder";
    }

    @PostMapping(value = "/answerfororder")
    public String setAnswer(HttpServletRequest rq) {
        String userLogin = rq.getParameter("userLogin");
        String nameRoom = rq.getParameter("nameRoom");
        String bed = rq.getParameter("bed");
        String dateStart = rq.getParameter("dateStart");
        String dateEnd = rq.getParameter("dateEnd");
        String[] answer = rq.getParameterValues("answer");
        String[] numberRoom = rq.getParameterValues("numberRoom");
        String[] costRoom = rq.getParameterValues("costs");

        String[] strStart;
        String[] strEnd;
        String delimeter = "\\.";
        strStart = dateStart.split(delimeter);
        strEnd = dateEnd.split(delimeter);
        final GregorianCalendar calendarStart = new GregorianCalendar();
        final GregorianCalendar calendarEnd = new GregorianCalendar();

        UserOrder userOrderNew = userOrderDao.getUserOrder(new UserOrder(null, userLogin, nameRoom, bed, calendarStart.getTime(), calendarEnd.getTime()));

        if (answer[0].equals("YES")) {
            userAdministratorDao.saveApprovedOrder(userOrderNew, parseInt(numberRoom[0]), new Cost(null, parseInt(costRoom[0])));
            userAdministratorDao.deleteNewOrders(userOrderNew);
        }

        if (answer[0].equals("NO")) {
            userAdministratorDao.saveDeniedOrder(userOrderNew);
            userAdministratorDao.deleteNewOrders(userOrderNew);
        }

        rq.getSession().setAttribute("message", "Ответ отправлен");
        return "redirect:/vieworder";
    }

}
