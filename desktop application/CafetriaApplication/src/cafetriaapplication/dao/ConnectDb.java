/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafetriaapplication.dao;

import cafetriaapplication.models.CommandMessage;
import cafetriaapplication.models.Products;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amine gasa
 */
public class ConnectDb {
    
    private String user="amine";
    private String password="2610";
   private String  ip="192.168.1.200";
    
    
    private String url = "jdbc:mysql://" + ip + ":3306/cafeteria";
private Connection cnx;
    private Statement st, jt;
    private ResultSet rst;
    public void ConnexionIntoDataBase() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK");
            try {
                cnx = (Connection) DriverManager.getConnection(url, user, password);
                System.out.println("successful connexion");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDb.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, " erreur connexion activer le serveur ou verifier "
                        + "\nle configuration de  serveur");

            } finally {
                exit();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void AllProducts(JTable T, String sql) {
     
        try {
            ArrayList<Products> list = new ArrayList<Products>();
            st = (Statement) cnx.createStatement();
            // String sql = "select * from achat";
            rst = (ResultSet) st.executeQuery(sql);

            while (rst.next()) {
                

                Products prod = new Products(rst.getInt("id"), rst.getString("designation"),
                        rst.getFloat("price"),  rst.getString("description"));
                list.add(prod);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);

            Object row[] = new Object[4];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getId();
                row[1] = list.get(k).getDesignation();
                row[2] = list.get(k).getPrice();
                row[3] = list.get(k).getDescription();
                
                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDb.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
        
    }
    

    public void insertProd(String Designation,Float price,String Description) {

        try {
            st = (Statement) cnx.createStatement();
            String sql1 = "INSERT INTO `products`( `designation`, `price`, `description`) "
                    + "VALUES ('" + Designation+ "'," + "'" + price + "','" +Description + "') ";
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDb.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ereur operation");
            exit();
        }

    }
    

    public void UpdatProducts(String Designation,Float price,String Description,int id) {

        try {
            String sql = "Update products set designation ='" + Designation + "', price= '" + price + "'"
                    + ", description ='"+Description +"'"+"  where id = '"+id+"'";

            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

public void DeleteProd(int id) {
        String sql = "DELETE FROM products WHERE id=" + id;
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void DeleteCommands(int id) {
        String sql = "DELETE FROM commands WHERE id=" + id;
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void UpdatCommands(String state,int id) {

        try {
            String sql = "Update commands set state ='" + state + "'" 
                    +"  where id = '"+id+"'";

            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

public void AllCommands(JTable T, String sql) {
     
        try {
            ArrayList<CommandMessage> list = new ArrayList<CommandMessage>();
            st = (Statement) cnx.createStatement();
           
            rst = (ResultSet) st.executeQuery(sql);

            while (rst.next()) {
                

                CommandMessage command = new CommandMessage(rst.getInt("id"), rst.getString("command_msg"),
                        rst.getFloat("total_price"),  rst.getInt("n_table"),rst.getString("state"),
                rst.getString("date_cmd"));
                list.add(command);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);

            Object row[] = new Object[6];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getId();
                row[1] = list.get(k).getCommandMsg();
                row[2] = list.get(k).getTotal_price();
                row[3] = list.get(k).getTabble();
                row[4] = list.get(k).getState();
                row[5] = list.get(k).getDate();
                
                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDb.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
        
    }

}
