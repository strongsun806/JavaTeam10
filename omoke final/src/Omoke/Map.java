package Omoke;

public class Map {
    private short[][] map; // 게임 보드 상태를 저장하는 2차원 배열
    private final short[] players; // 플레이어들을 저장하는 배열
    private int currentPlayer; // 현재 차례인 플레이어 인덱스
    private boolean checkBNW = true; // 흑백 체크 변수 (사용되지 않음)
    private SizeOfMap ms; // 보드의 크기를 저장하는 객체

    // 생성자: 보드 크기와 플레이어 수를 받아 Map 객체를 초기화합니다.
    public Map(SizeOfMap ms, int playerCount) {
        this.ms = ms; // 보드 크기 설정
        map = new short[ms.getSize()][]; // 보드 크기만큼 배열 초기화
        for (int i = 0; i < map.length; i++)
            map[i] = new short[ms.getSize()];
        players = new short[playerCount]; // 플레이어 배열 초기화
        for (short i = 0; i < playerCount; i++)
            players[i] = (short) (i + 1); // 플레이어 번호 설정 (1부터 시작)
        currentPlayer = 0; // 현재 플레이어 초기화
    }

    // 현재 플레이어를 반환
    public short getCurrentPlayer() {
        return players[currentPlayer];
    }

    // (y, x) 위치의 보드 상태를 반환
    public short getXY(int y, int x) {
        return map[y][x];
    }

    // 다음 플레이어로 차례를 넘김
    public void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % players.length;
    }

    // (y, x) 위치에 현재 플레이어의 돌을 놓는다.
    public void setMap(int y, int x) {
        map[y][x] = players[currentPlayer];
    }

    // 특정 위치에서 승리 조건을 확인하는 변수 
    public boolean winCheck(int x, int y) {
        // 왼쪽 방향에서 승리 조건을 확인
        boolean checkL = winCheckL(x, y);
        
        // 왼쪽-아래 대각선 방향에서 승리 조건을 확인
        boolean checkLD = winCheckLD(x, y);
        
        // 왼쪽-위 대각선 방향에서 승리 조건을 확인
        boolean checkLU = winCheckLU(x, y);
        
        // 오른쪽 방향에서 승리 조건을 확인
        boolean checkR = winCheckR(x, y);
        
        // 오른쪽-아래 대각선 방향에서 승리 조건을 확인
        boolean checkRD = winCheckRD(x, y);
        
        // 오른쪽-위 대각선 방향에서 승리 조건을 확인
        boolean checkRU = winCheckRU(x, y);
        
        // 위쪽 방향에서 승리 조건을 확인
        boolean checkUp = winCheckUp(x, y);
        
        // 아래쪽 방향에서 승리 조건을 확인
        boolean checkDown = winCheckDown(x, y);
        
        // 한 칸 아래에서 승리 조건을 확인
        boolean checkOneDown = winCheckOneDown(x, y);
        
        // 한 칸 왼쪽에서 승리 조건을 확인
        boolean checkOneL = winCheckOneL(x, y);
        
        // 한 칸 왼쪽-아래 대각선에서 승리 조건을 확인
        boolean checkOneLD = winCheckOneLD(x, y);
        
        // 한 칸 왼쪽-위 대각선에서 승리 조건을 확인
        boolean checkOneLU = winCheckOneLU(x, y);
        
        // 한 칸 오른쪽에서 승리 조건을 확인
        boolean checkOneR = winCheckOneR(x, y);
        
        // 한 칸 오른쪽-아래 대각선에서 승리 조건을 확인
        boolean checkOneRD = winCheckOneRD(x, y);
        
        // 한 칸 위쪽에서 승리 조건을 확인
        boolean checkOneUp = winCheckOneUp(x, y);
        
        // 한 칸 오른쪽-위 대각선에서 승리 조건을 확인
        boolean checkOneRU = winCheckOneRU(x, y);
        
        // 중심을 기준으로 왼쪽-위 방향에서 승리 조건을 확인
        boolean checkCenterLU = winCheckCenterLU(x, y);
        
        // 중심을 기준으로 오른쪽-왼쪽 방향에서 승리 조건을 확인
        boolean checkCenterRL = winCheckCenterRL(x, y);
        
        // 중심을 기준으로 오른쪽-위 방향에서 승리 조건을 확인
        boolean checkCenterRU = winCheckCenterRU(x, y);
        
        // 중심을 기준으로 위-아래 방향에서 승리 조건을 확인
        boolean checkCenterUD = winCheckCenterUD(x, y);

        // 위의 조건들 중 하나라도 만족하면 true를 반환, 그렇지 않으면 false를 반환
        if (checkL || checkLD || checkLU || checkR || checkRD || checkRU ||
            checkUp || checkDown || checkOneDown || checkOneL || checkOneLD || 
            checkOneLU || checkOneR || checkOneRD || checkOneUp || checkOneRU || 
            checkCenterLU || checkCenterRL || checkCenterRU || checkCenterUD) {
            return true;
        } else {
            return false;
        }
    }


    // 위쪽 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 아래쪽 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 오른쪽 위 대각선 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 왼쪽 위 대각선 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 오른쪽 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 왼쪽 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 오른쪽 아래 대각선 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 왼쪽 아래 대각선 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 한 칸 위쪽 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 한 칸 아래쪽 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 한 칸 오른쪽 위 대각선 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 한 칸 왼쪽 위 대각선 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 한 칸 오른쪽 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 한 칸 왼쪽 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 한 칸 오른쪽 아래 대각선 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 한 칸 왼쪽 아래 대각선 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 중앙 위아래 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 중앙 좌우 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 중앙 오른쪽 대각선 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 중앙 왼쪽 대각선 방향으로 5개의 돌이 같은지 확인합니다.
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

    // 게임 보드를 초기화합니다.
    public void clear() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 0; // 모든 위치를 초기화합니다.
            }
        }
        currentPlayer = 0; // 현재 플레이어를 초기화합니다.
    }
}
