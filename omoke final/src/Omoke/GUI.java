package Omoke;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// GUI Ŭ������ JFrame�� ����ϸ�, ���� ������ �׷��� ����� �������̽��� �����մϴ�.
public class GUI extends JFrame {
    private Container c; // �����̳� ��ü
    private SizeOfMap size; // ������ ũ�⸦ �����ϴ� ��ü
    private ArrayList<Color> playerColors; // �÷��̾ �� ������ �����ϴ� ����Ʈ

    // ������: �÷��̾� ���� ����Ʈ�� ���� ũ�⸦ �޾� GUI�� �ʱ�ȭ�մϴ�.
    public GUI(ArrayList<Color> playerColors, int mapSize) {
        this.size = new SizeOfMap(mapSize); // ���� ũ�� ����
        this.playerColors = playerColors; // �÷��̾� ���� ����Ʈ ����
        c = getContentPane(); // �����̳� ��������
        setBounds(200, 20, 650, 700); // â�� ��ġ�� ũ�� ����
        c.setLayout(null); // ���̾ƿ� �Ŵ��� ����
        Map map = new Map(size, playerColors.size()); // �� ��ü ���� (���� ���� ����)
        BoardDrawer d = new BoardDrawer(size, map, playerColors); // ����� ���� �׸� BoardDrawer ��ü ����
        setContentPane(d); // BoardDrawer�� ������ ������ ����
        addMouseListener(new MouseEventHandler(map, size, d, this)); // ���콺 �̺�Ʈ �ڵ鷯 �߰�
        setVisible(true); // â�� ǥ��
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â ���� �� ���α׷� ����
    }

    // showPopUp �޼ҵ�: �޽����� �˾����� ǥ���ϰ� ���α׷��� �����մϴ�.
    public void showPopUp(String message) {
        JOptionPane.showMessageDialog(this, message, "!!!Congratulation!!!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0); // ���α׷� ����
    }
}
