package dad.tema1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ejercicio2 {

	@RequestMapping("/ejercicio2")
	public String controladorEjercicio2(Model model) {
		return "ejercicio2";
	}

	@RequestMapping("/ejercicio2_mostrar")
	public String mostrarEnlace(Model model, @RequestParam String nenlace) {
		int numero = Integer.parseInt(nenlace);
		model.addAttribute("numero", numero);

		return "ejercicio2_mostrar";
	}

}
