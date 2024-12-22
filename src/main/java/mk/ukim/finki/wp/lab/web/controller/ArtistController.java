package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.implementation.ArtistServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@Controller
public class ArtistController {
    private String selectedId = "";
    private final ArtistServiceImpl artistService;

    public ArtistController(ArtistServiceImpl artistService, SpringTemplateEngine springTemplateEngine) {
        this.artistService = artistService;
      //  this.springTemplateEngine = springTemplateEngine;
    }

    @GetMapping("/artist")
    public String getDetails(Model model){
        model.addAttribute("artists",artistService.listArtists());
        model.addAttribute("trackId",selectedId);
        return "artistsList";
    }

    @PostMapping("/artist")
    public String getArtists(@RequestParam String trackId){
        selectedId = trackId;
        return "redirect:/artist";
    }

}
