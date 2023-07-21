package com.springtodoapp.myfirsttodoapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
//	@Autowired
//	private AuthenticationService authenticationService;

//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

//	@RequestMapping(value="login", method = RequestMethod.POST)
//	public String goToMain(@RequestParam String name, @RequestParam String password, ModelMap model ) {
//		if(authenticationService.authenticate(name, password)) {
//			model.put("name", name);
////			model.put("password", password);
//			return "welcome";
//		}
//		model.put("errorMessage", "Invalid cerendentials please re-enter");
//		return "login";
//	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getLoggedInUsername());
		return "welcome";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
