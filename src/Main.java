import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Resolution[] res = new Resolution[4];

        res[0] = new Resolution("640x480", 640, 480);
        res[1] = new Resolution("800x600", 800, 600);
        res[2] = new Resolution("1024x768", 1024, 768);
        res[3] = new Resolution("1200x700", 1200, 700);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        ButtonGroup bg = new ButtonGroup();
        JRadioButton[] rb = new JRadioButton[4];
        for (int i = 0; i < 4; i++) {
            rb[i] = new JRadioButton(res[i].name);
            bg.add(rb[i]);
            panel.add(rb[i]);
        }

        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        JOptionPane.showMessageDialog(null, panel);
        int choose = 0;
        for (int i = 0; i < bg.getButtonCount(); i++) {
            if (rb[i].isSelected())
                choose = i;
        }
        Resolution r = res[choose];
        JFrame x = new JFrame(r.name);
        x.setSize(r.width, r.height);
        x.setLocation(50, 10);
        x.setVisible(true);
    }
}

class Resolution {
    String name;
    int width;
    int height;

    Resolution(String s, int w, int h) {
        this.width = w;
        this.name = s;
        this.height = h;
    }

    @Override
    public String toString() {
        return name;
    }
}