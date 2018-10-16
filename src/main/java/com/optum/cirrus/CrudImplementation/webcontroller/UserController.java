package com.optum.cirrus.CrudImplementation.webcontroller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.optum.cirrus.CrudImplementation.model.User;
import com.optum.cirrus.CrudImplementation.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm,Model model) {

    	if(!userForm.getUsername().isEmpty() && !userForm.getPassword().isEmpty())
    		userService.save(userForm);
    	else
    	{
    		model.addAttribute("error", "Should not be empty");
    		return "registration";
    	}
        return "redirect:/welcome";
    }
    

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model,@PathParam(value = "username") String username ) {
    	System.out.println("username********in post login"+ username);

	User user=userService.findByUsername(username);
	System.out.println("---------------------"+user);
		if(user!=null)
		{
			System.out.println("Mom is"+user.getUsername().trim());
			return "welcome";
		}
		else
		{
			model.addAttribute("error", "Invalid inputs");
			return "login";
		}
			
    }

    

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,String error, String logout, @PathParam(value = "username") String username ) {

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
