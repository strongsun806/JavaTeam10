package Omoke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeSelector extends JFrame {
    private int playerCount;

    public ModeSelector() {
        setTitle("Select Omoke Game Mode");
        setBounds(200, 100, 400, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new GridLayout(3, 1));

        JButton twoPlayerButton = new JButton("2 Players Mode");
        JButton threePlayerButton = new JButton("3 Players Mode");
        JButton instructionsButton = new JButton("How to Play");

        // 2�ο� ��ư Ŭ�� �� �÷��̾� ���� 2�� �����ϰ� �� ũ�� ���� ȭ���� ǥ���մϴ�.
        twoPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerCount = 2;
                showMapSizeSelection();
            }
        });

        // 3�ο� ��ư Ŭ�� �� �÷��̾� ���� 3���� �����ϰ� �� ũ�� ���� ȭ���� ǥ���մϴ�.
        threePlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerCount = 3;
                showMapSizeSelection();
            }
        });

        // ���� ��� ��ư Ŭ�� �� ���� ����� �����ϴ� ���̾�α׸� ǥ���մϴ�.
        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "How to Play:\n\n- Two or three people take turns placing stones.\n\n- You win by placing five stones in a row horizontally, vertically, or diagonally.", "How to Play", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // ��ư���� �����̳ʿ� �߰��մϴ�.
        c.add(twoPlayerButton);
        c.add(threePlayerButton);
        c.add(instructionsButton);

        setVisible(true);
    }

    // �� ũ�� ���� ȭ���� ǥ���ϴ� �޼����Դϴ�.
    private void showMapSizeSelection() {
        JFrame mapSizeFrame = new JFrame("Select MapSize");
        mapSizeFrame.setBounds(200, 100, 400, 200);
        mapSizeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = mapSizeFrame.getContentPane();
        c.setLayout(new GridLayout(2, 1));

        JButton smallMapButton = new JButton("15 x 15");
        JButton largeMapButton = new JButton("19 x 19");

        // 15x15 ��ư Ŭ�� �� ColorSelector�� �����ϰ� ���� �������� �ݽ��ϴ�.
        smallMapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ColorSelector(playerCount, 15);
                mapSizeFrame.dispose();
                dispose();
            }
        });

        // 19x19 ��ư Ŭ�� �� ColorSelector�� �����ϰ� ���� �������� �ݽ��ϴ�.
        largeMapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ColorSelector(playerCount, 19);
                mapSizeFrame.dispose();
                dispose();
            }
        });

        // ��ư���� �����̳ʿ� �߰��մϴ�.
        c.add(smallMapButton);
        c.add(largeMapButton);

        mapSizeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new ModeSelector();
    }
}
