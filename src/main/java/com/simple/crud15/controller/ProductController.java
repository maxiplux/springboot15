package com.simple.crud15.controller;


import com.simple.crud15.model.Product;
import com.simple.crud15.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IService productService ;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView students(){
        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("products/list");
        return modelAndView;
    }

    @RequestMapping(value="/product/new", method = RequestMethod.GET)
    public String create(Model model){

        model.addAttribute("product", new Product());


        return "products/edit";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("product") Product product,
                       BindingResult result, Model model)  {

        if (result.hasErrors())
        {
            model.addAttribute("errors", result.getAllErrors());
            return "products/edit";
        }
        product = productService.save(product);
        return "redirect:/";
    }

    @RequestMapping(value="/product/edit/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model)
    {

        model.addAttribute("product", productService.findOne(id).get());
        return "products/edit";
    }

    @RequestMapping(value="/product/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model)
    {
        productService.delete(id);
        return "redirect:/";
    }
}
