/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info202_project;

import dao.JdbiDaoFactory;
import dao.ProductDAO;
import gui.MainMenu;

/**
 *
 * @author benforde
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code ic void main(String[] args) {
        // TODOapplication logic here
        ProductDAO dao = JdbiDaoFactory.getProductDAO();
        MainMenu menu = new MainMenu(dao);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }
    
}
