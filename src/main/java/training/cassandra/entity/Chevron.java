package training.cassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "Chevrons")
public class Chevron {

    @PrimaryKey
    private ChevronPrimaryKey key;

    @Column("name")
    @CassandraType(type = Name.TEXT)
    private String name;

    @Column("picture")
    @CassandraType(type = Name.TEXT)
    private String picture;
}
