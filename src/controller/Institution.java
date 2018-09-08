package controller;

public class Institution {
    private Long cnpj;
    private String name;
    private String logo;
    private String site;

    public Institution(Long cnpj, String name, String logo, String site) {
        this.cnpj = cnpj;
        this.name = name;
        this.logo = logo;
        this.site = site;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
