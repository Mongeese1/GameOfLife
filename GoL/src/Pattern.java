import java.util.ArrayList;
/**
 * Pra2003
 * @author mongeese1
 * i6222534
 */

public abstract class Pattern {
    protected ArrayList<ArrayList<Integer>> lines;    
    public abstract String name();     
    public ArrayList<ArrayList<Integer>> lines() { return lines; }
}

class Glider extends Pattern{

    @Override
    public String name(){
        return "Glider";
    }

    @Override
    public ArrayList<ArrayList<Integer>> lines() { 
        lines = new ArrayList<ArrayList<Integer>>();
        lines.add(new ArrayList<Integer>());
        lines.add(new ArrayList<Integer>());
        lines.add(new ArrayList<Integer>());
        lines.get(0).add(0,1);
        lines.get(0).add(1,1);
        lines.get(0).add(2,1);
        lines.get(1).add(0,0);
        lines.get(1).add(1,0);
        lines.get(1).add(2,1);
        lines.get(2).add(0,0);
        lines.get(2).add(1,1);
        lines.get(2).add(2,0);
		return lines;
    }
}

class LightSpaceship extends Pattern{

    public LightSpaceship(){
        lines = new ArrayList<ArrayList<Integer>>();
        lines.add(new ArrayList<Integer>());
        lines.add(new ArrayList<Integer>());
        lines.add(new ArrayList<Integer>());
        lines.add(new ArrayList<Integer>());
        lines.get(0).add(0,0);
        lines.get(0).add(1,1);
        lines.get(0).add(2,1);
        lines.get(0).add(3,1);
        lines.get(0).add(4,1);
        lines.get(1).add(0,1);
        lines.get(1).add(1,0);
        lines.get(1).add(2,0);
        lines.get(1).add(3,0);
        lines.get(1).add(4,1);
        lines.get(2).add(0,0);
        lines.get(2).add(1,0);
        lines.get(2).add(2,0);
        lines.get(2).add(3,0);
        lines.get(2).add(4,1);
        lines.get(3).add(0,1);
        lines.get(3).add(1,0);
        lines.get(3).add(2,0);
        lines.get(3).add(3,1);
        lines.get(3).add(4,0);
    }

    @Override
    public String name(){
        return "Light Spaceship";
    }

    @Override
    public ArrayList<ArrayList<Integer>> lines() {
        return lines;
    }
}
