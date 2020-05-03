package br.com.fsrocha.fiisexplorer.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ContextConfiguration
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public abstract class DatabaseTest {

    @Inject
    ApplicationContext applicationContext;

    @Inject
    DataSource dataSource;

    @Before
    public void setUp() {
        try (Connection connection = dataSource.getConnection()) {
            runScript(connection, getClass().getSimpleName() + ".sql");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void runScript(Connection connection, String scriptFile) throws SQLException, IOException {
        InputStream scriptResource = ClassLoader.getSystemResourceAsStream("scripts/" + scriptFile);
        if (scriptResource != null) {
            try (InputStreamReader reader = new InputStreamReader(scriptResource, StandardCharsets.UTF_8)) {
                RunScript.execute(connection, reader);
            }
        }
    }

    private void clearTables() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        Set<String> tables = new HashSet<>();
        ResultSet resultSet = statement.executeQuery("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='PUBLIC'");

        while (resultSet.next()) {
            tables.add(resultSet.getString(1));
        }

        for (String table : tables) {
            statement.execute("DELETE FROM " + table);
        }
        connection.close();
    }
}
