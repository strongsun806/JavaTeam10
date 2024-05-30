package Omoke;

public class SizeOfMap {
    private final int CELL = 30; // 셀의 크기를 30으로 고정
    private int size; // 맵의 크기를 저장할 변수

    // SizeOfMap 클래스의 생성자. 맵의 크기를 초기화합니다.
    public SizeOfMap(int size) {
        this.size = size;
    }

    // 셀의 크기를 반환하는 메서드입니다.
    public int getCell() {
        return CELL;
    }

    // 맵의 크기를 반환하는 메서드입니다.
    public int getSize() {
        return size;
    }
}
