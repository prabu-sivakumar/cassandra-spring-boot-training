package training.cassandra.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import training.cassandra.entity.Chevron;
import training.cassandra.entity.ChevronPrimaryKey;

import java.util.List;

@Repository
public interface ChevronRepository extends CassandraRepository<Chevron, ChevronPrimaryKey> {

    List<Chevron> findByKeyArea(String area);
}
