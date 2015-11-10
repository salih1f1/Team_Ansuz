import javax.swing.*;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ResultsShow extends JPanel{
    private static TreeMap<String, Integer> results = new TreeMap<>();
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

        results.put(name, Board.pointShow());

        Map<String, Integer> sortedMap =
                results.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Game/Files/results.txt"))) {
            for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
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
        int x = 0;
        int y = 0;
        for(Map.Entry<String, Integer> entry : results.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            text.setText(key + " " + value);
            panel.add(text);
        }


    }
}
