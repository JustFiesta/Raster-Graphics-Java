package labs.no2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    String version = "0.02";

    public static void main(String[] args) {
        //ex1
        int widthX = Integer.parseInt(args[1]);
        int widthY = Integer.parseInt(args[2]);

        Renderer mainRenderer = new Renderer(args[0], widthX, widthY);
        mainRenderer.clear();
        //mainRenderer.drawPoint(50, 50);
        //ex 3
//        mainRenderer.drawLine(0, 0, 100, 10, Renderer.LineAlgo.valueOf(args[3]));

//        ex4
        mainRenderer.drawLine(320, 240, 639, 479, Renderer.LineAlgo.valueOf(args[3]));

        try {
            mainRenderer.save();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getVersion() {
        return this.version;
    }
}