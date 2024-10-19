import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPage extends JFrame {
    public ResultPage() {
        setTitle("Result Page");
        setSize(800, 600); // Initial size
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen

        // Load the background image
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\USER\\Downloads\\IMG-20240917-WA0004.jpg");
        Image originalImage = originalIcon.getImage();

        // Create a panel with custom painting for background
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(originalImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        JButton showResultButton = new JButton("Show Result");
       showResultButton.setFont(new Font("Serif", Font.BOLD, 30));
       showResultButton.setBackground(Color.LIGHT_GRAY);

       showResultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (VoteManager.isVotingFinished()) {
                    String results = VoteManager.getResults();

                    // Display results in a label
                    JLabel resultsLabel = new JLabel("<html>" + results.replace("\n", "<br>") + "</html>", SwingConstants.CENTER);
                    resultsLabel.setFont(new Font("Serif", Font.BOLD, 24));
                    resultsLabel.setForeground(Color.BLACK); // Set text color
                    
                    backgroundPanel.removeAll(); // Clear previous components
                    backgroundPanel.add(resultsLabel, BorderLayout.CENTER);
                    
                    // Create and add the "Show Thanks Page" button
                    JButton showThanksButton = new JButton(" EXIT ");
                    showThanksButton.setFont(new Font("Serif", Font.BOLD, 24));
                    showThanksButton.setBackground(Color.LIGHT_GRAY);
                    showThanksButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            new ThanksPage().setVisible(true);
                            dispose(); // Close the ResultPage
                        }
                    });
                    //Back button setup
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Serif", Font.BOLD, 20));
        backButton.setBackground(Color.lightGray);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the previous page, e.g., MenuPage
                new MenuPage().setVisible(true);
                dispose(); // Close current window
            }
        });
        // Add buttons to the panel
        backgroundPanel.add(showResultButton, BorderLayout.NORTH); // Show result button at the top
        backgroundPanel.add(backButton, BorderLayout.WEST); // Back button on the left

        setContentPane(backgroundPanel);
                    backgroundPanel.add(showThanksButton, BorderLayout.SOUTH);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "Voting is still running.");
                }
            }
        });

        backgroundPanel.add(showResultButton, BorderLayout.NORTH); // Add button to north

        setContentPane(backgroundPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ResultPage().setVisible(true);
            }
        });
    }
}
