
import javax.swing.*;

public class Window extends JFrame {

    public Window (){
        this.setResizable(false);
        this.setSize(600, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Home Work 2");
        WorkPlace workPlace = new WorkPlace();
        workPlace.setVisible(true);
        this.add(workPlace);

    }


    public void showWindow(){
        this.setVisible(true);
    }

}
