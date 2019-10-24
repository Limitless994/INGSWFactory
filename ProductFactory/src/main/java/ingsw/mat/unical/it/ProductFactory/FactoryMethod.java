package ingsw.mat.unical.it.ProductFactory;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.*;
public class FactoryMethod
{
    public static void main(String[] args)
    {
		ProductFactory factory = new ProductFactory();
		Product p = factory.getProduct(ProductType.Smartphone);
		p.printStats();
		Product p2 = factory.getProduct(ProductType.Smartwatch);
		p2.printStats();
        AWTImageComponent component = new AWTImageComponent();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(component);
        Frame f = new Frame();
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        f.add(scrollPane);
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}
  
class AWTImageComponent extends Panel
{
    Image image;
  
    public AWTImageComponent()
    {
        loadImage();
    }
  
    public void paint(Graphics g)
    {
        super.paint(g);
        int w = getWidth();
        int h = getHeight();
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
        int x = (w - imageWidth)/2;
        int y = (h - imageHeight)/2;
        g.drawImage(image, x, y, this);
    }
  
    /**
     * For the ScrollPane or other Container.
     */
    public Dimension getPreferredSize()
    {
        return new Dimension(image.getWidth(this), image.getHeight(this));
    }
  
    private void loadImage()
    {
        String fileName = "images/coyote.jpg";
        URL url = getClass().getResource(fileName);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        image = toolkit.getImage(url);
        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(image, 0);
        try
        {
            tracker.waitForID(0);
        }
        catch(InterruptedException ie)
        {
            System.out.println("interrupt: " + ie.getMessage());
        }
    }
}