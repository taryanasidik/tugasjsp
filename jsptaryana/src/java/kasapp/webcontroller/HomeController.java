/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasapp.webcontroller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kasapp.dao.KasDAO;
import kasapp.dao.kasDAOProses;
import kasapp.model.DatabaseConfig;
import kasapp.model.Anggota;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author acer
 */
@Controller
public class HomeController {
    KasDAO angDao=null;
    public HomeController(){
        angDao=new kasDAOProses();
    }
    @RequestMapping(value="/home")
    public ModelAndView home(HttpServletRequest req,HttpServletResponse res) throws SQLException{
        /*Connection connection=null;
        connection=DatabaseConfig.openConnection();
        if(connection!=null){
            ModelAndView modelandview=new ModelAndView();
            modelandview.addObject("msg","koneksi DB Sukses");
            return modelandview;
        }else{
            ModelAndView modelandview=new ModelAndView();
            modelandview.addObject("msg","koneksi DB Gagal");
            return modelandview;
        }*/
        return listAnggota(req,res);
    }   

    private ModelAndView listAnggota(HttpServletRequest req, HttpServletResponse res) {
        List<Anggota> list=angDao.get();
        ModelAndView modelandview=new ModelAndView();
        modelandview.addObject("listAnggota", list);
        return modelandview;
    }
} 