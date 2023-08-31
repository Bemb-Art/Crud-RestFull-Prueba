package com.example.demo.service;

import com.example.demo.Utils.Exceptions;
import com.example.demo.persistence.entity.Empresa;
import com.example.demo.persistence.repository.JpaEmpresaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEmpresa {

    private JpaEmpresaRepository empresaRepository;

    public List<Empresa> getEmpresa() {
        return this.empresaRepository.findAll();
    }

    public Empresa createEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Transactional
    public Empresa updateEmpresa(Long id, Empresa empresa){
        Optional<Empresa> optionalEmpresa = this.empresaRepository.findById(id);
        if (optionalEmpresa.isEmpty()) {
            throw new Exceptions("Room not found", HttpStatus.NOT_FOUND);
        }
        return  this.empresaRepository.updateEmpresaQuery(id, empresa);
    }

    public void deleteEmpresa (Long id) {
        empresaRepository.deleteById(id);
    }

}
