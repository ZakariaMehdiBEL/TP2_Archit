package ServiceEtude;

import java.sql.SQLException;

public interface IEtudiantRepository {
    public abstract boolean Exists(int mat) throws SQLException;

    public abstract boolean Exists(String email) throws SQLException;

    public abstract void add(Etudiant E) throws SQLException;
    
    public boolean correctMailAndMat(Etudiant etud) throws SQLException;
}