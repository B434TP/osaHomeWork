package lesson08;

public class RunTrack extends Obstacle{
    private int length;

    public RunTrack(int length) {
        this.length = length;
    }

    @Override
    public void crossObstacle(Participant participant) {

        if (participant.isLooser()) {
            return;
        }

        if (this.length <= participant.getMaxLength()) {
            System.out.println(participant + " ran " + this.length);
        } else {
            System.out.println("ERR: " + participant + " can't run so far - "+ this.length);
            participant.setLooser();
        }


    }

    @Override
    public String toString() {
        return "run track (" + this.length + ")";
    }

}
