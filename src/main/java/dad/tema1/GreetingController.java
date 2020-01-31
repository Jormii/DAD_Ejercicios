package dad.tema1;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@Autowired
	private UsersService usersService;

	@RequestMapping("/greeting")
	public String greeting(Model model) {
		model.addAttribute("name", String.format("%d users", usersService.getNumUsers()));

		return "greeting_template";
	}

	@RequestMapping("/greetingname")
	public String greetingName(Model model, @RequestParam String name) {
		model.addAttribute("name", name);

		return "greeting_template";
	}

	@RequestMapping("/basic")
	public String basic(Model model) {
		model.addAttribute("name", "World");
		model.addAttribute("silent", false);

		return "basic_template";
	}

	@RequestMapping("/list")
	public String colorList(Model model) {
		List<String> colors = Arrays.asList("Red", "Green", "Blue");
		model.addAttribute("colors", colors);

		return "list_template";
	}

}