package JdbcCrud.service;

import JdbcCrud.domain.Producer;
import JdbcCrud.repository.ProducerRepository;

public class ProducerService {

    public static void save(Producer producer){
        ProducerRepository.save(producer);
    }
}
