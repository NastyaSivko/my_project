package com.github.nastyasivko.project_final.web.controller;

import com.github.nastyasivko.project_final.dao.HotelDao;
import com.github.nastyasivko.project_final.dao.NewOrderDao;
import com.github.nastyasivko.project_final.dao.UserOrderDao;
import com.github.nastyasivko.project_final.model.LoginUser;
import com.github.nastyasivko.project_final.model.Room;
import com.github.nastyasivko.project_final.model.UserOrder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.GregorianCalendar;
import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/pageUser")
public class LoginUserController {

    private final HotelDao hotelDao;
    private final UserOrderDao userOrderDao;
    private final NewOrderDao newOrderDao;

    public LoginUserController(HotelDao hotelDao, UserOrderDao userOrderDao, NewOrderDao newOrderDao) {
        this.hotelDao = hotelDao;
        this.userOrderDao = userOrderDao;
        this.newOrderDao = newOrderDao;
    }

    @GetMapping()
    public String startPage(HttpServletRequest rq){
        return "pageUser";
    }

    @GetMapping(value = "/userBuy")
    public String getUserOrder(HttpServletRequest rq, UsernamePasswordAuthenticationToken authentication) {
        List<Room> listRoom = hotelDao.getRoomBeds();
        rq.setAttribute("listRooms", listRoom);
        return "userBuy";
    }

    @PostMapping(value = "/userBuy")
    public String setUserOrder(HttpServletRequest rq, UsernamePasswordAuthenticationToken authentication) {
        String[] roomName = rq.getParameterValues("listName");
        String[] roomBed = rq.getParameterValues("listBed");
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
        LoginUser user =(LoginUser) rq.getSession().getAttribute("authUser");
        UserOrder userOrder = new UserOrder(null,user.getLogin(),roomName[0], roomBed[0], calendarStart.getTime(), calendarEnd.getTime());

        userOrderDao.saveUserOrder(userOrder);
        newOrderDao.saveNewOrder(userOrder);
        rq.setAttribute("done", "Вы отправили заказ");
        return "redirect:/pageUser";
    }
}
