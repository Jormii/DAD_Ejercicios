package dad.tema1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ejercicio1 {

	@RequestMapping("/ejercicio1")
	public String controladorEjercicio1(Model model) {
		return "nuevo_anuncio";
	}
	
	@RequestMapping("/mostrarAnuncio")
	public String nuevoAnuncio(Model model, @RequestParam String nombreUsuario,
			@RequestParam String asunto, @RequestParam String cuerpo) {
		model.addAttribute("nombreUsuario", nombreUsuario);
		model.addAttribute("asunto", asunto);
		model.addAttribute("mensaje", cuerpo);
		
		return "anuncio";
	}
	
}
