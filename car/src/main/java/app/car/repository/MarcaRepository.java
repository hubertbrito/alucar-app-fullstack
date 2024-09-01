package app.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.car.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    Marca findByNome(String nome);
}

