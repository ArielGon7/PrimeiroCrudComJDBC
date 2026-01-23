package JdbcCrud.repository;

import JdbcCrud.conn.ConnectionFactory;
import JdbcCrud.domain.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            log.error("Error while saving producer");
            throw new RuntimeException(e);
        }
    }

    public static void delete(Integer id){
        String sql = "DELETE FROM livro_store.new_table WHERE (id = ? )";
        try(Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
        ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            log.info("Deleting producer from id '{}', rows affected '{}' ", id, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while deleting producer");
            throw new RuntimeException(e);
        }
    }

    public static void update(Producer producer){
        String sql = "UPDATE livro_store.new_table SET name = ? WHERE (id = ? );";
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, producer.getName());
            ps.setInt(2, producer.getId());
            int rowsAffected = ps.executeUpdate();
            log.info("Updating producer '{}', rows affected '{}' ", producer, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while updating producer");
            throw new RuntimeException(e);
        }
    }

    public static List<Producer> findAll(){
        String sql = "SELECT * FROM livro_store.new_table";
        List<Producer> producers = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {
            while(rs.next()){
                Producer producer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
            log.info("Finding all producer");
        } catch (SQLException e) {
            log.error("Error while finding all producer");
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static Optional<Producer> findById(Integer id){
        String sql = "SELECT * FROM livro_store.new_table WHERE id = ?;";
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    Producer producer = Producer.builder()
                            .id(rs.getInt("id"))
                            .name(rs.getString("name"))
                            .build();
                    return Optional.of(producer);
                }
            }
            log.info("Finding producer by id");
        } catch (SQLException e) {
            log.error("Error while finding by id the producer");
            throw new RuntimeException(e);
        }
        return Optional.empty();

    }
}
