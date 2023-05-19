package projetoteste.apispringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoteste.apispringboot.services.util.URLConverter;
import projetoteste.apispringboot.dto.VendedorDTO;
import projetoteste.apispringboot.entities.Venda;
import projetoteste.apispringboot.entities.Vendedor;
import projetoteste.apispringboot.repositories.VendedorRepository;
import projetoteste.apispringboot.services.exceptions.ObjectNotFoundException;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public Vendedor findById(Long id){
        return vendedorRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public Vendedor save(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }

    public List<Vendedor> saveAll(List<Vendedor> listaDeVendedores){
        return vendedorRepository.saveAll(listaDeVendedores);
    }

    public List<VendedorDTO> obterVendasPorPeriodo(String minString, String maxString) {

        LocalDate min =  URLConverter.converterData(minString);
        LocalDate max = URLConverter.converterData(maxString);

        LocalDateTime minDate = min.atTime(LocalTime.MIN);
        LocalDateTime maxDate = max.atTime(LocalTime.MAX);

        var intervaloEmdias = Duration.between(minDate,maxDate).toDays();

        List<Vendedor> listaDeVendedores = vendedorRepository.findAll();
        List<VendedorDTO> listaDeVendedoresDto = new ArrayList<>();

        for (Vendedor vendedor : listaDeVendedores) {

            int totalDeVendas = 0;
            double soma = 0;

            for (Venda venda : vendedor.getListaDeVendas()) {
                if(venda.getData().isAfter(minDate) && venda.getData().isBefore(maxDate))
                    totalDeVendas++;
                    soma += venda.getTotal();
            }

            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            double mediaVendedor  = intervaloEmdias >0 ? soma/intervaloEmdias : soma;

            listaDeVendedoresDto.add(new VendedorDTO(vendedor.getNome(), totalDeVendas, decimalFormat.format(mediaVendedor)));
        }

        return listaDeVendedoresDto;
    }
}
