package com.example.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.persistence.entity.Empresa;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEmpresaRepository extends JpaRepository<Empresa, Long> {

    @Modifying
    @Query(value = "UPDATE empresa_db.empresa SET empresa =:empresa\n" +
            "WHERE id =:id", nativeQuery = true)
    public Empresa updateEmpresaQuery(@Param("id") Long id, @Param("empresa") Empresa empresa);
}
