package projetoteste.apispringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import projetoteste.apispringboot.dto.VendaDTO;
import projetoteste.apispringboot.services.VendaService;

@Controller
@RequestMapping(value = "/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody VendaDTO vendaDTO){
            VendaDTO objDTO = vendaService.saveDTO(vendaDTO);
            return ResponseEntity.ok().body(objDTO);
    }
}
