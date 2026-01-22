package JdbcCrud.test;

import JdbcCrud.domain.Producer;
import JdbcCrud.service.ProducerService;

public class ProducerTest {
    public static void main(String[] args) {
//        Producer kat = Producer.builder().name("Kat").build();
//        ProducerService.save(kat);
        ProducerService.delete(4);


    }
}
