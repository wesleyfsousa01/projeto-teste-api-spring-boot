package projetoteste.apispringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoteste.apispringboot.dto.VendedorDTO;
import projetoteste.apispringboot.entities.Venda;
import projetoteste.apispringboot.entities.Vendedor;
import projetoteste.apispringboot.repositories.VendedorRepository;
import projetoteste.apispringboot.services.exceptions.ObjectNotFoundException;

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

    public List<VendedorDTO> obterVendasPorPeriodo(LocalDate min, LocalDate max) {
        LocalDateTime minDate = min.atTime(LocalTime.MIN);
        LocalDateTime maxDate = max.atTime(LocalTime.MAX);

        Duration intervalo = Duration.between(minDate,maxDate);
        var intervaloEmDias = intervalo.toDays();

        List<Vendedor> listaVendedores = vendedorRepository.findAll();
        List<VendedorDTO> listaVendedoresDTO = new ArrayList<>();

        for (Vendedor vendedor : listaVendedores) {


            int totalDeVendas = 0;

            for (Venda venda : vendedor.getListaDeVendas()) {
                if(venda.getData().isAfter(minDate) && venda.getData().isBefore(maxDate))
                    totalDeVendas++;
            }

            listaVendedoresDTO.add(new VendedorDTO(vendedor.getNome(), totalDeVendas, vendedor.getTotalDeVendasNoPeriodo(minDate,maxDate)));
        }

        return listaVendedoresDTO;
    }

}
