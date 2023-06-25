/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.controller;

import com.example.plan.entity.Convenio;
import com.example.plan.serviceImpl.ConvenioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ALVARO
 */
@Controller
@RequestMapping("/convenio")
public class ConvenioController {

    @Autowired
    private ConvenioService convenioService;

    @GetMapping
    public String indexConvenio(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("Convenios", convenioService.readAll());
        return "Convenios/listarConvenios";
    }

    @GetMapping("/add")
    public String addConvenio(Model model) {
        model.addAttribute("nombre", "Registrar");
        model.addAttribute("convenio", new Convenio());
        model.addAttribute("fecha_inicio", "Registrar");
        model.addAttribute("fecha_fin", "Registrar");
        model.addAttribute("documento_validado", "Registrar");
        model.addAttribute("estado", "Registrar");
        return "convenios/addConvenio";
    }

    @GetMapping("/save")
    public String saveConvenio(Model model) {
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("convenio", new Convenio());
        return "convenio/addConvenio";
    }

    @PostMapping("/save")
    public String addConvenio(@Valid @ModelAttribute Convenio convenio, BindingResult result, Model model,@RequestPart("file") RedirectAttributes attributes) {
        convenioService.create(convenio);
        return "redirect:/convenio";
    }

    @GetMapping("/edit/{id}")
    public String editarConvenio(@PathVariable("id") int idconvenio, Model model) {
        Convenio convenio = convenioService.read(idconvenio);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("convenio", convenio);
        model.addAttribute("fecha_inicio", "Registrar");
        model.addAttribute("fecha_fin", "Registrar");
        model.addAttribute("documento_validado", "Registrar");
        model.addAttribute("estado", "Registrar");
        return "convenios/addConvenio";
    }

    /*
    @GetMapping("/detalle/{id}")
    public String detalleEditorial(@PathVariable("id") int ideditorial, Model model) {

        Editorial editorial = editorialService.read(ideditorial);
        model.addAttribute("titulo", "Detalle");
        model.addAttribute("autor", editorial);
        return "autores/detalleEditorial";
    }
     */
    @GetMapping("/delete/{id}")
    public String deleteConvenio(@PathVariable("id") int idconvenio) {
        convenioService.delete(idconvenio);
        return "redirect:/convenio";
    }
}
