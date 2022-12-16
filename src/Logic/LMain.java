/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Presentation.FrmLogin;
import Presentation.MDIPrincipal;
import java.sql.Connection;
import javax.swing.JFrame;

/**
 *
 * @author FeedzOne
 */
public class LMain {
    public static void main(String[] args) {
        Connection cn = LConnection.getConnection();
        /*MDIPrincipal miPrincipal = new MDIPrincipal();
        miPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        miPrincipal.setVisible(true);*/
        FrmLogin myLogin = new FrmLogin();
        myLogin.setLocationRelativeTo(null);
        myLogin.setVisible(true);
    }
}
