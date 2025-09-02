package com.uday.task4.controller;

import com.uday.task4.dao.MedicineDao;
import com.uday.task4.model.Medicine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

    private final MedicineDao medicineDao;

    public MedicineController(MedicineDao medicineDao) {
        this.medicineDao = medicineDao;
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "add-medicine";
    }

    @PostMapping("/add")
    public String addMedicine(@ModelAttribute Medicine medicine, Model model) {
        Date today = new Date();

        if (medicine.getExpiryDate().before(today)) {
            model.addAttribute("error", "Expiry date cannot be before today.");
            return "add-medicine";
        }

        medicineDao.save(medicine);
        return "redirect:/medicines/list";
    }

    @GetMapping("/list")
    public String listMedicines(Model model) {
        model.addAttribute("medicines", medicineDao.findAll());
        return "list-medicines";
    }
}
