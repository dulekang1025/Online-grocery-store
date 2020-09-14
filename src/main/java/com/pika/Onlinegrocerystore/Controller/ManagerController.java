package com.pika.Onlinegrocerystore.Controller;

import com.pika.Onlinegrocerystore.Services.ManagerService;
import com.pika.Onlinegrocerystore.Services.ProductService;
import com.pika.Onlinegrocerystore.domain.Manager;
import com.pika.Onlinegrocerystore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;
//    private ProductService productService;
//
//    @Autowired
//    public ManagerController(ManagerService managerService) {
//        this.managerService = managerService;
//    }

//    @RequestMapping("/findAll")
////    @ResponseBody
//    public String findById(Model model){
//        System.out.println("Here.");
//        model.addAttribute("manager", managerService.findById(1L));
////        return managerService.findAll();
//        return "managers";
//    }

    @RequestMapping("/findById")
    public String findManager1(Model model) {

        Manager manager = managerService.findById(1L);
        model.addAttribute("manager", manager);

        return "managers";
    }

}
