package JdbcCrud.service;

import JdbcCrud.domain.Producer;
import JdbcCrud.repository.ProducerRepository;

public class ProducerService {

    public static void save(Producer producer){
        ProducerRepository.save(producer);
    }

    public static void delete(Integer id){
        ProducerRepository.delete(id);
    }

    public static void update(Producer producer){
        ProducerRepository.update(producer);
    }

    public static void findAll(){
        ProducerRepository.findAll();
    }

    public static void findById(Integer id){
        ProducerRepository.findById(id);
    }
}
