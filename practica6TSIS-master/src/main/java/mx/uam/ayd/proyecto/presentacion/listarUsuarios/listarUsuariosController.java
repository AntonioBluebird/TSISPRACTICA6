package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;


@Controller
@Slf4j
public class listarUsuariosController {
	
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	/**
	 * 
	 * Método invocado cuando se hace una petición GET a la ruta
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listarUsuarios", method=RequestMethod.GET)
    public String getUsuario(Model model) {
			List <Usuario> usuario = new ArrayList<>();
    	
    		usuario = servicioUsuario.recuperaUsuarios();
    		for (int i=0; i<usuario.size(); i++) {
    			System.out.println(usuario.get(i));
    		}
    		
    		model.addAttribute("usuario", usuario);
        
    		// Redirige a esta vista
    		return "vistaListarUsuarios/TablaListarUsuario";
    	
    }

}
