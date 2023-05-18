package projetoteste.apispringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import projetoteste.apispringboot.controllers.util.URLConverter;
import projetoteste.apispringboot.dto.VendedorDTO;
import projetoteste.apispringboot.services.VendedorService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> obterVendasPorPeriodo(@RequestParam(name = "minDate") String dataInicio, @RequestParam(name = "maxDate") String dataFinal){

        LocalDate min =  URLConverter.converterData(dataInicio);
        LocalDate max = URLConverter.converterData(dataFinal);

        List<VendedorDTO> listaDTO = vendedorService.obterVendasPorPeriodo(min, max);
        return ResponseEntity.ok().body(listaDTO);
    }
}
