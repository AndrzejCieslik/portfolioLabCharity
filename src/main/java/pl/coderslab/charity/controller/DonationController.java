package pl.coderslab.charity.controller;

import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.DonationFilling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@Builder
public class DonationController {

    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;

    public DonationController(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/donation")
    public String donationStep1(Model model) {
        model.addAttribute("donationFillings", new DonationFilling());
        List<Institution> institutions = institutionRepository.findAll();
        List<String> institutionNames = institutions.stream()
                .map(Institution::getName).toList();
        model.addAttribute("institutionNames", institutionNames);
        //model.addAttribute("institutions", institutions);
        List<Category> cat = categoryRepository.findAll();
        List<String> categoryNames = cat.stream()
                .map(Category::getName).toList();
        model.addAttribute("categoryNames", categoryNames);
        model.addAttribute("cat", cat);
        return "donationStep1";
    }

    @PostMapping("/donation")
    @ResponseBody
    public List<String> donationAdd(@ModelAttribute("donationFilling") DonationFilling donationFillings) {
        Donation donation = new Donation();
        List<Category> categoryList = categoryRepository.findAll();
        List<Category> newCategoryList = new ArrayList<>();
        for (String d : donationFillings.getDonationName()) {
            for (Category c : categoryList) {
                if (d.equals(c.getName())) {
                    newCategoryList.add(c);
                }
            }
        }
        donation.setCategories(newCategoryList);
        List<Institution> institutionList = institutionRepository.findAll();
        List<Institution> newInstitutionList = new ArrayList<>();
        for (String d : donationFillings.getInstitutionName()) {
            for (Institution i : institutionList) {
                if (d.equals(i.getName())) {
                newInstitutionList.add(i);
                }
            }
        }
        donation.setInstitutions(newInstitutionList);
        donation.setQuantity(donationFillings.getDonationQuantity());
        donation.setStreet(donationFillings.getDonationStreet());
        donation.setCity(donationFillings.getDonationCity());
        donation.setZipCode(donationFillings.getDonationZipCode());
        donation.setPickUpDate(donationFillings.getDonationPickUpDate());
        donation.setPickUpTime(donationFillings.getDonationPickUpTime());
        donation.setPickUpComment(donationFillings.getDonationPickUpComment());
        donationRepository.save(donation);
        return Collections.singletonList(donationFillings.getDonationName().toString() + donationFillings.getInstitutionName().toString());

    }

}
