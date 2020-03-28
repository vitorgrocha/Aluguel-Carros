package trabprog2;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //Instanciar mainMenu
        mainMenu menuP = new mainMenu();
        menuP.print_main_menu();
    }    
}
