package Omoke;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventHandler extends MouseAdapter {
    private Map map;
    private SizeOfMap size;
    private BoardDrawer d;
    private GUI gui;

    // MouseEventHandler 클래스의 생성자. 게임 맵, 맵 크기, BoardDrawer 객체, GUI 객체를 초기화합니다.
    public MouseEventHandler(Map map, SizeOfMap size, BoardDrawer d, GUI gui) {
        this.map = map;
        this.size = size;
        this.d = d;
        this.gui = gui;
    }

    // 마우스가 눌렸을 때의 이벤트를 처리하는 메서드입니다.
    @Override
    public void mousePressed(MouseEvent e) {
        // 클릭한 좌표를 게임 보드의 셀 좌표로 변환합니다.
        int x = (e.getX() - size.getCell() / 2) / size.getCell();
        int y = (e.getY() - size.getCell() / 2) / size.getCell();

        // 클릭한 좌표가 맵 크기 안에 있는지 확인합니다.
        if (x >= 0 && x < size.getSize() && y >= 0 && y < size.getSize()) {
            // 클릭한 셀이 비어 있는지 확인합니다.
            if (map.getXY(y, x) == 0) {
                // 현재 플레이어의 돌을 해당 위치에 놓습니다.
                map.setMap(y, x);
                // 보드를 다시 그립니다.
                d.repaint();
                // 승리 조건을 체크합니다.
                if (map.winCheck(x, y)) {
                    // 승리자가 있으면 팝업을 표시하고 게임을 종료합니다.
                    gui.showPopUp(map.getCurrentPlayer() + " Player is Winner!");
                } else {
                    // 다음 플레이어로 턴을 넘깁니다.
                    map.nextPlayer();
                }
            }
        }
    }
}
