package com.example.prototip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import java.util.List;
import java.util.Optional;
@Controller
public class LoginController {
	 @Autowired
	    private UserRepository userRepository;
	 
	 private String username;
	 private String password;
	 public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	 @GetMapping("/login")
	    public String showLoginPage() {
		 
	
		 
		 
	        return "login";
	    }
	 // Login işlemini yöneten POST metodu
	    @PostMapping("/login")
	    public String login(@RequestParam String username, @RequestParam String password, Model model) {
	    	 List<User> users = userRepository.findAll();
	    	for(User us:users) {
	    		if(us.getUsername().equals(username) && us.getPassword().equals(password)) {
	    			return "homepage";
	    		}
	    	}
	    	model.addAttribute("error", "Hatalı kullanıcı adı veya şifre!");
	    	return "login";
	    	
	    }
	 // Ana sayfayı gösteren GET metodu
	    @GetMapping("/homepage")
	    public String showHomePage() {
	        return "homepage";
	    }
	    
	    
	    


}
