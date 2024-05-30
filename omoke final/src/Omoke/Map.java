package Omoke;

public class Map {
    private short[][] map; // ���� ���� ���¸� �����ϴ� 2���� �迭
    private final short[] players; // �÷��̾���� �����ϴ� �迭
    private int currentPlayer; // ���� ������ �÷��̾� �ε���
    private boolean checkBNW = true; // ��� üũ ���� (������ ����)
    private SizeOfMap ms; // ������ ũ�⸦ �����ϴ� ��ü

    // ������: ���� ũ��� �÷��̾� ���� �޾� Map ��ü�� �ʱ�ȭ�մϴ�.
    public Map(SizeOfMap ms, int playerCount) {
        this.ms = ms; // ���� ũ�� ����
        map = new short[ms.getSize()][]; // ���� ũ�⸸ŭ �迭 �ʱ�ȭ
        for (int i = 0; i < map.length; i++)
            map[i] = new short[ms.getSize()];
        players = new short[playerCount]; // �÷��̾� �迭 �ʱ�ȭ
        for (short i = 0; i < playerCount; i++)
            players[i] = (short) (i + 1); // �÷��̾� ��ȣ ���� (1���� ����)
        currentPlayer = 0; // ���� �÷��̾� �ʱ�ȭ
    }

    // ���� �÷��̾ ��ȯ�մϴ�.
    public short getCurrentPlayer() {
        return players[currentPlayer];
    }

    // (y, x) ��ġ�� ���� ���¸� ��ȯ�մϴ�.
    public short getXY(int y, int x) {
        return map[y][x];
    }

    // ���� �÷��̾�� ���ʸ� �ѱ�ϴ�.
    public void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % players.length;
    }

    // (y, x) ��ġ�� ���� �÷��̾��� ���� �����ϴ�.
    public void setMap(int y, int x) {
        map[y][x] = players[currentPlayer];
    }

    // Ư�� ��ġ���� �¸� ������ Ȯ���մϴ�.
    public boolean winCheck(int x, int y) {
        if (winCheckL(x, y) || winCheckLD(x, y) || winCheckLU(x, y) || winCheckR(x, y)
        		
            || winCheckRD(x, y) || winCheckRU(x, y) || winCheckUp(x, y) || winCheckDown(x, y)
            
            || winCheckOneDown(x, y) || winCheckOneL(x, y) || winCheckOneLD(x, y) || winCheckOneLU(x, y)
            
            || winCheckOneR(x, y) || winCheckOneRD(x, y) || winCheckOneUp(x, y) || winCheckOneRU(x, y)
            
            || winCheckCenterLU(x, y) || winCheckCenterRL(x, y) || winCheckCenterRU(x, y) || winCheckCenterUD(x, y))
            return true;
        else
            return false;
    }

    // ���� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckUp(int x, int y) {
        try {
            for (int i = y; i < y + 5; i++) {
                if (map[y][x] != map[i][x])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �Ʒ��� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckDown(int x, int y) {
        try {
            for (int i = y; i > y - 5; i--) {
                if (map[y][x] != map[i][x])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // ������ �� �밢�� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckRU(int x, int y) {
        try {
            for (int i = y, z = x; i > y - 5; i--, z++) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // ���� �� �밢�� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckLU(int x, int y) {
        try {
            for (int i = y, z = x; i > y - 5; i--, z--) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // ������ �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckR(int x, int y) {
        try {
            for (int z = x; z < x + 5; z++) {
                if (map[y][x] != map[y][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // ���� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckL(int x, int y) {
        try {
            for (int z = x; z > x - 5; z--) {
                if (map[y][x] != map[y][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // ������ �Ʒ� �밢�� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckRD(int x, int y) {
        try {
            for (int i = y, z = x; i < y + 5; i++, z++) {
                if (map[y][x] != map[i][z] || i > 19 || z > 19 || i < 0 || z < 0)
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // ���� �Ʒ� �밢�� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckLD(int x, int y) {
        try {
            for (int i = y, z = x; i < y + 5; i++, z--) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �� ĭ ���� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckOneUp(int x, int y) {
        try {
            for (int i = y - 1; i < y + 4; i++) {
                if (map[y][x] != map[i][x])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �� ĭ �Ʒ��� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckOneDown(int x, int y) {
        try {
            for (int i = y + 1; i > y - 4; i--) {
                if (map[y][x] != map[i][x])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �� ĭ ������ �� �밢�� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckOneRU(int x, int y) {
        try {
            for (int i = y + 1, z = x - 1; i > y - 4; i--, z++) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �� ĭ ���� �� �밢�� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckOneLU(int x, int y) {
        try {
            for (int i = y + 1, z = x + 1; i > y - 4; i--, z--) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �� ĭ ������ �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckOneR(int x, int y) {
        try {
            for (int z = x - 1; z < x + 4; z++) {
                if (map[y][x] != map[y][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �� ĭ ���� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckOneL(int x, int y) {
        try {
            for (int z = x + 1; z > x - 4; z--) {
                if (map[y][x] != map[y][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �� ĭ ������ �Ʒ� �밢�� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckOneRD(int x, int y) {
        try {
            for (int i = y - 1, z = x - 1; i < y + 4; i++, z++) {
                if (map[y][x] != map[i][z] || i > 19 || z > 19 || i < 0 || z < 0)
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �� ĭ ���� �Ʒ� �밢�� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckOneLD(int x, int y) {
        try {
            for (int i = y - 1, z = x + 1; i < y + 4; i++, z--) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �߾� ���Ʒ� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckCenterUD(int x, int y) {
        try {
            for (int i = y - 2; i < y + 3; i++) {
                if (map[y][x] != map[i][x])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �߾� �¿� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckCenterRL(int x, int y) {
        try {
            for (int z = x - 2; z < x + 3; z++) {
                if (map[y][x] != map[y][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �߾� ������ �밢�� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckCenterRU(int x, int y) {
        try {
            for (int i = y + 2, z = x - 2; i > y - 3; i--, z++) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // �߾� ���� �밢�� �������� 5���� ���� ������ Ȯ���մϴ�.
    public boolean winCheckCenterLU(int x, int y) {
        try {
            for (int i = y + 2, z = x + 2; i > y - 3; i--, z--) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // ���� ���带 �ʱ�ȭ�մϴ�.
    public void clear() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 0; // ��� ��ġ�� �ʱ�ȭ�մϴ�.
            }
        }
        currentPlayer = 0; // ���� �÷��̾ �ʱ�ȭ�մϴ�.
    }
}
