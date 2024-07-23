import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class display {

    //ppl keep saying static vars are bad and i mean thats probably true because of something something nerd stuff idk about but um im bad at coding sorry
    public static void main(String[] args) {
        //changes l&f to windows classic because im a basic bitch like that
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            //error handler for l&f in case something doesnt work
            System.out.println("error with look and feel");
        }


        // create main window
        JFrame frame = new JFrame("bloons td chimp calc");
        frame.setSize(350, 700);
        frame.setResizable(false);

        //window that adds the monkeys ----------
        //this shit has so many vars i never wanna see the word monkey again

        //create frame (the window)
        JFrame monkeyFrame = new JFrame("add monkeys");
        monkeyFrame.setSize(350, 500);
        monkeyFrame.setResizable(false);


        //main  panel to hold shit (in the monkey window)
        JPanel monkeyPanel = new JPanel();
        monkeyPanel.setLayout(null);
        monkeyPanel.setBounds(0, 0, 350, 700);
        monkeyFrame.add(monkeyPanel);

        addMonkeysPanel(monkeyPanel);
        monkeyFrame.setVisible(false);

        //out of the monkey zone -------------

        //main displayPanel to hold components
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(null);
        displayPanel.setBounds(0, 0, 350, 700);
        frame.add(displayPanel);

        //calls function to add shit to the panel
        panelAdd(displayPanel, monkeyFrame);
        frame.setVisible(true);
    }

    public static void panelAdd(JPanel panel, JFrame monkeyFrame){

        database db = new database();
        calc calc = new calc();
        //---

        //LABELS

        //---

        //label to indicate round
        JLabel roundLabel = new JLabel("Round:");
        roundLabel.setBounds(25,25,50,25);
        panel.add(roundLabel);

        //label to indicate cash remaining
        JLabel cashLabel = new JLabel("Cash Remaining:");
        cashLabel.setBounds(125,25,150,25);
        panel.add(cashLabel);

        //---

        //BUTTONS

        //---

        //add monkeys button
        JButton monkeyButton = new JButton("Add Monkeys...");
        monkeyButton.setBounds(125, 75, 100, 25);
        panel.add(monkeyButton);

        JButton run = new JButton("Run");
        run.setBounds(125, 100, 100, 25);
        panel.add(run);

        //---

        //TEXT AREAS

        //---

        //add remaining cash button
        JTextField cashInput = new JTextField();
        cashInput.setBounds(200, 25, 100, 25);
        panel.add(cashInput);

        //---

        //DROPDOWNS

        ///---

        //indicate current round input
        JComboBox<String> roundInput = new JComboBox<>(db.rounds);
        roundInput.setBounds(60, 25, 50, 25);
        panel.add(roundInput);

        //---

        //BUTTON ACTIONS

        //---

        //open new money menu (add monkeys button)
        monkeyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                monkeyFrame.setVisible(true);
            }
        });

            run.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int cash = Integer.valueOf(cashInput.getText());
                    calc.roundCost((String)roundInput.getSelectedItem(), cash);
                }
        });
    }
    public static void addMonkeysPanel(JPanel panel){

        database db = new database();
        String[] path = {"0","1","2","3","4","5"};


        //label to indicate top
        JLabel topLabel = new JLabel("Top:");
        topLabel.setBounds(25,50,50,25);
        panel.add(topLabel);

        //label to indicate middle
        JLabel middleLabel = new JLabel("Middle:");
        middleLabel.setBounds(25,75,50,25);
        panel.add(middleLabel);

        //label to indicate bottom
        JLabel bottomLabel = new JLabel("Bottom:");
        bottomLabel.setBounds(25,100,50,25);
        panel.add(bottomLabel);

        //label to indicate tower
        JLabel towerLabel = new JLabel("Tower:");
        towerLabel.setBounds(25,25,50,25);
        panel.add(towerLabel);

        //dropdowns

        JComboBox<String> topInput = new JComboBox<>(path);
        topInput.setBounds(60, 50, 50, 25);
        panel.add(topInput);

        JComboBox<String> middleInput = new JComboBox<>(path);
        middleInput.setBounds(60, 75, 50, 25);
        panel.add(middleInput);

        JComboBox<String> bottomInput = new JComboBox<>(path);
        bottomInput.setBounds(60, 100, 50, 25);
        panel.add(bottomInput);

        JComboBox<String> towerInput = new JComboBox<>(db.towers);
        towerInput.setBounds(60, 25, 150, 25);
        panel.add(towerInput);

        //button to close
        JButton close = new JButton("close");
        close.setBounds(25, 135, 70, 25);
        panel.add(close);

        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //ohly shit
                calc.monkeyCost(Integer.valueOf((String)topInput.getSelectedItem()), Integer.valueOf((String)middleInput.getSelectedItem()), Integer.valueOf((String)bottomInput.getSelectedItem()), (int)towerInput.getSelectedIndex());
            }
        });
    }
}
