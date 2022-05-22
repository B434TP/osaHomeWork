package lesson08;

public class Wall extends Obstacle{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void crossObstacle(Participant participant) {

        if (participant.isLooser()) {
            return;
        }

        if (this.height <= participant.getMaxHeight()) {
            System.out.println(participant + " jumped to " + this.height);
        } else {
            System.out.println("ERR: " + participant + " can't jump so high - "+ this.height);
            participant.setLooser();
        }


    }

    @Override
    public String toString() {
        return "wall ("  + this.height +  ")" ;
    }

}
