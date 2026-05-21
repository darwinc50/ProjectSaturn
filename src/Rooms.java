public class Rooms {

    private final char direction;
    private char floor;
    private char wing;
    private int roomNum;
    private static char[] directions = new char[]{'N','S','E','W'};
    private static int roomIDCounter = 0;
    private int roomID;

    public Rooms(int floor, int direction, int rNum) {
        this.floor = (floor == 0)? 'B' : (char) (floor + '0');
        this.direction = directions[direction];
        this.roomNum = rNum;
        roomIDCounter++;
        roomID = roomIDCounter;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < directions.length; j++) {
                for (int k = 1; k < 21; k++) {
                    System.out.println(new Rooms(i,j,k));
                }
            }
        }
    }

    @Override
    public String toString() {
        return ("Insert into Rooms (floor, wing, roomNum) " + "VALUES ("+floor+",\""+direction+"\","+roomNum+");");
    }
}
