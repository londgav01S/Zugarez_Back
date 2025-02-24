package co.edu.uniquindio.zugarez.Repositories;

import co.edu.uniquindio.zugarez.Model.Zugarez;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZugarezRepository extends MongoRepository<Zugarez,String> {
}
