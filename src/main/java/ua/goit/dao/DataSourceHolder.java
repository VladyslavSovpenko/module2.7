package ua.goit.dao;

import org.postgresql.ds.PGSimpleDataSource;
import ua.goit.config.AppProperties;

import javax.sql.DataSource;
import java.util.Properties;

public class DataSourceHolder {

    private static DataSourceHolder value;
    private final DataSource dataSource;

    private DataSourceHolder() {
        Properties prop = AppProperties.getProperties();
        switch (prop.getProperty("db.type")){
            case "postgres": initPG(prop);
        }
        PGSimpleDataSource dataSource = initPG(prop);
        this.dataSource = dataSource;

    }

    private PGSimpleDataSource initPG(Properties prop) {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerNames(new String[]{prop.getProperty("db.host")});
        dataSource.setPortNumbers(new int[]{Integer.parseInt(prop.getProperty("db.port"))});
        dataSource.setDatabaseName(prop.getProperty("db.databaseName"));
        dataSource.setUser(prop.getProperty("db.username"));
        dataSource.setPassword(prop.getProperty("db.password"));
        return dataSource;
    }

    public static DataSource getDataSource() {
        if (value == null) {
            value = new DataSourceHolder();
        }
        return value.dataSource;
    }
}

