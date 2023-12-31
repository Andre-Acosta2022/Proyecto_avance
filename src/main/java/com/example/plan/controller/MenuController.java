/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/autor")
    public String indexAutor(Model model){
        model.addAttribute("mensaje", "Hola");
        return "autores/autor";
    }
    
    @GetMapping("/editorial")
    public String indexEdit(){
        return "editoriales/editorial";
    }

    
    @GetMapping("/lector")
    public String indexLector(){
        return "lectores/lector";
    }
    @GetMapping("/libro")
    public String indexLibro(){
        return "libros/libro";
    }
    @GetMapping("/prestamo")
    public String indexPrestamo(){
        return "prestamos/prestamo";
    }
    @GetMapping("/user")
    public String indexUser(){
        return "usuarios/user";
    }   
}
