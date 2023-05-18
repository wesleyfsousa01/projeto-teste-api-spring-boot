package projetoteste.apispringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projetoteste.apispringboot.dto.VendedorDTO;
import projetoteste.apispringboot.entities.Vendedor;
import projetoteste.apispringboot.services.VendedorService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> obterVendasPorPeriodo(@RequestParam(name = "minDate") String minDateString,
                                                                   @RequestParam(name = "maxDate") String maxDateString)
    {
        List<VendedorDTO> listaDTO = vendedorService.obterVendasPorPeriodo(minDateString, maxDateString);
        return ResponseEntity.ok().body(listaDTO);
    }

    @PostMapping
    public ResponseEntity<Vendedor> save(@RequestBody Vendedor vendedor){
        vendedor = vendedorService.save(vendedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(vendedor.getId()).toUri();
        return ResponseEntity.created(uri).body(vendedor);
    }
}
