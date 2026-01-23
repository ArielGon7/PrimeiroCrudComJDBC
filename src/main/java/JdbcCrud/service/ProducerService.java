package JdbcCrud.service;

import JdbcCrud.domain.Producer;
import JdbcCrud.repository.ProducerRepository;

public class ProducerService {

    public static void save(Producer producer){
        ProducerRepository.save(producer);
    }

    public static void delete(Integer id){
        verifyId(id);
        ProducerRepository.delete(id);
    }

    public static void update(Producer producer){
        verifyId(producer.getId());
        ProducerRepository.update(producer);
    }

    public static void findAll(){
        ProducerRepository.findAll();
    }

    public static void findById(Integer id){
        verifyId(id);
        ProducerRepository.findById(id);
    }

    private static void verifyId(Integer id){
        if(id == null || id <= 0){
            throw new IllegalArgumentException("Id invalid, please verify if id exist");
        }
    }
}
