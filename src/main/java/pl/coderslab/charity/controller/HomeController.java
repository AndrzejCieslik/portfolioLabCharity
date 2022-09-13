package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> all = institutionRepository.findAll();
        model.addAttribute("institutions", all);
        List<Donation> donations = donationRepository.findAll();
        Integer sucksSum = donations.stream()
                .map(x->x.getQuantity())
                .reduce(0,Integer::sum);
        System.out.println(sucksSum);
        Long donationSum = donations.stream()
                        .collect(Collectors.counting());
        model.addAttribute("sucksSum",sucksSum);
        model.addAttribute("donationSum",donationSum);

        return "index";
    }
    /*
   public String homeAction(){
        return  "redirect:/home";
    }*/
}
