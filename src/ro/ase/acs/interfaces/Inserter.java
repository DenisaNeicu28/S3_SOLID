package ro.ase.acs.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface Inserter {
    void insertData(Connection connection) throws SQLException;
}
