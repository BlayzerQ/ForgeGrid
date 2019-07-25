package blayzer.webservice.controllers;

import blayzer.webservice.bussines.objects.User;
import blayzer.webservice.presentation.dto.RegistrationForm;
import blayzer.webservice.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public ModelAndView registration(ModelAndView model) {
        model.addObject("user", new RegistrationForm());
        return model;
    }

    @PostMapping("/registration")
    public String processRegistration(@Valid @ModelAttribute("user") RegistrationForm registrationForm, Errors errors, HttpServletRequest request) {
        if (errors.hasErrors()) {
            return "registration";
        }
        String login = registrationForm.getLogin();
        String password = registrationForm.getPassword();
        User user = new User();
        user.setLogin(login);
        user.setEmail(registrationForm.getEmail());
        user.setPassword(passwordEncoder.encode(password));
        userService.persist(user);
        try {
            request.login(login, password);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "redirect:/index";
    }
}
