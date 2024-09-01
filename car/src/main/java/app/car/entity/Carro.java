package app.car.entity;


import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carro {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String modelo;
	private int ano;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("carros")
	private Marca marca;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "carro_proprietario")
	private List<Proprietario> proprietarios;
	
	
}
