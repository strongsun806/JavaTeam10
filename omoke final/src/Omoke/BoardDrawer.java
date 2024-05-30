package Omoke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.ArrayList;

// BoardDrawer 클래스는 JPanel을 상속하며, 오목 게임의 보드와 돌을 그리는 역할을 담당합니다.
@SuppressWarnings("serial")
public class BoardDrawer extends JPanel {
    private SizeOfMap size; // 보드의 크기를 저장하는 객체
    private Map map; // 게임 상태를 저장하는 맵 객체
    private final int STONE_SIZE = 28; // 돌의 크기
    private JButton resetButton; // 보드를 초기화하는 버튼
    private ArrayList<Color> playerColors; // 플레이어별 돌 색상을 저장하는 리스트

    // 생성자: 보드의 크기, 게임 상태 맵, 플레이어 색상 리스트를 받아 초기화 한다
    public BoardDrawer(SizeOfMap m, Map map, ArrayList<Color> playerColors) {
        setBackground((Color.lightGray)); // 보드 배경색 설정
        /***
         *       기존 코드:   setBackground(new Color(206, 167, 61)); // 보드 배경색 설정
         *       
         */
        size = m;
        setLayout(null); // 레이아웃 매니저 설정
        this.map = map;
        this.playerColors = playerColors;

        resetButton = new JButton("Reset"); // 리셋 버튼 생성
        resetButton.setBounds(280, 615, 80, 30); // 리셋 버튼 위치와 크기 설정
        add(resetButton); // 리셋 버튼을 패널에 추가

        // 리셋 버튼에 액션 리스너 추가: 클릭 시 보드를 초기화하고 처음부터 시작할 수 있도록 한다.
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.clear(); // 맵 초기화
                repaint(); // 보드 다시 그리기 - 다시 돌을 놓을 수 있게 한다.
            }
        });
    }

    // paintComponent 메소드: 보드를 그리고 돌을 그립니다.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // 부모 클래스의 paintComponent 호출
        g.setColor(Color.BLACK); // 선 색상을 검정으로 설정
        board(g); // 보드 그리기
        drawStone(g); // 돌 그리기
    }

    // 보드 그리기 메소드: 보드의 격자를 그리기. 
    public void board(Graphics g) {
        for (int i = 1; i <= size.getSize(); i++) {
            g.drawLine(size.getCell(), i * size.getCell(), size.getCell() * size.getSize(), i * size.getCell()); // 가로선 그리기
            g.drawLine(i * size.getCell(), size.getCell(), i * size.getCell(), size.getCell() * size.getSize()); // 세로선 그리기
        }
    }

    // 돌 그리기 메소드: 맵에 저장된 돌 정보를 기반으로 돌을 그립니다.
    public void drawStone(Graphics g) {
        for (int y = 0; y < size.getSize(); y++) {
            for (int x = 0; x < size.getSize(); x++) {
                if (map.getXY(y, x) != 0) { // 해당 위치에 돌이 있는 경우
                    drawColoredStone(g, x, y, map.getXY(y, x)); // 돌을 그립니다.
                }
            }
        }
    }

    // 색상이 있는 돌을 그리는 메소드: 플레이어의 번호에 따라 색상을 설정하고 돌을 그립니다.
    public void drawColoredStone(Graphics g, int x, int y, int player) {
        g.setColor(playerColors.get(player - 1)); // 플레이어 번호에 따른 색상 설정
        g.fillOval((x + 1) * size.getCell() - STONE_SIZE / 2, (y) * size.getCell() - STONE_SIZE / 2, STONE_SIZE, STONE_SIZE); // 돌 그리기
    }
}