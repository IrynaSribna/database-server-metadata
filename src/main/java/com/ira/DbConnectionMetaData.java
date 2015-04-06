package com.ira;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Iryna on 4/5/15.
 */
public class DbConnectionMetaData {

    public static void main(String[] args) {
        try ( Connection connection = DbConnector.connectToDb()) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("Database is: " + metaData.getDatabaseProductName() + " " +
                    metaData.getDatabaseProductVersion());
            ResultSet catalogs = metaData.getCatalogs();

            printHeader();
            int count = 1;
            while (catalogs.next()) {
                String catalogName = catalogs.getString(1);
                System.out.println(count + ") " + catalogName);
                count++;
                getTables(metaData, catalogName);

            }
            printFooter();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printFooter() {
        System.out.println("==============================================================");
    }

    private static void printHeader() {
        System.out.println("==============================================================");
        System.out.println("\t\t\tCatalogs and their tables:");
        System.out.println("==============================================================");
    }

    private static void getTables(DatabaseMetaData metaData, String catalogName) throws SQLException {
        ResultSet tables = metaData.getTables(
                catalogName, null, null, null );

        while(tables.next()) {
            String tableName = tables.getString(3);
            System.out.println("-- " + tableName);
        }
    }
}
