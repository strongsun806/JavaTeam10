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

        // 2인용 버튼 클릭 시 플레이어 수를 2로 설정하고 맵 크기 선택 화면을 표시합니다.
        twoPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerCount = 2;
                showMapSizeSelection();
            }
        });

        // 3인용 버튼 클릭 시 플레이어 수를 3으로 설정하고 맵 크기 선택 화면을 표시합니다.
        threePlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerCount = 3;
                showMapSizeSelection();
            }
        });

        // 게임 방법 버튼 클릭 시 게임 방법을 설명하는 다이얼로그를 표시합니다.
        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "How to Play:\n\n- Two or three people take turns placing stones.\n\n- You win by placing five stones in a row horizontally, vertically, or diagonally.", "How to Play", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // 버튼들을 컨테이너에 추가합니다.
        c.add(twoPlayerButton);
        c.add(threePlayerButton);
        c.add(instructionsButton);

        setVisible(true);
    }

    // 맵 크기 선택 화면을 표시하는 메서드입니다.
    private void showMapSizeSelection() {
        JFrame mapSizeFrame = new JFrame("Select MapSize");
        mapSizeFrame.setBounds(200, 100, 400, 200);
        mapSizeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = mapSizeFrame.getContentPane();
        c.setLayout(new GridLayout(2, 1));

        JButton smallMapButton = new JButton("15 x 15");
        JButton largeMapButton = new JButton("19 x 19");

        // 15x15 버튼 클릭 시 ColorSelector를 생성하고 현재 프레임을 닫습니다.
        smallMapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ColorSelector(playerCount, 15);
                mapSizeFrame.dispose();
                dispose();
            }
        });

        // 19x19 버튼 클릭 시 ColorSelector를 생성하고 현재 프레임을 닫습니다.
        largeMapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ColorSelector(playerCount, 19);
                mapSizeFrame.dispose();
                dispose();
            }
        });

        // 버튼들을 컨테이너에 추가합니다.
        c.add(smallMapButton);
        c.add(largeMapButton);

        mapSizeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new ModeSelector();
    }
}
