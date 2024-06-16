# JavaTeam10

경북대학교 자바 프로그래밍 24-1semester 001분반 Team 10 프로젝트 과제 입니다.

# FlowChart
![image](https://github.com/strongsun806/JavaTeam10/assets/145644915/87197623-d3bf-465b-9b58-1066268a0ec2)



![image](https://github.com/strongsun806/JavaTeam10/assets/145644915/678ad224-0cea-4cfc-ae34-e4b31eec71d5)





기존 오목 게임은 2인이서 플레이 할 수 있는 것에 비하여 이 프로그램은 3인까지 플레이가 가능합니다.
맵 크기 선택은 15X15, 19X19 선택이 가능합니다.

1. 모드 선택 및 게임 방법 설명

![image](https://github.com/strongsun806/JavaTeam10/assets/145644915/da00363d-dc66-4459-a952-607758b1732e)


프로그램 실행 시 2인 모드, 3인 모드, 게임 방법에 대한 버튼을 출력합니다.


![image](https://github.com/strongsun806/JavaTeam10/assets/145644915/8e46b814-8903-4a6e-92fc-861fe874c720)
How to Play 버튼 클릭 시 게임 방법에 대해 설명하는 창이 띄워지고, 확인 버튼을 누르면 다시 첫 화면으로 돌아갑니다.

2. 맵 크기 선택
   
![image](https://github.com/strongsun806/JavaTeam10/assets/145644915/28e20d64-156e-4c8d-b362-14ea68fd3fd4)

모드 선택 완료 후 맵 크기 선택을 할 수 있습니다.
작은 화면을 선호하시면 15X15, 큰 화면을 좋아하시면 19X19 버튼을 누르시면 됩니다.


4. 돌 색상 선택

![image](https://github.com/strongsun806/JavaTeam10/assets/145644915/34f2c2ea-1097-4b12-8c52-f7027cba6cb8)
각각의 플레이어는 본인이 원하는 색의 돌을 선택할 수 있습니다.
돌 선택은 흑돌, 백돌, 청돌 중 선택이 가능합니다. Player 1 부터 돌을 선택할 수 있습니다.

![image](https://github.com/strongsun806/JavaTeam10/assets/145644915/a725283f-e846-4bef-8dba-5fb147556f82)

이전 플레이어가 선택한 돌 색상을 선택하면 이미 선택된 색상이라는 화면이 출력됩니다. 확인을 누르면 돌 색상을 다시 선택할 수 있습니다.


4. 플레이 시작
    1) 15X15

   
       ![image](https://github.com/strongsun806/JavaTeam10/assets/145644915/89581368-96d7-40a5-8972-8a2518f98fd7)


       ![image](https://github.com/strongsun806/JavaTeam10/assets/145644915/25cdf40f-7a1b-4346-90f2-95feb3a16a68)

지금은 2인 모드를 선택했습니다.
Player1과 Player2가 번갈아가면서 돌을 놓을 수 있습니다.
Reset 버튼을 누르면 보드를 깨끗하게 만들고 다시 Player1 부터 돌을 놓을 수 있습니다.


   2) 19X19

    
  ![image](https://github.com/strongsun806/JavaTeam10/assets/145644915/3ee6490a-06ff-44a9-93a2-62680ceec255)


훨씬 보기 편해진 것 같은 느낌이 듭니다. 
이번엔 3인 모드를 선택했습니다.
Player1과 Player2, 그리고 Player3 이 세 명이 순서대로 판에 돌을 놓을 겁니다.


  ![image](https://github.com/strongsun806/JavaTeam10/assets/145644915/660e5506-fe13-4ab0-8a0e-cad1faa7c48b)

Player3이 선택한 청돌이 가장 먼저 오목을 성공시켰습니다. 
화면에는 3번 플레이어가 승리했다고 출력합니다.

이렇게 3명이서 하는 오목 게임이 완성이 되었습니다. 


# Class Diagram


![image](https://github.com/strongsun806/JavaTeam10/assets/145644915/71a9d71a-271a-4b63-a37c-c7a724938a21)



### 오목 게임 프로그램 설명
이 프로그램은 Java Swing을 사용하여 구현된 다인용 오목 게임입니다. 두 명 또는 세 명의 
플레이어가 차례대로 돌을 놓아 5개의 돌을 가로, 세로 또는 대각선으로 연속으로 배치하는 
것을 목표로 합니다. 프로그램은 GUI를 통해 사용자와 상호작용하며, 승리 조건이 충족되면 
게임이 종료됩니다.
 ### 클래스 설명
#### OmokeMain 클래스- **OmokeMain** 클래스는 프로그램의 시작점을 정의합니다.
  - `public static void main(String[] args)` 메소드: 프로그램 실행 시 호출되는 메소드로, 
게임 모드 선택 화면인 `ModeSelector`를 생성합니다.
 #### ModeSelector 클래스- **ModeSelector** 클래스는 게임 모드를 선택하는 화면을 제공합니다.
  - **생성자**: `public ModeSelector()`
    - JFrame 설정: 윈도우 타이틀, 크기, 종료 동작 설정
    - 2인용, 3인용, 게임 방법 버튼 추가
    - 각 버튼 클릭 시 플레이어 수를 설정하고 맵 크기 선택 화면을 보여줍니다.
  - `private void showMapSizeSelection()`: 맵 크기를 선택하는 새로운 프레임을 생성합니
다.
    - 15x15 및 19x19 맵 크기 선택 버튼 추가
    - 각 버튼 클릭 시 `ColorSelector` 화면을 표시하고 현재 프레임을 닫습니다.
 #### GUI 클래스- **GUI** 클래스는 게임의 그래픽 사용자 인터페이스를 제공합니다.
  - **생성자**: `public GUI(ArrayList<Color> playerColors, int mapSize)`
    - 플레이어 색상 리스트와 맵 크기를 받아 초기화합니다.
    - `Map` 객체와 `SizeOfMap` 객체 생성
    - 게임 보드와 돌을 그리는 `BoardDrawer` 객체 생성
    - 마우스 이벤트 핸들러 추가
  - `public void showPopUp(String message)`: 승리 메시지를 팝업으로 표시하고 프로그
램을 종료합니다.
 #### ColorSelector 클래스- **ColorSelector** 클래스는 각 플레이어가 사용할 돌의 색상을 선택하는 화면을 제공합
니다.
  - **생성자**: `public ColorSelector(int playerCount, int mapSize)`
    - 플레이어 수와 맵 크기를 받아 초기화합니다.
    - 색상 선택 버튼과 완료 버튼 추가
    - 각 플레이어가 돌의 색상을 선택하고 게임을 시작합니다.
  - `private void showGameStartScreen(ArrayList<Color> colors, int mapSize)`: 선택
한 색상과 맵 크기로 게임을 시작합니다.
#### Map 클래스- **Map** 클래스는 게임 보드 상태와 게임 로직을 관리합니다.
  - **생성자**: `public Map(SizeOfMap ms, int playerCount)`
    - 보드 크기와 플레이어 수를 받아 초기화합니다.
    - 게임 보드 상태를 저장하는 2차원 배열과 현재 플레이어 정보를 관리합니다.
  - `public short getCurrentPlayer()`: 현재 플레이어를 반환합니다.
  - `public short getXY(int y, int x)`: (y, x) 위치의 보드 상태를 반환합니다.
  - `public void nextPlayer()`: 다음 플레이어로 차례를 넘깁니다.
  - `public void setMap(int y, int x)`: 현재 플레이어의 돌을 해당 위치에 놓습니다.
  - `public boolean winCheck(int x, int y)`: 특정 위치에서 승리 조건을 확인합니다.
    - 다양한 방향(가로, 세로, 대각선)으로 5개의 돌이 연속으로 있는지 확인하는 여러 메소
드 포함
  - `public void clear()`: 게임 보드를 초기화합니다.
 #### SizeOfMap 클래스- **SizeOfMap** 클래스는 보드의 크기와 셀 크기를 관리합니다.
  - **생성자**: `public SizeOfMap(int size)`
    - 맵의 크기를 받아 초기화합니다.
  - `public int getCell()`: 셀의 크기를 반환합니다.
  - `public int getSize()`: 맵의 크기를 반환합니다.
 #### BoardDrawer 클래스- **BoardDrawer** 클래스는 게임 보드와 돌을 그립니다.
  - **생성자**: `public BoardDrawer(SizeOfMap size, Map map, ArrayList<Color> 
playerColors)`
    - 보드 크기, 게임 상태, 플레이어 색상을 받아 초기화합니다.
  - `protected void paintComponent(Graphics g)`: 보드와 돌을 그리는 메소드로, 
`JPanel`의 `paintComponent` 메소드를 오버라이드합니다.
 #### MouseEventHandler 클래스- **MouseEventHandler** 클래스는 마우스 이벤트를 처리합니다.
  - **생성자**: `public MouseEventHandler(Map map, SizeOfMap size, BoardDrawer 
d, GUI gui)`
    - 게임 맵, 맵 크기, `BoardDrawer` 객체, `GUI` 객체를 받아 초기화합니다.
  - `public void mousePressed(MouseEvent e)`: 마우스가 눌렸을 때의 이벤트를 처리하는 
메소드로, 클릭한 좌표를 게임 보드의 셀 좌표로 변환하여 돌을 놓고 승리 조건을 확인합니
다.
이 프로그램은 각 클래스가 명확한 역할을 가지고 있으며, 게임의 흐름을 자연스럽게 처리하
도록 설계되었습니다. GUI를 통해 사용자와 상호작용하고, 게임 상태를 관리하며, 승리 조건
을 확인하는 등 오목 게임의 기본적인 동작을 충실히 구현하고 있습니다.
