package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.service.DonationFilling;

import java.util.List;

@Controller
public class DonationFillingController {
    private final DonationFilling donationFilling;

    public DonationFillingController(DonationFilling donationFilling) {
        this.donationFilling = donationFilling;
    }

    @PostMapping("/step1")
    public String fillingAction1(@RequestParam List<String> filling) {


        return "/donationStep2";
    }


}
