package com.example.ticketreservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;


@Controller
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "index";
    }

    @PostMapping("/book")
    public String bookTicket(@ModelAttribute Ticket ticket) {
        ticketService.bookTicket(ticket);
        return "redirect:/";
    }
}