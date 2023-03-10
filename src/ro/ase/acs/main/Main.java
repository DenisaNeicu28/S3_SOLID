package ro.ase.acs.main;

import ro.ase.acs.classes.DataInserter;
import ro.ase.acs.classes.DataReader;
import ro.ase.acs.classes.TableCreator;
import ro.ase.acs.interfaces.Creator;
import ro.ase.acs.interfaces.Inserter;
import ro.ase.acs.interfaces.Reader;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            Creator creator = new TableCreator();
            creator.createTable(connection);

            Inserter inserter = new DataInserter();
            inserter.insertData(connection);

            Reader reader = new DataReader();
            reader.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}