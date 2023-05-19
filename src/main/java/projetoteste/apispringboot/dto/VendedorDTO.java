package projetoteste.apispringboot.dto;

public class VendedorDTO {

    private String nome;

    private Integer totalDeVendas;

    private String mediaVendasDia;

    public VendedorDTO(String nome, Integer totalVendas, String mediaVendasDia) {
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

    public String getMediaVendasDia() {
        return mediaVendasDia;
    }

    public void setMediaVendasDia(String mediaVendasDia) {
        this.mediaVendasDia = mediaVendasDia;
    }
}