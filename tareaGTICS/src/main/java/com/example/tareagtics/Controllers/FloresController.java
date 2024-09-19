package com.example.tareagtics.Controllers;

import com.example.tareagtics.Models.Entities.Flores;
import com.example.tareagtics.Models.Repositories.*;
import com.example.tareagtics.Models.Repositories.FloresRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lab")
public class FloresController {

    final FloresRepository floresRepository;
    final ColorRepository colorRepository;
    final OcasionRepository ocasionRepository;
    final TipoRepository tipoRepository;

    public FloresController(FloresRepository floresRepository, ColorRepository colorRepository, OcasionRepository ocasionRepository, TipoRepository tipoRepository) {
        this.floresRepository = floresRepository;
        this.colorRepository = colorRepository;
        this.ocasionRepository = ocasionRepository;
        this.tipoRepository = tipoRepository;
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model) {
        return "catalogo";
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
