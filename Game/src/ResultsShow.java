import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultsShow extends JPanel{
    private static Map<String, Integer> results = new HashMap<String, Integer>() {};
    private static Map<String, Integer> sortedMap;
    private static JButton startButton = new JButton("Start new game");
    private static JButton quitButton = new JButton("Exit");

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

        sortedMap =
                results.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
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
        resultWin.setLocationRelativeTo(null);

        resultWin.setVisible(true);
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        resultWin.setSize(300, 400);

        int i = 0;
        for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            i = i + 1;
            String key = entry.getKey();
            Integer value = entry.getValue();
            builder.append( i + ": " +key.toUpperCase() + " - " + value + " points<br>");
            if (i == 10){
                break;
            }
        }
        builder.append("</html>");
        JLabel label = new JLabel(builder.toString(), SwingConstants.CENTER);
        panel.add(startButton);
        panel.add(quitButton);
        panel.add(label);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Breakout game = new Breakout();
                        game.setVisible(true);
                        resultWin.setVisible(false);
                    }
                });
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
