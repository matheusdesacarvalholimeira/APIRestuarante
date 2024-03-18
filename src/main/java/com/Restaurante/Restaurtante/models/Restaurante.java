package com.Restaurante.Restaurtante.models;
import com.Restaurante.Restaurtante.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "restaurante")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante extends RepresentationModel<Restaurante> implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idResturante;
    private String nome;
    private int CNPJ;
    private Endereco endereco;
    private int contato;
    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<Cardapio> cardapios;




}
