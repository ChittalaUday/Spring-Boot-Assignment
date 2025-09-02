package com.uday.task4.controller;

import com.uday.task4.model.InvoiceItem;
import com.uday.task4.model.Medicine;
import com.uday.task4.service.InvoiceService;

import java.util.List;
import java.util.ArrayList;

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
        model.addAttribute("medicines", service.getAllMedicines());
        return "invoice";
    }

    @PostMapping("/generate")
    public String generateInvoice(@RequestParam("medicineId") List<Integer> medIds,
            @RequestParam("quantity") List<Integer> quantities,
            Model model) {

        List<InvoiceItem> invoiceItems = new ArrayList<>();
        double totalAmount = 0.0;
        double totalGst = 0.0;
        double totalReceivable = 0.0;

        for (int i = 0; i < medIds.size(); i++) {
            int medId = medIds.get(i);
            Medicine med = service.getAllMedicines().stream()
                    .filter(m -> m.getId().equals(medId))
                    .findFirst()
                    .orElse(null);

            if (med != null) {
                int qty = quantities.get(i);

                double baseAmount = service.calculateBaseAmount(med, qty);
                double discountAmount = service.calculateDiscountAmount(med, qty);
                double gstAmount = service.calculateGstAmount(med, qty);
                double netAmount = service.calculateNetAmount(med, qty);

                InvoiceItem item = new InvoiceItem();
                item.setQuantity(qty);
                item.setDescription(med.getName());
                item.setPacking(med.getPacking());
                item.setGst(med.getGst());
                item.setTradePrice(med.getTradePrice());
                item.setRetailPrice(med.getRetailPrice());
                item.setDiscount(med.getDiscount());
                item.setExpiryDate(med.getExpiryDate());
                item.setNetAmount(netAmount);

                invoiceItems.add(item);

                totalAmount += baseAmount - discountAmount;
                totalGst += gstAmount;
                totalReceivable += netAmount;
            }
        }

        model.addAttribute("invoiceItems", invoiceItems);
        model.addAttribute("totalAmount", totalAmount);
        model.addAttribute("totalGst", totalGst);
        model.addAttribute("totalReceivable", totalReceivable);

        return "invoice";
    }

}
