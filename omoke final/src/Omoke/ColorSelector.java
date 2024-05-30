package Omoke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// ColorSelector Ŭ������ JFrame�� ����ϸ�, �� �÷��̾ ���� ���ӿ��� ����� ������ ������ �� �ֵ��� �ϴ� UI�� �����Ѵ�.
public class ColorSelector extends JFrame {
    private int playerCount; // �÷��̾� ��
    private int mapSize; // ���� ũ��
    private ArrayList<Color> selectedColors; // ���õ� ������ �����ϴ� ����Ʈ
    private int currentPlayer; // ���� ������ ���� ���� �÷��̾�

    // ������: �÷��̾� ���� ���� ũ�⸦ �޾� ���� ���� â�� �ʱ�ȭ�մϴ�.
    public ColorSelector(int playerCount, int mapSize) {
        this.playerCount = playerCount;
        this.mapSize = mapSize;
        this.selectedColors = new ArrayList<>();
        this.currentPlayer = 1;
        
        // â�� ����� �ʱ� ��ġ, ũ�⸦ �����մϴ�.
        setTitle("Player " + currentPlayer + " Choose Color");
        setBounds(200, 100, 400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // ���� �ҿ� ���̾ƿ��� �����ϰ� ���� ���� ��ư�� �߰��մϴ�.
        Container c = getContentPane();
        c.setLayout(new GridLayout(3, 1));

        JButton redButton = new JButton("BLACK");
        JButton blueButton = new JButton("WHITE");
        JButton greenButton = new JButton("BLUE");

        // �� ��ư�� �׼� �����ʸ� �߰��մϴ�.
        redButton.addActionListener(new ColorButtonAction(Color.BLACK, "BLACK"));
        blueButton.addActionListener(new ColorButtonAction(Color.WHITE, "WHITE"));
        greenButton.addActionListener(new ColorButtonAction(Color.BLUE, "BLUE"));

        // ��ư�� ���� �ҿ� �߰��մϴ�.
        c.add(redButton);
        c.add(blueButton);
        c.add(greenButton);

        setVisible(true); // â�� ǥ���մϴ�.
    }

    // ColorButtonAction Ŭ������ ��ư Ŭ�� �� ������ �����ϴ� �׼� �����ʸ� �����մϴ�.
    private class ColorButtonAction implements ActionListener {
        private Color color; // ������ ����
        private String colorName; // ���� �̸�

        // ������: ����� ���� �̸��� �޾� �ʱ�ȭ�մϴ�.
        public ColorButtonAction(Color color, String colorName) {
            this.color = color;
            this.colorName = colorName;
        }

        // actionPerformed �޼ҵ�: ��ư Ŭ�� �� ȣ��Ǿ� ������ �����մϴ�.
        public void actionPerformed(ActionEvent e) {
            // �̹� ���õ� ������ �ƴ� ��� ������ �߰��ϰ� ���� �÷��̾�� �̵��մϴ�.
            if (!selectedColors.contains(color)) {
                selectedColors.add(color);
                if (currentPlayer == playerCount) {
                    // ��� �÷��̾ ������ ������ ��� ���� UI�� �����ϰ� â�� �ݽ��ϴ�.
                    new GUI(selectedColors, mapSize);
                    dispose();
                } else {
                    currentPlayer++;
                    setTitle("Player " + currentPlayer + " Choose Color");
                }
            } else {
                // �̹� ���õ� ������ ��� ��� �޽����� ǥ���մϴ�.
                JOptionPane.showMessageDialog(null, colorName + " is already selected", "", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}