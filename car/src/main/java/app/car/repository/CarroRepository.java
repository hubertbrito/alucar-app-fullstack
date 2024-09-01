package app.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.car.entity.Carro;
import app.car.entity.Marca;

public interface CarroRepository extends JpaRepository<Carro, Long> {
	
	public List<Carro> findByNome (String nome);
	
	public List<Carro> findByMarca (Marca marca);
	
	@Query("FROM Carro c WHERE c.ano > :ano")
	public List<Carro> findByAcimaAno (int ano);

}
