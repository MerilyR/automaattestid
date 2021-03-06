/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.tlu.automaattestid;

/**
 *
 * @author Merily.Rooparg
 */
public class Area {

    public enum Command {FWD, BWD}
    
    int w, h;
    char[][] m;
    
    public Area(int width, int height) {
        w = width;
        h = height;
        m = new char[w][h];
        clearArea();
        setTurtle (new Turtle (0,0));
    }
    
    public void clearArea(){
        turtle = null;
        for (int y = 0; y < m[0].length; y ++ ) 
            for (char[] m1 : m) {
                m1[y] = '.';
            }
    }
        
    Turtle turtle;
    
    public Turtle getTurtle() {
        return turtle;
    }
    
    public void setTurtle(Turtle t) {
        // remove turtle
        if (turtle != null)
            m [turtle.getX()][turtle.getY()] = '.';
        // set new Turtle
        turtle = t;
        m [turtle.getX()][turtle.getY()] = turtle.toString().charAt(0);
    }

    
    public void command (Command c) {
        switch (c) {
            case FWD:
                moveForward();
                break;
        }
    }
    
    public void command (char c) {
        switch (c) {
            case 'f' :
                moveForward();
                break;
            case ('r'):
                turnRight();
                break;
            case ('l'):
                turnLeft();
                break;
        }
    }
    
    public void commandsAsString(String s) {
        for (char c : s.toCharArray())
            command (c);
    }
    
    private void moveForward () {
        if (!outOfArea (turtle))        
            // set current position to *
            m [turtle.getX()][turtle.getY()] = '*';
        // step to direction
        turtle.step();
        if (!outOfArea (turtle))
        // set new position
            m [turtle.getX()][turtle.getY()] = turtle.toString().charAt(0);            
    }
    
    private void turnRight () {
        // step to direction
        turtle.rotateRight();
        if (!outOfArea (turtle))  
        // set new position
            m [turtle.getX()][turtle.getY()] = turtle.toString().charAt(0);
    }
    
    private void turnLeft () {
        // step to direction
        turtle.rotateLeft();
        if (!outOfArea (turtle))  
        // set new position
            m [turtle.getX()][turtle.getY()] = turtle.toString().charAt(0);
    }
    
    private boolean outOfArea (Turtle t) {
        if (t.getX() < 0)
            return true;
        if (t.getY() < 0)
            return true;
        System.out.println("Turtle is out of area!!!");
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < m[0].length; y ++ ) {
            for (char[] m1 : m) {
                sb.append(m1[y]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
