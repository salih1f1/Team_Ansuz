import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultsShow extends JPanel{
    private HashMap<String, List<Integer>> results = new HashMap<>();
    private JLabel renderer = new JLabel("555");
    private CellRendererPane crp = new CellRendererPane();

    public ResultsShow(){
        collectResults();
        showResults();
    }
    public void collectResults(){
        String name= JOptionPane.showInputDialog("You have " + Board.pointShow() + " points. \n Please insert your name: ");
        if (results.containsKey(name)) {
            List<Integer> list = results.get(name);
            list.add(Board.pointShow());
            results.put(name, list);
        }else {
            ArrayList<Integer> resultList = new ArrayList<>();
            resultList.add(Board.pointShow());
            results.put(name, resultList);
        }

        try(BufferedWriter writer = new BufferedWriter( new FileWriter("Game/Files/results.txt")))
        {
            writer.write(name + " " + Board.pointShow());
        }
        catch ( IOException e)
        {
        }

    }
    public static void showResults(){
        JFrame resultWin = new JFrame("Results");
        JPanel panel = new JPanel();
        resultWin.getContentPane().add(panel);
        resultWin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        resultWin.setResizable(true);
        resultWin.setVisible(true);
        resultWin.setBounds(0,0,200,400);

        JLabel text = new JLabel();


    }
}
