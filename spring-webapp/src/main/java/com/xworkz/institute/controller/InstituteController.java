package com.xworkz.institute.controller;

import com.xworkz.institute.dto.InstituteDto;
import com.xworkz.institute.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@Controller
public class InstituteController {
    @Autowired
    InstituteService instituteService;

    @PostMapping("/signup")
    public String instituteRegister(InstituteDto instituteDto){
        instituteService.saveInstitute(instituteDto);
        return "success";
    }

    @GetMapping("/viewAllInstitutes")
    public String getAllInstitutes(Model model) {

        List<InstituteDto> instituteDtoList =
                instituteService.getAllInstitute();

        model.addAttribute("institutes", instituteDtoList);

        return "viewAllInstitutes";
    }

    @GetMapping("edit")
    public String getInstituteById(@RequestParam("id") int id , Model model){
        InstituteDto instituteDto = instituteService.getInstituteById(id);
        model.addAttribute("dto",instituteDto);
        return "update";
    }

    @PostMapping("update")
    public RedirectView updateInstitute(InstituteDto instituteDto , HttpServletRequest req){
        instituteService.updateInstitute(instituteDto);
         RedirectView redirectView = new RedirectView();
         redirectView.setUrl(req.getContextPath()+"/viewAllInstitutes");
         return redirectView;
    }

    @GetMapping("delete")
    public RedirectView deleteInstitute(@RequestParam("id") int id, HttpServletRequest req){
        instituteService.deleteInstitute(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(req.getContextPath()+"/viewAllInstitutes");
        return redirectView;
    }


}
