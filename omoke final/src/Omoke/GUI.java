package Omoke;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// GUI 클래스는 JFrame을 상속하며, 오목 게임의 그래픽 사용자 인터페이스를 제공합니다.
public class GUI extends JFrame {
    private Container c; // 컨테이너 객체
    private SizeOfMap size; // 보드의 크기를 저장하는 객체
    private ArrayList<Color> playerColors; // 플레이어별 돌 색상을 저장하는 리스트

    // 생성자: 플레이어 색상 리스트와 보드 크기를 받아 GUI를 초기화합니다.
    public GUI(ArrayList<Color> playerColors, int mapSize) {
        this.size = new SizeOfMap(mapSize); // 보드 크기 설정
        this.playerColors = playerColors; // 플레이어 색상 리스트 설정
        c = getContentPane(); // 컨테이너 가져오기
        setBounds(200, 20, 650, 700); // 창의 위치와 크기 설정
        c.setLayout(null); // 레이아웃 매니저 설정
        Map map = new Map(size, playerColors.size()); // 맵 객체 생성 (게임 상태 저장)
        BoardDrawer d = new BoardDrawer(size, map, playerColors); // 보드와 돌을 그릴 BoardDrawer 객체 생성
        setContentPane(d); // BoardDrawer를 콘텐츠 팬으로 설정
        addMouseListener(new MouseEventHandler(map, size, d, this)); // 마우스 이벤트 핸들러 추가
        setVisible(true); // 창을 표시
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫을 때 프로그램 종료
    }

    // showPopUp 메소드: 메시지를 팝업으로 표시하고 프로그램을 종료합니다.
    public void showPopUp(String message) {
        JOptionPane.showMessageDialog(this, message, "!!!Congratulation!!!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0); // 프로그램 종료
    }
}
