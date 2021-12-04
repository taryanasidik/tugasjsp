/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasapp.webcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kasapp.dao.KasDAO;
import kasapp.dao.kasDAOProses;
import kasapp.model.Anggota;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author acer
 */
@Controller
public class AnggotaController {
    KasDAO angDao=null;
    public AnggotaController(){
        angDao=new kasDAOProses();
    }
    
    @RequestMapping(value="/kas-form")
    public ModelAndView index(HttpServletRequest req, HttpServletResponse res){
        String action=req.getParameter("action");
        ModelAndView modelandview;
        if(action==null){
            action="ADD";
        }
        switch(action.toUpperCase()){
            case "EDIT":
                modelandview=editAnggota(req,res);
                break;
            case "DELETE":
                modelandview=deleteAnggota(req,res);
                break;
            default:
                modelandview=addAnggota(req,res);
                break;
        }
        return modelandview;
    }

    @RequestMapping(value="/kas-form",method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("ang") Anggota mh){
        ModelAndView modelandview=new ModelAndView("redirect:/kas-form.html");
        if(mh.getId()!=0){
            if(angDao.update(mh)){
                return new ModelAndView("redirect:/home.html");   
            }else{
                modelandview.addObject("message", "gagal updatte data");
            }    
        }else{
            if(angDao.save(mh)){
                return new ModelAndView("redirect:/home.html");   
            }else{
                modelandview.addObject("message", "gagal simpan data");
            }    
        }
        return modelandview;
       
}

    private ModelAndView editAnggota(HttpServletRequest req, HttpServletResponse res) {
    String id=req.getParameter("id");
    Anggota mah=angDao.getSinggle(Integer.parseInt(id));
    ModelAndView modelandview=new ModelAndView();
    modelandview.addObject("ang", mah);
    return modelandview;
    }
    
    private ModelAndView deleteAnggota(HttpServletRequest req, HttpServletResponse res) {
        String id=req.getParameter("id");
        if(angDao.delete(Integer.parseInt(id))){
            return new ModelAndView("redirect:/home.html");
        }else{
            req.setAttribute("message", "gagal delete");
            return addAnggota(req, res);
        }
    }

    private ModelAndView addAnggota(HttpServletRequest req, HttpServletResponse res) {
        if(req.getParameter("message")!=null){
            ModelAndView modelandview=new ModelAndView();
            modelandview.addObject("message", req.getParameter("message"));
            return modelandview;
        }
        return new ModelAndView();


    }

}    