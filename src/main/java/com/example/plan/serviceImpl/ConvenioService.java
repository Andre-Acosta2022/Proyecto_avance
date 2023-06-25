/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Convenio;
import java.util.List;

/**
 *
 * @author ALVARO
 */
public interface ConvenioService {
Convenio create(Convenio convenio);
 Convenio update(Convenio convenio);
    void delete(int id);
    Convenio read(int id);
    List<Convenio> readAll();
}
