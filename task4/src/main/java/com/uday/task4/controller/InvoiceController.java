package com.uday.task4.controller;

import com.uday.task4.model.InvoiceItem;
import com.uday.task4.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @GetMapping
    public String viewInvoice(Model model) {
        model.addAttribute("items", service.getAllItems());
        model.addAttribute("item", new InvoiceItem());
        return "invoice";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute InvoiceItem item) {
        service.addItem(item);
        return "redirect:/invoice";
    }
}
