package projetoteste.apispringboot.dto;

public class VendedorDTO {

    private String nome;

    private Integer totalDeVendas;

    private Double mediaVendasDia;

    public VendedorDTO(String nome, Integer totalVendas, Double mediaVendasDia) {
        this.nome = nome;
        this.totalDeVendas = totalVendas;
        this.mediaVendasDia = mediaVendasDia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTotalDeVendas() {
        return totalDeVendas;
    }

    public void setTotalDeVendas(Integer totalDeVendas) {
        this.totalDeVendas = totalDeVendas;
    }

    public Double getMediaVendasDia() {
        return mediaVendasDia;
    }

    public void setMediaVendasDia(Double mediaVendasDia) {
        this.mediaVendasDia = mediaVendasDia;
    }
}