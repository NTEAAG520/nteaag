package util;


import annotation.Column;
import annotation.Table;

import java.lang.reflect.Field;

public class TableUtils {
    public static String getCreateTableSQL(Class<?> clazz) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table ");
        //【1】获取表名
        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.tableName();
        stringBuilder.append(tableName).append("(\n");
        Field[] fields = clazz.getDeclaredFields();
        String primaryKey = "";
        //【2】遍历所有字段
        for (int i = 0; i < fields.length; i++) {
            Column column = (Column) fields[i].getAnnotations()[0];
            String field = column.field();
            String type = column.type();
            boolean defaultNull = column.defaultNull();

            stringBuilder.append("\t" + field).append(" ").append(type).append(" ");
            if (defaultNull) {
                if (type.toUpperCase().equals("TIMESTAMP")) {
                    stringBuilder.append(",\n");
                } else {
                    if (i == fields.length - 1) {
                        stringBuilder.append("DEFAULT NULL\n");
                    } else {
                        stringBuilder.append("DEFAULT NULL,\n");
                    }

                }
            } else {
                if (i == fields.length - 1) {
                    stringBuilder.append("NOT NULL\n");
                } else {
                    stringBuilder.append("NOT NULL,\n");
                }
                if (column.primaryKey()) {
                    primaryKey = "PRIMARY KEY (" + field + ")";
                }
            }

        }
        if (StringUtils.isEmpity(primaryKey)) {
            stringBuilder.append("\t").append(primaryKey);
        }
        stringBuilder.append(") DEFAULT CHARSET=utf-8;");
        return stringBuilder.toString();
    }
}
