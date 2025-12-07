package com.propertymanagement.controller;

import com.propertymanagement.model.*;
import com.propertymanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private LandlordRepository landlordRepo;

    @Autowired
    private PropertyRepository propertyRepo;

    @Autowired
    private TenantRepository tenantRepo;

    @Autowired
    private BillRepository billRepo;

    @Autowired
    private PaymentRepository paymentRepo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("propertyCount", propertyRepo.count());
        model.addAttribute("tenantCount", tenantRepo.count());
        model.addAttribute("billCount", billRepo.count());
        model.addAttribute("properties", propertyRepo.findAll());
        model.addAttribute("tenants", tenantRepo.findAll());
        return "index";
    }

    @GetMapping("/properties")
    public String properties(Model model) {
        model.addAttribute("properties", propertyRepo.findAll());
        model.addAttribute("landlords", landlordRepo.findAll());
        return "properties";
    }

    @PostMapping("/properties/add")
    public String addProperty(@RequestParam String address,
            @RequestParam String propertyType,
            @RequestParam Long landlordId) {
        Landlord landlord = landlordRepo.findById(landlordId).orElse(null);
        if (landlord != null) {
            Property property = new Property("P" + (propertyRepo.count() + 1), address, propertyType);
            property.setLandlord(landlord);
            propertyRepo.save(property);
        }
        return "redirect:/properties";
    }

    @GetMapping("/tenants")
    public String tenants(Model model) {
        model.addAttribute("tenants", tenantRepo.findAll());
        model.addAttribute("properties", propertyRepo.findAll());
        return "tenants";
    }

    @PostMapping("/tenants/add")
    public String addTenant(@RequestParam String name,
            @RequestParam String contactInfo,
            @RequestParam Long propertyId,
            @RequestParam String roomID) {
        Property property = propertyRepo.findById(propertyId).orElse(null);
        if (property != null) {
            Tenant tenant = new Tenant("T" + (tenantRepo.count() + 1), name, contactInfo);
            tenant.setAssignedRoomID(roomID);
            tenant.setProperty(property);
            tenantRepo.save(tenant);
        }
        return "redirect:/tenants";
    }

    @GetMapping("/bills")
    public String bills(Model model) {
        model.addAttribute("bills", billRepo.findAll());
        model.addAttribute("tenants", tenantRepo.findAll());
        return "bills";
    }

    @PostMapping("/bills/add")
    public String addBill(@RequestParam Long tenantId,
            @RequestParam String billType,
            @RequestParam double amount) {
        Tenant tenant = tenantRepo.findById(tenantId).orElse(null);
        if (tenant != null) {
            Bill bill = new Bill("B" + (billRepo.count() + 1), billType, amount);
            bill.setTenant(tenant);
            billRepo.save(bill);
        }
        return "redirect:/bills";
    }

    @PostMapping("/bills/pay/{id}")
    public String markBillPaid(@PathVariable Long id) {
        Bill bill = billRepo.findById(id).orElse(null);
        if (bill != null) {
            bill.setPaid(true);
            billRepo.save(bill);
        }
        return "redirect:/bills";
    }

    @PostMapping("/payments/add")
    public String addPayment(@RequestParam Long tenantId,
            @RequestParam double amount,
            @RequestParam String paymentType) {
        Tenant tenant = tenantRepo.findById(tenantId).orElse(null);
        if (tenant != null) {
            Payment payment = new Payment("P" + (paymentRepo.count() + 1), amount, paymentType);
            payment.setTenant(tenant);
            paymentRepo.save(payment);
        }
        return "redirect:/bills";
    }

    @GetMapping("/landlord")
    public String landlord(Model model) {
        model.addAttribute("landlords", landlordRepo.findAll());
        return "landlord";
    }

    @PostMapping("/landlord/add")
    public String addLandlord(@RequestParam String name, @RequestParam String contactInfo) {
        Landlord landlord = new Landlord("L" + (landlordRepo.count() + 1), name, contactInfo);
        landlordRepo.save(landlord);
        return "redirect:/landlord";
    }
}
