package com.uday.task4.service;

import com.uday.task4.dao.MedicineDao;
import com.uday.task4.model.Medicine;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceService {

    private final MedicineDao dao;

    public InvoiceService(MedicineDao dao) {
        this.dao = dao;
    }

    public List<Medicine> getAllMedicines() {
        return dao.findAll();
    }

    public double calculateBaseAmount(Medicine med, int qty) {
        return med.getRetailPrice() * qty;
    }

    public double calculateDiscountAmount(Medicine med, int qty) {
        return calculateBaseAmount(med, qty) * (med.getDiscount() / 100);
    }

    public double calculateGstAmount(Medicine med, int qty) {
        double taxable = calculateBaseAmount(med, qty) - calculateDiscountAmount(med, qty);
        return taxable * (med.getGst() / 100);
    }

    public double calculateNetAmount(Medicine med, int qty) {
        double base = calculateBaseAmount(med, qty);
        double discount = calculateDiscountAmount(med, qty);
        double gst = calculateGstAmount(med, qty);
        return base - discount + gst;
    }

}
