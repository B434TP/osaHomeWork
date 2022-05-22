package lesson08;

public class Main {
    public static void main(String[] args) {

        Obstacle [] obstacles = {
            new Wall(1),
            new Wall(2),
            new RunTrack(100),
            new Wall(2),
            new Wall(3),
            new RunTrack(200),
            new Wall(3),
            new Wall(4),
            new RunTrack(300),
            new Wall(5),
            new RunTrack(1000),
        };

        Wall wl1 = new Wall(1);
        RunTrack rt1 = new RunTrack(1000);

        Participant[] participants =  {
            new Man(300,2 ),
            new Cat(100,1),
            new Robot(500, 10),
            new Man(200,3 ),
            new Cat(50,2),
            new Robot(1500, 100)
        };


        for (int i = 0; i < obstacles.length; i++) {

            System.out.println("\n---------- Trying to cross " + obstacles[i] );

            for (int j = 0; j < participants.length; j++) {
                obstacles[i].crossObstacle(participants[j]);
            }
        }
    }
}


