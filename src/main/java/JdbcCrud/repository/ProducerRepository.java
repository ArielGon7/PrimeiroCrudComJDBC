package JdbcCrud.repository;

import JdbcCrud.conn.ConnectionFactory;
import JdbcCrud.domain.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class ProducerRepository {
    public static void save(Producer producer){
        String sql = "INSERT INTO livro_store.new_table (name) VALUES ( ? )";
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, producer.getName());
            int rowAffect = ps.executeUpdate();
            log.info("Save producer '{}', Rows Affected '{}'", ps, rowAffect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
