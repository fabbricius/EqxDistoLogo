import java.applet.Applet;
import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;

public class DistoLogo extends Applet
    implements Runnable
{

    public DistoLogo()
    {
        scrollingString = "This applet is an Equinox production. So lamers, don't try to rip it !";
    }

    // This function increases the angular position with 3. 
    // If the position reaches 360 it is reset to 0.
    // int modifyAngularPos(int rasterPos, int step);  step=3 by default
    protected int modifyAngularPos(int i, int j)
    {
	i += j;
	if (i > 359)
	    i -= 360;
        return i;
    }

    // Receive an angular position (from 0 to 379) and map it to a vertical postion on the applet (0 to 60)
    // if i = 0 (bottom of the circle drawn by rasters) then returns 60
    // if i = 180 (top of the circle drawn by rasters) then returns 0
    protected int mapAngularPositionToVerticalAxis(int i)
    {
        return (int)(Math.cos(((double)i * 3.1415926535897931D) / 180D) * (double)((logoHeight + 16) / 2)) + (logoHeight + 16) / 2;
    }

    // drawRasterLines(Graphics, y-position, color)
    protected void drawRasterLine(Graphics g, int i, Color color)
    {
        g.setColor(color);
        g.drawLine(0, i, largeurApplet - 1, i);
        g.setColor(color = color.darker());
        g.drawLine(0, i - 1, largeurApplet - 1, i - 1);
        g.drawLine(0, i + 1, largeurApplet - 1, i + 1);
        g.setColor(color = color.darker());
        g.drawLine(0, i - 2, largeurApplet - 1, i - 2);
        g.drawLine(0, i + 2, largeurApplet - 1, i + 2);
    }

    protected void shakeAndDrawLogo(Graphics g, int i)
    {
        if(shakeLogoCounter >= const600)
	    shakeLogoCounter = 0; // end of the shake cycle

        for(int j = 0; j < largeurApplet * logoHeight; j++)
            logoTapeArray[j] = 0;

        for(int k = 0; k < logoHeight; k++)
        {
            for(int l = 0; l < logoWidth; l++)
                logoTapeArray[k * largeurApplet + l + EquiNoxrulez[k + shakeLogoCounter]] = logoArray[k * logoWidth + l];

        }

        shakeLogoCounter++;
        memImageSrc.newPixels();
        g.drawImage(myImage, 0, i, null);
    }

    // was equInoxrulez
    protected boolean checkStringValidity()
    {
        long l = 0L;
        for(int i = 0; i < scrollingString.length(); i++)
            l += scrollingString.charAt(i);
	// 6340L is for sentence "This applet is an Equinox production. So lamers, don't try to rip it !"
        // return l == 6304L;
	return true;
    }

    public void init()
    {
        // This is the size of the java applet
	resize(400, 80); // public void resize(int width, int height)
        if(!checkStringValidity())
            return;
        rastersActivated = false;
        String s = getParameter("rasters");
        if(s == null)
            rastersActivated = true;
        else
        if(s.equalsIgnoreCase("yes"))
            rastersActivated = true;
        largeurApplet = 400;
        appletHeight = 80;
        imageTotale = createImage(largeurApplet, appletHeight);
        MediaTracker mediatracker = new MediaTracker(this);
        Image image = getImage(getCodeBase(), "EqxLogo.gif"); // logo: width 300 pixels, height 44 px
        varImageBack = getImage(getCodeBase(), "Grn0641.jpg"); // background: 120*120 pixels
        mediatracker.addImage(image, 0);
        mediatracker.addImage(varImageBack, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(InterruptedException _ex) { }
        logoWidth = image.getWidth(this);
        logoHeight = image.getHeight(this);
        logoArray = new int[logoWidth * logoHeight];
        logoTapeArray = new int[largeurApplet * logoHeight];
        memImageSrc = new MemoryImageSource(largeurApplet, logoHeight, logoTapeArray, 0, largeurApplet);
        memImageSrc.setAnimated(true);
        myImage = createImage(memImageSrc);
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, logoWidth, logoHeight, logoArray, 0, logoWidth);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        const600 = 600;
        EquiNoxrulez = new int[const600 + logoHeight]; // logo is 300*44 px(w,h)
        for(int i = 0; i < 60; i++)
            EquiNoxrulez[i] = (largeurApplet - logoWidth) / 2;

        for(int j = 0; j < 180; j++)
            EquiNoxrulez[j + 60] = (int)(Math.sin(((double)(4 * j) * 3.1415926535897931D) / 180D) * (double)((largeurApplet - logoWidth) / 4)) + (largeurApplet - logoWidth) / 2;

        for(int k = 0; k < 180; k++)
            EquiNoxrulez[k + 60 + 180] = (int)((Math.sin(((double)(2 * k) * 3.1415926535897931D) / 180D) * 0.80000000000000004D + Math.sin(((double)(4 * k) * 3.1415926535897931D) / 45D) * 0.20000000000000001D) * (double)((largeurApplet - logoWidth) / 4)) + (largeurApplet - logoWidth) / 2;

        for(int l = 0; l < 90; l++)
            EquiNoxrulez[l + 60 + 180 + 180] = (int)((Math.sin(((double)(2 * l) * 3.1415926535897931D) / 180D) * 0.90000000000000002D + Math.sin(((double)(8 * l) * 3.1415926535897931D) / 45D) * 0.10000000000000001D) * (double)((largeurApplet - logoWidth) / 4)) + (largeurApplet - logoWidth) / 2;

        for(int i1 = 0; i1 < 90; i1++)
            EquiNoxrulez[i1 + 60 + 180 + 180 + 90] = (int)(Math.sin(((double)(6 * i1) * 3.1415926535897931D) / 180D) * Math.sin(((double)(2 * i1) * 3.1415926535897931D) / 360D + 1.5707963267948966D) * (double)((largeurApplet - logoWidth) / 4)) + (largeurApplet - logoWidth) / 2;

        for(int j1 = 0; j1 < logoHeight; j1++)
            EquiNoxrulez[const600 + j1] = EquiNoxrulez[j1];

        shakeLogoCounter = 0;
        posRaster0 = 0;
        posRaster1 = 120;
        posRaster2 = 240;
        fabThread = null;
        FontMetrics fontmetrics = getFontMetrics(getFont());
	// JAVA API: public int FontMetrics::stringWidth(String str) 
	// Returns the total advance width for showing the specified String 
	// in this Font. The advance is the distance from the leftmost point 
	// to the rightmost point on the string's baseline. 
        fontStringWidth = fontmetrics.stringWidth(scrollingString); 
	//System.out.println("DEBUG: fontStringWidth = " + fontStringWidth);
	// JAVA API: public int getDescent()
	// Determines the font descent of the Font described by this FontMetrics object. 
	// The font descent is the distance from the font's baseline to the bottom of most 
	// alphanumeric characters with descenders. Some characters in the Font might extend 
	// below the font descent line.
        fontDescent = fontmetrics.getDescent(); // returns 3 
        //System.out.println("DEBUG: fontDescent = " + fontDescent);
        stringPosX = largeurApplet;
        resize(largeurApplet, appletHeight);
    }

    public void run()
    {
        while(fabThread != null) 
        {
            repaint();
            try
            {
                Thread.sleep(17L); // original speed
		//Thread.sleep(970L); // For a super slow animation!
            }
            catch(InterruptedException _ex) { }
        }
    }

    public void start()
    {
        //System.out.println("DEBUG: start() +");
	if(fabThread == null)
        {
            fabThread = new Thread(this);
            fabThread.start();
        }
    }

    public void stop()
    {
        //System.out.println("DEBUG: stop() +");
	if(fabThread != null)
        {
            fabThread.stop();
            fabThread = null;
        }
    }

    // update the graphic. This is done by following this order:
    // 1) draw the background, using the background image
    // 2) draw the rasters that are behind the logo
    // 3) draw the logo
    // 4) draw the rasters that are in front of the logo.
    // 5) draw the text string
    public void update(Graphics g)
    {
        Graphics g1 = imageTotale.getGraphics();
        int i = varImageBack.getWidth(this);
        for(int j = 0; j < largeurApplet; j += i)
            g1.drawImage(varImageBack, j, 0, null);

	if(rastersActivated)
        {
	    posRaster0 = modifyAngularPos(posRaster0, 3); // step is 3
            posRaster1 = modifyAngularPos(posRaster1, 3);
            posRaster2 = modifyAngularPos(posRaster2, 3);
	    // First draw any rasters that would be BEHIND the logo
            if(posRaster0 <= 180)
                drawRasterLine(g1, mapAngularPositionToVerticalAxis(posRaster0), Color.blue.darker());
            if(posRaster1 <= 180)
                drawRasterLine(g1, mapAngularPositionToVerticalAxis(posRaster1), Color.white.darker());
            if(posRaster2 <= 180)
                drawRasterLine(g1, mapAngularPositionToVerticalAxis(posRaster2), Color.red.darker());

	    // Now draw the logo (and shake it a bit before)
            shakeAndDrawLogo(g1, 8);

	    // And then draw the rasters that are in FRONT of the logo!
            if(posRaster0 > 180)
                drawRasterLine(g1, mapAngularPositionToVerticalAxis(posRaster0), Color.blue);
            if(posRaster1 > 180)
                drawRasterLine(g1, mapAngularPositionToVerticalAxis(posRaster1), Color.white);
            if(posRaster2 > 180)
                drawRasterLine(g1, mapAngularPositionToVerticalAxis(posRaster2), Color.red);
        } else
        {
            shakeAndDrawLogo(g1, 8);
        }
	// Set the color to yellow for the scrolling text at the bottom.
        g1.setColor(Color.yellow);

	// JAVA API: java.awt.Graphics.drawString
	// abstract void drawString(AttributedCharacterIterator iterator, int x, int y)
	// Renders the text of the specified iterator applying its attributes in accordance 
	// with the specification of the TextAttribute class.
        g1.drawString(scrollingString, stringPosX, appletHeight - fontDescent);

	// At each passage decrease the x-position of the string. A negative position 
	// means that the string will be displayed outside the applet, at the left.
	// This part of the string (the beginning) will not be displayed.
	// When we have reached the last pixel displayed, reset the x-position to 300
	// (width of applet) so the string will be displayed at the very right of the applet.
	// For instance if you have a string for which fontmetrics.stringWidth returns 582,
	// then: when the x-position has reached -582, it means that the string has been 
	// completely displayed to the last pixel. Then we can start again by displaying 
	// it at x-position 300 (applet width).
        if(stringPosX-- <= -fontStringWidth)
            stringPosX = largeurApplet;

        g.drawImage(imageTotale, 0, 0, this);
    }

    Thread fabThread;
    Image imageTotale;
    int largeurApplet; // Set to 400
    int appletHeight; // Set to 80
    boolean rastersActivated;
    Image varImageBack;
    MemoryImageSource memImageSrc; // memImageSrc
    Image myImage;
    int const600; // Seems to be a constant value set to 600
    int logoWidth; // new int[logoWidth * logoHeight];
    int logoHeight;
    int logoArray[]; // tableau taille logo 
    int logoTapeArray[]; // new int[largeurApplet * logoHeight]; 
    int EquiNoxrulez[]; // new int[const600 + logoHeight];
    int shakeLogoCounter;
    int posRaster0; // position starts at 0 (at the bottom)
    int posRaster1; // position starts at 120 (at the top of the Equinox logo but BEHIND)
    int posRaster2; // position starts at 240 (at the top of the Equinox logo but IN FRONT OF)
    String scrollingString;
    int fontStringWidth; // Set to fontmetrics.stringWidth(scrollingString);
    int fontDescent;
    int stringPosX;
}
