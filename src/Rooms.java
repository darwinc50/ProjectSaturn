import java.util.ArrayList;

public class Rooms {
    private static ArrayList<Rooms> rooms = new ArrayList<>();
    private final char direction;
    private char floor;
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
    public static void generateRooms() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < directions.length; j++) {
                for (int k = 1; k < 21; k++) {
                rooms.add(new Rooms(i,j,k));
                }
            }
        }
    }
    public static void printRooms(){
        System.out.println("Insert into Rooms (floor, wing, roomNum) " + "VALUES");
        for (int i = 0; i < rooms.size() - 2; i++) {
            System.out.print(rooms.get(i)); System.out.println(",");
        }
        System.out.print(rooms.get(rooms.size()-1)); System.out.println(";");
    }

    @Override
    public String toString() {
        return ("(\""+floor+"\",\""+direction+"\","+roomNum+")");
    }
}
