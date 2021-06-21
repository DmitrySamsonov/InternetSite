package good.team.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeJdbcDao implements EmployeeDao {

    @Override
    public void deleteEmployeeById(int id) {
        try (Connection connection = new JdbcUtil().getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM `ppVLywhE9a`.`employee` WHERE (`id` = '" + id + "');";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
