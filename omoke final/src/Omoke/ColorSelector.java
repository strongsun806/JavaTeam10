package Omoke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// ColorSelector 클래스는 JFrame을 상속하며, 각 플레이어가 오목 게임에서 사용할 색상을 선택할 수 있도록 하는 UI를 제공한다.
public class ColorSelector extends JFrame {
    private int playerCount; // 플레이어 수
    private int mapSize; // 보드 크기
    private ArrayList<Color> selectedColors; // 선택된 색상을 저장하는 리스트
    private int currentPlayer; // 현재 색상을 선택 중인 플레이어

    // 생성자: 플레이어 수와 보드 크기를 받아 색상 선택 창을 초기화합니다.
    public ColorSelector(int playerCount, int mapSize) {
        this.playerCount = playerCount;
        this.mapSize = mapSize;
        this.selectedColors = new ArrayList<>();
        this.currentPlayer = 1;
        
        // 창의 제목과 초기 위치, 크기를 설정합니다.
        setTitle("Player " + currentPlayer + " Choose Color");
        setBounds(200, 100, 400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 내용 팬에 레이아웃을 설정하고 색상 선택 버튼을 추가합니다.
        Container c = getContentPane();
        c.setLayout(new GridLayout(3, 1));

        JButton redButton = new JButton("BLACK");
        JButton blueButton = new JButton("WHITE");
        JButton greenButton = new JButton("BLUE");

        // 각 버튼에 액션 리스너를 추가합니다.
        redButton.addActionListener(new ColorButtonAction(Color.BLACK, "BLACK"));
        blueButton.addActionListener(new ColorButtonAction(Color.WHITE, "WHITE"));
        greenButton.addActionListener(new ColorButtonAction(Color.BLUE, "BLUE"));

        // 버튼을 내용 팬에 추가합니다.
        c.add(redButton);
        c.add(blueButton);
        c.add(greenButton);

        setVisible(true); // 창을 표시합니다.
    }

    // ColorButtonAction 클래스는 버튼 클릭 시 색상을 선택하는 액션 리스너를 정의합니다.
    private class ColorButtonAction implements ActionListener {
        private Color color; // 선택할 색상
        private String colorName; // 색상 이름

        // 생성자: 색상과 색상 이름을 받아 초기화합니다.
        public ColorButtonAction(Color color, String colorName) {
            this.color = color;
            this.colorName = colorName;
        }

        // actionPerformed 메소드: 버튼 클릭 시 호출되어 색상을 선택합니다.
        public void actionPerformed(ActionEvent e) {
            // 이미 선택된 색상이 아닌 경우 색상을 추가하고 다음 플레이어로 이동합니다.
            if (!selectedColors.contains(color)) {
                selectedColors.add(color);
                if (currentPlayer == playerCount) {
                    // 모든 플레이어가 색상을 선택한 경우 게임 UI를 생성하고 창을 닫습니다.
                    new GUI(selectedColors, mapSize);
                    dispose();
                } else {
                    currentPlayer++;
                    setTitle("Player " + currentPlayer + " Choose Color");
                }
            } else {
                // 이미 선택된 색상인 경우 경고 메시지를 표시합니다.
                JOptionPane.showMessageDialog(null, colorName + " is already selected", "", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
