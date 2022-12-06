package ServiceEtude;

import java.sql.SQLException;

public interface IUniversiteRepository {
    public Universite GetById(int universityId) throws SQLException ;
}