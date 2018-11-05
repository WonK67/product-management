package br.com.dificuldadezero.management.dto;

import br.com.dificuldadezero.management.enums.ChangeType;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Log {

    public long getId_log() {
        return id_log;
    }

    public void setId_log(long id_log) {
        this.id_log = id_log;
    }

    public ChangeType getType_log() {
        return type_log;
    }

    public void setType_log(ChangeType type_log) {
        this.type_log = type_log;
    }

    public String getCategoria_log() {
        return categoria_log;
    }

    public void setCategoria_log(String categoria_log) {
        this.categoria_log = categoria_log;
    }

    public List<String> getTags_log() {
        return tags_log;
    }

    public void setTags_log(List<String> tags_log) {
        this.tags_log = tags_log;
    }

    public long getId_produto() {
        return id_produto;
    }

    public void setId_produto(long id_produto) {
        this.id_produto = id_produto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    @Id
    @GeneratedValue
    private long id_log;
    @Enumerated(EnumType.STRING)
    private ChangeType type_log;
    private String categoria_log;
    @ElementCollection
    @CollectionTable(name="log_tags")
    @Column(name="tag")
    private List<String> tags_log;
    private long id_produto;
    private double preco;
}
