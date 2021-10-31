
public class Game {
    int a;
    int b;
    State state;

    public Game(final int a, final int b){
        this.a = a;
        this.b = b;
        state = new State(a,b);
    }
}

