package ua.config;

import org.flywaydb.core.Flyway;
import ua.dao.DataSourceHolder;

public class DbMigration {
    public static void migrate() {
        Flyway flyway = Flyway.configure().dataSource(DataSourceHolder.getDataSource()).load();
        flyway.migrate();
    }
}
