package com.pruebaDefinitiva;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrosApiController {

    private final JdbcTemplate jdbcTemplate;

    public RegistrosApiController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/registros")
    public List<Map<String, Object>> listarRegistros() {
        return jdbcTemplate.queryForList(
        "SELECT nombre, apellido, email, telefono, direccion FROM registros ORDER BY id"
        );
    }
}