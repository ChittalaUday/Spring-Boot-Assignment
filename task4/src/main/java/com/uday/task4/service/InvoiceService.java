package com.uday.task4.service;

import com.uday.task4.dao.InvoiceItemDao;
import com.uday.task4.model.InvoiceItem;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceItemDao dao;

    public InvoiceService(InvoiceItemDao dao) {
        this.dao = dao;
    }

    public void addItem(InvoiceItem item) {
        // Calculate net amount: (retailPrice * quantity) - discount + gst
        double total = item.getRetailPrice() * item.getQuantity();
        double discountAmt = total * (item.getDiscount() / 100);
        double gstAmt = (total - discountAmt) * (item.getGst() / 100);
        item.setNetAmount(total - discountAmt + gstAmt);

        dao.save(item);
    }

    public List<InvoiceItem> getAllItems() {
        return dao.findAll();
    }
}
