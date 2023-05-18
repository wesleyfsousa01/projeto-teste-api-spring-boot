package projetoteste.apispringboot.data;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import projetoteste.apispringboot.entities.ItemVenda;
import projetoteste.apispringboot.entities.Produto;
import projetoteste.apispringboot.entities.Venda;
import projetoteste.apispringboot.entities.Vendedor;
import projetoteste.apispringboot.service.ItemVendaService;
import projetoteste.apispringboot.service.ProdutoService;
import projetoteste.apispringboot.service.VendaService;
import projetoteste.apispringboot.service.VendedorService;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class InstanciaBanco implements CommandLineRunner {

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ItemVendaService itemVendaService;

    @Override
    public void run(String... args) throws Exception {

        Produto p1 = new Produto("Mouse",89d);
        Produto p2 = new Produto("teclado",129d);
        Produto p3 = new Produto("HeadSet",368d);
        Produto p4 = new Produto("Memória-RAM",299d);
        Produto p5 = new Produto("Processador",1260d);
        Produto p6 = new Produto("Placa-Mãe",729d);
        Produto p7 = new Produto("Monitor",1999d);
        Produto p8 = new Produto("Placa de video",2699d);
        Produto p9 = new Produto("SSD 1TB",499d);

        List<Produto> listaDeProdutos = Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9);
        produtoService.saveAll(listaDeProdutos);

        Vendedor vendedor1 = new Vendedor("Pedro","222.333.444-55","pedro@gmail.com");
        Vendedor vendedor2 = new Vendedor("Jose","222.333.777-88","jose@gmail.com");
        Vendedor vendedor3 = new Vendedor("Maria","222.333.111-00","maria@gmail.com");

        List<Vendedor> listaDeVendedores = Arrays.asList(vendedor1,vendedor2,vendedor3);
        vendedorService.saveAll(listaDeVendedores);

        //Gerador de dados
        DataFactory df = new DataFactory();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date minDate = simpleDateFormat.parse("2023-05-01");
        Date maxDate = simpleDateFormat.parse("2023-05-31");

        List<Venda> listaDeVendas = new ArrayList<>();
        List<ItemVenda> listaDeItens = new ArrayList<>();

        //Gerando vendas aleatórias
        for (int i=0; i<= 10; i++){

            var itemAleatorio = (Math.random() * listaDeVendedores.size());

            int index = (int) itemAleatorio;
            Date intervalo = df.getDateBetween(minDate,maxDate);
            LocalDateTime localDateTime = intervalo.toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime();
            listaDeVendas.add(new Venda( localDateTime,listaDeVendedores.get(index)));

        }

        //inserindo Vendas geradas
        vendaService.saveAll(listaDeVendas);

        //Gerando Itens e relacionando-os ás vendas geradas
        for (int i=0; i<= 10; i++){
            //Seleciona uma, dentre as vendas, a cada iteração:
            int index = (int) (Math.random() * listaDeVendas.size());
            Venda venda = listaDeVendas.get(index);

            //Seleciona um, dentre os produtos, a cada iteração:
            int index2 = (int) (Math.random() * listaDeProdutos.size());
            Produto produto = listaDeProdutos.get(index2);

            //Adiciona a lista de itens cada item, gerado aleatóriamente:
            listaDeItens.add(new ItemVenda(venda, produto, df.getNumberBetween(1,5), produto.getPreco()));
        }
        //salvando itens gerados
        itemVendaService.saveAll(listaDeItens);

    }


}
