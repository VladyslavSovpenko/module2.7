//package ua;
//
//
//import java.sql.*;
//
//public class DbHelper {
//
//    public static int executeWithPreparedStatement(String sql, ParameterSetter psCall) throws SQLException {
//        Connection connection = DataSourceHolder.getDataSource().getConnection();
//                try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            psCall.set(ps);
//            int i = ps.executeUpdate();
//           return i;
//        }
//    }
//
//    public static ResultSet getWithPreparedStatement(String sql, ParameterSetter psCall) throws SQLException {
//        Connection connection = DataSourceHolder.getDataSource().getConnection();
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            psCall.set(ps);
//            return ps.executeQuery();
//        }
//    }
//
//    @FunctionalInterface
//    public interface ParameterSetter {
//        void set(PreparedStatement ps) throws SQLException;
//    }
//}
