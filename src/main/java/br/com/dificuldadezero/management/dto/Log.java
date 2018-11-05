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
    @Id
    @GeneratedValue
    private long id_log;
    @Enumerated(EnumType.STRING)
    private ChangeType type_log;
    private String versao_log;
    private String categoria_log;
    @ElementCollection
    @CollectionTable(name="log_tags")
    @Column(name="tag")
    private List<String> tags_log;
    private long id_produto;
    private double preco;
}
