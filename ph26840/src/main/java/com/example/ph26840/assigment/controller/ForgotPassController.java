package com.example.ph26840.assigment.controller;

import com.example.ph26840.assigment.entity.Users;
import com.example.ph26840.assigment.repository.IUserRepository;
import com.example.ph26840.assigment.service.EmailSenderService;
import com.example.ph26840.assigment.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForgotPassController {
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private IUserRepository usersRepository;
    @Autowired
    private UserService userSevice;

    private String generateNewPassword() {
        return RandomStringUtils.randomAlphanumeric(6);
    }

    @RequestMapping(value = { "/forgot-password"}, method = RequestMethod.GET)
    public String forgotPage() {
        return "assigment/login/forgot-password";
    }
    @PostMapping(value = "/forgot-password")
    public String processForgotPasswordForm(@RequestParam("email") String email, Model model)
            throws AddressException, MessagingException {
        Users user = usersRepository.findByEmail(email);

        if (user == null) {
            model.addAttribute("errorMessage", "Không tìm thấy tài khoản với địa chỉ email này");
        } else {

            String newPassword = generateNewPassword();
            userSevice.updatePassword(user, newPassword);
            emailSenderService.sendSimpleEmail(email, "Password New:", newPassword);
            return "redirect:/login";
        }

        return "assigment/login/forgot-password";
    }
}
