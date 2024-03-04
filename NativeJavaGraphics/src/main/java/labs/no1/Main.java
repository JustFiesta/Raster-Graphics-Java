package labs.no1;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

// image manipulation in native Java
public class Main {

    //32 bity do ustawiania koloru, po 8 bitów dla alpha, red, green, blue

    public static void main(String args[]) throws IOException {
        BufferedImage img = null;
        File f = null;
// wczytaj obraz
        try {
            f = new File("img/all_black.png");
            img = ImageIO.read(f);

        } catch (IOException e) {
            System.out.println(e);
        }
// pobieramy szerokość i wysokość obrazów
        int width = img.getWidth();
        int height = img.getHeight();
        // pobieramy środkowy piksel
        int p = img.getRGB(width / 2, height / 2);
// Odczytujemy wartosci kanalow przesuwajac o odpowiednia liczbe bitow w prawo, tak aby
// kanal znalazł się na bitach 7-0, następnie zerujemy pozostałe bity używając bitowego AND z maską 0xFF.

        int a = (p >> 24) & 0xff;
        int r = (p >> 16) & 0xff;
        int g = (p >> 8) & 0xff;
        int b = p & 0xff;

// Ustawiamy wartosci poszczegolnych kanalow na przykładowe liczby


        a = 255;
        r = 100;
        g = 150;
        b = 200;

// TODO: ustaw ponownie wartości kanałów dla zmiennej p

        img.setRGB(width / 2, height / 2, p);



        allWhite(img);
        imgNegative(img);


// zapis obrazu
        try {
            f = new File("img/all_black.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void allWhite(BufferedImage img) {
        int height = img.getHeight();
        int width = img.getWidth();

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                img.setRGB(i, j, 0xffffffff);
            }
        }
    }

    public static void imgNegative(BufferedImage img) {
        int height = img.getHeight();
        int width = img.getWidth();


        //wysokopoziomowo (bez operacji na bitach koloru danego pixela)
        int rgb = img.getRGB(height/2, width/2);

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){

                int currentPixel = img.getRGB(i, j);

//                img.setRGB(i, j, 0xffffffff - currentPixel);

                //lub
                int r = (currentPixel >> 24) & 0xff;
                int g = (currentPixel >> 24) & 0xff;
                int b = (currentPixel >> 24) & 0xff;

                Color color = new Color(255 - r,255 - g,255 - b);

                img.setRGB(i, j, color.getRGB());
            }
        }


        //niskopoziomowo (z wykorzystaniem bitów koloru pixeli)

//        >> przesunięcie bitowe w prawo
//        >>> przesunięcie bitowe w prawo z wypełnieniem zerami
//        << przesunięcie bitowe w lewo

//        int pixel = img.getRGB(width/2, height/2);
//        int r = (pixel >> 24) & 0xff;
//        int g = (pixel >> 24) & 0xff;
//        int b = (pixel >> 24) & 0xff;
//        for (){
//            for (){
//                //to samo co wyżej
//            }
//        }

    }
}