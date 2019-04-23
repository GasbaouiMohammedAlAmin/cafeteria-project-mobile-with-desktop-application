/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafetriaapplication.models;

/**
 *
 * @author amine gasa
 */
public class CommandMessage {
    int id;
    String commandMsg;
    double total_price;
    int tabble;
    String state;
    String date;

    public CommandMessage(int id, String commandMsg, double total_price, int table,String state, String date) {
        this.id = id;
        this.commandMsg = commandMsg;
        this.total_price = total_price;
        this.state = state;
        this.date = date;
        this.tabble=table;
    }

    public int getTabble() {
        return tabble;
    }

    public int getId() {
        return id;
    }

    public String getCommandMsg() {
        return commandMsg;
    }

    public double getTotal_price() {
        return total_price;
    }

    public String getState() {
        return state;
    }

    public String getDate() {
        return date;
    }
}
