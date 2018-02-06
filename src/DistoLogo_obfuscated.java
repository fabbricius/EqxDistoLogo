import java.applet.Applet;
import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;

public class DistoLogo extends Applet
    implements Runnable
{

    public DistoLogo()
    {
        EquInoxrulez = "This applet is an Equinox production. So lamers, don't try to rip it !";
    }

    protected int EquinOxrulez(int i, int j)
    {
        for(i += j; i < 0; i += 360);
        for(; i > 359; i -= 360);
        return i;
    }

    protected int EquinoXrulez(int i)
    {
        return (int)(Math.cos(((double)i * 3.1415926535897931D) / 180D) * (double)((equinoxrUlez + 16) / 2)) + (equinoxrUlez + 16) / 2;
    }

    protected void Equinox(Graphics g, int i, Color color)
    {
        g.setColor(color);
        g.drawLine(0, i, EQuiNoxrulez - 1, i);
        g.setColor(color = color.darker());
        g.drawLine(0, i - 1, EQuiNoxrulez - 1, i - 1);
        g.drawLine(0, i + 1, EQuiNoxrulez - 1, i + 1);
        g.setColor(color = color.darker());
        g.drawLine(0, i - 2, EQuiNoxrulez - 1, i - 2);
        g.drawLine(0, i + 2, EQuiNoxrulez - 1, i + 2);
    }

    protected void EquinoxRulez(Graphics g, int i)
    {
        if(EquinoxruLez >= EquinoxrulEz)
            EquinoxruLez = 0;
        for(int j = 0; j < EQuiNoxrulez * equinoxrUlez; j++)
            equinoxRulez[j] = 0;

        for(int k = 0; k < equinoxrUlez; k++)
        {
            for(int l = 0; l < equinoxrulEz; l++)
                equinoxRulez[k * EQuiNoxrulez + l + EquiNoxrulez[k + EquinoxruLez]] = equinoxruLez[k * equinoxrulEz + l];

        }

        EquinoxruLez++;
        EQUinoxrulez.newPixels();
        g.drawImage(equinOxrulez, 0, i, null);
    }

    protected boolean equInoxrulez()
    {
        long l = 0L;
        for(int i = 0; i < EquInoxrulez.length(); i++)
            l += EquInoxrulez.charAt(i);

        return l == 6304L;
    }

    public void init()
    {
        resize(400, 80);
        if(!equInoxrulez())
            return;
        EquinoxruleZ = false;
        String s = getParameter("rasters");
        if(s == null)
            EquinoxruleZ = true;
        else
        if(s.equalsIgnoreCase("yes"))
            EquinoxruleZ = true;
        EQuiNoxrulez = 400;
        EquinoxrUlez = 80;
        equinoXrulez = createImage(EQuiNoxrulez, EquinoxrUlez);
        MediaTracker mediatracker = new MediaTracker(this);
        Image image = getImage(getCodeBase(), "EqxLogo.gif");
        equiNoxrulez = getImage(getCodeBase(), "Grn0641.jpg");
        mediatracker.addImage(image, 0);
        mediatracker.addImage(equiNoxrulez, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(InterruptedException _ex) { }
        equinoxrulEz = image.getWidth(this);
        equinoxrUlez = image.getHeight(this);
        equinoxruLez = new int[equinoxrulEz * equinoxrUlez];
        equinoxRulez = new int[EQuiNoxrulez * equinoxrUlez];
        EQUinoxrulez = new MemoryImageSource(EQuiNoxrulez, equinoxrUlez, equinoxRulez, 0, EQuiNoxrulez);
        EQUinoxrulez.setAnimated(true);
        equinOxrulez = createImage(EQUinoxrulez);
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, equinoxrulEz, equinoxrUlez, equinoxruLez, 0, equinoxrulEz);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        EquinoxrulEz = 600;
        EquiNoxrulez = new int[EquinoxrulEz + equinoxrUlez];
        for(int i = 0; i < 60; i++)
            EquiNoxrulez[i] = (EQuiNoxrulez - equinoxrulEz) / 2;

        for(int j = 0; j < 180; j++)
            EquiNoxrulez[j + 60] = (int)(Math.sin(((double)(4 * j) * 3.1415926535897931D) / 180D) * (double)((EQuiNoxrulez - equinoxrulEz) / 4)) + (EQuiNoxrulez - equinoxrulEz) / 2;

        for(int k = 0; k < 180; k++)
            EquiNoxrulez[k + 60 + 180] = (int)((Math.sin(((double)(2 * k) * 3.1415926535897931D) / 180D) * 0.80000000000000004D + Math.sin(((double)(4 * k) * 3.1415926535897931D) / 45D) * 0.20000000000000001D) * (double)((EQuiNoxrulez - equinoxrulEz) / 4)) + (EQuiNoxrulez - equinoxrulEz) / 2;

        for(int l = 0; l < 90; l++)
            EquiNoxrulez[l + 60 + 180 + 180] = (int)((Math.sin(((double)(2 * l) * 3.1415926535897931D) / 180D) * 0.90000000000000002D + Math.sin(((double)(8 * l) * 3.1415926535897931D) / 45D) * 0.10000000000000001D) * (double)((EQuiNoxrulez - equinoxrulEz) / 4)) + (EQuiNoxrulez - equinoxrulEz) / 2;

        for(int i1 = 0; i1 < 90; i1++)
            EquiNoxrulez[i1 + 60 + 180 + 180 + 90] = (int)(Math.sin(((double)(6 * i1) * 3.1415926535897931D) / 180D) * Math.sin(((double)(2 * i1) * 3.1415926535897931D) / 360D + 1.5707963267948966D) * (double)((EQuiNoxrulez - equinoxrulEz) / 4)) + (EQuiNoxrulez - equinoxrulEz) / 2;

        for(int j1 = 0; j1 < equinoxrUlez; j1++)
            EquiNoxrulez[EquinoxrulEz + j1] = EquiNoxrulez[j1];

        EquinoxruLez = 0;
        Equinoxrulez = 0;
        eQuinoxrules = 120;
        eqUinoxrulez = 240;
        EQuInoxrulez = null;
        FontMetrics fontmetrics = getFontMetrics(getFont());
        EqUinoxrulez = fontmetrics.stringWidth(EquInoxrulez);
        equinoxruleZ = fontmetrics.getDescent();
        EQuinoxrulez = EQuiNoxrulez;
        resize(EQuiNoxrulez, EquinoxrUlez);
    }

    public void run()
    {
        while(EQuInoxrulez != null) 
        {
            repaint();
            try
            {
                Thread.sleep(17L);
            }
            catch(InterruptedException _ex) { }
        }
    }

    public void start()
    {
        if(EQuInoxrulez == null)
        {
            EQuInoxrulez = new Thread(this);
            EQuInoxrulez.start();
        }
    }

    public void stop()
    {
        if(EQuInoxrulez != null)
        {
            EQuInoxrulez.stop();
            EQuInoxrulez = null;
        }
    }

    public void update(Graphics g)
    {
        Graphics g1 = equinoXrulez.getGraphics();
        int i = equiNoxrulez.getWidth(this);
        for(int j = 0; j < EQuiNoxrulez; j += i)
            g1.drawImage(equiNoxrulez, j, 0, null);

        if(EquinoxruleZ)
        {
            Equinoxrulez = EquinOxrulez(Equinoxrulez, 3);
            eQuinoxrules = EquinOxrulez(eQuinoxrules, 3);
            eqUinoxrulez = EquinOxrulez(eqUinoxrulez, 3);
            if(Equinoxrulez <= 180)
                Equinox(g1, EquinoXrulez(Equinoxrulez), Color.blue.darker());
            if(eQuinoxrules <= 180)
                Equinox(g1, EquinoXrulez(eQuinoxrules), Color.white.darker());
            if(eqUinoxrulez <= 180)
                Equinox(g1, EquinoXrulez(eqUinoxrulez), Color.red.darker());
            EquinoxRulez(g1, 8);
            if(Equinoxrulez > 180)
                Equinox(g1, EquinoXrulez(Equinoxrulez), Color.blue);
            if(eQuinoxrules > 180)
                Equinox(g1, EquinoXrulez(eQuinoxrules), Color.white);
            if(eqUinoxrulez > 180)
                Equinox(g1, EquinoXrulez(eqUinoxrulez), Color.red);
        } else
        {
            EquinoxRulez(g1, 8);
        }
        g1.setColor(Color.yellow);
        g1.drawString(EquInoxrulez, EQuinoxrulez, EquinoxrUlez - equinoxruleZ);
        if(EQuinoxrulez-- <= -EqUinoxrulez)
            EQuinoxrulez = EQuiNoxrulez;
        g.drawImage(equinoXrulez, 0, 0, this);
    }

    Thread EQuInoxrulez;
    Image equinoXrulez;
    int EQuiNoxrulez;
    int EquinoxrUlez;
    boolean EquinoxruleZ;
    Image equiNoxrulez;
    MemoryImageSource EQUinoxrulez;
    Image equinOxrulez;
    int EquinoxrulEz;
    int equinoxrulEz;
    int equinoxrUlez;
    int equinoxruLez[];
    int equinoxRulez[];
    int EquiNoxrulez[];
    int EquinoxruLez;
    int Equinoxrulez;
    int eQuinoxrules;
    int eqUinoxrulez;
    String EquInoxrulez;
    int EqUinoxrulez;
    int equinoxruleZ;
    int EQuinoxrulez;
}
