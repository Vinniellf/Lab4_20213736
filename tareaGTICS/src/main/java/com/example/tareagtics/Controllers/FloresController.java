package com.example.tareagtics.Controllers;

import com.example.tareagtics.Models.Entities.*;
import com.example.tareagtics.Models.Repositories.*;
import com.example.tareagtics.Models.Repositories.FloresRepository;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lab")
public class FloresController {

    final FloresRepository floresRepository;
    final ColorRepository colorRepository;
    final OcasionRepository ocasionRepository;
    final TipoRepository tipoRepository;
    final PuntajesRepository puntajesRepository;

    public FloresController(FloresRepository floresRepository, ColorRepository colorRepository, OcasionRepository ocasionRepository, TipoRepository tipoRepository, PuntajesRepository puntajesRepository) {
        this.floresRepository = floresRepository;
        this.colorRepository = colorRepository;
        this.ocasionRepository = ocasionRepository;
        this.tipoRepository = tipoRepository;
        this.puntajesRepository = puntajesRepository;
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model) {
        List<Flores> floresList = floresRepository.findAll();
        List<Color> colorList = colorRepository.findAll();
        List<Tipo> tipoList = tipoRepository.findAll();
        List<Ocasion> ocasionList = ocasionRepository.findAll();

        model.addAttribute("flores", floresList);
        model.addAttribute("colors", colorList);
        model.addAttribute("ocasions", ocasionList);
        model.addAttribute("tipos", tipoList);
        return "catalogo";
    }

    @GetMapping("/filtrarFlores")
    public String filtrarFlores(
            @RequestParam("tipo") Long  tipo,
            @RequestParam("color") Long  color,
            @RequestParam("ocasion") Long  ocasion, Model model) {
        List<Flores> floresList = floresRepository.findByTipoColorOcasion(tipo, color, ocasion);
        List<Color> colorList = colorRepository.findAll();
        List<Tipo> tipoList = tipoRepository.findAll();
        List<Ocasion> ocasionList = ocasionRepository.findAll();
        model.addAttribute("flores", floresList);
        model.addAttribute("colors", colorList);
        model.addAttribute("ocasions", ocasionList);
        model.addAttribute("tipos", tipoList);
        return "catalogo";
    }

    @GetMapping("/entretenimineto")
    public String entretenimiento(Model model) {
        List<Puntajes> puntajesList = puntajesRepository.findAll();
        List<Flores> floresLis1 = floresRepository.findAll();
        List<Flores> floresLis2 = floresRepository.findAll();
        List<Flores> listaSumada = new ArrayList<>(floresLis1);
        listaSumada.addAll(floresLis2);
        model.addAttribute("flores", listaSumada);
        model.addAttribute("puntajes", puntajesList);
        return "entretenimiento";
    }





    /*
    @GetMapping("/listar")
    public String showEmployees(Model model) {
        List<Employee> listaEmployees = employeesRepository.findAll();
        model.addAttribute("listaEmployees", listaEmployees);
        return "listaEmpleados";
    }

    @GetMapping("/editar")
    public String editarEmployees(Model model,
                                  @RequestParam("idEmployee") int id) {
        List<Job> listaJobs = employeesJobRepository.findAll();
        model.addAttribute("listaJobs", listaJobs);
        Optional<Employee> optionalEmployee = employeesRepository.findById(id);

        if(optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            model.addAttribute("employee", employee);
            return "catalogo";
        }else{
            return "redirect:/employee/listar";
        }
    }

    @PostMapping("/guardar")
    public String guardar (Employee employee) {
        employeesRepository.save(employee);
        return "redirect:/employee/listar";
    }

    @GetMapping("/borrar")
    public String borrarEmpleado(Model model, @RequestParam("idEmployee") int id, RedirectAttributes redirectAttributes) {
        try {
            employeesRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Se borró el empleado");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "No se pudo borrar el empleado");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        return "redirect:/employee/listar";
    }*/


}
