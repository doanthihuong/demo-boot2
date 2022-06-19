package com.example.demoboot2.controller;

import com.example.demoboot2.model.Province;
import com.example.demoboot2.service.IProvinceService;
import com.example.demoboot2.service.impl.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Name;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    ProvinceService provinceService =new ProvinceService();

    @GetMapping
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("province", provinceService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView save(Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("redirect:/provinces");
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Province province = provinceService.findById(id).get();
        modelAndView.addObject("pro", province);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView update(@PathVariable Long id, Province province) {
        ModelAndView modelAndView = new ModelAndView("redirect:/provinces");
        provinceService.save(province);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        Province province = provinceService.findById(id).get();
        modelAndView.addObject("pro", province);
        return modelAndView;

    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/provinces");
        provinceService.remove(id);
        return modelAndView;

    }
    @GetMapping("/search")
    public ModelAndView showFindForm (@RequestParam String name) {
        ModelAndView modelAndView =new ModelAndView("search");
        modelAndView.addObject("province", provinceService.findByName(name));
        return modelAndView;
    }
    @GetMapping("/findTop")
    public ModelAndView showTopLike ( ) {
        ModelAndView modelAndView =new ModelAndView("topName");
        modelAndView.addObject("province", provinceService.findTopName());
        return modelAndView;
    }


}