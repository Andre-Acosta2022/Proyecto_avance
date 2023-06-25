/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Convenio;
import com.example.plan.repository.ConvenioReposity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ALVARO
 */
@Service
public class ConvenioServicelmpl implements ConvenioService{
@Autowired
private ConvenioReposity convenioRepository;

    @Override
    public Convenio create(Convenio convenio) {
        return convenioRepository.save(convenio);
    }

    @Override
    public Convenio update(Convenio convenio) {
        return convenioRepository.save(convenio); 
    }

    @Override
    public void delete(int id) {
       convenioRepository.deleteById(id); 
    }

    @Override
    public Convenio read(int id) {
      return convenioRepository.findById(id).get(); 
    }

    @Override
    public List<Convenio> readAll() {
        return convenioRepository.findAll(); 
    }

}
