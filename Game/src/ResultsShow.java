import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ResultsShow extends JPanel{
    private HashMap<String, Integer> results = new HashMap<>();
    private HashMap<String, Integer> printResults = new HashMap<>();
    private JLabel renderer = new JLabel("555");
    private CellRendererPane crp = new CellRendererPane();

    public ResultsShow(){
        collectResults();
        showResults();
    }
    public void collectResults(){
        String name= JOptionPane.showInputDialog("You have " + Board.pointShow() + " points. \n Please insert your name: ");
        try(BufferedReader fileReader = new BufferedReader(new FileReader("Game/Files/results.txt"))){
            while (true){
                String line = fileReader.readLine();
                if (line == null) {
                    break;
                }
                String[] words = line.split(" ");
                results.put(words[0], Integer.parseInt(words[1]));
            }
        }catch (IOException ex){
        }
        System.out.println();
        results.entrySet().stream().sorted((x, y) -> x.getValue().compareTo(y.getValue()));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Game/Files/results.txt"))) {
            for(Map.Entry<String, Integer> entry : results.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                writer.write(key + " " + value);
                writer.newLine();
            }
        }catch (IOException ex){
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
