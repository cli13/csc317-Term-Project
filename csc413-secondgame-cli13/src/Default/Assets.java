package Default;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.imageio.ImageIO.read;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Canran
 */
public class Assets {

    public static BufferedImage bee, bg, walls, dbee, bear, bear2, qButt, rButt, hive, honey, redLock, blueLock, redSwitch, blueSwitch;
    public static BufferedImage flower, web2, web, Scissor;
    public static BufferedImage winScreen, title;
    //wall pieces
    public static BufferedImage hLine, vLine, bottomLeftCorner, bottomRightCorner, topRightCorner, topLeftCorner, tBottom, tRight, tLeft, tTop, crossPiece;

    public void init() {
        try {
            bg = read(getClass().getResource("/resources/Background.bmp"));
            bee = read(getClass().getResource("/resources/bee.png"));
            dbee = read(getClass().getResource("/resources/deadbee.png"));
            bear = read(getClass().getResource("/resources/bearwalk.png"));
            bear2 = read(getClass().getResource("/resources/bearsleep.png"));
            qButt = read(getClass().getResource("/resources/qButt.gif"));
            rButt = read(getClass().getResource("/resources/rButt.gif"));
            hive = read(getClass().getResource("/resources/hive.png"));
            honey = read(getClass().getResource("/resources/honey.png"));
            redLock = read(getClass().getResource("/resources/lock_red.png"));
            blueLock = read(getClass().getResource("/resources/lock_blue.png"));
            redSwitch = read(getClass().getResource("/resources/switch_red.png"));
            blueSwitch = read(getClass().getResource("/resources/switch_blue.png"));
            flower = read(getClass().getResource("/resources/flower.png"));
            web = read(getClass().getResource("/resources/web.png"));
            web2 = read(getClass().getResource("/resources/web2.png"));
            Scissor = read(getClass().getResource("/resources/scissors.png"));
            winScreen = read(getClass().getResource("/resources/gratz.png"));
            title = read(getClass().getResource("/resources/title.png"));

            //wall
            walls = read(getClass().getResource("/resources/wall.png"));
            hLine = walls.getSubimage(120, 120, 40, 40);
            vLine = walls.getSubimage(80, 120, 40, 40);
            bottomLeftCorner = walls.getSubimage(0, 40, 40, 40);
            bottomRightCorner = walls.getSubimage(120, 40, 40, 40);
            topLeftCorner = walls.getSubimage(40, 40, 40, 40);
            topRightCorner = walls.getSubimage(80, 40, 40, 40);
            tBottom = walls.getSubimage(0, 80, 40, 40);
            tTop = walls.getSubimage(80, 80, 40, 40);
            tRight = walls.getSubimage(40, 80, 40, 40);
            tLeft = walls.getSubimage(120, 80, 40, 40);
            crossPiece = walls.getSubimage(40, 120, 40, 40);

        } catch (IOException ex) {
            Logger.getLogger(Assets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
