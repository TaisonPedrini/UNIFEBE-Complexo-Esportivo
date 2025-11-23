package com.complexo.UNIFEBE_Complexo_Esportivo.controller;

import com.complexo.UNIFEBE_Complexo_Esportivo.dao.Agendamentos;
import com.complexo.UNIFEBE_Complexo_Esportivo.dao.AgendamentosDAOImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentosController {
    private final AgendamentosDAOImpl dao = new AgendamentosDAOImpl();

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Agendamentos a) {
        int res = dao.inserirAgendamento(a);
        return res>0 ? ResponseEntity.ok("OK") : ResponseEntity.status(500).body("Erro");
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<String> cancelar(@PathVariable int id) {
        Agendamentos a = new Agendamentos();
        a.setID_AGENDAMENTOS(id);
        int res = dao.cancelarAgendamento(a);
        return res>0 ? ResponseEntity.ok("OK") : ResponseEntity.status(404).body("Não encontrado/erro");
    }

    @GetMapping("/usuario/{id}")
    public ArrayList<Agendamentos> porUsuario(@PathVariable int id) { return dao.consultarAgendamentosUsuario(id); }

    @GetMapping("/usuario/{id}/futuros")
    public ArrayList<Agendamentos> porUsuarioFuturos(@PathVariable int id) { return dao.consultarAgendamentosUsuarioFuturo(id); }

    @GetMapping("/ambiente/{id}")
    public ArrayList<Agendamentos> porAmbiente(@PathVariable int id) { return dao.consultarAgendamentosAmbiente(id); }

    @GetMapping("/ambiente/{id}/futuros")
    public ArrayList<Agendamentos> porAmbienteFuturos(@PathVariable int id) { return dao.consultarAgendamentosAmbienteFuturos(id); }

}
