package app.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.car.entity.Carro;
import app.car.entity.Marca;
import app.car.entity.Proprietario;
import app.car.repository.CarroRepository;
import app.car.repository.MarcaRepository;
import app.car.repository.ProprietarioRepository;
import jakarta.transaction.Transactional;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
    private MarcaRepository marcaRepository;
	
	@Autowired
    private ProprietarioRepository proprietarioRepository;


	
	 public String save(Carro carro) {
	        Marca existingMarca = marcaRepository.findByNome(carro.getMarca().getNome());
	        if (existingMarca != null) {
	            carro.setMarca(existingMarca);
	        } else {
	            marcaRepository.save(carro.getMarca());
	        }
	        
	        
	        List<Proprietario> proprietarios = carro.getProprietarios();
	        for (int i = 0; i < proprietarios.size(); i++) {
	            Proprietario existingProprietario = proprietarioRepository.findByNome(proprietarios.get(i).getNome());
	            if (existingProprietario != null) {
	                proprietarios.set(i, existingProprietario);
	            } else {
	                proprietarioRepository.save(proprietarios.get(i));
	            }
	        }
	        
	        
	        carroRepository.save(carro);
	        return "Carro salvo com sucesso!";
	    }
	
	
	 @Transactional
	    public String update(Carro carro, long id) {
	        carro.setId(id);

	        Marca existingMarca = marcaRepository.findByNome(carro.getMarca().getNome());
	        if (existingMarca != null) {
	            carro.setMarca(existingMarca);
	        } else {
	            marcaRepository.save(carro.getMarca());
	        }

	        List<Proprietario> proprietarios = carro.getProprietarios();
	        for (int i = 0; i < proprietarios.size(); i++) {
	            Proprietario existingProprietario = proprietarioRepository.findByNome(proprietarios.get(i).getNome());
	            if (existingProprietario != null) {
	                proprietarios.set(i, existingProprietario);
	            } else {
	                proprietarioRepository.save(proprietarios.get(i));
	            }
	        }

	        carroRepository.save(carro);
	        return "Registro alterado com sucesso!";
	    }
	
	public String delete(long id) {
		
		
		this.carroRepository.deleteById(id);
		
		return "Carro deletado com sucesso!";
	}
	
	
	public List<Carro> findAll(){
		
		List<Carro> lista = this.carroRepository.findAll();
		return lista;
	}
	
	
	public Carro findById(long id) {
		
	    Carro carro = this.carroRepository.findById(id).get();
		
		return carro;
		
	}
	
	public List<Carro> findByNome(String nome){
		
		return this.carroRepository.findByNome(nome);
	}
	
	
	public List<Carro> findByMarca(long id){
		Marca marca = new Marca();
		marca.setId(id);
		return this.carroRepository.findByMarca(marca);
	}
	
	
	public List<Carro> findByAcimaAno(int ano){
		
		return this.carroRepository.findByAcimaAno(ano);
	}
	
	
}












