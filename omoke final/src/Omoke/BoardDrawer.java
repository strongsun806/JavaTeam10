package Omoke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.ArrayList;

// BoardDrawer Ŭ������ JPanel�� ����ϸ�, ���� ������ ����� ���� �׸��� ������ ����մϴ�.
@SuppressWarnings("serial")
public class BoardDrawer extends JPanel {
    private SizeOfMap size; // ������ ũ�⸦ �����ϴ� ��ü
    private Map map; // ���� ���¸� �����ϴ� �� ��ü
    private final int STONE_SIZE = 28; // ���� ũ��
    private JButton resetButton; // ���带 �ʱ�ȭ�ϴ� ��ư
    private ArrayList<Color> playerColors; // �÷��̾ �� ������ �����ϴ� ����Ʈ

    // ������: ������ ũ��, ���� ���� ��, �÷��̾� ���� ����Ʈ�� �޾� �ʱ�ȭ �Ѵ�
    public BoardDrawer(SizeOfMap m, Map map, ArrayList<Color> playerColors) {
        setBackground((Color.lightGray)); // ���� ���� ����
        /***
         *       ���� �ڵ�:   setBackground(new Color(206, 167, 61)); // ���� ���� ����
         *       
         */
        size = m;
        setLayout(null); // ���̾ƿ� �Ŵ��� ����
        this.map = map;
        this.playerColors = playerColors;

        resetButton = new JButton("Reset"); // ���� ��ư ����
        resetButton.setBounds(280, 615, 80, 30); // ���� ��ư ��ġ�� ũ�� ����
        add(resetButton); // ���� ��ư�� �гο� �߰�

        // ���� ��ư�� �׼� ������ �߰�: Ŭ�� �� ���带 �ʱ�ȭ�ϰ� ó������ ������ �� �ֵ��� �Ѵ�.
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.clear(); // �� �ʱ�ȭ
                repaint(); // ���� �ٽ� �׸��� - �ٽ� ���� ���� �� �ְ� �Ѵ�.
            }
        });
    }

    // paintComponent �޼ҵ�: ���带 �׸��� ���� �׸��ϴ�.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // �θ� Ŭ������ paintComponent ȣ��
        g.setColor(Color.BLACK); // �� ������ �������� ����
        board(g); // ���� �׸���
        drawStone(g); // �� �׸���
    }

    // ���� �׸��� �޼ҵ�: ������ ���ڸ� �׸���. 
    public void board(Graphics g) {
        for (int i = 1; i <= size.getSize(); i++) {
            g.drawLine(size.getCell(), i * size.getCell(), size.getCell() * size.getSize(), i * size.getCell()); // ���μ� �׸���
            g.drawLine(i * size.getCell(), size.getCell(), i * size.getCell(), size.getCell() * size.getSize()); // ���μ� �׸���
        }
    }

    // �� �׸��� �޼ҵ�: �ʿ� ����� �� ������ ������� ���� �׸��ϴ�.
    public void drawStone(Graphics g) {
        for (int y = 0; y < size.getSize(); y++) {
            for (int x = 0; x < size.getSize(); x++) {
                if (map.getXY(y, x) != 0) { // �ش� ��ġ�� ���� �ִ� ���
                    drawColoredStone(g, x, y, map.getXY(y, x)); // ���� �׸��ϴ�.
                }
            }
        }
    }

    // ������ �ִ� ���� �׸��� �޼ҵ�: �÷��̾��� ��ȣ�� ���� ������ �����ϰ� ���� �׸��ϴ�.
    public void drawColoredStone(Graphics g, int x, int y, int player) {
        g.setColor(playerColors.get(player - 1)); // �÷��̾� ��ȣ�� ���� ���� ����
        g.fillOval((x + 1) * size.getCell() - STONE_SIZE / 2, (y) * size.getCell() - STONE_SIZE / 2, STONE_SIZE, STONE_SIZE); // �� �׸���
    }
}