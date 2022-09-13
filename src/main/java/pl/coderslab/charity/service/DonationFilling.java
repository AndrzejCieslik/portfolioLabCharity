package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonationFilling {

    private List<String> donationName;
    private List<String> institutionName;
    private Integer donationQuantity;
    private String donationStreet;
    private String donationCity;

    private String donationZipCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate donationPickUpDate;

    private LocalTime donationPickUpTime;

    private String donationPickUpComment;

}
