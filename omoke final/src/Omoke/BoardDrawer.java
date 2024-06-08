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
        initializeBackground(); // 배경 초기화
        initializeSize(m); // 보드 크기 초기화
        initializeLayout(); // 레이아웃 초기화
        initializeMap(map); // 게임 상태 맵 초기화
        initializePlayerColors(playerColors); // 플레이어 색상 초기화
        initializeResetButton(); // 리셋 버튼 초기화
        setupResetButtonAction(); // 리셋 버튼 액션 설정
    }

    private void initializeBackground() {
        // 보드 배경색을 설정합니다.
        setBackground(Color.lightGray);
    }

    private void initializeSize(SizeOfMap m) {
        // 보드의 크기를 초기화합니다.
        size = m;
    }

    private void initializeLayout() {
        // 레이아웃 매니저를 설정하지 않는다.
        setLayout(null);
    }

    private void initializeMap(Map map) {
        // 게임 상태 맵을 초기화합니다.
        this.map = map;
    }

    private void initializePlayerColors(ArrayList<Color> playerColors) {
        // 플레이어별 돌 색상을 초기화합니다.
        this.playerColors = playerColors;
    }

    private void initializeResetButton() {
        // 리셋 버튼을 생성합니다.
        resetButton = new JButton("Reset");

        // 리셋 버튼의 위치와 크기를 설정합니다.
        resetButton.setBounds(280, 615, 80, 30);

        // 리셋 버튼을 패널에 추가합니다.
        add(resetButton);
    }

    private void setupResetButtonAction() {
        // 리셋 버튼에 액션 리스너를 추가합니다. 클릭 시 보드를 초기화하고 처음부터 시작할 수 있도록 합니다.
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 맵을 초기화합니다.
                map.clear();

                // 보드를 다시 그립니다.
                repaint();
            }
        });
    }

    // paintComponent 메소드: 보드를 그리고 돌을 그립니다.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // 부모 클래스의 paintComponent를 호출하여 배경을 지웁니다.
        setColorBlack(g); // 선 색상을 검정으로 설정합니다.
        drawBoard(g); // 보드를 그립니다.
        drawStones(g); // 돌을 그립니다.
    }

    private void setColorBlack(Graphics g) {
        g.setColor(Color.BLACK);
    }

    private void drawBoard(Graphics g) {
        board(g); // 보드 그리기 메소드 호출
    }

    private void drawStones(Graphics g) {
        drawStone(g); // 돌 그리기 메소드 호출
    }

    // 보드 그리기 메소드: 보드의 격자를 그립니다.
    public void board(Graphics g) {
        for (int i = 1; i <= size.getSize(); i++) {
            drawHorizontalLine(g, i); // 가로선 그리기
            drawVerticalLine(g, i); // 세로선 그리기
        }
    }

    private void drawHorizontalLine(Graphics g, int i) {
        g.drawLine(size.getCell(), i * size.getCell(), size.getCell() * size.getSize(), i * size.getCell());
    }

    private void drawVerticalLine(Graphics g, int i) {
        g.drawLine(i * size.getCell(), size.getCell(), i * size.getCell(), size.getCell() * size.getSize());
    }

    // 돌 그리기 메소드: 맵에 저장된 돌 정보를 기반으로 돌을 그립니다.
    public void drawStone(Graphics g) {
        for (int y = 0; y < size.getSize(); y++) {
            for (int x = 0; x < size.getSize(); x++) {
                if (map.getXY(y, x) != 0) {
                    drawColoredStone(g, x, y, map.getXY(y, x));
                }
            }
        }
    }

    // 색상이 있는 돌을 그리는 메소드: 플레이어의 번호에 따라 색상을 설정하고 돌을 그립니다.
    public void drawColoredStone(Graphics g, int x, int y, int player) {
        g.setColor(getPlayerColor(player)); // 플레이어 번호에 따른 색상 설정
        fillOvalForStone(g, x, y); // 돌을 그립니다.
    }

    private Color getPlayerColor(int player) {
        return playerColors.get(player - 1); // 플레이어 색상을 반환합니다.
    }

    private void fillOvalForStone(Graphics g, int x, int y) {
        g.fillOval((x + 1) * size.getCell() - STONE_SIZE / 2, (y) * size.getCell() - STONE_SIZE / 2, STONE_SIZE, STONE_SIZE);
    }
}
