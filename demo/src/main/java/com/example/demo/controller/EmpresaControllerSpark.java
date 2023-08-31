package com.example.demo.controller;

import com.example.demo.Utils.JsonTransformer;
import com.example.demo.Utils.JsonUtils;
import com.example.demo.persistence.entity.Empresa;
import com.example.demo.service.ServiceEmpresa;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import spark.Route;

import java.util.List;
import java.util.Set;

import static spark.Spark.*;

public class EmpresaControllerSpark {

    private final ServiceEmpresa serviceEmpresa;


    public EmpresaControllerSpark(ServiceEmpresa serviceEmpresa) {
        this.serviceEmpresa = serviceEmpresa;


        get("/empresa", (req, res) -> serviceEmpresa.getEmpresa(), new JsonTransformer());

        post("/crearEmpresa", (req, res) -> {
            Empresa empresa = JsonUtils.fromJson(req.body(), Empresa.class);
            return serviceEmpresa.createEmpresa(empresa);
        }, new JsonTransformer());

        put("/putEmpresa/:id", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            Empresa empresa = JsonUtils.fromJson(req.body(), Empresa.class);
            empresa.setId(id);
            return serviceEmpresa.updateEmpresa(id, empresa);
        }, new JsonTransformer());

        delete("/delete/:id", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            serviceEmpresa.deleteEmpresa(id);
            return "Empresa Eliminada";
        }, new JsonTransformer());
    }

    /*private static void configureSwagger() {
        OpenApiResource openApiResource = new OpenApiResource();

        // Ruta para acceder a la documentación de Swagger UI
        get("/swagger-ui/*", (Route) openApiResource);

        // Escanear clases para generar la documentación
        SwaggerConfiguration oasConfig = new SwaggerConfiguration()
                .prettyPrint(true)
                .resourcePackages((Set<String>) List.of("com.example.demo"));

        new JaxrsOpenApiContextBuilder<>()
                .openApiConfiguration(oasConfig)
                .applicationPath("/api-docs")
                .buildContext(true);

    }*/

}
