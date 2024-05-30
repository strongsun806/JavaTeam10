package Omoke;

public class SizeOfMap {
    private final int CELL = 30; // ���� ũ�⸦ 30���� ����
    private int size; // ���� ũ�⸦ ������ ����

    // SizeOfMap Ŭ������ ������. ���� ũ�⸦ �ʱ�ȭ�մϴ�.
    public SizeOfMap(int size) {
        this.size = size;
    }

    // ���� ũ�⸦ ��ȯ�ϴ� �޼����Դϴ�.
    public int getCell() {
        return CELL;
    }

    // ���� ũ�⸦ ��ȯ�ϴ� �޼����Դϴ�.
    public int getSize() {
        return size;
    }
}
