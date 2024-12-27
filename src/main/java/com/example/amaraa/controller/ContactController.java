package com.example.amaraa.controller;

import com.example.amaraa.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    // Handle the GET request to show the contact form
    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    // Handle the POST request when the form is submitted
    @PostMapping("/contact")
    public String handleContactFormSubmission(@ModelAttribute ContactForm contactForm, Model model) {
        try {
            // Create an email message
            MimeMessageHelper helper = new MimeMessageHelper(mailSender.createMimeMessage(), true);
            helper.setTo("your-email@example.com"); // Replace with your email
            helper.setSubject("Contact Form Submission");
            helper.setText("Name: " + contactForm.getName() + "\nEmail: " + contactForm.getEmail() + "\nMessage: " + contactForm.getMessage());

            // Send the email
            mailSender.send(helper.getMimeMessage());

            // Success message
            model.addAttribute("message", "Таны мессеж амжилттай илгээгдлээ!");
        } catch (Exception e) {
            model.addAttribute("message", "Мессеж илгээх үед алдаа гарлаа.");
        }

        return "contact-success";
    }
}
