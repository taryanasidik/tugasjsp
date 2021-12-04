/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasapp.webcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kasapp.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author acer
 */
@Controller
public class LoginController {
    @RequestMapping(value="/login")
    public ModelAndView login(HttpServletRequest req,HttpServletResponse res){
        if(req.getParameter("message")!=null){
            ModelAndView modelandview=new ModelAndView();
            modelandview.addObject("message", req.getParameter("message"));
            return modelandview;
        }
        return new ModelAndView();
    }
    @RequestMapping(value="/login/save")
    public ModelAndView save(@ModelAttribute("emp")LoginModel emp){
        ModelAndView modelandview=new ModelAndView("redirect:/login.html");
        if(emp.getUsername().equalsIgnoreCase("taryana")&&
                emp.getPassword().equalsIgnoreCase("2222")){
            return new ModelAndView ("redirect:/home.html");
        }else{
            modelandview.addObject("message", "Username dan Password salah");
        }
        return modelandview;
    }
}    