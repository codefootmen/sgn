package dao;

import model.HonorificsEnum;
import model.StatusEnum;
import utils.Capitalize;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class Query {

    private static List<String> types = Arrays.asList(
            "string",
            "long",
            "integer",
            "double",
            "byte",
            "short",
            "character",
            "boolean",
            "float"
    );

    public static String getSQLValuesString(Field[] fields) {
        String sql = "";
        for (Field field : fields) {
            if (Query.types.contains(field.getType().getSimpleName().toLowerCase())) {
                sql += " " + Capitalize.toSneakCase(field.getName()) + " = ?,";
            } else if (field.getType().isEnum()) {
                sql += " " + Capitalize.toSneakCase(field.getName()) + " = ?,";
            } else {
                sql += " id_" + Capitalize.toSneakCase(field.getType().getSimpleName()) + " = ?,";
            }
        }
        return sql;
    }

    private static String getParentSQLValuesString(Object object) {
        String sql = "";
        if (object.getClass().getSuperclass().getSimpleName() != "Object") {
            sql += getSQLValuesString(object.getClass().getSuperclass().getDeclaredFields());
        }
        return sql;
    }

    public static String getInsertSQLString(Object object) {
        String sql = "INSERT INTO ";
        sql += Capitalize.toSneakCase(object.getClass().getSimpleName()) + " SET";

        sql += getParentSQLValuesString(object);

        sql += getSQLValuesString(object.getClass().getDeclaredFields());

        sql = sql.substring(0, sql.length() - 1);

        return sql;
    }

    public static String getUpdateSQLString(Object object) {
        String sql = "UPDATE ";
        sql += Capitalize.toSneakCase(object.getClass().getSimpleName()) + " SET";

        sql += getParentSQLValuesString(object);

        sql += getSQLValuesString(object.getClass().getDeclaredFields());

        String regex = "id_" + Capitalize.toSneakCase(object.getClass().getSimpleName()) + " = \\?, |,$";
        sql = sql.replaceAll(regex, "");
        sql += " WHERE " + regex.replaceAll("\\\\|,|\\||\\$", "").trim();

        return sql;
    }

    public static String getDeleteSQLString(Object object) {
        String sql = "DELETE FROM " +
                Capitalize.toCamelCase(object.getClass().getSimpleName()) +
                " WHERE id_" + Capitalize.toCamelCase(object.getClass().getSimpleName()) +
                " = ?";
        return sql;
    }

    public static String getSelectSQLString(Object object) {
        String sql = "SELECT * FROM " +
                Capitalize.toCamelCase(object.getClass().getSimpleName()) +
                " WHERE id_" +
                Capitalize.toCamelCase(object.getClass().getSimpleName()) +
                " = ?";

        return sql;
    }

    public static PreparedStatement getInsertStatement(Object object) {

        System.out.println(getInsertSQLString(object));

        PreparedStatement statement = null;
        /*
        try {
            statement = Database.getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, e);
        }

        //Parent
        if (object.getClass().getSuperclass().getSimpleName() != "Object") {
            Class<?> currentParentClass = null;
            try {
                currentParentClass = Class.forName("model." + object.getClass().getSuperclass().getSimpleName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Method[] parentMethods = currentParentClass.getMethods();
            for (Field field : parentFields) {
                for (Method method : parentMethods) {
                    if (method.getName().startsWith("get") && !method.getName().endsWith("Class")) {
                        try {
                            if (field.getName().toLowerCase().equals(method.getName().substring(3).toLowerCase())) {
                                if(!Query.types.contains(field.getType().getSimpleName().toLowerCase())){
                                    statement.setObject(Arrays.asList(parentFields).lastIndexOf(field) + 1, Long.valueOf(1));
                                }else {
                                    statement.setObject(Arrays.asList(parentFields).lastIndexOf(field) + 1, method.invoke(object));
                                    System.out.println(method.getName());
                                }
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }


        //Children
        Class<?> currentClass = null;
        try {
            currentClass = Class.forName("model." + object.getClass().getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method[] methods = currentClass.getMethods();
        for (Field field : fields) {
            for (Method method : methods) {
                if (method.getName().startsWith("get") && !method.getName().endsWith("Class")) {
                    try {
                        if (field.getName().toLowerCase().equals(method.getName().substring(3).toLowerCase())) {
                            if(!Query.types.contains(field.getType().getSimpleName().toLowerCase())){
                                statement.setObject(Arrays.asList(fields).lastIndexOf(field) + 1, Long.valueOf(1));
                            }else {
                                statement.setObject(Arrays.asList(fields).lastIndexOf(field) + 1, method.invoke(object));
                                System.out.println(method.getName());
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println(statement);*/
        return statement;
    }

    public static void setStatementValues(PreparedStatement statement, Object... values) throws SQLException {
        Integer i = 1;
        for (Object value : values) {
            statement.setObject(i, value);
            i++;
        }
    }
}
