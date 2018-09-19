package model;


import lombok.Data;

@Data
public class Institution {
    private Long cnpj;
    private String name;
    private String logo;
    private String site;
}
