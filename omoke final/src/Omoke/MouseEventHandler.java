package Omoke;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventHandler extends MouseAdapter {
    private Map map;
    private SizeOfMap size;
    private BoardDrawer d;
    private GUI gui;

    // MouseEventHandler Ŭ������ ������. ���� ��, �� ũ��, BoardDrawer ��ü, GUI ��ü�� �ʱ�ȭ�մϴ�.
    public MouseEventHandler(Map map, SizeOfMap size, BoardDrawer d, GUI gui) {
        this.map = map;
        this.size = size;
        this.d = d;
        this.gui = gui;
    }

    // ���콺�� ������ ���� �̺�Ʈ�� ó���ϴ� �޼����Դϴ�.
    @Override
    public void mousePressed(MouseEvent e) {
        // Ŭ���� ��ǥ�� ���� ������ �� ��ǥ�� ��ȯ�մϴ�.
        int x = (e.getX() - size.getCell() / 2) / size.getCell();
        int y = (e.getY() - size.getCell() / 2) / size.getCell();

        // Ŭ���� ��ǥ�� �� ũ�� �ȿ� �ִ��� Ȯ���մϴ�.
        if (x >= 0 && x < size.getSize() && y >= 0 && y < size.getSize()) {
            // Ŭ���� ���� ��� �ִ��� Ȯ���մϴ�.
            if (map.getXY(y, x) == 0) {
                // ���� �÷��̾��� ���� �ش� ��ġ�� �����ϴ�.
                map.setMap(y, x);
                // ���带 �ٽ� �׸��ϴ�.
                d.repaint();
                // �¸� ������ üũ�մϴ�.
                if (map.winCheck(x, y)) {
                    // �¸��ڰ� ������ �˾��� ǥ���ϰ� ������ �����մϴ�.
                    gui.showPopUp(map.getCurrentPlayer() + " Player is Winner!");
                } else {
                    // ���� �÷��̾�� ���� �ѱ�ϴ�.
                    map.nextPlayer();
                }
            }
        }
    }
}
