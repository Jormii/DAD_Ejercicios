package dad.tema1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ejercicio3 {

	@RequestMapping("/ejercicio3")
	public String controladorEjercicio2(Model model) {
		return "ejercicio3";
	}

	@RequestMapping("/ejercicio3_mostrar/{nenlace}")
	public String mostrarEnlace(Model model, @PathVariable String nenlace) {
		int numero = Integer.parseInt(nenlace);
		model.addAttribute("numero", numero);

		return "ejercicio2_mostrar";
	}
	
}
