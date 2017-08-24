enum TrafficLightColor{
    RED, GREEN, YELLOW
}

class TrafficLightSimulator implements Runnable{
    private Thread thread;
    private TrafficLightColor tlc;
    private boolean stop = false;
    private boolean changed = false;

    TrafficLightSimulator(TrafficLightColor tlc){
        this.tlc = tlc;
        thread = new Thread(this);
        thread.start();
    }

    TrafficLightSimulator(){
        tlc = TrafficLightColor.RED;
        thread = new Thread(this);
        thread.start();
    }

    public void run(){
        while (!stop){

            try{
                switch (tlc){
                    case GREEN:
                        Thread.sleep(10000);
                        break;
                    case YELLOW:
                        Thread.sleep(2000);
                        break;
                    case RED:
                        Thread.sleep(12000);
                        break;
                }
            } catch (InterruptedException exc){
                System.out.println(exc.getMessage());
            }
            changeColor();
        }
    }

    private synchronized void changeColor(){
        switch (tlc){
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
        }

        changed = true;
        notify();
    }

    synchronized void waitForChange(){
        try{
            while (!changed)
                wait();
            changed = false;
        } catch (InterruptedException exc){
            System.out.println(exc.getMessage());
        }
    }

    TrafficLightColor getColor(){
        return tlc;
    }

    void cancel(){
        stop = true;
    }
}

public class TrafficLightDemo {
    public static void main(String[] args) {
        TrafficLightSimulator tl = new TrafficLightSimulator(TrafficLightColor.GREEN);

        for(int i = 0; i < 9; i++){
            System.out.println(tl.getColor());
            tl.waitForChange();
        }

        tl.cancel();
    }

}