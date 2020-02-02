package dad.tema1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ejercicio4 {

	private static class Anuncio {
		static int proximaId = 0;

		final int ID;
		String nombreUsuario;
		String asunto;
		String cuerpo;

		public Anuncio(String nombreUsuario, String asunto, String cuerpo) {
			this.ID = proximaId++;
			this.nombreUsuario = nombreUsuario;
			this.asunto = asunto;
			this.cuerpo = cuerpo;
		}
	}

	private static final String PAGINA_PRINCIPAL_TEMPLATE = "ejercicio4_pagina_principal";
	private static final String CREAR_ANUNCIO_TEMPLATE = "ejercicio4_crear_anuncio";
	private static final String ANUNCIO_CREADO_TEMPLATE = "ejercicio4_anuncio_creado";
	private static final String ANUNCIO_TEMPLATE = "ejercicio4_anuncio";

	private static final String ANUNCIOS_KEY = "anuncios";
	private static final String ASUNTO_KEY = "asunto";
	private static final String NOMBRE_USUARIO_KEY = "nombreUsuario";
	private static final String CUERPO_KEY = "cuerpo";

	private Map<Integer, Anuncio> anuncios = new HashMap<>();

	@RequestMapping("/ejercicio4")
	public String controladorPaginaPrincipal(Model model) {
		model.addAttribute(ANUNCIOS_KEY, anuncios.values());

		return PAGINA_PRINCIPAL_TEMPLATE;
	}

	@RequestMapping("/ejercicio4/crearanuncio")
	public String controladorCrearAnuncio(Model model) {
		return CREAR_ANUNCIO_TEMPLATE;
	}

	@RequestMapping("/ejercicio4/anunciocreado")
	public String controladorCrearAnuncio(Model model, @RequestParam String nombreUsuario, @RequestParam String asunto,
			@RequestParam String cuerpo) {
		Anuncio nuevoAnuncio = new Anuncio(nombreUsuario, asunto, cuerpo);
		anuncios.put(nuevoAnuncio.ID, nuevoAnuncio);

		return ANUNCIO_CREADO_TEMPLATE;
	}

	@RequestMapping("ejercicio4/mostraranuncio")
	public String controladorMostrarAnuncio(Model model, @RequestParam String id) {
		int numericID = Integer.parseInt(id);
		Anuncio anuncio = anuncios.get(numericID);

		model.addAttribute(ASUNTO_KEY, anuncio.asunto);
		model.addAttribute(NOMBRE_USUARIO_KEY, anuncio.nombreUsuario);
		model.addAttribute(CUERPO_KEY, anuncio.cuerpo);

		return ANUNCIO_TEMPLATE;
	}

}
